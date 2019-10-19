package model.factories.units;

import model.map.Location;
import model.units.Sorcerer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for the Sorcerer Factory unit.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class SorcererFactoryTest extends AbstractTestUnitFacory{
    private SorcererFactory sorcererFactory;

    @Override
    public void setTestUnit() {
        super.setTestUnit();
        sorcererFactory = new SorcererFactory();
    }

    @Override
    public IUnitFactory getTestUnit() {
        return sorcererFactory;
    }


    @Test
    void setDefault() {
        sorcererFactory.setHitPoints(0);
        sorcererFactory.setMovement(50);
        sorcererFactory.setLocation(new Location(10,10));
        sorcererFactory.setDefault();
        assertEquals(getExpectedMaxHitPoints(),sorcererFactory.create().getMaxHitPoints());
        assertEquals(getExpectedMovement(),sorcererFactory.create().getMovement());
        assertEquals(getExpectedLocation(),sorcererFactory.create().getLocation());
    }

    @Test
    void create() {
        Sorcerer sorcerer = new Sorcerer(20,2,getExpectedLocation());
        Sorcerer sorcerer2 = sorcererFactory.create();
        assertEquals(sorcerer,sorcerer2);
    }

}
