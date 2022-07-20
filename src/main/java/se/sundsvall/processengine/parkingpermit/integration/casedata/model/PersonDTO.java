package se.sundsvall.processengine.parkingpermit.integration.casedata.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import se.sundsvall.dept44.common.validators.annotation.ValidUuid;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PersonDTO extends StakeholderDTO {

    @Length(max = 255)
    @NotBlank
    @Schema(example = "Test")
    private String firstName;

    @Length(max = 255)
    @NotBlank
    @Schema(example = "Testorsson")
    private String lastName;

    @ValidUuid
    @Schema(example = "3ed5bc30-6308-4fd5-a5a7-78d7f96f4438")
    private String personId;

}