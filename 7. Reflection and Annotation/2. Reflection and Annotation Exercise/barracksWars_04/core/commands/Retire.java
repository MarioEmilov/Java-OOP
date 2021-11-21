package barracksWars_04.core.commands;

import barracksWars_04.interfaces.Repository;
import barracksWars_04.interfaces.UnitFactory;

public class Retire extends Command{

    protected Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getData()[1]; // take second param from super(data,...) -> retire Archer
        getRepository().removeUnit(unitType);
        return unitType + " retired!";
    }
}
