package se.sundsvall.processengine.parkingpermit.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ParkingPermitResponse {
    @Schema(example = "bfc9d438-db4e-11ec-bb5b-0242ac110003")
    private String processId;
}