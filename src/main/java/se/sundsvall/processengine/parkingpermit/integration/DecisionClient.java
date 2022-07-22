package se.sundsvall.processengine.parkingpermit.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.web.reactive.function.client.WebClient;
import se.sundsvall.dept44.configuration.webclient.WebClientBuilder;
import se.sundsvall.processengine.parkingpermit.integration.casedata.enums.DecisionType;
import se.sundsvall.processengine.parkingpermit.integration.casedata.model.DecisionDTO;
import se.sundsvall.processengine.parkingpermit.integration.casedata.model.ErrandDTO;

public class DecisionClient {

    private String caseDataDecisionUrl;
    private ClientRegistration clientRegistration;

    public DecisionClient(@Value("${casedata.errands.url}") String caseDataDecisionUrl,ClientRegistration clientRegistration){
        this.caseDataDecisionUrl = caseDataDecisionUrl;
        this.clientRegistration = clientRegistration;
    }

    public void postDecision(String caseId, DecisionDTO decisionDTO){

        WebClient webClient = new WebClientBuilder()
                .withBaseUrl(caseDataDecisionUrl)
                .withOAuth2Client(clientRegistration)
                .build();

        ErrandDTO errandDTO = webClient.patch()
                .uri(uriBuilder -> uriBuilder
                        .path("/errands/{id}/decisions")
                        .build(caseId))
                .bodyValue(decisionDTO)
                .retrieve()
                .bodyToMono(ErrandDTO.class)
                .block();
    }
}