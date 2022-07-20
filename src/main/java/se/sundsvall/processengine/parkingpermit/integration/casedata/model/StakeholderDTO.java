package se.sundsvall.processengine.parkingpermit.integration.casedata.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.DiscriminatorMapping;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import se.sundsvall.processengine.parkingpermit.integration.casedata.enums.StakeholderRole;
import se.sundsvall.processengine.parkingpermit.integration.casedata.enums.StakeholderType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Schema(oneOf = {PersonDTO.class, OrganizationDTO.class}, discriminatorMapping = {@DiscriminatorMapping(value = StakeholderType.Constants.PERSON_VALUE, schema = PersonDTO.class), @DiscriminatorMapping(value = StakeholderType.Constants.ORGANIZATION_VALUE, schema = OrganizationDTO.class)})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", include = JsonTypeInfo.As.EXISTING_PROPERTY, visible = true)
@JsonSubTypes({@JsonSubTypes.Type(value = PersonDTO.class, name = StakeholderType.Constants.PERSON_VALUE),
        @JsonSubTypes.Type(value = OrganizationDTO.class, name = StakeholderType.Constants.ORGANIZATION_VALUE)})
@Data
@EqualsAndHashCode(exclude = {"id", "version", "created", "updated"})
public abstract class StakeholderDTO {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotNull
    private StakeholderType type;

    @NotNull
    @Schema(description = "An stakeholder can have one or more roles.")
    private List<StakeholderRole> roles = new ArrayList<>();

    @Valid
    @Schema(description = "An stakeholder may have one or more addresses. For example one POSTAL_ADDRESS and another INVOICE_ADDRESS.")
    private List<AddressDTO> addresses = new ArrayList<>();

    private List<ContactInformationDTO> contactInformation = new ArrayList<>();

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