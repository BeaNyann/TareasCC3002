package model.factories.units;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import model.map.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class AbstractTestUnitFacory {
    protected int expectedMaxHitPoints;
    protected int expectedMovement;
    protected Location expectedLocation;

    /**
     * Sets up the units and weapons to be tested
     */
    @BeforeEach
    public void setUp() {
        setTestUnit();
    }

    /**
     * Set up the main unit that's going to be tested in the test set
     */
    public void setTestUnit(){
        expectedMaxHitPoints = 20;
        expectedMovement = 2;
        expectedLocation = new Location(0,0);
    }

    /**
     * Checks that the constructor works properly.
     */
    @Test
    public void constructorTest() {
        assertEquals(getExpectedMaxHitPoints(), getTestUnit().create().getMaxHitPoints());
        assertEquals(getExpectedMovement(), getTestUnit().create().getMovement());
        assertEquals(getExpectedLocation(), getTestUnit().create().getLocation());
        assertTrue(getTestUnit().create().getItems().isEmpty());
    }

    /**
     * @return the current unit being tested
     */
    public abstract IUnitFactory getTestUnit();

    public int getExpectedMaxHitPoints(){
        return this.expectedMaxHitPoints;
    }

    public int getExpectedMovement(){
        return this.expectedMovement;
    }

    public Location getExpectedLocation(){
        return this.expectedLocation;
    }

    @Test
    void setHitPoints() {
        getTestUnit().setHitPoints(50);
        assertEquals(50,getTestUnit().getHitPoints());
    }

    @Test
    void setMovement() {
        getTestUnit().setMovement(100);
        assertEquals(100,getTestUnit().getMovement());
    }

    @Test
    void setLocation() {
        getTestUnit().setLocation(new Location(1,1));
        assertEquals(new Location(1,1),getTestUnit().getLocation());
    }

    @Test
    void getHitPoints() {
        assertEquals(getExpectedMaxHitPoints(),getTestUnit().getHitPoints());
    }

    @Test
    void getMovement() {
        assertEquals(getExpectedMovement(),getTestUnit().getMovement());
    }

    @Test
    void getLocation() {
        assertEquals(getExpectedLocation(),getTestUnit().getLocation());
    }
}
