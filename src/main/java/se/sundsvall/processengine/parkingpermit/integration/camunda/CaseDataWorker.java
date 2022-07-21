package se.sundsvall.processengine.parkingpermit.integration.camunda;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Component;
import se.sundsvall.processengine.parkingpermit.integration.casedata.ErrandsClient;
import se.sundsvall.processengine.parkingpermit.integration.casedata.enums.StakeholderRole;
import se.sundsvall.processengine.parkingpermit.integration.casedata.enums.StakeholderType;
import se.sundsvall.processengine.parkingpermit.integration.casedata.model.ErrandDTO;
import se.sundsvall.processengine.parkingpermit.integration.casedata.model.PersonDTO;
import se.sundsvall.processengine.parkingpermit.integration.casedata.model.StakeholderDTO;
import se.sundsvall.processengine.parkingpermit.integration.citizen.CitizenClient;
import java.util.*;
import java.util.stream.Collectors;

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

        List<ErrandDTO> errandList = errandsClient.getErrandById(caseId);

        StakeholderDTO stakeholderDTO = new PersonDTO();

        List<PersonDTO> personDTOList = errandList.stream()
                .flatMap(errand -> errand.getStakeholders()
                        .stream()
                        .filter(stakeholder -> stakeholder.getType().getText().equals(StakeholderType.PERSON.getText())))
                .map(stakeHolderDto -> (PersonDTO) stakeHolderDto)
                .collect(Collectors.toList());

        Optional<PersonDTO> optionalPersonDTO = personDTOList.stream()
                .filter(person -> person.getRoles().contains(StakeholderRole.APPLICANT))
                .findFirst();

        PersonDTO personDTO = optionalPersonDTO.orElseThrow();

        boolean isPersonCitizen = citizenClient.isPersonCitizen(personDTO.getPersonId());
        Map<String,Object> camundaVariables = new HashMap<>();
        camundaVariables.put("isCitizen",isPersonCitizen);

        externalTaskService.complete(externalTask,camundaVariables);

    }
}
