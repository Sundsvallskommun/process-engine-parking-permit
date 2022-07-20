package se.sundsvall.processengine.parkingpermit.integration.casedata.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import se.sundsvall.casedata.integration.db.model.enums.FacilityType;
import se.sundsvall.processengine.parkingpermit.integration.casedata.enums.FacilityType;

import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id", "version", "created", "updated"})
public class FacilityDTO {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(example = "En fritextbeskrivning av facility.")
    private String description;

    @Valid
    private AddressDTO address;

    @Schema(description = "The name on the sign.", example = "Sundsvalls testfabrik")
    private String facilityCollectionName;

    private boolean mainFacility;

    private FacilityType facilityType;

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
