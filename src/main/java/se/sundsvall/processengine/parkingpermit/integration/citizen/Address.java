
package se.sundsvall.processengine.parkingpermit.integration.citizen;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "realEstateDescription",
    "co",
    "address",
    "addressArea",
    "addressNumber",
    "addressLetter",
    "appartmentNumber",
    "postalCode",
    "city",
    "country",
    "emigrated",
    "addressType"
})
@Generated("jsonschema2pojo")
@Data
@ToString
public class Address {

    @JsonProperty("realEstateDescription")
    public String realEstateDescription;
    @JsonProperty("co")
    public String co;
    @JsonProperty("address")
    public String address;
    @JsonProperty("addressArea")
    public String addressArea;
    @JsonProperty("addressNumber")
    public String addressNumber;
    @JsonProperty("addressLetter")
    public String addressLetter;
    @JsonProperty("appartmentNumber")
    public String appartmentNumber;
    @JsonProperty("postalCode")
    public String postalCode;
    @JsonProperty("city")
    public String city;
    @JsonProperty("country")
    public String country;
    @JsonProperty("emigrated")
    public Boolean emigrated;
    @JsonProperty("addressType")
    public String addressType;

}
