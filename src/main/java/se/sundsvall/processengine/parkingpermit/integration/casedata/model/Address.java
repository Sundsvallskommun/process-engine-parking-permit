package se.sundsvall.processengine.parkingpermit.integration.casedata.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import se.sundsvall.processengine.parkingpermit.integration.casedata.enums.AddressCategory;

import java.util.Objects;

@Getter
@Setter
@ToString
public class Address {

    private AddressCategory addressCategory;

    private String street;

    private String houseNumber;

    private String postalCode;

    private String city;

    private String country;

    private String careOf;

    private String attention;

    private String propertyDesignation;

    private String apartmentNumber;

    private Boolean isZoningPlanArea;

    private String invoiceMarking;

    private Coordinates location;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return addressCategory == address.addressCategory && Objects.equals(street, address.street) && Objects.equals(houseNumber, address.houseNumber) && Objects.equals(postalCode, address.postalCode) && Objects.equals(city, address.city) && Objects.equals(country, address.country) && Objects.equals(careOf, address.careOf) && Objects.equals(attention, address.attention) && Objects.equals(propertyDesignation, address.propertyDesignation) && Objects.equals(apartmentNumber, address.apartmentNumber) && Objects.equals(isZoningPlanArea, address.isZoningPlanArea) && Objects.equals(invoiceMarking, address.invoiceMarking) && Objects.equals(location, address.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressCategory, street, houseNumber, postalCode, city, country, careOf, attention, propertyDesignation, apartmentNumber, isZoningPlanArea, invoiceMarking, location);
    }
}
