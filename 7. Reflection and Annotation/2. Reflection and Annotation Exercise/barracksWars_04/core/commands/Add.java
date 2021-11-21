package barracksWars_04.core.commands;

import barracksWars_04.interfaces.Repository;
import barracksWars_04.interfaces.Unit;
import barracksWars_04.interfaces.UnitFactory;

public class Add extends Command{

    protected Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        Unit unitToAdd = getUnitFactory().createUnit(unitType);
        getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }
}
