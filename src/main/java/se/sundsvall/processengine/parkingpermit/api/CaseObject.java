package se.sundsvall.processengine.parkingpermit.api;

import java.io.Serializable;

public class CaseObject implements Serializable {

    private String processName;
    private String caseNumber;
    private String processInstanceId;

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

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    @Override
    public String toString() {
        return "CaseObject{" +
                "processName='" + processName + '\'' +
                ", caseNumber='" + caseNumber + '\'' +
                ", processInstanceId='" + processInstanceId + '\'' +
                '}';
    }
}
