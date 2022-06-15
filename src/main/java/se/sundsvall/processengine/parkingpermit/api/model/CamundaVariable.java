package se.sundsvall.processengine.parkingpermit.api.model;

import java.io.Serial;
import java.io.Serializable;

public class CamundaVariable <T extends Serializable> implements Serializable {
    @Serial
    private static final long serialVersionUID = 7646442882519891559L;

    private T  value;
    private String type;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}