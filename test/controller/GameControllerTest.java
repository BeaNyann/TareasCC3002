package controller;

import static java.lang.Math.abs;
import static java.lang.Math.log;
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
import model.map.Location;
import model.tactician.Tactician;
import model.map.Field;
import model.units.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Beatriz Graboloza
 * @since v2.0
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
        controller.setSeed(randomSeed);
        testTacticians = List.of("Player 0", "Player 1", "Player 2", "Player 3");
        controller.setGameMap();
    }


    @Test
    void randomTest(){
        Random randomowo = new Random();
        randomowo.nextInt();
        randomowo.setSeed(randomSeed);
        Random randomowo2 = new Random(randomSeed);
        for(int i=0; i<100;i++){
            assertEquals(randomowo.nextInt(),randomowo2.nextInt());
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
                for (Location neighbour: gameMap.getCell(i, j).getNeighbours()) {
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
        controller.newRound();
        assertEquals(controller.getCurrentOrder().get(0),controller.getTurnOwner());
        controller.endTurn();
        assertEquals(controller.getCurrentOrder().get(1),controller.getTurnOwner());
        controller.endTurn();
        assertEquals(controller.getCurrentOrder().get(2),controller.getTurnOwner());
        controller.endTurn();
        assertEquals(controller.getCurrentOrder().get(3),controller.getTurnOwner());
        controller.endTurn();
    }

     @Test
     void getCurrentOrder(){
         Random randomTurnSequence = new Random(randomSeed);
         controller.setSeed(randomSeed);
         List<Tactician> tacticians = controller.getTacticians();
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
         assertEquals(newTurns,testTurns);
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
        controller.initGame(4);
        controller.newRound();
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
        assertEquals(4, controller.getTacticians().size());
        controller.getTacticians()
                .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));

        controller.removeTactician("Player 0");
        assertEquals(3, controller.getTacticians().size());
        controller.getTacticians().forEach(tactician -> assertNotEquals("Player 0", tactician));
        controller.getTacticians()
                .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));

        controller.removeTactician("Player 5");
        assertEquals(3, controller.getTacticians().size());
        controller.getTacticians()
                .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));
    }

    @Test
    void removeTacticianCheckTurns(){
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
        assertEquals(thirdTactician,controller.getTurnOwner());
        assertEquals(expectedOrder,controller.getCurrentOrder());

        controller.endTurn();
        controller.endTurn();

        List<Tactician> tacticiansOrder2 = controller.getCurrentOrder();
        Tactician secondTactician2 = tacticiansOrder2.get(1);
        Tactician thirdTactician2 = tacticiansOrder2.get(2);
        List<Tactician> expectedOrder2 = new ArrayList<>();
        expectedOrder2.add(tacticiansOrder2.get(0));
        expectedOrder2.add(thirdTactician2);
        assertEquals(tacticiansOrder2.get(0),controller.getTurnOwner());
        controller.removeTactician(secondTactician2.getName());
        controller.endTurn();
        assertEquals(thirdTactician2,controller.getTurnOwner());
        assertEquals(expectedOrder2,controller.getCurrentOrder());

    }

    @Test
    void removeTacticianUnits() {
        Tactician tactician = controller.getTacticians().get(0);
        //tactician.getUnits();
        //TODO como obtengo las unidades del tactician?:C o como se las asigno = factory?, testear el getUnits es cosa del TActician test que no existe
        controller.removeTactician("Player 0");
        assertTrue(tactician.getUnits().size() == 0); //o equals con una lista vacia, recien creada
    }

    //TODO agregar el test para que tbm se eliminen las unidades

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
    void addUnits(){
        Tactician tactician = new Tactician("yo");
        controller.addAlpaca(tactician);
        Alpaca alpaca = alpacaFactory.create();
        assertTrue(tactician.getUnits().contains(alpaca));
        controller.addArcher(tactician);
        Archer archer = archerFactory.create();
        assertTrue(tactician.getUnits().contains(archer));
        controller.addCleric(tactician);
        Cleric cleric = clericFactory.create();
        assertTrue(tactician.getUnits().contains(cleric));
        controller.addFighter(tactician);
        Fighter fighter = fighterFactory.create();
        assertTrue(tactician.getUnits().contains(fighter));
        controller.addHero(tactician);
        Hero hero = heroFactory.create();
        assertTrue(tactician.getUnits().contains(hero));
        controller.addSorcerer(tactician);
        Sorcerer sorcerer = sorcererFactory.create();
        assertTrue(tactician.getUnits().contains(sorcerer));
        controller.addSwordMaster(tactician);
        SwordMaster swordMaster = swordMasterFactory.create();
        assertTrue(tactician.getUnits().contains(swordMaster));
    }

    // Desde aquí en adelante, los tests deben definirlos completamente ustedes
    @Test
    void getSelectedUnit() {
    }

    @Test
    void selectUnitIn() {
    }

    @Test
    void getItems() {

    }

    @Test
    void equipItem() {
    }

    @Test
    void useItemOn() {
        //poner un numero especifico de long lon :C
    }

    @Test
    void selectItem() {
    }

    @Test
    void giveItemTo() {
    }
}