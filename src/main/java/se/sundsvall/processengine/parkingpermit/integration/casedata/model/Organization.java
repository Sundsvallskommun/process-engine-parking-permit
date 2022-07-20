package se.sundsvall.processengine.parkingpermit.integration.casedata.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Objects;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@Schema(allOf = Stakeholder.class)
public class Organization extends Stakeholder {

    private String organizationName;
    private String organizationNumber;
    private String authorizedSignatory;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organization)) return false;
        if (!super.equals(o)) return false;
        Organization that = (Organization) o;
        return Objects.equals(organizationName, that.organizationName) && Objects.equals(organizationNumber, that.organizationNumber) && Objects.equals(authorizedSignatory, that.authorizedSignatory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), organizationName, organizationNumber, authorizedSignatory);
    }
}
