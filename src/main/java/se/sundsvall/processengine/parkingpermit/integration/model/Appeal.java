
package se.sundsvall.processengine.parkingpermit.integration.model;

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
    "attachments",
    "extraParameters",
    "version",
    "created",
    "updated"
})
@Generated("jsonschema2pojo")
@Data
@ToString
public class Appeal {

    @JsonProperty("id")
    public Integer id;
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
