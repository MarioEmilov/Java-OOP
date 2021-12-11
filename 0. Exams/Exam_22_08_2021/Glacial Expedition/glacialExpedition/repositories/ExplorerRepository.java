package glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExplorerRepository implements Repository<Explorer> {
    List<Explorer> explorers;

    public ExplorerRepository() {
        this.explorers = new ArrayList<>();
    }

    @Override
    public List<Explorer> getCollection() {
        return Collections.unmodifiableList(this.explorers);
    }

    @Override
    public void add(Explorer entity) {
        this.explorers.add(entity);
    }

    @Override
    public boolean remove(Explorer entity) {
        return this.explorers.remove(entity);
    }

    @Override
    public Explorer byName(String name) {
        for (Explorer explorer : explorers) {
            if(explorer.getName().equals(name)){
                return explorer;
            }
        }
        return null;
    }
}
