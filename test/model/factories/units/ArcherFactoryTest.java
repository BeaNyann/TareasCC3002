package model.factories.units;

import model.map.Location;
import model.units.Archer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for the Archer Factory unit.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class ArcherFactoryTest extends AbstractTestUnitFacory{
    private ArcherFactory archerFactory;

    @Override
    public void setTestUnit() {
        super.setTestUnit();
        archerFactory = new ArcherFactory();
    }

    @Override
    public IUnitFactory getTestUnit() {
        return archerFactory;
    }


    @Test
    void setDefault() {
        archerFactory.setHitPoints(0);
        archerFactory.setMovement(50);
        archerFactory.setLocation(new Location(10,10));
        archerFactory.setDefault();
        assertEquals(getExpectedMaxHitPoints(),archerFactory.create().getMaxHitPoints());
        assertEquals(getExpectedMovement(),archerFactory.create().getMovement());
        assertEquals(getExpectedLocation(),archerFactory.create().getLocation());
    }

    @Test
    void create() {
        Archer archer = new Archer(20,2,getExpectedLocation());
        Archer archer2 = archerFactory.create();
        assertEquals(archer,archer2);
    }

}
