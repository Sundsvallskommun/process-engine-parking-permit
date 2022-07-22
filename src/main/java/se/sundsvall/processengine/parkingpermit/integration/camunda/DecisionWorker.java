package se.sundsvall.processengine.parkingpermit.integration.camunda;

import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import se.sundsvall.processengine.parkingpermit.integration.DecisionClient;
import se.sundsvall.processengine.parkingpermit.integration.casedata.ErrandsClient;
import se.sundsvall.processengine.parkingpermit.integration.casedata.enums.DecisionType;
import se.sundsvall.processengine.parkingpermit.integration.casedata.model.DecisionDTO;
import se.sundsvall.processengine.parkingpermit.integration.casedata.model.ErrandDTO;

import java.util.List;

public class DecisionWorker implements ExternalTaskHandler {

    private ErrandsClient errandsClient;
    private DecisionClient decisionClient;

    public DecisionWorker (ErrandsClient errandsClient, DecisionClient decisionClient){
        this.errandsClient = errandsClient;
        this.decisionClient = decisionClient;
    }

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        String caseId = externalTask.getVariable("caseNumber");
        boolean isCitizen = externalTask.getVariable("isCitizen");

        List<ErrandDTO> errandList = errandsClient.getErrandById(caseId);

        ErrandDTO errandDTO = errandList.get(0);
        DecisionDTO decision = errandDTO.getDecision();


        if (isCitizen){
            decision.setDecisionType(DecisionType.APPROVAL);
            decision.setDescription("Personen är boende i Sundsvalls kommun. Nuvarande kontroll ger rekommenderat beslut att godkänna ansökan");
        }
        else {
            decision.setDecisionType(DecisionType.REJECTION);
            decision.setDescription("Personen är inte skriven i Sundsvalls kommun. Rekommenderar därför avslag på ansökan.");
        }

        decisionClient.postDecision(caseId,decision);

    }
}
