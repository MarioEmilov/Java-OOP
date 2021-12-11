package glacialExpedition.core;

import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.List;
import java.util.stream.Collectors;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private ExplorerRepository explorerRepository;
    private StateRepository stateRepository;
    int explored = 0;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer = null;
        switch (type){
            case"GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case"NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            case"AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            default:throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        }
        explorerRepository.add(explorer);
        return String.format(EXPLORER_ADDED,type,explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        for (String exhibit : exhibits) {
            state.getExhibits().add(exhibit);
        }
        stateRepository.add(state);

        return String.format(STATE_ADDED,stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
       if(this.explorerRepository.getCollection().stream().noneMatch(a->a.getName().equals(explorerName))){
           throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST,explorerName));
       }
       Explorer explorer = explorerRepository.byName(explorerName);
       this.explorerRepository.remove(explorer);
        return String.format(EXPLORER_RETIRED,explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        List<Explorer> suitableExplorers = this.explorerRepository.getCollection().stream().filter(ex->ex.getEnergy() > 50).collect(Collectors.toList());
        if(suitableExplorers.isEmpty()){
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }
        int countBefore = suitableExplorers.size();
        Mission mission = new MissionImpl();
        State state = this.stateRepository.byName(stateName);
        mission.explore(state,suitableExplorers);
        explored+=1;
        int afterCount = suitableExplorers.size();
        return String.format(STATE_EXPLORER,stateName,countBefore-afterCount);
    }

    @Override
    public String finalResult() {
        StringBuilder build = new StringBuilder();
        build.append(explored).append(" states were explored.").append(System.lineSeparator());
        build.append(FINAL_EXPLORER_INFO).append(System.lineSeparator());
        for (Explorer explorer : this.explorerRepository.getCollection()) {
            build.append("Name: " + explorer.getName() + System.lineSeparator());
            build.append(String.format("Energy: %.0f",explorer.getEnergy()) + System.lineSeparator());
            build.append("Suitcase exhibits: ");
            if(explorer.getSuitcase().getExhibits().isEmpty()){
                build.append("None");
            } else{
                String exhibit = String.join(", ", explorer.getSuitcase().getExhibits());
                build.append(exhibit);
            }
            build.append(System.lineSeparator());
        }
        return build.toString().trim();
    }
}
