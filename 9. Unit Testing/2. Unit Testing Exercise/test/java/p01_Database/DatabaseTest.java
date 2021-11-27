package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    @Before
    public void prepare() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    //Test the constructor
    private static final Integer[] NUMBERS = {1, 2, 3, 4};
    private Database database;

    //1. Constructor creates Database instance (Happy path)
    @Test
    public void testConstructorShouldCreateValidDatabase() throws OperationNotSupportedException {
        Integer[] dbElements = database.getElements();
        Assert.assertEquals("Count of db elements is incorrect", dbElements.length, NUMBERS.length);
        for (int i = 0; i < NUMBERS.length; i++) {
            Assert.assertEquals("We have different elements in the database", dbElements[i], NUMBERS[i]);
        }
    }

    //2. If constructor takes more than 16 elements -> OperationNotSupportedException
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExceptionForMoreThan16Elements() throws OperationNotSupportedException {
        Integer[] largeArray = new Integer[17];
        new Database(largeArray);
    }

    //3. If constructor takes less than 0 elements -> OperationNotSupportedException
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExceptionForLessThan1Elements() throws OperationNotSupportedException {
        Integer[] smallArray = new Integer[0];
        new Database(smallArray);
    }

    //4. Add method with null element -> OperationNotSupportedException
    @Test(expected = OperationNotSupportedException.class)
    public void testAddThrowsExceptionWithNullArgument() throws OperationNotSupportedException {
        database.add(null);
    }

    //5. Add method works fine (Happy path)
    @Test
    public void testAddShouldAddElement() throws OperationNotSupportedException {
        database.add(6);
        Integer[] dbElements = database.getElements();
        Assert.assertEquals(dbElements.length, NUMBERS.length + 1);
        Assert.assertEquals(dbElements[dbElements.length - 1], Integer.valueOf(6));
    }

    //6. Remove should throw Exception
    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowException() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }

    //7. Remove should remove last element
    @Test
    public void testRemoveShouldRemoveLastElement() throws OperationNotSupportedException {
        database.remove();
        Integer[] dbElements = database.getElements();
        Assert.assertEquals(NUMBERS.length - 1, dbElements.length);
        Assert.assertEquals(Integer.valueOf(NUMBERS.length - 1), dbElements[dbElements.length - 1]);
    }
}