package se.sundsvall.processengine.parkingpermit.api;

import java.io.Serializable;

public class CaseObject implements Serializable {

    private String processName;
    private String caseNumber;

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

}
