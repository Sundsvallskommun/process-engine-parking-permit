package se.sundsvall.processengine.parkingpermit.integration.casedata.enums;

import lombok.Getter;

public enum AddressCategory {
    POSTAL_ADDRESS("Postadress"), INVOICE_ADDRESS("Fakturaadress"), VISITING_ADDRESS("Besöksadress");

    @Getter
    private final String text;
    AddressCategory(String text) {
        this.text = text;
    }
}
