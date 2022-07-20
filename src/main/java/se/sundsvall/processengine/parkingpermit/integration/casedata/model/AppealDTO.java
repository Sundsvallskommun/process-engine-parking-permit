package se.sundsvall.processengine.parkingpermit.integration.casedata.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id", "version", "created", "updated"})
public class AppealDTO {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    private StakeholderDTO appealedBy;

    private StakeholderDTO judicialAuthorisation;

    private List<AttachmentDTO> attachments = new ArrayList<>();

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
