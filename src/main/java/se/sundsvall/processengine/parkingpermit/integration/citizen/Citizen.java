
package se.sundsvall.processengine.parkingpermit.integration.citizen;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "personId",
    "givenname",
    "lastname",
    "addresses"
})
@Generated("jsonschema2pojo")
@Data
@ToString
public class Citizen {

    @JsonProperty("personId")
    public String personId;
    @JsonProperty("givenname")
    public String givenname;
    @JsonProperty("lastname")
    public String lastname;
    @JsonProperty("addresses")
    public List<Address> addresses = null;

}
