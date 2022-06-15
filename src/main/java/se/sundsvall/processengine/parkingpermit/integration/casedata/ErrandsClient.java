package se.sundsvall.processengine.parkingpermit.integration.casedata;

import org.springframework.beans.factory.annotation.Value;

public class ErrandsClient {

    private String caseDataErrandsUrl;

    public ErrandsClient(@Value("${casedata.errands.url}") String caseDataErrandsUrl){
        this.caseDataErrandsUrl = caseDataErrandsUrl;
    }

    public String getErrandById(String errandId){



        return null;
    }

}