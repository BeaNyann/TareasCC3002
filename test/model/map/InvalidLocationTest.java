package model.map;

import model.units.Alpaca;
import model.units.IUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Beatriz Graboloza
 * @since 1.0
 */
public class InvalidLocationTest {

    /** Test locations */
    private Location
            locationA0,
            locationB0,
            locationA1;
    private IUnit unit;

    @BeforeEach
    void setUp() {
        locationA0 = new InvalidLocation();
        locationB0 = new Location(1, 0);
        unit = new Alpaca(50, 2, locationB0);
    }

    @Test
    void testNeighbourhood() {
        assertTrue(locationA0.getNeighbours().isEmpty());

        locationA0.addNeighbour(locationB0);
        assertEquals(0, locationA0.getNeighbours().size());
        assertEquals(0, locationB0.getNeighbours().size());
        assertFalse(locationA0.isNeighbour(locationB0));
        assertFalse(locationB0.isNeighbour(locationA0));
    }

}
