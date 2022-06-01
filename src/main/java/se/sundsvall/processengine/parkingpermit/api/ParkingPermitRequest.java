package se.sundsvall.processengine.parkingpermit.api;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ParkingPermitRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = -2756385544020464216L;

    private Map<String, CamundaVariable<?>> variables;

    public ParkingPermitRequest (){
        variables = new HashMap<>();
    }

    public Map<String, CamundaVariable<?>> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, CamundaVariable<?>> variables) {
        this.variables = variables;
    }
}