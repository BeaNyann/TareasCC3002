package model.tactician;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controller.GameController;
import controller.Pair;
import model.factories.items.*;
import model.factories.units.*;
import model.map.Field;
import model.units.*;
import model.map.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertTrue(tactician.getGlobalUnits().contains(alpaca));
        Archer archer = archerFactory.create();
        tactician.addUnit(archer);
        assertTrue(tactician.getGlobalUnits().contains(archer));
        Cleric cleric = clericFactory.create();
        tactician.addUnit(cleric);
        assertTrue(tactician.getGlobalUnits().contains(cleric));
        Fighter fighter = fighterFactory.create();
        tactician.addUnit(fighter);
        assertTrue(tactician.getGlobalUnits().contains(fighter));
        Hero hero = heroFactory.create();
        tactician.addUnit(hero);
        assertTrue(tactician.getGlobalUnits().contains(hero));
        Sorcerer sorcerer = sorcererFactory.create();
        tactician.addUnit(sorcerer);
        assertTrue(tactician.getGlobalUnits().contains(sorcerer));
        SwordMaster swordMaster = swordMasterFactory.create();
        tactician.addUnit(swordMaster);
        assertTrue(tactician.getGlobalUnits().contains(swordMaster));
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
        assertEquals(units,tactician.getGlobalUnits());
    }

    @Test
    void addDeadHeroObserver() {
    }

    @Test
    void setDeadHero() {
    }

    @Test
    void restoreUnits() {
        tactician.addUnit(alpacaFactory.create());
        Alpaca alpaca = alpacaFactory.create();
        assertEquals(1,tactician.getGlobalUnits().size());
        assertEquals(alpaca,tactician.getGlobalUnits().get(0));
        assertEquals(0,tactician.getUnits().size());
        tactician.restoreUnits();
        assertEquals(1,tactician.getUnits().size());
        assertEquals(alpaca,tactician.getUnits().get(0));
    }

    @Test
    void restoreHarmedUnits(){
        tactician.addUnit(alpacaFactory.create());
        tactician.restoreUnits();
        tactician.getUnits().get(0).setNormalDamage(5);
        assertEquals(15,tactician.getUnits().get(0).getCurrentHitPoints());
        tactician.restoreUnits();
        assertEquals(20,tactician.getUnits().get(0).getCurrentHitPoints());
    }

    @Test
    void getAliveUnits() {
        tactician.addUnit(alpacaFactory.create());
        tactician.restoreUnits();
        Alpaca alpaca = alpacaFactory.create();
        assertEquals(1,tactician.getUnits().size());
        assertEquals(alpaca,tactician.getUnits().get(0));
    }

    @Test
    void getLocations() {
        tactician.addUnit(alpacaFactory.create());
        Location location = new Location(0,1);
        tactician.setLocations(location);
        assertEquals(1,tactician.getLocations().size());
    }

    @Test
    void eraseLocations() {
        tactician.addUnit(alpacaFactory.create());
        Location location = new Location(0,1);
        tactician.setLocations(location);
        tactician.eraseLocations();
        assertEquals(0,tactician.getLocations().size());
    }

    @Test
    void setLocations() {
        tactician.addUnit(alpacaFactory.create());
        Location location = new Location(0,1);
        tactician.setLocations(location);
        Pair pair = new Pair(0,1);
        assertEquals(pair,tactician.getLocations().get(0));
    }

    @Test
    void removeUnit(){
        Alpaca alpaca = alpacaFactory.create();
        Archer archer = archerFactory.create();
        tactician.addUnit(alpaca);
        tactician.addUnit(archer);
        tactician.restoreUnits();

        tactician.removeUnit(alpaca);

        assertEquals(1,tactician.getUnits().size());
        assertEquals(1,tactician.getMovedUnit().size());
        assertTrue(tactician.getUnits().contains(archer));
        assertFalse(tactician.getUnits().contains(alpaca));

        tactician.removeUnit(archer);
        assertEquals(0,tactician.getUnits().size());
        assertEquals(0,tactician.getMovedUnit().size());
        assertFalse(tactician.getUnits().contains(archer));
    }

    @Test
    void setMovedUnit(){
        Alpaca alpaca = alpacaFactory.create();
        Archer archer = archerFactory.create();
        tactician.addUnit(alpaca);
        tactician.addUnit(archer);
        tactician.restoreUnits();

        tactician.setMovedUnit(1);
        assertTrue(tactician.getMovedUnit().get(1));
    }

    @Test
    void setMapField(){
        Field map = new Field();
        tactician.setMapField(map);
        assertEquals(map,tactician.getMapField());
    }

    @Test
    void getMapField(){
        Field map = new Field();
        tactician.setMapField(map);
        assertNotNull(tactician.getMapField());
    }

    @Test
    void checkUnits(){
        GameController gameController = new GameController(4,7);
        Tactician tactician = gameController.getCurrentOrder().get(0);
        tactician.addUnit(alpacaFactory.create());
        tactician.addUnit(archerFactory.create());
        tactician.restoreUnits();

        gameController.initGame(5);

        tactician.getUnits().get(0).setBigDamage(50);
        tactician.checkUnits();
        assertEquals(1,tactician.getUnits().size());
        assertFalse(tactician.getUnits().contains(alpacaFactory.create()));
    }

}
