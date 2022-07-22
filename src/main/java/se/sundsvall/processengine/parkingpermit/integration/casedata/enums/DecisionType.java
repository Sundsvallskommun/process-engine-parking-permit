package se.sundsvall.processengine.parkingpermit.integration.casedata.enums;

public enum DecisionType {
    APPROVAL("APPROVAL"), REJECTION("REJECTION ");

    private String decsionText;

    DecisionType(String decsionText){
        this.decsionText = decsionText;
    }
}
