package catHouse.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static catHouse.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT;
import static catHouse.common.ConstantMessages.UNSUITABLE_HOUSE;
import static catHouse.common.ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseHouse implements House {
    private String name;
    private int capacity;
    private List<Toy> toys;
    private List<Cat> cats;

    protected BaseHouse(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        return toys.stream().mapToInt(Toy::getSoftness).sum();
    }

    @Override
    public void addCat(Cat cat) {
        if (capacity == this.cats.size()) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CAT);
        }

        String catType = cat.getClass().getSimpleName().replaceAll("Cat", "");

        if (this.getClass().getSimpleName().contains(catType)) {
            throw new IllegalStateException(UNSUITABLE_HOUSE);
        }
        this.cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        for (Cat c : cats) {
            c.eating();
        }
    }

    @Override
    public String getStatistics() {
        String catOutput = cats.isEmpty()
                ? "none"
                : cats.stream().map(Cat::getName).collect(Collectors.joining(" "));

        return String.format("%s %s:%n" +
                        "Cats: %s%n" +
                        "Toys: %d " +
                        "Softness: %d",
                name, this.getClass().getSimpleName(), catOutput, toys.size(), sumSoftness());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return toys;
    }
}
