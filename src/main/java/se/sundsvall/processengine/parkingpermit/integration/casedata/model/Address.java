
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
    "addressCategories",
    "street",
    "houseNumber",
    "postalCode",
    "city",
    "country",
    "careOf",
    "attention",
    "propertyDesignation",
    "apartmentNumber",
    "isZoningPlanArea",
    "invoiceMarking",
    "location"
})
@Generated("jsonschema2pojo")
@Data
@ToString
public class Address {

    @JsonProperty("addressCategories")
    public List<String> addressCategories = null;
    @JsonProperty("street")
    public String street;
    @JsonProperty("houseNumber")
    public String houseNumber;
    @JsonProperty("postalCode")
    public String postalCode;
    @JsonProperty("city")
    public String city;
    @JsonProperty("country")
    public String country;
    @JsonProperty("careOf")
    public String careOf;
    @JsonProperty("attention")
    public String attention;
    @JsonProperty("propertyDesignation")
    public String propertyDesignation;
    @JsonProperty("apartmentNumber")
    public String apartmentNumber;
    @JsonProperty("isZoningPlanArea")
    public Boolean isZoningPlanArea;
    @JsonProperty("invoiceMarking")
    public String invoiceMarking;
    @JsonProperty("location")
    public Location location;
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
