
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
    "type",
    "roles",
    "addresses",
    "contactInformation",
    "extraParameters",
    "version",
    "created",
    "updated",
    "organizationName",
    "organizationNumber",
    "authorizedSignatory",
    "firstName",
    "lastName",
    "personId",
    "personalNumber"
})
@Generated("jsonschema2pojo")
@Data
@ToString
public class Stakeholder {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("type")
    public String type;
    @JsonProperty("roles")
    public List<String> roles = null;
    @JsonProperty("addresses")
    public List<Address> addresses = null;
    @JsonProperty("contactInformation")
    public List<ContactInformation> contactInformation = null;
    @JsonProperty("extraParameters")
    public ExtraParameters extraParameters;
    @JsonProperty("version")
    public Integer version;
    @JsonProperty("created")
    public String created;
    @JsonProperty("updated")
    public String updated;
    @JsonProperty("organizationName")
    public String organizationName;
    @JsonProperty("organizationNumber")
    public String organizationNumber;
    @JsonProperty("authorizedSignatory")
    public String authorizedSignatory;
    @JsonProperty("firstName")
    public String firstName;
    @JsonProperty("lastName")
    public String lastName;
    @JsonProperty("personId")
    public String personId;
    @JsonProperty("personalNumber")
    public String personalNumber;
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
