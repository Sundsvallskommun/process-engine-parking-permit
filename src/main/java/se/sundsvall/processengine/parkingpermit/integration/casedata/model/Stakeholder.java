package se.sundsvall.processengine.parkingpermit.integration.casedata.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import se.sundsvall.processengine.parkingpermit.integration.casedata.enums.StakeholderRole;
import se.sundsvall.processengine.parkingpermit.integration.casedata.enums.StakeholderType;
import se.sundsvall.processengine.parkingpermit.integration.citizen.Address;

import java.time.OffsetDateTime;
import java.util.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", include = JsonTypeInfo.As.EXISTING_PROPERTY, visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Person.class, name = StakeholderType.Constants.PERSON_VALUE),
        @JsonSubTypes.Type(value = Organization.class, name = StakeholderType.Constants.ORGANIZATION_VALUE)})
@Getter
@Setter
@ToString
@Schema(oneOf = {Person.class, Organization.class})
public abstract class Stakeholder {

    private Long id;
    private StakeholderType type;
    private List<StakeholderRole> roles = new ArrayList<>();
    private List<Address> addresses = new ArrayList<>();
    private List<ContactInformation> contactInformation = new ArrayList<>();
    private Map<String, String> extraParameters = new HashMap<>();

    private int version;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime created;
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
