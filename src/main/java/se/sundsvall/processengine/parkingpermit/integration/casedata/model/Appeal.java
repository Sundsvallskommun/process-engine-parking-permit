package se.sundsvall.processengine.parkingpermit.integration.casedata.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.OffsetDateTime;
import java.util.*;

@Getter
@Setter
public class Appeal {

    private Long id;
    private Stakeholder appealedBy;
    private Stakeholder judicialAuthorisation;
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
        if (!(o instanceof Appeal)) return false;
        Appeal appeal = (Appeal) o;
        return Objects.equals(appealedBy, appeal.appealedBy) && Objects.equals(judicialAuthorisation, appeal.judicialAuthorisation) && Objects.equals(attachments, appeal.attachments) && Objects.equals(extraParameters, appeal.extraParameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appealedBy, judicialAuthorisation, attachments, extraParameters);
    }

    @Override
    public String toString() {
        return "Appeal{" +
                "id=" + id +
                ", appealedBy=" + appealedBy +
                ", judicialAuthorisation=" + judicialAuthorisation +
                ", attachments=" + attachments +
                ", extraParameters=" + extraParameters +
                ", version=" + version +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
