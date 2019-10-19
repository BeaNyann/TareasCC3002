package model.factories.units;

import model.map.Location;
import model.units.Fighter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for the Fighter Factory unit.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class FighterFactoryTest extends AbstractTestUnitFacory{
    private FighterFactory fighterFactory;

    @Override
    public void setTestUnit() {
        super.setTestUnit();
        fighterFactory = new FighterFactory();
    }

    @Override
    public IUnitFactory getTestUnit() {
        return fighterFactory;
    }


    @Test
    void setDefault() {
        fighterFactory.setHitPoints(0);
        fighterFactory.setMovement(50);
        fighterFactory.setLocation(new Location(10,10));
        fighterFactory.setDefault();
        assertEquals(getExpectedMaxHitPoints(),fighterFactory.create().getMaxHitPoints());
        assertEquals(getExpectedMovement(),fighterFactory.create().getMovement());
        assertEquals(getExpectedLocation(),fighterFactory.create().getLocation());
    }

    @Test
    void create() {
        Fighter fighter = new Fighter(20,2,getExpectedLocation());
        Fighter fighter2 = fighterFactory.create();
        assertEquals(fighter,fighter2);
    }

}
