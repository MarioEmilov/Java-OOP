package catHouse.entities.cat;

public class LonghairCat extends BaseCat {
    private static final int KILOGRAMS = 3;

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
        setKilograms(KILOGRAMS);
    }

    @Override
    public void eat() {
        int newKilograms = getKilograms() + KILOGRAMS;
        setKilograms(newKilograms);
    }
}
