package se.sundsvall.processengine.parkingpermit.integration.casedata.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import se.sundsvall.processengine.parkingpermit.integration.casedata.enums.AddressCategory;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AddressDTO {

    private AddressCategory addressCategory;

    @Schema(example = "Testvägen")
    @Length(max = 255)
    private String street;

    @Schema(example = "18")
    @Length(max = 255)
    private String houseNumber;

    @Schema(example = "123 45")
    @Length(max = 255)
    private String postalCode;

    @Schema(example = "Sundsvall")
    @Length(max = 255)
    private String city;

    @Schema(example = "Sverige")
    @Length(max = 255)
    private String country;

    @Schema(description = "c/o", example = "Test Testorsson")
    @Length(max = 255)
    private String careOf;

    @Schema(example = "Test Testorsson")
    @Length(max = 255)
    private String attention;

    @Schema(example = "SUNDSVALL LJUSTA 7:2")
    @Length(max = 255)
    private String propertyDesignation;

    @Schema(example = "LGH 1001")
    @Length(max = 255)
    private String apartmentNumber;

    private Boolean isZoningPlanArea;

    @Schema(description = "Only in combination with addressCategory: INVOICE_ADDRESS")
    @Length(max = 255)
    private String invoiceMarking;

    private CoordinatesDTO location;
}
