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
    private int globalNumberOfPlayers;
    private final int mapSize;
    private List<Tactician> currentOrder = new ArrayList<>();
    private List<Tactician> tacticians = new ArrayList<>();
    //private int currentTurn;
    private Tactician turnOwner;
    private int roundNumber;
    private int MaxRounds;
    private Field mapField = new Field();
    private Random randomTurnSequence = new Random();

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
        this.globalNumberOfPlayers = numberOfPlayers;
        this.numberOfPlayers = this.globalNumberOfPlayers;
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
        //TODO este if esta como mal planteado owo
        if (this.tacticians.size() == 0 && this.roundNumber == 0) { //si es que ya empezo la partida no va a haber ninguno null
            for (int i = 0; i < this.numberOfPlayers; i++) {
                Tactician tactician = new Tactician("Player " + i);
                this.tacticians.add(tactician);
            }
        }
        return this.tacticians;
        //TODO si eliminan al 0 dsps se van a volver a crear con esos nombres al preguntar por ellos?:C
    }

    public void setTacticians(){
        List<Tactician> newTacticians = new ArrayList<>();
        for (int i = 0; i < this.numberOfPlayers; i++) {
            Tactician tactician = new Tactician("Player " + i);
            newTacticians.add(tactician);
        }

        this.tacticians = newTacticians;
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
        this.randomTurnSequence.setSeed(seed);
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

    public int getCurrentTurn() {
        return this.currentTurn;
    }*/

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
        if (this.roundNumber < this.MaxRounds || this.getMaxRounds()==-1) {
            reorderTurns();
            Tactician tactician = this.currentOrder.get(0);
            this.roundNumber++;
            //this.currentTurn = 0;
            startTurn(tactician);
        } else {
            this.roundNumber++;
            //para que el winners sepa cuando termino el juego?
            //end game??
        }
    }

    /**
     * Select the round´s order.
     */
    public void reorderTurns() {
        List<Tactician> tacticians = getTacticians();
        List<Tactician> newturns = new ArrayList<>();
        int i = 0;
        while (i < this.numberOfPlayers) {
            int next = abs(this.randomTurnSequence.nextInt() % this.numberOfPlayers);
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
        }
        else {
            int currentTurn = this.currentOrder.indexOf(this.turnOwner);
            startTurn(this.currentOrder.get(currentTurn+1));
            //mejor me encuentro en currentorder con un for, veo que indice soy, y le digo que empiece el siguiente no?
            //soy el turn owner, eso es despues de arreglar current order... nopo pq si es dsps no voy a estar :C
            //si ese arreglo retornara a que indice deberia tocarle(???) pero entonces no llama a end turn?
            //si tengo el current turn verifico quien viene antes de eliminarme de la lista y le doy directo a start a el
            //es como un end turn especial, no se va a sumar nada a current turn puta la wea a a a , tengo que eliminar ese numero
            //culiao
            //si no tengo el current turn el end turn normal deberia saber que hacer no? pico en vdd
            //en vez de current turn le hago un get index de dd estoy y mando al siguiente, pero se arregla el current orden
            //antes o dsps?
            //como no se si start lo usa o no seria mejor que antes, lo arregla y dsps, pero como respaldo el indice si ya no voy a
            //estar en current order?
            //que el normal lo vea sin el current turn y que si tengo el turno antes de mandar que se arregle busco a quien le toca y
            //llamo start del siguiente
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
        //TODO que llame a remove tacticianunits en vez de hacerlo aca
        Tactician ripTactician = new Tactician(tactician);

        boolean newRound = false;
        int currentTurn = 0;
        Tactician nextTactician = null;

        if(this.turnOwner!=null){
            currentTurn = this.currentOrder.indexOf(this.turnOwner);
            nextTactician = this.currentOrder.get(currentTurn+1);
            if(this.currentOrder.get(this.currentOrder.size() - 1).equals(this.turnOwner)){
                newRound = true;
            }
        }
        removeTacticianfromCurrentOrder(ripTactician);
        this.tacticians.remove(ripTactician);
        this.numberOfPlayers--;

        if(this.turnOwner!=null && this.turnOwner.getName().equals(tactician)) {
            if (newRound) {
                newRound();
            } else {
                startTurn(nextTactician);
            }
        }
        //TODO debes termoinar el turno y asegurarte de que current turn no sea.. 3?xd si ahora quedan 4 tacticians
        //elimina esta unidad, le dices a la unidad eliminate
        //TODO agregar esos metodos


    }

    private void removeTacticianfromCurrentOrder(Tactician ripTactician) {
        List<Tactician> resetOrder = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            if((this.currentOrder.get(i)==null)||(!(this.currentOrder.get(i).equals(ripTactician)))){
                resetOrder.add(this.currentOrder.get(i));
            }
        }
        this.currentOrder = resetOrder;
    }

    public void resetCurrentOrder(){
        List<Tactician> resetOrder = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            resetOrder.add(null);
        }
        this.currentOrder = resetOrder;
    }
    /**
     * Reset the game.
     */
    public void resetGame(){
        //this.currentTurn = 0;
        this.roundNumber = 0;
        this.setGameMap();
        this.numberOfPlayers = this.globalNumberOfPlayers;
        resetCurrentOrder();
        setTacticians();
    }
    /**
     * Starts the game.
     *
     * @param maxRounds the maximum number of rounds the game can last
     */
    public void initGame(final int maxRounds) {
        this.MaxRounds = maxRounds;
        resetGame();
        newRound();
        //TODO llame a first round o selecion round que seleccione y haga la primera ronda owowowowoo
        //ayuda
    }

    /**
     * Starts a game without a limit of turns.
     */
    public void initEndlessGame() {
        this.MaxRounds = -1;
        resetGame();
        newRound();
        //TODO esto
        //deberia resetear los jugadores o guardar unos jugadores globales y que una copia sea la que usemos en cada juego
        //para no perder la referencia al jjugador cuando pierda o crear nuevos tacticians? es like malo
        // es como si fueran controles conectados
    }

    /**
     * @return the winner of this game, if the match ends in a draw returns a list of all the winners
     */
    public List<String> getWinners() {
        //juego normal solo hay ganador(es) si acaba
        //en un endless solo termina si hay 1
        List<String> winners = new ArrayList<>();
        if(getMaxRounds()>-1){
            if(getRoundNumber()==(getMaxRounds())+1){
                for (Tactician tactician: getTacticians()) {
                    winners.add(tactician.getName());
                }
            }
            else{
                return null;
            }
        }
        else{
            if(getTacticians().size()==1){
                winners.add(getTacticians().get(0).getName());
            }
            else{
                return null;
            }
        }
        return winners;
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
