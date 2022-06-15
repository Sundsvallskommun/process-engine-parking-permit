package se.sundsvall.processengine.parkingpermit.integration.camunda;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.context.annotation.Configuration;
import se.sundsvall.processengine.parkingpermit.integration.casedata.ErrandsClient;

@Configuration
@ExternalTaskSubscription("caseData")
public class CaseDataWorker implements ExternalTaskHandler {

    private ErrandsClient errandsClient;

    public CaseDataWorker(ErrandsClient errandsClient){
        this.errandsClient = errandsClient;
    }

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        String caseId = externalTask.getVariable("caseId");

        String errandString = errandsClient.getErrandById(caseId);

        System.out.println(errandString);
        
        externalTaskService.complete(externalTask);
    }
}
