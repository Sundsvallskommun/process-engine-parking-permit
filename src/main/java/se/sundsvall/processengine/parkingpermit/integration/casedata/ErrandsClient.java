package se.sundsvall.processengine.parkingpermit.integration.casedata;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class ErrandsClient {

    private String caseDataErrandsUrl;

    public ErrandsClient(@Value("${casedata.errands.url}") String caseDataErrandsUrl){
        this.caseDataErrandsUrl = caseDataErrandsUrl;
    }

    public String getErrandById(String errandId){

        WebClient webClient = WebClient.builder()
                .baseUrl(caseDataErrandsUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
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