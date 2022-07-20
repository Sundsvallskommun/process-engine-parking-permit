package se.sundsvall.processengine.parkingpermit.integration.casedata.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import se.sundsvall.processengine.parkingpermit.integration.casedata.enums.AttachmentCategory;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@ToString
public class Attachment {

    private Long id;
    private AttachmentCategory category;
    private String name;
    private String note;
    private String extension;
    private String mimeType;
    private String file;
    private Map<String, String> extraParameters = new HashMap<>();
    private int version;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime created;
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
