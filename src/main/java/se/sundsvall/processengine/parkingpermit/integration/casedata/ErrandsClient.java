package se.sundsvall.processengine.parkingpermit.integration.casedata;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import se.sundsvall.dept44.configuration.webclient.WebClientBuilder;
import se.sundsvall.processengine.parkingpermit.integration.casedata.model.Errand;

import java.util.List;

@Component
public class ErrandsClient {

    private String caseDataErrandsUrl;
    private ClientRegistration clientRegistration;

    public ErrandsClient(@Value("${casedata.errands.url}") String caseDataErrandsUrl, ClientRegistration clientRegistration){
        this.caseDataErrandsUrl = caseDataErrandsUrl;
        this.clientRegistration = clientRegistration;
    }

    public List<Errand> getErrandById(String errandId){

        WebClient webClient = new WebClientBuilder()
                .withBaseUrl(caseDataErrandsUrl)
                .withOAuth2Client(clientRegistration)
                .build();

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/errands")
                        .queryParam("caseType", "PARKING_PERMIT")
                        .queryParam("id", errandId)
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Errand>>() {
                })
                .block();
    }
}