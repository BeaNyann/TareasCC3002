package model.tactician;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import model.factories.items.*;
import model.factories.units.*;
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

    private AlpacaFactory alpacaFactory = new AlpacaFactory();
    private ArcherFactory archerFactory = new ArcherFactory();
    private ClericFactory clericFactory = new ClericFactory();
    private FighterFactory fighterFactory = new FighterFactory();
    private HeroFactory heroFactory = new HeroFactory();
    private SorcererFactory sorcererFactory = new SorcererFactory();
    private SwordMasterFactory swordMasterFactory = new SwordMasterFactory();

    private AxeFactory axeFactory = new AxeFactory();
    private BowFactory bowFactory = new BowFactory();
    private DarkMagicBookFactory darkMagicBookFactory = new DarkMagicBookFactory();
    private LightMagicBookFactory lightMagicBookFactory = new LightMagicBookFactory();
    private SpearFactory spearFactory = new SpearFactory();
    private SpiritMagicBookFactory spiritMagicBookFactory = new SpiritMagicBookFactory();
    private StaffFactory staffFactory = new StaffFactory();
    private SwordFactory swordFactory = new SwordFactory();

    @BeforeEach
    void setUp() {
        // Se define la semilla como un número aleatorio para generar variedad en los tests
        randomSeed = new Random().nextLong();
        tactician = new Tactician("Player 0");
    }

    @Test
    void getName(){
        assertEquals("Player 0", tactician.getName());
    }

    @Test
    void addUnit(){
        Alpaca alpaca = alpacaFactory.create();
        tactician.addUnit(alpaca);
        assertTrue(tactician.getUnits().contains(alpaca));
        Archer archer = archerFactory.create();
        tactician.addUnit(archer);
        assertTrue(tactician.getUnits().contains(archer));
        Cleric cleric = clericFactory.create();
        tactician.addUnit(cleric);
        assertTrue(tactician.getUnits().contains(cleric));
        Fighter fighter = fighterFactory.create();
        tactician.addUnit(fighter);
        assertTrue(tactician.getUnits().contains(fighter));
        Hero hero = heroFactory.create();
        tactician.addUnit(hero);
        assertTrue(tactician.getUnits().contains(hero));
        Sorcerer sorcerer = sorcererFactory.create();
        tactician.addUnit(sorcerer);
        assertTrue(tactician.getUnits().contains(sorcerer));
        SwordMaster swordMaster = swordMasterFactory.create();
        tactician.addUnit(swordMaster);
        assertTrue(tactician.getUnits().contains(swordMaster));
    }

    @Test
    void getUnits(){

        Alpaca alpaca = alpacaFactory.create();
        tactician.addUnit(alpaca);
        Archer archer = archerFactory.create();
        tactician.addUnit(archer);
        Cleric cleric = clericFactory.create();
        tactician.addUnit(cleric);
        Fighter fighter = fighterFactory.create();
        tactician.addUnit(fighter);
        Hero hero = heroFactory.create();
        tactician.addUnit(hero);
        Sorcerer sorcerer = sorcererFactory.create();
        tactician.addUnit(sorcerer);
        SwordMaster swordMaster = swordMasterFactory.create();
        tactician.addUnit(swordMaster);
        List<IUnit> units = new ArrayList<>();
        units.add(alpaca);
        units.add(archer);
        units.add(cleric);
        units.add(fighter);
        units.add(hero);
        units.add(sorcerer);
        units.add(swordMaster);
        assertEquals(units,tactician.getUnits());
    }
}
