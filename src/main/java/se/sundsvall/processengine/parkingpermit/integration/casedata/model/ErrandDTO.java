package se.sundsvall.processengine.parkingpermit.integration.casedata.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import se.sundsvall.processengine.parkingpermit.integration.casedata.enums.Priority;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id", "version", "created", "updated"})
public class
ErrandDTO {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Case ID from the client.", example = "caa230c6-abb4-4592-ad9a-34e263c2787b")
    @Length(max = 255)
    private String externalCaseId;

    @NotNull
    private CaseType caseType;

    private Priority priority;

    @Schema(example = "Some description of the case.")
    @Length(max = 255)
    private String description;

    @Schema(description = "Additions to the case title. Right now only applicable to cases of CaseType: NYBYGGNAD_ANSOKAN_OM_BYGGLOV.", example = "Eldstad/rökkanal, Skylt")
    @Length(max = 255)
    private String caseTitleAddition;

    @Length(max = 255)
    private String diaryNumber;

    private List<StatusDTO> statuses = new ArrayList<>();

    @Length(max = 255)
    private String municipalityId;

    @Schema(description = "Start date for the business.", format = "date", example = "2022-01-01")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Schema(description = "End date of the business if it is time-limited.", format = "date", example = "2022-06-01")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @Schema(description = "The time the application was received.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime applicationReceived;

    private String processId;

    @Valid
    private List<StakeholderDTO> stakeholders = new ArrayList<>();

    @Valid
    private List<FacilityDTO> facilities = new ArrayList<>();

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Valid
    private List<AttachmentDTO> attachments = new ArrayList<>();

    @Valid
    private DecisionDTO decision;

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
