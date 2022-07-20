package se.sundsvall.processengine.parkingpermit.integration.casedata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LawDTO {

    // Rubrik
    @Length(max = 255)
    private String heading;
    // Svensk författningssamling, (SFS)
    @Length(max = 255)
    private String sfs;
    // kapitel
    @Length(max = 255)
    private String chapter;
    // paragraf
    @Length(max = 255)
    private String article;

}
