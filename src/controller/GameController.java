package controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controller.observers.EndTurnHandler;
import controller.observers.EquipItemHandler;
import model.factories.items.*;
import model.factories.units.*;
import model.items.DarkMagicBook;
import model.items.LightMagicBook;
import model.map.Location;
import model.tactician.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.units.Alpaca;
import model.units.IUnit;

import static java.lang.Math.abs;

/**
 * Controller of the game.
 * The controller manages all the input received from de game's GUI.
 *
 * @author Beatriz Graboloza
 * @version 2.0
 * @since v2.0
 */
public class GameController {

    private int numberOfPlayers;
    private final int mapSize;
    private List<Tactician> currentOrder = new ArrayList<>();
    private List<Tactician> tacticians = new ArrayList<>();
    private int currentTurn;
    private Tactician turnOwner;
    private int roundNumber;
    private int MaxRounds;
    private Field mapField = new Field();

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

    private EndTurnHandler endTurnHandler = new EndTurnHandler(this);
    private EquipItemHandler equipItemHandler = new EquipItemHandler(this);


    /**
     * Creates the controller for a new game.
     *
     * @param numberOfPlayers the number of players for this game
     * @param mapSize         the dimensions of the map, for simplicity, all maps are squares
     */
    public GameController(int numberOfPlayers, int mapSize) {
        this.numberOfPlayers = numberOfPlayers;
        this.mapSize = mapSize;
        this.roundNumber = 0;
        for (int i = 0; i < numberOfPlayers; i++) {
            this.currentOrder.add(null);
        }
        getTacticians();
    }

    /**
     * @return the list of all the tacticians participating in the game.
     */
    public List<Tactician> getTacticians() {
        if (this.tacticians.size() == 0 && this.roundNumber == 0) { //si es que ya empezo la partida no va a haber ninguno null
            for (int i = 0; i < this.numberOfPlayers; i++) {
                Tactician tactician = new Tactician("Player " + i);
                this.tacticians.add(tactician);
            }
        }
        return this.tacticians;
        //TODO si eliminan al 0 dsps se van a volver a crear con esos nombres al preguntar por ellos?:C
    }

    /**
     * set the map of the current game.
     */
    public void setGameMap(){
        for (int i = 0; i < this.mapSize; i++) {
            for (int j = 0; j < this.mapSize; j++) {
                this.mapField.addCells(false, new Location(i,j));
            }
        }
    }
    public void setSeed(long seed){
        this.mapField.setSeed(seed);
    }
    /**
     * @return the map of the current game.
     */
    public Field getGameMap() {
        return this.mapField;
    }

    /**
     * @return the tactician that's currently playing.
     */
    public Tactician getTurnOwner() {
        return this.turnOwner;
    }

    /**
     * @return the index of the tactician that's currently playing.
     */
    public int getCurrentTurn() {
        return this.currentTurn;
    }

    /**
     * @return the list of tactician in order to play.
     */
    public List<Tactician> getCurrentOrder() {
        return this.currentOrder;
    }

    /**
     * @return the number of rounds since the start of the game.
     */
    public int getRoundNumber() {
        return this.roundNumber;
    }

    /**
     * @return the maximum number of rounds a match can last
     */
    public int getMaxRounds() {
        return this.MaxRounds;
    }

    /**
     * Start a new round.
     */
    public void newRound() {
        if (this.roundNumber < this.MaxRounds) {
            reorderTurns();
            Tactician tactician = this.currentOrder.get(0);
            this.roundNumber++;
            this.currentTurn = 0;
            startTurn(tactician);
        } else {
            //end game??
        }
    }

    /**
     * Select the round´s order.
     */
    public void reorderTurns() {
        Random randomTurnSequence = new Random();
        List<Tactician> tacticians = getTacticians();
        List<Tactician> newturns = new ArrayList<>();
        int i = 0;
        while (i < this.numberOfPlayers) {
            int next = abs(randomTurnSequence.nextInt() % this.numberOfPlayers);
            if (!newturns.contains(tacticians.get(next))) {
                newturns.add(tacticians.get(next));
                i++;
            }
        }
        if (newturns.get(0).equals(this.currentOrder.get(currentOrder.size() - 1))) { //cuando esta vacío que pasa si geteo algo?
            reorderTurns();
        } else {
            this.currentOrder = newturns;
        }
    }

    /**
     * Starts the current player's turn.
     */
    public void startTurn(Tactician tactician) {
        this.turnOwner = tactician;
        //nose que más
        //endTurn();
        // el tactician avisa que terminó
    }

    /**
     * Finishes the current player's turn.
     */
    public void endTurn() {
        if (this.currentOrder.get(this.currentOrder.size() - 1).equals(this.turnOwner)) {
            newRound();
        } else {
            this.currentTurn++;
        }
    }

    /**
     * Removes a tactician and all of it's units from the game.
     *
     * @param tactician the player to be removed
     */
    public void removeTactician(String tactician) {
        //units = tactician.getUnits();
        //for(IUnit unit: units){
        //    tactician.removeUnit(unit);
        //}
        Tactician ripTactician = new Tactician(tactician);
        this.tacticians.remove(ripTactician);
        this.numberOfPlayers--;
        //elimina esta unidad, le dices a la unidad eliminate

        //TODO agregar esos metodos


    }

    /**
     * Starts the game.
     *
     * @param maxRounds the maximum number of rounds the game can last
     */
    public void initGame(final int maxRounds) {
        this.MaxRounds = maxRounds;
        newRound();
        //ayuda
    }

    /**
     * Starts a game without a limit of turns.
     */
    public void initEndlessGame() {
        this.MaxRounds = -1;
        //TODO esto
        //deberia resetear los jugadores o guardar unos jugadores globales y que una copia sea la que usemos en cada juego
        //para no perder la referencia al jjugador cuando pierda o crear nuevos tacticians? es like malo
        // es como si fueran controles conectados
    }

    /**
     * @return the winner of this game, if the match ends in a draw returns a list of all the winners
     */
    public List<String> getWinners() {
        return null;
    }

    /**
     * @return the current player's selected unit
     */
    public IUnit getSelectedUnit() {
        return null;
    }

    /**
     * Selects a unit in the game map
     *
     * @param x horizontal position of the unit
     * @param y vertical position of the unit
     */
    public void selectUnitIn(int x, int y) {

    }

    /**
     * @return the inventory of the currently selected unit.
     */
    public List<IEquipableItem> getItems() {
        return null;
    }

    /**
     * Equips an item from the inventory to the currently selected unit.
     *
     * @param index the location of the item in the inventory.
     */
    public void equipItem(int index) {

    }

    /**
     * Uses the equipped item on a target
     *
     * @param x horizontal position of the target
     * @param y vertical position of the target
     */
    public void useItemOn(int x, int y) {

    }

    /**
     * Selects an item from the selected unit's inventory.
     *
     * @param index the location of the item in the inventory.
     */
    public void selectItem(int index) {

    }

    /**
     * Gives the selected item to a target unit.
     *
     * @param x horizontal position of the target
     * @param y vertical position of the target
     */
    public void giveItemTo(int x, int y) {

    }

}
