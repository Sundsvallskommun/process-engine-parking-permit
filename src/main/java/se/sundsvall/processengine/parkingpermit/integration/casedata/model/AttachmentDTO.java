package se.sundsvall.processengine.parkingpermit.integration.casedata.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import se.sundsvall.processengine.parkingpermit.integration.casedata.enums.AttachmentCategory;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id", "version", "created", "updated"})
public class AttachmentDTO {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private AttachmentCategory category;
    @Length(max = 255)
    private String name;
    @Length(max = 1000)
    private String note;
    @Length(max = 255)
    private String extension;
    @Length(max = 255)
    private String mimeType;
    private String file;
    private Map<String, String> extraParameters = new HashMap<>();
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private int version;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime created;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime updated;

}