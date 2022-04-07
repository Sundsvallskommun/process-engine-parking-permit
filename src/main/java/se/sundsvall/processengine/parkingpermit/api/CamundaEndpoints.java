package se.sundsvall.processengine.parkingpermit.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CamundaEndpoints {

    @PostMapping("startprocess")
    public ResponseEntity<?> startParkingPermitProcess(@RequestBody CaseObject caseObject){

        return null;

    }
}
