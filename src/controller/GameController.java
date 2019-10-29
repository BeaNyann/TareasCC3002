package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controller.observers.DeadHeroHandler;
import controller.observers.DeadUnitHandler;
import model.factories.items.*;
import model.factories.units.*;
import model.map.Location;
import model.tactician.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.units.*;

import static java.lang.Math.abs;

/**
 * Controller of the game.
 * The controller manages all the input received from de game's GUI.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class GameController {

    private int numberOfPlayers;
    private int globalNumberOfPlayers;
    private final int mapSize;
    private List<Tactician> currentOrder = new ArrayList<>();
    private List<Tactician> tacticians = new ArrayList<>();
    private List<Tactician> globalTacticians = new ArrayList<>();
    //private int currentTurn;
    private Tactician turnOwner;
    private int roundNumber;
    private int MaxRounds;
    private Field mapField = new Field();
    private Random randomTurnSequence = new Random();
    private long randomMapSeed;
    private IUnit selectedUnit;
    private IEquipableItem selectedItem;

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

    private DeadHeroHandler deadHeroHandler = new DeadHeroHandler(this);
    private DeadUnitHandler deadUnitHandler = new DeadUnitHandler(this);


    /**
     * Creates the controller for a new game.
     *
     * @param numberOfPlayers the number of players for this game.
     * @param mapSize         the dimensions of the map, for simplicity, all maps are squares.
     */
    public GameController(int numberOfPlayers, int mapSize) {
        this.globalNumberOfPlayers = numberOfPlayers;
        this.numberOfPlayers = this.globalNumberOfPlayers;
        this.mapSize = mapSize;
        this.roundNumber = 0;
        List<Tactician> newTacticians = new ArrayList<>();
        for (int i = 0; i < this.numberOfPlayers; i++) {
            Tactician tactician = new Tactician("Player " + i);
            newTacticians.add(tactician);
        }
        this.globalTacticians = newTacticians;
        setTacticians();
        reorderTurns();
        this.turnOwner = this.currentOrder.get(0);
    }

    /**
     * @return the list of all the tacticians participating in the game.
     */
    public List<Tactician> getTacticians() {
        return this.globalTacticians;
    }

    /**
     * Set the tacticians of the current game.
     */
    public void setTacticians() {
        this.tacticians = new ArrayList<>();
        this.tacticians.addAll(this.globalTacticians);
        this.currentOrder = new ArrayList<>();
        this.currentOrder.addAll(this.globalTacticians);
        setTacticiansFields();
        setTacticiansObservers();
    }

    public void setTacticiansObservers(){
        for (Tactician tactician : this.globalTacticians) {
            tactician.addDeadHeroObserver(deadHeroHandler);
            tactician.addDeadUnitObserver(deadUnitHandler);
        }
    }

    /**
     * Set the field of the map to the tacticians.
     */
    public void setTacticiansFields(){
        for (Tactician tactician : this.globalTacticians) {
            tactician.setMapField(this.mapField);
        }
    }

    /**
     * Set the map of the current game.
     */
    public void setGameMap() {
        this.mapField = new Field();
        this.mapField.setSeed(this.randomMapSeed);
        for (int i = 0; i < this.mapSize; i++) {
            for (int j = 0; j < this.mapSize; j++) {
                this.mapField.addCells(false, new Location(i, j));
            }
        }
        setTacticiansFields();
    }

    /**
     * Set a random seed to the map and the turn sequence.
     *
     * @param seed the random seed to set.
     */
    public void setSeed(long seed) {
        this.randomMapSeed = seed;
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
        if (this.roundNumber < this.MaxRounds || this.getMaxRounds() == -1) {
            Tactician tactician = this.currentOrder.get(0);
            this.roundNumber++;
            startTurn(tactician);
        }
        else{
            this.roundNumber++;
        }
        //si ya nos pasamos pos no hay más rondas uwu
    }

    /**
     * Select the round´s order.
     */
    public void reorderTurns() {
        List<Tactician> tacticians = getCurrentOrder();
        List<Tactician> newTurns = new ArrayList<>();
        int i = 0;
        while (i < this.numberOfPlayers) {
            int next = abs(this.randomTurnSequence.nextInt() % this.numberOfPlayers);
            if (!newTurns.contains(tacticians.get(next))) {
                newTurns.add(tacticians.get(next));
                i++;
            }
        }
        if (newTurns.get(0).equals(this.currentOrder.get(currentOrder.size() - 1))) {
            reorderTurns();
        } else {
            this.currentOrder = newTurns;
        }
    }

    /**
     * Starts the current player's turn.
     */
    public void startTurn(Tactician tactician) {
        this.turnOwner = tactician;
        tactician.restoreMovement();
    }

    /**
     * Finishes the current player's turn.
     */
    public void endTurn() {
        if (this.currentOrder.get(this.currentOrder.size() - 1).equals(this.turnOwner)) {
            reorderTurns();
            newRound();
        } else {
            int currentTurn = this.currentOrder.indexOf(this.turnOwner);
            startTurn(this.currentOrder.get(currentTurn + 1));
        }
    }

    /**
     * Removes a tactician and all of it's units from the game.
     *
     * @param tactician the player to be removed
     */
    public void removeTactician(String tactician) {
        int index = this.tacticians.indexOf(new Tactician(tactician));
        if(index>=0) {
            Tactician ripTactician = this.tacticians.get(index);
            List<IUnit> units = ripTactician.getUnits();
            if(units.size()!=0) {
                for (int i = 0; i < ripTactician.getGlobalUnits().size(); i++) {
                    ripTactician.removeUnit(units.get(0)); //se van eliminando entonces siempre voy a encontrarme con la 0
                }
            }
            for (Pair par : ripTactician.getLocations()) {
                Location location = this.mapField.getCell(par.getLeft(), par.getRight());
                location.setUnit(null);
            }
            boolean newRound = false;
            int currentTurn;
            Tactician nextTactician;

            currentTurn = this.currentOrder.indexOf(this.turnOwner);
            nextTactician = this.currentOrder.get(currentTurn + 1);
            if (this.currentOrder.get(this.currentOrder.size() - 1).equals(this.turnOwner)) {
                newRound = true;
            }
            this.currentOrder.remove(ripTactician);
            this.tacticians.remove(ripTactician);
            this.numberOfPlayers--;

            if (this.turnOwner.getName().equals(tactician)) {
                if (newRound) {
                    newRound();
                } else {
                    startTurn(nextTactician);
                }
            }
        }
    }

    /**
     * Reset the game.
     */
    public void resetGame() {
        this.roundNumber = 0;
        this.setGameMap();
        if(this.numberOfPlayers<this.globalNumberOfPlayers) {
            setTacticians();
            this.numberOfPlayers = this.globalNumberOfPlayers;
            reorderTurns();
        }
        this.numberOfPlayers = this.globalNumberOfPlayers;
        for(Tactician tactician: this.getTacticians()){
            tactician.restoreUnits();
            List<Pair> locations = tactician.getLocations();
            List<Location> newlocations = new ArrayList<>();
            for(Pair par: locations){
                Location newlocation = this.mapField.getCell(par.getLeft(),par.getRight());
                newlocations.add(newlocation);
            }
            this.putUnitsOn(tactician, newlocations);
        }
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
    }

    /**
     * Starts a game without a limit of turns.
     */
    public void initEndlessGame() {
        this.MaxRounds = -1;
        resetGame();
        newRound();
    }

    /**
     * @return the winner of this game, if the match ends in a draw returns a list of all the winners.
     */
    public List<String> getWinners() {
        //juego normal solo hay ganador(es) si acaba
        //en un endless solo termina si hay 1
        List<String> winners = new ArrayList<>();
        if (getMaxRounds() > -1) {
            if (getRoundNumber() == (getMaxRounds()) + 1) {
                int max = 0;
                for (Tactician tactician : getCurrentOrder()) {
                    if(tactician.getUnits().size() > max){
                        winners = new ArrayList<>();
                        winners.add(tactician.getName());
                        max = tactician.getUnits().size();
                    }
                    else if(tactician.getUnits().size() == max){
                        winners.add(tactician.getName());
                    }
                }
            } else {
                return null;
            }
        } else {
            if (getCurrentOrder().size() == 1) {
                winners.add(getCurrentOrder().get(0).getName());
            } else {
                return null;
            }
        }
        return winners;
    }

    /**
     * @return the current player's selected unit.
     */
    public IUnit getSelectedUnit() {
        return this.selectedUnit;
    }

    /**
     * Selects a unit in the game map.
     *
     * @param x horizontal position of the unit.
     * @param y vertical position of the unit.
     */
    public void selectUnitIn(int x, int y) {
        Location location = this.mapField.getCell(x, y);
        this.selectedUnit = location.getUnit();
    }

    /**
     * @return the inventory of the currently selected unit.
     */
    public List<IEquipableItem> getItems() {
        if (this.selectedUnit != null) {
            IUnit unit = this.selectedUnit;
            return unit.getItems();
        }
        return null;
    }

    /**
     * Equips an item from the inventory to the currently selected unit.
     *
     * @param index the location of the item in the inventory.
     */
    public void equipItem(int index) {
        if (this.selectedUnit != null) {
            IUnit unit = this.selectedUnit;
            if(!unit.getItems().isEmpty()) {
                unit.getItems().get(index).equipTo(unit);
            }
        }
    }

    /**
     * Uses the equipped item on a target.
     *
     * @param x horizontal position of the target.
     * @param y vertical position of the target.
     */
    public void useItemOn(int x, int y) {
        if (this.selectedUnit != null) {
            IUnit unit = this.selectedUnit;
            IUnit targetUnit = this.mapField.getCell(x, y).getUnit();
            unit.attack(targetUnit);
            targetUnit.getTactician().checkUnits();
            this.getTurnOwner().checkUnits();
        }
    }

    /**
     * Selects an item from the selected unit's inventory.
     *
     * @param index the location of the item in the inventory.
     */
    public void selectItem(int index) {
        if(this.selectedUnit!=null){
            IUnit unit = this.selectedUnit;
            if(!unit.getItems().isEmpty()){
                this.selectedItem = unit.getItems().get(index);
            }
        }
    }

    /**
     * @return the current player's selected unit's selected item.
     */
    public IEquipableItem getSelectedItem() {
        return this.selectedItem;
    }

    /**
     * Gives the selected item to a target unit.
     *
     * @param x horizontal position of the target.
     * @param y vertical position of the target.
     */
    public void giveItemTo(int x, int y) {
        if (this.selectedUnit != null && this.selectedItem != null) {
            IUnit unit = this.selectedUnit;
            IEquipableItem item = this.selectedItem;
            IUnit targetUnit = this.mapField.getCell(x, y).getUnit();
            unit.giveObj(targetUnit, item);
        }
    }


    /**
     * Add an alpaca to the tactician.
     *
     * @param tactician the tactician to add the alpaca.
     */
    public void addAlpaca(Tactician tactician) {
        Alpaca alpaca = alpacaFactory.create();
        alpaca.setTactician(tactician);
        tactician.addUnit(alpaca);
    }

    /**
     * Add an archer to the tactician.
     *
     * @param tactician the tactician to add the archer.
     */
    public void addArcher(Tactician tactician) {
        Archer archer = archerFactory.create();
        archer.setTactician(tactician);
        tactician.addUnit(archer);
    }

    /**
     * Add a cleric to the tactician.
     *
     * @param tactician the tactician to add the cleric.
     */
    public void addCleric(Tactician tactician) {
        Cleric cleric = clericFactory.create();
        cleric.setTactician(tactician);
        tactician.addUnit(cleric);
    }

    /**
     * Add a fighter to the tactician.
     *
     * @param tactician the tactician to add the fighter.
     */
    public void addFighter(Tactician tactician) {
        Fighter fighter = fighterFactory.create();
        fighter.setTactician(tactician);
        tactician.addUnit(fighter);
    }

    /**
     * Add a fighter to the tactician.
     *
     * @param tactician the tactician to add the hero.
     */
    public void addHero(Tactician tactician) {
        Hero hero = heroFactory.create();
        hero.setTactician(tactician);
        tactician.addUnit(hero);
    }

    /**
     * Add a sorcerer to the tactician.
     *
     * @param tactician the tactician to add the sorcerer.
     */
    public void addSorcerer(Tactician tactician) {
        Sorcerer sorcerer = sorcererFactory.create();
        sorcerer.setTactician(tactician);
        tactician.addUnit(sorcerer);
    }

    /**
     * Add a sword master to the tactician.
     *
     * @param tactician the tactician to add the sword master.
     */
    public void addSwordMaster(Tactician tactician) {
        SwordMaster swordMaster = swordMasterFactory.create();
        swordMaster.setTactician(tactician);
        tactician.addUnit(swordMaster);
    }

    /**
     * Put all the units of the tactician on the given locations.
     *
     * @param tactician the tactician to put its units on the game map.
     * @param locations the locations where to put the units.
     */
    public void putUnitsOn(Tactician tactician, List<Location> locations) {
        if (locations.size() == tactician.getUnits().size()) {
            tactician.eraseLocations();
            int i = 0;
            for (IUnit unit : tactician.getUnits()) {
                unit.setLocation(locations.get(i));
                tactician.setLocations(locations.get(i));
                i++;
            }
        }
    }

    /**
     * Add an axe to the tactician's unit in that index.
     *
     * @param index the index of tactician's unit to add the axe.
     */
    public void addAxe(int index) {
        IUnit unit = this.turnOwner.getUnits().get(index);
        unit.addItem(axeFactory.create());
    }

    /**
     * Add a bow to the tactician's unit in that index.
     *
     * @param index the index of tactician's unit to add the bow.
     */
    public void addBow(int index) {
        IUnit unit = this.turnOwner.getUnits().get(index);
        unit.addItem(bowFactory.create());
    }

    /**
     * Add a dark magic book to the tactician's unit in that index.
     *
     * @param index the index of tactician's unit to add the dark magic book.
     */
    public void addDarkMagicBook(int index) {
        IUnit unit = this.turnOwner.getUnits().get(index);
        unit.addItem(darkMagicBookFactory.create());
    }

    /**
     * Add a light magic book to the tactician's unit in that index.
     *
     * @param index the index of tactician's unit to add the light magic book.
     */
    public void addLightMagicBook(int index) {
        IUnit unit = this.turnOwner.getUnits().get(index);
        unit.addItem(lightMagicBookFactory.create());
    }

    /**
     * Add a spear to the tactician's unit in that index.
     *
     * @param index the index of tactician's unit to add the spear.
     */
    public void addSpear(int index) {
        IUnit unit = this.turnOwner.getUnits().get(index);
        unit.addItem(spearFactory.create());
    }

    /**
     * Add a spirit magic book to the tactician's unit in that index.
     *
     * @param index the index of tactician's unit to add the spirit magic book.
     */
    public void addSpiritMagicBook(int index) {
        IUnit unit = this.turnOwner.getUnits().get(index);
        unit.addItem(spiritMagicBookFactory.create());
    }

    /**
     * Add a staff to the tactician's unit in that index.
     *
     * @param index the index of tactician's unit to add the staff.
     */
    public void addStaff(int index) {
        IUnit unit = this.turnOwner.getUnits().get(index);
        unit.addItem(staffFactory.create());
    }

    /**
     * Add an sword to the tactician's unit in that index.
     *
     * @param index the index of tactician's unit to add the sword.
     */
    public void addSword(int index) {
        IUnit unit = this.turnOwner.getUnits().get(index);
        unit.addItem(swordFactory.create());
    }

    /**
     * Moves the selected unit to the target position.
     *
     * @param x horizontal position where to move the unit.
     * @param y vertical position where to move the unit.
     */
    public void moveTo(int x, int y) {
        if(this.selectedUnit!=null){
            IUnit unit = this.selectedUnit;
            int index = this.turnOwner.getUnits().indexOf(unit);
            if(!this.turnOwner.getMovedUnit().get(index)) {
                this.turnOwner.setMovedUnit(index);
                unit.moveTo(this.mapField.getCell(x, y));
            }
        }
    }
}
