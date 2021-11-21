package barracksWars_04.core.commands;

import barracksWars_04.interfaces.Repository;
import barracksWars_04.interfaces.UnitFactory;

public class Fight extends Command{

    protected Fight(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
