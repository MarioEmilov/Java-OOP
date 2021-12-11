package catHouse.entities.cat;

public class ShorthairCat extends BaseCat {
    private static final int KILOGRAMS = 1;

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        setKilograms(KILOGRAMS);
    }

    @Override
    public void eat() {
        int newKilograms = getKilograms() + KILOGRAMS;
        setKilograms(newKilograms);
    }
}
