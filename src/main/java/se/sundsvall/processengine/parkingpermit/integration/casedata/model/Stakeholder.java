package se.sundsvall.processengine.parkingpermit.integration.casedata.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;
import org.springframework.format.annotation.DateTimeFormat;
import se.sundsvall.casedata.integration.db.model.enums.StakeholderRole;
import se.sundsvall.casedata.integration.db.model.enums.StakeholderType;
import se.sundsvall.processengine.parkingpermit.integration.casedata.enums.StakeholderRole;
import se.sundsvall.processengine.parkingpermit.integration.casedata.enums.StakeholderType;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.*;

@Entity
@Audited
@Inheritance
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", include = JsonTypeInfo.As.EXISTING_PROPERTY, visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Person.class, name = StakeholderType.Constants.PERSON_VALUE),
        @JsonSubTypes.Type(value = Organization.class, name = StakeholderType.Constants.ORGANIZATION_VALUE)})
@Getter
@Setter
@ToString
@Schema(oneOf = {Person.class, Organization.class})
public abstract class Stakeholder {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(insertable = false, updatable = false)
    private StakeholderType type;

    @ElementCollection
    @OrderColumn
    @Enumerated(EnumType.STRING)
    private List<StakeholderRole> roles = new ArrayList<>();

    @ElementCollection
    @OrderColumn
    private List<Address> addresses = new ArrayList<>();

    @ElementCollection
    @OrderColumn
    private List<ContactInformation> contactInformation = new ArrayList<>();

    @ElementCollection
    @OrderColumn
    private Map<String, String> extraParameters = new HashMap<>();

    @Version
    private int version;
    @CreationTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime created;
    @UpdateTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime updated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stakeholder)) return false;
        Stakeholder that = (Stakeholder) o;
        return type == that.type && Objects.equals(roles, that.roles) && Objects.equals(addresses, that.addresses) && Objects.equals(contactInformation, that.contactInformation) && Objects.equals(extraParameters, that.extraParameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, roles, addresses, contactInformation, extraParameters);
    }
}
