package model.factories.units;

import model.map.Location;
import model.units.Alpaca;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for the Alpaca Factory unit.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class AlpacaFactoryTest extends AbstractTestUnitFacory{
    private AlpacaFactory alpacaFactory;

    @Override
    public void setTestUnit() {
        super.setTestUnit();
        alpacaFactory = new AlpacaFactory();
    }

    @Override
    public IUnitFactory getTestUnit() {
        return alpacaFactory;
    }


    @Test
    void setDefault() {
        alpacaFactory.setHitPoints(0);
        alpacaFactory.setMovement(50);
        alpacaFactory.setLocation(new Location(10,10));
        alpacaFactory.setDefault();
        assertEquals(getExpectedMaxHitPoints(),alpacaFactory.create().getMaxHitPoints());
        assertEquals(getExpectedMovement(),alpacaFactory.create().getMovement());
        assertEquals(getExpectedLocation(),alpacaFactory.create().getLocation());
    }

    @Test
    void create() {
        Alpaca alpaca = new Alpaca(20,2,getExpectedLocation());
        Alpaca alpaca2 = alpacaFactory.create();
        assertEquals(alpaca,alpaca2);
    }

}
