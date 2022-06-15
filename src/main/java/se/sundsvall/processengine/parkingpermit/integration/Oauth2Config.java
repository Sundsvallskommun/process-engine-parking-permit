package se.sundsvall.processengine.parkingpermit.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.AuthorizationGrantType;

@Configuration
public class Oauth2Config {

    private String tokenUrl;
    private String clientKey;
    private String clientSecret;

    public Oauth2Config(@Value("${oauth2.token.url}") String tokenUrl,
                        @Value("${oauth2.client.key}") String clientKey,
                        @Value("${oauth2.client.secret}") String clientSecret){
        this.tokenUrl = tokenUrl;
        this.clientKey = clientKey;
        this.clientSecret = clientSecret;
    }

    @Bean
    ClientRegistration clientRegistration() {
        return ClientRegistration.withRegistrationId("Oauth2 token client")
                .clientId(clientKey)
                .clientSecret(clientSecret)
                .tokenUri(tokenUrl)
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .build();
    }
}