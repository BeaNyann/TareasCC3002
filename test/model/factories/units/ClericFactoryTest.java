package model.factories.units;

import model.map.Location;
import model.units.Cleric;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for the Cleric Factory unit.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class ClericFactoryTest extends AbstractTestUnitFacory{
    private ClericFactory clericFactory;

    @Override
    public void setTestUnit() {
        super.setTestUnit();
        clericFactory = new ClericFactory();
    }

    @Override
    public IUnitFactory getTestUnit() {
        return clericFactory;
    }


    @Test
    void setDefault() {
        clericFactory.setHitPoints(0);
        clericFactory.setMovement(50);
        clericFactory.setLocation(new Location(10,10));
        clericFactory.setDefault();
        assertEquals(getExpectedMaxHitPoints(),clericFactory.create().getMaxHitPoints());
        assertEquals(getExpectedMovement(),clericFactory.create().getMovement());
        assertEquals(getExpectedLocation(),clericFactory.create().getLocation());
    }

    @Test
    void create() {
        Cleric cleric = new Cleric(20,2,getExpectedLocation());
        Cleric cleric2 = clericFactory.create();
        assertEquals(cleric,cleric2);
    }

}
