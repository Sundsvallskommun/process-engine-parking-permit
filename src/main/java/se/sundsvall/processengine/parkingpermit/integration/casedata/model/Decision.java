package se.sundsvall.processengine.parkingpermit.integration.casedata.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import se.sundsvall.processengine.parkingpermit.integration.casedata.enums.DecisionType;
import java.time.OffsetDateTime;
import java.util.*;

@Getter
@Setter
public class Decision {

    private Long id;
    private DecisionType decisionType;
    private String description;
    private List<Law> law = new ArrayList<>();
    private Stakeholder decidedBy;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime decidedAt;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime validFrom;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime validTo;
    private Appeal appeal;
    private List<Attachment> attachments = new ArrayList<>();
    private Map<String, String> extraParameters = new HashMap<>();
    private int version;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime created;
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