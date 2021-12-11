package glacialExpedition.repositories;

import glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StateRepository implements Repository<State>{

    List<State> states;

    public StateRepository() {
        this.states = new ArrayList<>();
    }

    @Override
    public List<State> getCollection() {
        return Collections.unmodifiableList(this.states);
    }

    @Override
    public void add(State entity) {
        this.states.add(entity);
    }

    @Override
    public boolean remove(State entity) {
        return this.states.remove(entity);
    }

    @Override
    public State byName(String name) {
        for (State state : states) {
            if(state.getName().equals(name)){
                return state;
            }
        }
        return null;
    }
}
