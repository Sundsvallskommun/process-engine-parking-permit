package se.sundsvall.processengine.parkingpermit.integration.citizen;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.web.reactive.function.client.WebClient;
import se.sundsvall.dept44.configuration.webclient.WebClientBuilder;

import java.util.Optional;

public class CitizenClient {

    private String citizenUrl;
    private ClientRegistration clientRegistration;

    public CitizenClient(@Value("${citizen.url}") String citizenUrl, ClientRegistration clientRegistration ){

        this.citizenUrl = citizenUrl;
        this.clientRegistration = clientRegistration;
    }

    public boolean isPersonCitizen(String citizenGuid){

        WebClient webClient = new WebClientBuilder()
                .withBaseUrl(citizenUrl)
                .withOAuth2Client(clientRegistration)
                .build();

        Optional<Citizen> citizenDataOptional = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/citizen/{personId}")
                        .build(citizenGuid))
                .retrieve()
                .bodyToMono(Citizen.class)
                .blockOptional();


        return citizenDataOptional.isPresent();
    }
}
