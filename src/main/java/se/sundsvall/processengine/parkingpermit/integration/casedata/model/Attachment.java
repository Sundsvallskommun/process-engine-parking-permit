
package se.sundsvall.processengine.parkingpermit.integration.casedata.model;

import java.util.HashMap;
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
    "category",
    "name",
    "note",
    "extension",
    "mimeType",
    "file",
    "extraParameters",
    "version",
    "created",
    "updated"
})
@Generated("jsonschema2pojo")
@Data
@ToString
public class Attachment {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("category")
    public String category;
    @JsonProperty("name")
    public String name;
    @JsonProperty("note")
    public String note;
    @JsonProperty("extension")
    public String extension;
    @JsonProperty("mimeType")
    public String mimeType;
    @JsonProperty("file")
    @ToString.Exclude
    public String file;
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
