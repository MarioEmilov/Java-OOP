package barracksWars_04;

import barracksWars_04.core.Engine;
import barracksWars_04.core.factories.UnitFactoryImpl;
import barracksWars_04.data.UnitRepository;
import barracksWars_04.interfaces.Repository;
import barracksWars_04.interfaces.UnitFactory;

public class Main {
    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
