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
import model.units.*;
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
        Location locationA = new Location(0,0);
        tactician.setAlpaca(locationA);
        assertTrue(tactician.getUnits().contains(new Alpaca(20, 2, locationA)));
        //es exactamente igual al otro? pruebo ambos a la vez al hacer eso?
        //TODO AAAAAAAAAAAA
    }

    @Test
    public void setUnits(){
        Location locationA = new Location(0,0); //puedo chantarlos en locations que no estan en el mapa?xd
        tactician.setAlpaca(locationA);
        assertTrue(tactician.getUnits().contains(new Alpaca(20, 2, locationA)));
        Location locationAr = new Location(1,1);
        tactician.setArcher(locationAr);
        assertTrue(tactician.getUnits().contains(new Archer(20, 2, locationAr)));
        Location locationC = new Location(2,2);
        tactician.setCleric(locationC);
        assertTrue(tactician.getUnits().contains(new Cleric(20, 2, locationC)));
        Location locationF = new Location(3,3);
        tactician.setFighter(locationF);
        assertTrue(tactician.getUnits().contains(new Fighter(20, 2, locationF)));
        Location locationH = new Location(4,4);
        tactician.setHero(locationH);
        assertTrue(tactician.getUnits().contains(new Hero(20, 2, locationH)));
        Location locationS = new Location(5,5);
        tactician.setSorcerer(locationS);
        assertTrue(tactician.getUnits().contains(new Sorcerer(20, 2, locationS)));
        Location locationSw = new Location(6,6);
        tactician.setSwordMaster(locationSw);
        assertTrue(tactician.getUnits().contains(new SwordMaster(20, 2, locationSw)));
    }
}
