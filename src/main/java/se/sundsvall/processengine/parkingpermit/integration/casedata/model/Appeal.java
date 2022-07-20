package se.sundsvall.processengine.parkingpermit.integration.casedata.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.*;

@Entity
@Audited
@Getter
@Setter
public class Appeal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Stakeholder appealedBy;
    @OneToOne(cascade = CascadeType.ALL)
    private Stakeholder judicialAuthorisation;
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
