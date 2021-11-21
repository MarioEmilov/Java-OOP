package barracksWars_04.core.commands;

import barracksWars_04.interfaces.Repository;
import barracksWars_04.interfaces.UnitFactory;

public class Report extends Command{

    protected Report(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return getRepository().getStatistics();
    }
}
