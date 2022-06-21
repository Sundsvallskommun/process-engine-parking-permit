package se.sundsvall.processengine.parkingpermit.integration.camunda;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Component;
import se.sundsvall.processengine.parkingpermit.integration.casedata.ErrandsClient;
import se.sundsvall.processengine.parkingpermit.integration.casedata.model.Errand;
import se.sundsvall.processengine.parkingpermit.integration.citizen.CitizenClient;
import java.util.*;

@Component
@ExternalTaskSubscription("caseData")
public class CaseDataWorker implements ExternalTaskHandler {

    private ErrandsClient errandsClient;
    private CitizenClient citizenClient;

    public CaseDataWorker(ErrandsClient errandsClient, CitizenClient citizenClient) {
        this.errandsClient = errandsClient;
        this.citizenClient = citizenClient;
    }

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        String caseId = externalTask.getVariable("caseNumber");


        List<Errand> errandList = errandsClient.getErrandById(caseId);

        Optional<String> personIdOptional = errandList.stream()
                .flatMap(errand -> errand.getStakeholders()
                        .stream()
                        .filter(stakeholder -> stakeholder.getRoles().contains("APPLICANT"))
                        .map(stakeholder -> stakeholder.getPersonId()))
                .findAny();

        String personId = personIdOptional.orElseThrow();

        boolean isPersonCitizen = citizenClient.isPersonCitizen(personId);
        Map<String,Object> camundaVariables = new HashMap<>();
        camundaVariables.put("isCitizen",isPersonCitizen);

        externalTaskService.complete(externalTask,camundaVariables);

    }
}
