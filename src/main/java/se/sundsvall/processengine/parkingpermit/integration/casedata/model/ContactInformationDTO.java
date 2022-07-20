package se.sundsvall.processengine.parkingpermit.integration.casedata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import se.sundsvall.casedata.integration.db.model.enums.ContactType;
import se.sundsvall.processengine.parkingpermit.integration.casedata.enums.ContactType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ContactInformationDTO {
    private ContactType contactType;
    @Length(max = 255)
    private String value;

}