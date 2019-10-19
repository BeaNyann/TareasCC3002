package model.factories.items;

import model.items.IEquipableItem;
import model.units.IUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Defines some common methods for all the item factory tests.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public abstract class AbstractTestItemFactory {
    protected String expectedName;
    protected double expectedPower;
    protected short expectedMinRange;
    protected short expectedMaxRange;

    /**
     * Sets up the items to be tested
     */
    @BeforeEach
    public void setUp() {
        setTestItem();
    }

    /**
     * Sets up a correctly implemented item that's going to be tested.
     */
    public abstract void setTestItem();

    /**
     * Tests that the constructor for the tested item works properly.
     */
    @Test
    public void constructorTest() {
        assertEquals(getExpectedName(), getTestItem().create().getName());
        assertEquals(getExpectedBasePower(), getTestItem().create().getPower(),1E-6);
        assertEquals(getExpectedMinRange(), getTestItem().create().getMinRange());
        assertEquals(getExpectedMaxRange(), getTestItem().create().getMaxRange());
    }

    /**
     * @return the expected name of the item.
     */
    public String getExpectedName() {
        return expectedName;
    }

    /**
     * @return the item being tested.
     */
    public abstract IEquipableItemFactory getTestItem();

    /**
     * @return the expected power of the Item.
     */
    public double getExpectedBasePower() {
        return expectedPower;
    }

    /**
     * @return the expected minimum range of the item.
     */
    public int getExpectedMinRange() {
        return expectedMinRange;
    }

    /**
     * @return the expected maximum range of the item.
     */
    public int getExpectedMaxRange() {
        return expectedMaxRange;
    }


    @Test
    void setName() {
        getTestItem().setName("uwu");
        assertEquals("uwu",getTestItem().getName());
    }

    @Test
    void setPower() {
        getTestItem().setPower(100);
        assertEquals(100,getTestItem().getPower());
    }

    @Test
    void setMaxRange() {
        getTestItem().setMaxRange(20);
        assertEquals(20,getTestItem().getMaxRange());
    }

    @Test
    void setMinRange() {
        getTestItem().setMaxRange(20);
        getTestItem().setMinRange(19);
        assertEquals(19,getTestItem().getMinRange());
    }

    @Test
    void getName() {
        assertEquals(getExpectedName(),getTestItem().getName());
    }

    @Test
    void getPower() {
        assertEquals(getExpectedBasePower(),getTestItem().getPower());
    }

    @Test
    void getMaxRange() {
        assertEquals(getExpectedMaxRange(),getTestItem().getMaxRange());
    }

    @Test
    void getMinRange() {
        assertEquals(getExpectedMinRange(),getTestItem().getMinRange());
    }
}
