package se.sundsvall.processengine.parkingpermit.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("process-engine")
public class CamundaEndpoints {

    @PostMapping("start-process")
    public ResponseEntity<?> startParkingPermitProcess(@RequestBody CaseObject caseObject) throws JsonProcessingException {


        Map<String, CamundaVariable> variables = new HashMap<>();
        CamundaVariable<String> caseNumberVariable = new CamundaVariable<>();
        caseNumberVariable.setValue("1");
        caseNumberVariable.setType("String");

        CamundaVariable<Boolean> testBoolVariable = new CamundaVariable<>();
        testBoolVariable.setValue(true);
        testBoolVariable.setType("Boolean");

        variables.put("caseNumber",caseNumberVariable);
        variables.put("booleanTest",testBoolVariable);

        ParkingPermitRequest parkingPermitRequest2 = new ParkingPermitRequest();
        parkingPermitRequest2.setVariables(variables);


        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(parkingPermitRequest2);


        WebClient webClient = WebClient.builder()
                        .baseUrl("http://localhost:8080")
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

        return new ResponseEntity<>(parkingPermitResponse, HttpStatus.ACCEPTED);

    }

    @PostMapping("update-process")
    public ResponseEntity<?> updateParkingPermitProcess(@RequestBody CaseObject caseObject){

        System.out.println(caseObject);

        return new ResponseEntity<>("Test update", HttpStatus.ACCEPTED);

    }
}
