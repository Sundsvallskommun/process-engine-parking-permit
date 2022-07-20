package se.sundsvall.processengine.parkingpermit.util;

public final class Constants {

    private Constants() {
    }

    public static final String ORGNR_PATTERN_REGEX = "^((18|19|20|21)\\d{6}|\\d{6})-(\\d{4})$";
    public static final String ORGNR_PATTERN_MESSAGE = "organizationNumber must consist of 10 or 12 digits. 10 digit orgnr must follow this format: \"XXXXXX-XXXX\". 12 digit orgnr must follow this format: \"(18|19|20)XXXXXX-XXXX\".";

}
