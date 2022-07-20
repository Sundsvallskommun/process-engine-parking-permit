package se.sundsvall.processengine.parkingpermit.integration.casedata.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;
import org.springframework.format.annotation.DateTimeFormat;
import se.sundsvall.casedata.integration.db.model.enums.DecisionType;
import se.sundsvall.processengine.parkingpermit.integration.casedata.enums.DecisionType;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.*;

@Entity
@Audited
@Getter
@Setter
public class Decision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DecisionType decisionType;

    @Column(length = 1000)
    private String description;

    @ElementCollection
    @OrderColumn
    private List<Law> law = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Stakeholder decidedBy;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime decidedAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime validFrom;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime validTo;

    @OneToOne(cascade = CascadeType.ALL)
    private Appeal appeal;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Attachment> attachments = new ArrayList<>();

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
        if (!(o instanceof Decision)) return false;
        Decision decision = (Decision) o;
        return decisionType == decision.decisionType && Objects.equals(description, decision.description) && Objects.equals(law, decision.law) && Objects.equals(decidedBy, decision.decidedBy) && Objects.equals(decidedAt, decision.decidedAt) && Objects.equals(validFrom, decision.validFrom) && Objects.equals(validTo, decision.validTo) && Objects.equals(appeal, decision.appeal) && Objects.equals(attachments, decision.attachments) && Objects.equals(extraParameters, decision.extraParameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(decisionType, description, law, decidedBy, decidedAt, validFrom, validTo, appeal, attachments, extraParameters);
    }

    @Override
    public String toString() {
        return "Decision{" +
                "id=" + id +
                ", decisionType=" + decisionType +
                ", description='" + description + '\'' +
                ", law=" + law +
                ", decidedBy=" + decidedBy +
                ", decidedAt=" + decidedAt +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                ", appeal=" + appeal +
                ", attachments=" + attachments +
                ", extraParameters=" + extraParameters +
                ", version=" + version +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
