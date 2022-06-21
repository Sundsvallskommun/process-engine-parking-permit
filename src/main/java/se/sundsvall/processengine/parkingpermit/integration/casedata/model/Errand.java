
package se.sundsvall.processengine.parkingpermit.integration.casedata.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "externalCaseId",
    "caseType",
    "priority",
    "description",
    "caseTitleAddition",
    "diaryNumber",
    "statuses",
    "municipalityId",
    "startDate",
    "endDate",
    "applicationReceived",
    "stakeholders",
    "facilities",
    "attachments",
    "decision",
    "extraParameters",
    "version",
    "created",
    "updated"
})
@Generated("jsonschema2pojo")
@Data
@ToString
public class Errand {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("externalCaseId")
    public String externalCaseId;
    @JsonProperty("caseType")
    public String caseType;
    @JsonProperty("processId")
    public String processid;
    @JsonProperty("priority")
    public String priority;
    @JsonProperty("description")
    public String description;
    @JsonProperty("caseTitleAddition")
    public String caseTitleAddition;
    @JsonProperty("diaryNumber")
    public String diaryNumber;
    @JsonProperty("statuses")
    public List<Status> statuses = null;
    @JsonProperty("municipalityId")
    public String municipalityId;
    @JsonProperty("startDate")
    public String startDate;
    @JsonProperty("endDate")
    public String endDate;
    @JsonProperty("applicationReceived")
    public String applicationReceived;
    @JsonProperty("stakeholders")
    public List<Stakeholder> stakeholders = null;
    @JsonProperty("facilities")
    public List<Facility> facilities = null;
    @JsonProperty("attachments")
    public List<Attachment> attachments = null;
    @JsonProperty("decision")
    public Decision decision;
    @JsonProperty("extraParameters")
    public ExtraParameters extraParameters;
    @JsonProperty("version")
    public Integer version;
    @JsonProperty("created")
    public String created;
    @JsonProperty("updated")
    public String updated;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public List<Errand> findErrandsByCaseType(List<Errand> errandsList, List<String> caseTypesList){

        List<Errand> foundErrandsList = errandsList.stream()
                .filter(errand -> caseTypesList.contains(errand.getCaseType()))
                .collect(Collectors.toList());

        return foundErrandsList;
    }

}
