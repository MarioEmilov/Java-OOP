package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.List;

public class MissionImpl implements Mission {
    @Override
    public void explore(State state, List<Explorer> explorers) {
        for (int j = 0; j < explorers.size(); j++) {
            Explorer explorer = explorers.get(j);
            for (int i = 0; i < state.getExhibits().size(); i++) {
                String currentExhibit = state.getExhibits().get(i);
                explorer.getSuitcase().getExhibits().add(currentExhibit);
                state.getExhibits().remove(currentExhibit);
                i--;
                explorer.search();
                if(!explorer.canSearch()){
                    explorers.remove(explorer);
                    j--;
                    break;
                }
            }
        }
    }
}
