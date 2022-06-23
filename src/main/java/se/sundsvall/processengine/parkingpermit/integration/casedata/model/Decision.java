
package se.sundsvall.processengine.parkingpermit.integration.casedata.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    "text",
    "description",
    "law",
    "decidedAt",
    "validFrom",
    "validTo",
    "appeal",
    "attachments",
    "extraParameters",
    "version",
    "created",
    "updated"
})
@Generated("jsonschema2pojo")
@Data
@ToString
public class Decision {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("text")
    public String text;
    @JsonProperty("description")
    public String description;
    @JsonProperty("law")
    public List<Law> law = null;
    @JsonProperty("decidedAt")
    public String decidedAt;
    @JsonProperty("validFrom")
    public String validFrom;
    @JsonProperty("validTo")
    public String validTo;
    @JsonProperty("appeal")
    public Appeal appeal;
    @JsonProperty("attachments")
    public List<Attachment> attachments = null;
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

}
