package model.tactician;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import model.tactician.Tactician;
import model.map.Field;
import model.units.Alpaca;
import model.map.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Beatriz Graboloza
 * @since v2.0
 */

public class TacticianTest {

    private Tactician tactician;
    private long randomSeed;

    @BeforeEach
    void setUp() {
        // Se define la semilla como un número aleatorio para generar variedad en los tests
        randomSeed = new Random().nextLong();
        tactician = new Tactician("Player 0");
    }

    @Test
    public void getName(){
        assertEquals("Player 0", tactician.getName());
    }

    @Test
    public void getUnits(){
        tactician.setUnit();
        //assertEquals(? el tactician elige que units mete auxilio);
        //TODO AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    }

    @Test
    public void setUnits(){
        Location location = new Location(0,0);
        tactician.setAlpaca(location);
        assertTrue(tactician.getUnits().contains(new Alpaca(20, 2, location)));
        tactician.setArcher(location);
        assertTrue(tactician.getUnits().contains(new Archer(20, 2, location)));
        tactician.setCleric(location);
        assertTrue(tactician.getUnits().contains(new Cleric(20, 2, location)));
        tactician.setFighter(location);
        assertTrue(tactician.getUnits().contains(new Fighter(20, 2, location)));
        tactician.setHero(location);
        assertTrue(tactician.getUnits().contains(new Hero(20, 2, location)));
        tactician.setSorcerer(location);
        assertTrue(tactician.getUnits().contains(new Sorcerer(20, 2, location)));
        tactician.setSwordMaster(location);
        assertTrue(tactician.getUnits().contains(new SwordMaster(20, 2, location)));


    }
}
