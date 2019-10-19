package model.factories.units;

import model.map.Location;
import model.units.Hero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for the Hero Factory unit.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class HeroFactoryTest extends AbstractTestUnitFacory{
    private HeroFactory heroFactory;

    @Override
    public void setTestUnit() {
        super.setTestUnit();
        heroFactory = new HeroFactory();
    }

    @Override
    public IUnitFactory getTestUnit() {
        return heroFactory;
    }


    @Test
    void setDefault() {
        heroFactory.setHitPoints(0);
        heroFactory.setMovement(50);
        heroFactory.setLocation(new Location(10,10));
        heroFactory.setDefault();
        assertEquals(getExpectedMaxHitPoints(),heroFactory.create().getMaxHitPoints());
        assertEquals(getExpectedMovement(),heroFactory.create().getMovement());
        assertEquals(getExpectedLocation(),heroFactory.create().getLocation());
    }

    @Test
    void create() {
        Hero hero = new Hero(20,2,getExpectedLocation());
        Hero hero2 = heroFactory.create();
        assertEquals(hero,hero2);
    }

}
