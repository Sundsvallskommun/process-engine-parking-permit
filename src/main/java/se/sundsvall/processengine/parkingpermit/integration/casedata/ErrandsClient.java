package se.sundsvall.processengine.parkingpermit.integration.casedata;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import se.sundsvall.dept44.configuration.webclient.WebClientBuilder;

@Component
public class ErrandsClient {

    private String caseDataErrandsUrl;
    private ClientRegistration clientRegistration;

    public ErrandsClient(@Value("${casedata.errands.url}") String caseDataErrandsUrl, ClientRegistration clientRegistration){
        this.caseDataErrandsUrl = caseDataErrandsUrl;
        this.clientRegistration = clientRegistration;
    }

    public String getErrandById(String errandId){

        WebClient webClient = new WebClientBuilder()
                .withBaseUrl(caseDataErrandsUrl)
                .withOAuth2Client(clientRegistration)
                .build();

        JsonNode jsonNode = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/errands")
                        .queryParam("caseType", "PARKING_PERMIT")
                        .queryParam("id", errandId)
                        .build())
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block();

        System.out.println(jsonNode.toPrettyString());

        return jsonNode.toPrettyString();
    }

}