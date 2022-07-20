package se.sundsvall.processengine.parkingpermit.integration.casedata.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import se.sundsvall.processengine.parkingpermit.util.Constants;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OrganizationDTO extends StakeholderDTO {

    @Length(max = 255)
    @Schema(example = "Sundsvalls testfabrik")
    private String organizationName;

    @Length(max = 255)
    @NotBlank
    @Pattern(regexp = Constants.ORGNR_PATTERN_REGEX, message = Constants.ORGNR_PATTERN_MESSAGE)
    @Schema(description = "Organization number with 10 or 12 digits.", example = "19901010-1234")
    private String organizationNumber;

    @Length(max = 255)
    @Schema(example = "Test Testorsson")
    private String authorizedSignatory;

}