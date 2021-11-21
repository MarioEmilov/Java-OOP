package barracksWars_04.core.factories;

import barracksWars_04.interfaces.Unit;
import barracksWars_04.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        // TODO: implement for problem 3
        Unit unit = null;
        try {
            Class<?> clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<?> ctor = clazz.getDeclaredConstructor();
            ctor.setAccessible(true);
            unit = (Unit) ctor.newInstance();

        } catch (ClassNotFoundException |
                NoSuchMethodException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException e) {
            e.printStackTrace();
        }
        return unit;
    }
}
