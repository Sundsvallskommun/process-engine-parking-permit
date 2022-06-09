package se.sundsvall.processengine.parkingpermit.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import se.sundsvall.processengine.parkingpermit.api.model.CamundaVariable;
import se.sundsvall.processengine.parkingpermit.api.model.CaseObject;
import se.sundsvall.processengine.parkingpermit.api.model.ParkingPermitRequest;
import se.sundsvall.processengine.parkingpermit.api.model.ParkingPermitResponse;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("process")
public class CamundaEndpoints {

    private String camundaUrl;

    public CamundaEndpoints(@Value("${camunda.endpoint}") String camundaUrl){
        this.camundaUrl = camundaUrl;
    }

    @PostMapping(path = "start-process",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Start a new process instance with the given process name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = ParkingPermitResponse.class)))
    })

    public ResponseEntity<ParkingPermitResponse> startParkingPermitProcess(@RequestBody CaseObject caseObject) throws JsonProcessingException {

        Map<String, CamundaVariable<?>> camundaVariables = new HashMap<>();
        CamundaVariable<String> caseNumberVariable = new CamundaVariable<>();
        caseNumberVariable.setValue(caseObject.getCaseNumber());
        caseNumberVariable.setType("String");

        camundaVariables.put("caseNumber",caseNumberVariable);

        ParkingPermitRequest parkingPermitRequest = new ParkingPermitRequest();
        parkingPermitRequest.setVariables(camundaVariables);


        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(parkingPermitRequest);

        WebClient webClient = WebClient.builder()
                .baseUrl(camundaUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        Mono<JsonNode> processDefinitionJsonMono = webClient.post()
                .uri("/engine-rest/process-definition/key/parking-permit/start")
                .bodyValue(requestBody)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(JsonNode.class);

        JsonNode jsonNode = processDefinitionJsonMono.block();
        String processId = jsonNode.path("id").asText();
        ParkingPermitResponse parkingPermitResponse = new ParkingPermitResponse();
        parkingPermitResponse.setProcessId(processId);

        return new ResponseEntity<>(parkingPermitResponse, HttpStatus.OK);
    }

    @PostMapping(path = "update-process",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Update a process instance with the given process instance ID")
    public ResponseEntity<ParkingPermitResponse> updateParkingPermitProcess(@RequestBody CaseObject caseObject){

        ParkingPermitResponse parkingPermitResponse = new ParkingPermitResponse();
        parkingPermitResponse.setProcessId(caseObject.getProcessInstanceId());

        return new ResponseEntity<>(parkingPermitResponse, HttpStatus.OK);

    }
}