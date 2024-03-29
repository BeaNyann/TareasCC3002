package controller;

import static java.lang.Math.abs;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import model.factories.items.*;
import model.factories.units.*;
import model.items.*;
import model.map.Location;
import model.tactician.Tactician;
import model.map.Field;
import model.units.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Beatriz Graboloza
 * @since 2.0
 */
class GameControllerTest {

    private GameController controller;
    private long randomSeed;
    private List<String> testTacticians;

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
        controller = new GameController(4, 7);
        testTacticians = List.of("Player 0", "Player 1", "Player 2", "Player 3");
        controller.setSeed(randomSeed);
        controller.setGameMap();
    }


    @Test
    void randomTest() {
        Random randomowo = new Random();
        randomowo.nextInt();
        randomowo.setSeed(randomSeed);
        Random randomowo2 = new Random(randomSeed);
        for (int i = 0; i < 100; i++) {
            assertEquals(randomowo.nextInt(), randomowo2.nextInt());
        }
    }

    @Test
    void getTacticians() {
        List<Tactician> tacticians = controller.getTacticians();
        assertEquals(4, tacticians.size());
        for (int i = 0; i < tacticians.size(); i++) {
            assertEquals("Player " + i, tacticians.get(i).getName());
        }
    }

    @Test
    void getGameMap() {
        Field gameMap = controller.getGameMap();
        Field testMap = new Field();
        testMap.setSeed(randomSeed);
        for (int i = 0; i < gameMap.getSize(); i++) {
            for (int j = 0; j < gameMap.getSize(); j++) {
                testMap.addCells(false, new Location(i, j));
            }
        }
        assertEquals(7, gameMap.getSize());
        assertTrue(controller.getGameMap().isConnected());

        for (int i = 0; i < gameMap.getSize(); i++) {
            for (int j = 0; j < gameMap.getSize(); j++) {
                //assertTrue(testMap.getCell(i,j).getNeighbours().containsAll(gameMap.getCell(i,j).getNeighbours()));
                for (Location neighbour : gameMap.getCell(i, j).getNeighbours()) {
                    boolean found = false;
                    for (Location l : testMap.getCell(i, j).getNeighbours()) {
                        if (l.equals(neighbour)) {
                            found = true;
                        }
                    }
                    assertTrue(found, "Expected: " + neighbour.toString());
                }
            }
        }
        // Para testear funcionalidades que dependen de valores aleatorios se hacen 2 cosas:
        //  - Comprobar las invariantes de las estructuras que se crean (en este caso que el mapa tenga
        //    las dimensiones definidas y que sea conexo.
        //  - Setear una semilla para el generador de números aleatorios. Hacer esto hace que la
        //    secuencia de números generada sea siempre la misma, así pueden predecir los
        //    resultados que van a obtener.
        //    Hay 2 formas de hacer esto en Java, le pueden pasar el seed al constructor de Random, o
        //    usar el método setSeed de Random.
    }

    @Test
    void getTurnOwner() {
        //  En este caso deben hacer lo mismo que para el mapa : getCurrentOrder tiene el random
        controller.initGame(2);
        assertEquals(controller.getCurrentOrder().get(0), controller.getTurnOwner());
        controller.endTurn();
        assertEquals(controller.getCurrentOrder().get(1), controller.getTurnOwner());
        controller.endTurn();
        assertEquals(controller.getCurrentOrder().get(2), controller.getTurnOwner());
        controller.endTurn();
        assertEquals(controller.getCurrentOrder().get(3), controller.getTurnOwner());
        controller.endTurn();
    }

    @Test
    void getCurrentOrder() {
        //a veces por alguna razon set seed no hace nada y falla porque usan seed distintas
        //pero es como.. wtf? pq set seed debería... setear la seed y a veces no lo hace
        Random randomTurnSequence = new Random(randomSeed);
        controller.setSeed(randomSeed);
        List<Tactician> tacticians = controller.getCurrentOrder();
        List<Tactician> testTurns = new ArrayList<>();
        int i = 0;
        while (i < tacticians.size()) {
            int next = abs(randomTurnSequence.nextInt() % tacticians.size());
            if (!testTurns.contains(tacticians.get(next))) {
                testTurns.add(tacticians.get(next));
                i++;
            }
        }
        controller.reorderTurns();
        List<Tactician> newTurns = controller.getCurrentOrder();
        assertEquals(newTurns, testTurns);
    }

    @Test
    void getRoundNumber() {
        controller.initGame(10);
        for (int i = 1; i < 10; i++) {
            assertEquals(i, controller.getRoundNumber());
            for (int j = 0; j < 4; j++) {
                controller.endTurn();
            }
        }
    }

    @Test
    void getMaxRounds() {
        Random randomTurnSequence = new Random();
        IntStream.range(0, 50).map(i -> randomTurnSequence.nextInt() & Integer.MAX_VALUE).forEach(nextInt -> {
            controller.initGame(nextInt);
            //System.out.println(nextInt);
            assertEquals(nextInt, controller.getMaxRounds());
            //System.out.println(nextInt);
        });
        controller.initEndlessGame();
        assertEquals(-1, controller.getMaxRounds());
    }

    @Test
    void endTurn() {
        Tactician firstPlayer = controller.getTurnOwner();
        // Nuevamente, para determinar el orden de los jugadores se debe usar una semilla
        int pos = controller.getCurrentOrder().indexOf(controller.getTurnOwner());
        Tactician secondPlayer = controller.getCurrentOrder().get(pos + 1);
        assertNotEquals(secondPlayer.getName(), firstPlayer.getName());

        controller.endTurn();
        assertNotEquals(firstPlayer.getName(), controller.getTurnOwner().getName());
        assertEquals(secondPlayer.getName(), controller.getTurnOwner().getName());
    }

    @Test
    void removeTactician() {
        assertEquals(4, controller.getCurrentOrder().size());
        controller.getCurrentOrder()
                .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));

        controller.removeTactician("Player 0");
        assertEquals(3, controller.getCurrentOrder().size());
        controller.getCurrentOrder().forEach(tactician -> assertNotEquals("Player 0", tactician));
        controller.getCurrentOrder()
                .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));

        controller.removeTactician("Player 5");
        assertEquals(3, controller.getCurrentOrder().size());
        controller.getCurrentOrder()
                .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));
    }

    @Test
    void removeTacticianCheckTurns() {
        controller.initGame(5);
        List<Tactician> tacticiansOrder = controller.getCurrentOrder();
        Tactician secondTactician = tacticiansOrder.get(1);
        Tactician thirdTactician = tacticiansOrder.get(2);
        List<Tactician> expectedOrder = new ArrayList<>();
        expectedOrder.add(tacticiansOrder.get(0));
        expectedOrder.add(thirdTactician);
        expectedOrder.add(tacticiansOrder.get(3));
        controller.endTurn();
        controller.removeTactician(secondTactician.getName());
        assertEquals(thirdTactician, controller.getTurnOwner());
        assertEquals(expectedOrder, controller.getCurrentOrder());

        controller.endTurn();
        controller.endTurn();

        List<Tactician> tacticiansOrder2 = controller.getCurrentOrder();
        Tactician secondTactician2 = tacticiansOrder2.get(1);
        Tactician thirdTactician2 = tacticiansOrder2.get(2);
        List<Tactician> expectedOrder2 = new ArrayList<>();
        expectedOrder2.add(tacticiansOrder2.get(0));
        expectedOrder2.add(thirdTactician2);
        assertEquals(tacticiansOrder2.get(0), controller.getTurnOwner());
        controller.removeTactician(secondTactician2.getName());
        controller.endTurn();
        assertEquals(thirdTactician2, controller.getTurnOwner());
        assertEquals(expectedOrder2, controller.getCurrentOrder());

    }

    @Test
    void removeTacticianUnits() {
        Tactician tactician = controller.getCurrentOrder().get(0);
        controller.addAlpaca(tactician);
        controller.addArcher(tactician);
        controller.addSorcerer(tactician);
        tactician.restoreUnits();
        List<Location> locations = new ArrayList<>();
        locations.add(controller.getGameMap().getCell(0,1));
        locations.add(controller.getGameMap().getCell(1,0));
        locations.add(controller.getGameMap().getCell(1,1));
        controller.putUnitsOn(tactician,locations);

        controller.initGame(5);

        controller.removeTactician(tactician.getName());
        assertEquals(0,tactician.getUnits().size());
        controller.selectUnitIn(0,1);
        assertNull(controller.getSelectedUnit());
        controller.selectUnitIn(1,0);
        assertNull(controller.getSelectedUnit());
        controller.selectUnitIn(1,1);
        assertNull(controller.getSelectedUnit());
    }

    @Test
    void getWinners() {
        controller.initGame(2);
        IntStream.range(0, 8).forEach(i -> controller.endTurn());
        assertEquals(4, controller.getWinners().size());
        controller.getWinners()
                .forEach(player -> Assertions.assertTrue(testTacticians.contains(player)));

        controller.initGame(2);
        IntStream.range(0, 4).forEach(i -> controller.endTurn());
        assertNull(controller.getWinners());
        controller.removeTactician("Player 0");
        controller.removeTactician("Player 2");
        IntStream.range(0, 2).forEach(i -> controller.endTurn());
        List<String> winners = controller.getWinners();
        assertEquals(2, winners.size());
        assertTrue(List.of("Player 1", "Player 3").containsAll(winners));

        controller.initEndlessGame();
        for (int i = 0; i < 3; i++) {
            assertNull(controller.getWinners());
            controller.removeTactician("Player " + i);
        }
        assertTrue(List.of("Player 3").containsAll(controller.getWinners()));
    }

    @Test
    void getWinnersByUnits(){
        controller.addArcher(controller.getTurnOwner());
        controller.addAlpaca(controller.getCurrentOrder().get(1));
        Tactician tactician1 = controller.getTurnOwner();
        Tactician tactician2 = controller.getCurrentOrder().get(1);
        Tactician tactician3 = controller.getCurrentOrder().get(2);
        Tactician tactician4 = controller.getCurrentOrder().get(3);

        controller.initGame(2);

        IntStream.range(0, 8).forEach(i -> controller.endTurn());
        assertEquals(2, controller.getWinners().size());
        assertTrue(controller.getWinners().contains(tactician1.getName()));
        assertTrue(controller.getWinners().contains(tactician2.getName()));
        assertFalse(controller.getWinners().contains(tactician3.getName()));
        assertFalse(controller.getWinners().contains(tactician4.getName()));
    }

    @Test
    void addUnits() {
        Tactician tactician = new Tactician("yo");
        controller.addAlpaca(tactician);
        Alpaca alpaca = alpacaFactory.create();
        assertTrue(tactician.getGlobalUnits().contains(alpaca));
        controller.addArcher(tactician);
        Archer archer = archerFactory.create();
        assertTrue(tactician.getGlobalUnits().contains(archer));
        controller.addCleric(tactician);
        Cleric cleric = clericFactory.create();
        assertTrue(tactician.getGlobalUnits().contains(cleric));
        controller.addFighter(tactician);
        Fighter fighter = fighterFactory.create();
        assertTrue(tactician.getGlobalUnits().contains(fighter));
        controller.addHero(tactician);
        Hero hero = heroFactory.create();
        assertTrue(tactician.getGlobalUnits().contains(hero));
        controller.addSorcerer(tactician);
        Sorcerer sorcerer = sorcererFactory.create();
        assertTrue(tactician.getGlobalUnits().contains(sorcerer));
        controller.addSwordMaster(tactician);
        SwordMaster swordMaster = swordMasterFactory.create();
        assertTrue(tactician.getGlobalUnits().contains(swordMaster));
    }

    @Test
    void putUnitsOn() {
        Tactician tactician = new Tactician(testTacticians.get(0));
        controller.addAlpaca(tactician);
        controller.addArcher(tactician);
        controller.addCleric(tactician);
        tactician.restoreUnits();
        List<Location> locations = new ArrayList<>();
        locations.add(controller.getGameMap().getCell(0, 1));
        locations.add(controller.getGameMap().getCell(0, 2));
        locations.add(controller.getGameMap().getCell(1, 1));
        controller.putUnitsOn(tactician, locations);
        int i = 0;
        for (IUnit unit : tactician.getUnits()) {
            assertEquals(locations.get(i), unit.getLocation());
            i++;
        }
    }

    @Test
    void addItems() {
        Tactician tactician = controller.getCurrentOrder().get(0);
        controller.addAlpaca(tactician);
        tactician.restoreUnits();
        List<Location> locations = new ArrayList<>();
        locations.add(controller.getGameMap().getCell(0, 1));
        controller.putUnitsOn(tactician, locations);

        controller.initGame(5);

        controller.selectUnitIn(0, 1);
        controller.addAxe(0);
        Axe axe = axeFactory.create();
        assertTrue(tactician.getUnits().get(0).getItems().contains(axe));
        controller.addBow(0);
        Bow bow = bowFactory.create();
        assertTrue(tactician.getUnits().get(0).getItems().contains(bow));
        controller.addDarkMagicBook(0);
        DarkMagicBook darkMagicBook = darkMagicBookFactory.create();
        assertTrue(tactician.getUnits().get(0).getItems().contains(darkMagicBook));
        controller.addLightMagicBook(0);
        LightMagicBook lightMagicBook = lightMagicBookFactory.create();
        assertTrue(tactician.getUnits().get(0).getItems().contains(lightMagicBook));
        controller.addSpear(0);
        Spear spear = spearFactory.create();
        assertTrue(tactician.getUnits().get(0).getItems().contains(spear));
        controller.addSpiritMagicBook(0);
        SpiritMagicBook spiritMagicBook = spiritMagicBookFactory.create();
        assertTrue(tactician.getUnits().get(0).getItems().contains(spiritMagicBook));
        controller.addStaff(0);
        Staff staff = staffFactory.create();
        assertTrue(tactician.getUnits().get(0).getItems().contains(staff));
        controller.addSword(0);
        Sword sword = swordFactory.create();
        assertTrue(tactician.getUnits().get(0).getItems().contains(sword));
    }

    @Test
    void getSelectedUnit() {
        controller.addAlpaca(controller.getTurnOwner());
        controller.getTurnOwner().restoreUnits();
        List<Location> locations = new ArrayList<>();
        locations.add(controller.getGameMap().getCell(0, 1));
        controller.putUnitsOn(controller.getTurnOwner(), locations);

        controller.initGame(5);

        controller.selectUnitIn(0, 1);
        assertNotNull(controller.getSelectedUnit());
        //selecciono algo
    }

    @Test
    void selectUnitIn() {
        controller.addAlpaca(controller.getTurnOwner());
        controller.getTurnOwner().restoreUnits();
        alpacaFactory.setLocation(new Location(0, 1));
        Alpaca alpaca = alpacaFactory.create();
        List<Location> locations = new ArrayList<>();
        Location location = controller.getGameMap().getCell(0, 1);
        locations.add(location);
        controller.putUnitsOn(controller.getTurnOwner(), locations);

        controller.initGame(5);

        controller.selectUnitIn(0, 1);
        assertEquals(alpaca, controller.getSelectedUnit());
        //se selecciono corectamente
    }

    @Test
    void getItems() {
        Tactician tactician = controller.getCurrentOrder().get(0);
        controller.addAlpaca(tactician);
        tactician.restoreUnits();
        List<Location> locations = new ArrayList<>();
        locations.add(controller.getGameMap().getCell(0, 1));
        controller.putUnitsOn(tactician, locations);

        controller.initGame(5);

        controller.selectUnitIn(0, 1);
        controller.addAxe(0);
        Axe axe = axeFactory.create();
        assertTrue(controller.getItems().contains(axe));
        controller.addBow(0);
        Bow bow = bowFactory.create();
        assertTrue(controller.getItems().contains(bow));
        controller.addDarkMagicBook(0);
        DarkMagicBook darkMagicBook = darkMagicBookFactory.create();
        assertTrue(controller.getItems().contains(darkMagicBook));
        controller.addLightMagicBook(0);
        LightMagicBook lightMagicBook = lightMagicBookFactory.create();
        assertTrue(controller.getItems().contains(lightMagicBook));
        controller.addSpear(0);
        Spear spear = spearFactory.create();
        assertTrue(controller.getItems().contains(spear));
        controller.addSpiritMagicBook(0);
        SpiritMagicBook spiritMagicBook = spiritMagicBookFactory.create();
        assertTrue(controller.getItems().contains(spiritMagicBook));
        controller.addStaff(0);
        Staff staff = staffFactory.create();
        assertTrue(controller.getItems().contains(staff));
        controller.addSword(0);
        Sword sword = swordFactory.create();
        assertTrue(controller.getItems().contains(sword));
    }

    @Test
    void failGetItems() {
        Tactician tactician = controller.getCurrentOrder().get(0);
        controller.addAlpaca(tactician);
        tactician.restoreUnits();
        List<Location> locations = new ArrayList<>();
        locations.add(controller.getGameMap().getCell(0, 1));
        controller.putUnitsOn(tactician, locations);

        controller.initGame(5);

        //no seleccione ninguna unidad entonces no se puede saber los items de quien quieres obtener
        controller.addAxe(0);
        assertNull(controller.getItems());
    }

    @Test
    void equipItem() {
        Tactician tactician = controller.getCurrentOrder().get(0);
        controller.addArcher(tactician);
        tactician.restoreUnits();
        List<Location> locations = new ArrayList<>();
        locations.add(controller.getGameMap().getCell(0, 1));
        controller.putUnitsOn(tactician, locations);

        controller.initGame(5);

        controller.selectUnitIn(0, 1);
        controller.addBow(0);
        controller.equipItem(0);
        Bow bow = bowFactory.create();
        assertEquals(bow, controller.getSelectedUnit().getEquippedItem());
    }

    @Test
    void failEquipItem() {
        Tactician tactician = controller.getCurrentOrder().get(0);
        controller.addArcher(tactician);
        tactician.restoreUnits();
        List<Location> locations = new ArrayList<>();
        locations.add(controller.getGameMap().getCell(0, 1));
        controller.putUnitsOn(tactician, locations);

        controller.initGame(5);

        //si no selecciono la unidad no puedo equipar la cuestion owo
        controller.addBow(0);
        controller.equipItem(0);
        assertNull(controller.getSelectedUnit());
    }

    @Test
    void failEquipNoHavingItem() {
        Tactician tactician = controller.getCurrentOrder().get(0);
        controller.addArcher(tactician);
        tactician.restoreUnits();
        List<Location> locations = new ArrayList<>();
        locations.add(controller.getGameMap().getCell(0, 1));
        controller.putUnitsOn(tactician, locations);

        controller.initGame(5);

        controller.selectUnitIn(0, 1);
        controller.equipItem(0);
        assertNull(controller.getSelectedUnit().getEquippedItem());
    }

    @Test
    void useItemOn() {
        GameController controller = new GameController(4,3);
        controller.setGameMap();
        List<Location> locationsT1 = new ArrayList<>();
        locationsT1.add(controller.getGameMap().getCell(0, 1));
        List<Location> locationsT2 = new ArrayList<>();
        locationsT2.add(controller.getGameMap().getCell(1, 1));

        Tactician atackingTactician = controller.getCurrentOrder().get(0);
        controller.addHero(atackingTactician);
        Tactician vistimaTactician = controller.getCurrentOrder().get(1); //se hace la vistima uwu
        controller.addArcher(vistimaTactician);
        atackingTactician.restoreUnits();
        vistimaTactician.restoreUnits();

        controller.putUnitsOn(atackingTactician, locationsT1);
        controller.putUnitsOn(vistimaTactician, locationsT2);


        controller.initGame(5);
        controller.addSpear(0);
        controller.selectUnitIn(0, 1);
        controller.equipItem(0);
        controller.useItemOn(1, 1);

        assertEquals(10, controller.getCurrentOrder().get(1).getGlobalUnits().get(0).getCurrentHitPoints());
    }

    @Test
    void failUseItemOn() {
        List<Location> locationsT1 = new ArrayList<>();
        locationsT1.add(controller.getGameMap().getCell(0, 1));
        List<Location> locationsT2 = new ArrayList<>();
        locationsT2.add(controller.getGameMap().getCell(1, 1));

        Tactician atackingTactician = controller.getCurrentOrder().get(0);
        controller.addHero(atackingTactician);
        Tactician vistimaTactician = controller.getCurrentOrder().get(1); //se hace la vistima uwu
        controller.addArcher(vistimaTactician);
        atackingTactician.restoreUnits();
        vistimaTactician.restoreUnits();

        controller.putUnitsOn(atackingTactician, locationsT1);
        controller.putUnitsOn(vistimaTactician, locationsT2);


        controller.initGame(5);
        controller.addSpear(0);
        //si no selecciono la unidad no sucede el ataque
        controller.equipItem(0);
        controller.useItemOn(1, 1);

        assertEquals(20, controller.getCurrentOrder().get(1).getUnits().get(0).getCurrentHitPoints());
    }

    @Test
    void selectItem() {
        Tactician tactician = controller.getCurrentOrder().get(0);
        controller.addArcher(tactician);
        tactician.restoreUnits();
        List<Location> locations = new ArrayList<>();
        locations.add(controller.getGameMap().getCell(0, 1));
        controller.putUnitsOn(tactician, locations);

        controller.initGame(5);

        controller.selectUnitIn(0, 1);
        controller.addBow(0);
        controller.selectItem(0);
        Bow bow = bowFactory.create();
        assertEquals(bow, controller.getSelectedItem());
    }

    @Test
    void getSelectedItem() {
        Tactician tactician = controller.getCurrentOrder().get(0);
        controller.addArcher(tactician);
        tactician.restoreUnits();
        List<Location> locations = new ArrayList<>();
        locations.add(controller.getGameMap().getCell(0, 1));
        controller.putUnitsOn(tactician, locations);

        controller.initGame(5);

        controller.selectUnitIn(0, 1);
        controller.addBow(0);
        controller.selectItem(0);
        assertNotNull(controller.getSelectedItem());
    }

    @Test
    void giveItemTo() {
        GameController controller = new GameController(4,3);
        controller.setGameMap();
        List<Location> locations = new ArrayList<>();
        locations.add(controller.getGameMap().getCell(0, 1));
        locations.add(controller.getGameMap().getCell(1, 1));

        Tactician tactician = controller.getCurrentOrder().get(0);
        controller.addHero(tactician);
        controller.addArcher(tactician);
        tactician.restoreUnits();

        controller.putUnitsOn(tactician, locations);

        controller.initGame(5);
        controller.addSpear(0);
        controller.selectUnitIn(0, 1);
        controller.selectItem(0);
        controller.giveItemTo(1, 1);

        assertEquals(0, controller.getCurrentOrder().get(0).getUnits().get(0).getItems().size());
        assertEquals(1, controller.getCurrentOrder().get(0).getUnits().get(1).getItems().size());
        Spear spear = spearFactory.create();
        assertEquals(spear,controller.getCurrentOrder().get(0).getUnits().get(1).getItems().get(0));
    }

    @Test
    void failGiveItemTo() {
        List<Location> locations = new ArrayList<>();
        locations.add(controller.getGameMap().getCell(0, 1));
        locations.add(controller.getGameMap().getCell(1, 1));

        Tactician tactician = controller.getCurrentOrder().get(0);
        controller.addHero(tactician);
        controller.addArcher(tactician);
        tactician.restoreUnits();

        controller.putUnitsOn(tactician, locations);

        controller.initGame(5);
        controller.addSpear(0);
        //no se selecciona la unidad significa que no se hace na uwu
        controller.selectItem(0);
        controller.giveItemTo(1, 1);

        assertEquals(1, controller.getCurrentOrder().get(0).getUnits().get(0).getItems().size());
        assertEquals(0, controller.getCurrentOrder().get(0).getUnits().get(1).getItems().size());
        Spear spear = spearFactory.create();
        assertEquals(spear,controller.getCurrentOrder().get(0).getUnits().get(0).getItems().get(0));
    }

    @Test
    void failGiveNoHavingItemTo() {
        List<Location> locations = new ArrayList<>();
        locations.add(controller.getGameMap().getCell(0, 1));
        locations.add(controller.getGameMap().getCell(1, 1));

        Tactician tactician = controller.getCurrentOrder().get(0);
        controller.addHero(tactician);
        controller.addArcher(tactician);
        tactician.restoreUnits();

        controller.putUnitsOn(tactician, locations);

        controller.initGame(5);
        //si no le doy item al que va a dar no puede dar
        controller.selectUnitIn(0, 1);
        controller.selectItem(0);
        controller.giveItemTo(1, 1);

        assertEquals(0, controller.getCurrentOrder().get(0).getUnits().get(0).getItems().size());
        assertEquals(0, controller.getCurrentOrder().get(0).getUnits().get(1).getItems().size());
    }

    @Test
    void setTacticiansFields(){
        controller.setTacticiansFields();
        for (Tactician tactician : controller.getTacticians()) {
            assertEquals(controller.getGameMap(),tactician.getMapField());
        }
    }

    @Test
    void moveUnitTo(){
        GameController controller = new GameController(4,3);
        controller.setGameMap();
        Tactician tactician = controller.getCurrentOrder().get(0);
        controller.addArcher(tactician);
        tactician.restoreUnits();
        List<Location> locations = new ArrayList<>();
        locations.add(controller.getGameMap().getCell(0, 1));
        controller.putUnitsOn(tactician, locations);

        controller.initGame(5);

        controller.selectUnitIn(0, 1);
        controller.moveTo(1,1);
        assertEquals(controller.getGameMap().getCell(1,1),tactician.getUnits().get(0).getLocation());
    }

    @Test
    void failMoveUnitTo(){
        Tactician tactician = controller.getCurrentOrder().get(0);
        controller.addArcher(tactician);
        tactician.restoreUnits();
        List<Location> locations = new ArrayList<>();
        locations.add(controller.getGameMap().getCell(0, 1));
        controller.putUnitsOn(tactician, locations);

        controller.initGame(5);

        //si no selecciono unidad no se a quien mover
        controller.moveTo(1,1);
        assertEquals(controller.getGameMap().getCell(0,1),tactician.getUnits().get(0).getLocation());
    }

    @Test
    void failMoveUnitTwice(){
        GameController controller = new GameController(4,3);
        controller.setGameMap();
        Tactician tactician = controller.getCurrentOrder().get(0);
        controller.addArcher(tactician);
        controller.addSorcerer(tactician);
        tactician.restoreUnits();
        List<Location> locations = new ArrayList<>();
        locations.add(controller.getGameMap().getCell(0, 1));
        locations.add(controller.getGameMap().getCell(2,2));
        controller.putUnitsOn(tactician, locations);

        controller.initGame(5);

        controller.selectUnitIn(0, 1);
        controller.moveTo(1,1);
        controller.moveTo(1,2);
        assertEquals(controller.getGameMap().getCell(1,1),tactician.getUnits().get(0).getLocation());
        controller.selectUnitIn(2,2);
        controller.moveTo(2,1);
        assertEquals(controller.getGameMap().getCell(2,1),tactician.getUnits().get(1).getLocation());
    }

    @Test
    void checkHero(){
        GameController controller = new GameController(4,3);
        controller.setGameMap();
        Tactician tactician = controller.getCurrentOrder().get(0);
        Tactician tactician1 = controller.getCurrentOrder().get(1);
        controller.addHero(tactician1);
        controller.addSorcerer(tactician);
        tactician.restoreUnits();
        tactician1.restoreUnits();

        List<Location> locations = new ArrayList<>();
        locations.add(controller.getGameMap().getCell(1,0));
        List<Location> locations1 = new ArrayList<>();
        locations1.add(controller.getGameMap().getCell(1,1));
        controller.putUnitsOn(tactician,locations);
        controller.putUnitsOn(tactician1,locations1);

        controller.initGame(5);

        controller.selectUnitIn(1,0);
        controller.addDarkMagicBook(0);
        controller.equipItem(0);
        controller.useItemOn(1,1);
        controller.useItemOn(1,1);

        assertEquals(1,tactician.getUnits().size());
        assertEquals(0,tactician1.getUnits().size());

        assertFalse(controller.getCurrentOrder().contains(tactician1));
    }

    @Test
    void checkUnits(){
        GameController controller = new GameController(4,3);
        controller.setGameMap();
        Tactician tactician = controller.getCurrentOrder().get(0);
        Tactician tactician1 = controller.getCurrentOrder().get(1);
        controller.addSorcerer(tactician1);
        controller.addArcher(tactician1);
        controller.addAlpaca(tactician1);
        controller.addSorcerer(tactician);
        tactician.restoreUnits();
        tactician1.restoreUnits();

        List<Location> locations = new ArrayList<>();
        locations.add(controller.getGameMap().getCell(1,0));
        List<Location> locations1 = new ArrayList<>();
        locations1.add(controller.getGameMap().getCell(2,2));
        locations1.add(controller.getGameMap().getCell(1,1));
        locations1.add(controller.getGameMap().getCell(2,1));
        controller.putUnitsOn(tactician,locations);
        controller.putUnitsOn(tactician1,locations1);

        controller.initGame(5);

        controller.selectUnitIn(1,0);
        controller.addDarkMagicBook(0);
        controller.equipItem(0);
        controller.useItemOn(1,1);
        controller.useItemOn(1,1);

        assertEquals(1,tactician.getUnits().size());
        assertEquals(2,tactician1.getUnits().size());

        assertFalse(tactician1.getUnits().contains(archerFactory.create()));
    }

    @Test
    void checkNoUnits(){
        GameController controller = new GameController(4,3);
        controller.setGameMap();
        Tactician tactician = controller.getCurrentOrder().get(0);
        Tactician tactician1 = controller.getCurrentOrder().get(1);
        controller.addArcher(tactician1);
        controller.addSorcerer(tactician);
        tactician.restoreUnits();
        tactician1.restoreUnits();

        List<Location> locations = new ArrayList<>();
        locations.add(controller.getGameMap().getCell(1,0));
        List<Location> locations1 = new ArrayList<>();
        locations1.add(controller.getGameMap().getCell(1,1));
        controller.putUnitsOn(tactician,locations);
        controller.putUnitsOn(tactician1,locations1);

        controller.initGame(5);

        controller.selectUnitIn(1,0);
        controller.addDarkMagicBook(0);
        controller.equipItem(0);
        controller.useItemOn(1,1);
        controller.useItemOn(1,1);

        assertEquals(1,tactician.getUnits().size());
        assertEquals(0,tactician1.getUnits().size());

        assertFalse(controller.getCurrentOrder().contains(tactician1));
    }

}