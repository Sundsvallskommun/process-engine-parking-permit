package se.sundsvall.processengine.parkingpermit.integration.casedata.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import se.sundsvall.processengine.parkingpermit.integration.casedata.enums.ContactType;
import java.util.Objects;

@Getter
@Setter
@ToString
public class ContactInformation {
    private ContactType contactType;

    private String value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactInformation)) return false;
        ContactInformation that = (ContactInformation) o;
        return contactType == that.contactType && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactType, value);
    }
}
