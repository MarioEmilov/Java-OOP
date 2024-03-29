package aquarium.entities.fish;

public class SaltwaterFish extends BaseFish {
    private static final int SIZE = 2;

    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
        setSize(SIZE);
    }

    @Override
    public void eat() {
        int newSize = getSize() + SIZE;
        setSize(newSize);
    }
}
