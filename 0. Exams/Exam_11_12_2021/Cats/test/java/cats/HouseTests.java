package cats;

import org.junit.Test;
import static org.junit.Assert.*;

public class HouseTests {

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailNameIsNull() {
        new House(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenIsWhitespaces() {
        new House("  ", 10);
    }

    @Test
    public void testSetNameShouldSetCorrectName() {
        House house = new House("test_name", 10);
        assertEquals("test_name", house.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldThrowWithLessThanZeroCapacity() {
        new House("test_name", -1);
    }

    @Test
    public void testSetCapacityShouldSetCorrectCapacity() {
        House house = new House("test_name", 10);
        assertEquals(10, house.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatShouldFailWhenMaxCapacityIsReached() {
        House house = new House("test_name", 0);
        house.addCat(new Cat("test_cat"));
    }

    @Test
    public void testAddCatShouldIncreaseFishCount() {
        House house = new House("test_name", 10);
        house.addCat(new Cat("test_cat"));
        assertEquals(1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatShouldFailIfNoSuchFishAdded() {
        House house = new House("test_name", 10);
        house.removeCat("test_name");
    }

    @Test
    public void testRemoveCatShouldDecreaseCount() {
        House house = new House("test_name", 10);
        house.addCat(new Cat("test_name"));
        house.removeCat("test_name");
        assertEquals(0, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellCatShouldFailIfNoSuchFishAdded() {
        House house = new House("test_name", 10);
        house.catForSale("test_name");
    }

    @Test
    public void testSellCatShouldSetFishAsSold() {
        House house = new House("test_name", 10);
        Cat cat = new Cat("test_name");
        house.addCat(cat);
        house.catForSale("test_name");
        assertFalse(cat.isHungry());
    }

    @Test
    public void testGetInfo() {
        House house = new House("test_name", 10);
        house.addCat(new Cat("test_cat_1"));
        house.addCat(new Cat("test_cat_2"));
        house.addCat(new Cat("test_cat_3"));

        String expected = "The cat test_cat_1, test_cat_2, test_cat_3 is in the house test_name!";
        assertEquals(expected, house.statistics());
    }
}
