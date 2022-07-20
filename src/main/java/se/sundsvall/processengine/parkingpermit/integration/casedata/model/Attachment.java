package se.sundsvall.processengine.parkingpermit.integration.casedata.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;
import org.springframework.format.annotation.DateTimeFormat;
import se.sundsvall.casedata.integration.db.model.enums.AttachmentCategory;
import se.sundsvall.processengine.parkingpermit.integration.casedata.enums.AttachmentCategory;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Entity
@Audited
@Getter
@Setter
@ToString
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AttachmentCategory category;

    private String name;

    @Column(length = 1000)
    private String note;

    private String extension;

    private String mimeType;

    @Lob
    private String file;

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
        if (!(o instanceof Attachment)) return false;
        Attachment that = (Attachment) o;
        return category == that.category && Objects.equals(name, that.name) && Objects.equals(note, that.note) && Objects.equals(extension, that.extension) && Objects.equals(mimeType, that.mimeType) && Objects.equals(file, that.file) && Objects.equals(extraParameters, that.extraParameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, name, note, extension, mimeType, file, extraParameters);
    }
}
