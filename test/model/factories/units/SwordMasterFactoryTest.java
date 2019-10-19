package model.factories.units;

import model.map.Location;
import model.units.SwordMaster;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for the SwordMaster Factory unit.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class SwordMasterFactoryTest extends AbstractTestUnitFacory{
    private SwordMasterFactory swordMasterFactory;

    @Override
    public void setTestUnit() {
        super.setTestUnit();
        swordMasterFactory = new SwordMasterFactory();
    }

    @Override
    public IUnitFactory getTestUnit() {
        return swordMasterFactory;
    }


    @Test
    void setDefault() {
        swordMasterFactory.setHitPoints(0);
        swordMasterFactory.setMovement(50);
        swordMasterFactory.setLocation(new Location(10,10));
        swordMasterFactory.setDefault();
        assertEquals(getExpectedMaxHitPoints(),swordMasterFactory.create().getMaxHitPoints());
        assertEquals(getExpectedMovement(),swordMasterFactory.create().getMovement());
        assertEquals(getExpectedLocation(),swordMasterFactory.create().getLocation());
    }

    @Test
    void create() {
        SwordMaster swordMaster = new SwordMaster(20,2,getExpectedLocation());
        SwordMaster swordMaster2 = swordMasterFactory.create();
        assertEquals(swordMaster,swordMaster2);
    }

}
