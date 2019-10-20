package model.tactician;

import controller.Pair;
import controller.observers.DeadHeroHandler;
import controller.observers.DeadUnitHandler;
import model.map.Field;
import model.map.Location;
import model.units.IUnit;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * The representation of the players of the game.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class Tactician{

    private final String name;
    private PropertyChangeSupport deadHero;
    private PropertyChangeSupport deadUnit;
    private List<IUnit> units = new ArrayList<>();
    private List<IUnit> globalUnits = new ArrayList<>();
    private List<Pair> locations = new ArrayList<>();
    private List<Boolean> movedUnit = new ArrayList<>();
    private Field mapField;
    //TODO las units deben guardar una referencia a su tactician

    /**
     * Constructor for a default Tactician.
     *
     * @param name     the name of the tactician.
     */
    public Tactician(final String name) {
        this.name = name;
        deadHero = new PropertyChangeSupport(this);
    }

    /**
     * @return the name of the tactician.
     */
    public String getName() {
        return name;
    }

    /**
     * @return the tactician's list of units.
     */
    public List<IUnit> getUnits(){
        return this.globalUnits;
    }

    /**
     * @return the tactician's list of alive units in the game.
     */
    public List<IUnit> getAliveUnits(){
        return this.units;
    }

    /**
     * @return if one tactician is equals to another.
     */
    @Override
    public boolean equals(Object tactician){
        if(tactician instanceof Tactician){
            return this.getName().equals(((Tactician) tactician).getName());
        }
        return false;
    }

    /**
     * Adds a response handler to the dead hero message.
     *
     * @param resp the response handler.
     */
    public void addDeadHeroObserver(DeadHeroHandler resp) {
        deadHero.addPropertyChangeListener(resp);
    }

    /**
     * Sets a change in the dead hero event.
     */
    public void setDeadHero() {
        deadHero.firePropertyChange(new PropertyChangeEvent(this, "deadHero",null,this.getName()));
            }

    /**
     * Adds a response handler to the dead unit message.
     *
     * @param resp the response handler.
     */
    public void addDeadUnitObserver(DeadUnitHandler resp) {
        deadHero.addPropertyChangeListener(resp);
    }

    /**
     * Sets a change in the dead unit event.
     */
    public void setDeadUnit() {
        deadHero.firePropertyChange(new PropertyChangeEvent(this, "deadUnit",null,this.getName()));
    }
    /**
     * Add a unit to the tactician's list of units with its correspondent boolean.
     *
     * @param unit the unit to add to the list of units.
     */
    public void addUnit(IUnit unit) {
        this.globalUnits.add(unit);
        this.movedUnit.add(FALSE);
    }

    /**
     * Restore the units of this tactician and its moving boolean.
     */
    public void restoreUnits(){
        this.units = new ArrayList<>();
        this.units.addAll(this.globalUnits);
        this.movedUnit = new ArrayList<>();
        for(int i=0;i<this.globalUnits.size();i++){
            movedUnit.add(FALSE);
        }
    }

    /**
     * @return the locations of the units of this tactician.
     */
    public List<Pair> getLocations(){
        return this.locations;
    }

    /**
     * Erase de locations of the tactician's units.
     */
    public void eraseLocations(){
        this.locations = new ArrayList<>();
    }

    /**
     * Add a location to the tactician's units list of locations in form of pairs.
     *
     * @param location the locations of the tactician units.
     */
    public void setLocations(Location location){
        Pair par = new Pair(location.getRow(),location.getColumn());
        this.locations.add(par);
    }

    /**
     * @return the boolean list of the moved units.
     */
    public List<Boolean> getMovedUnit(){
        return this.movedUnit;
    }

    /**
     * Set TRUE in the position of the unit that was moved.
     *
     * @param index the index of the unit that was moved.
     */
    public void setMovedUnit(int index){
        this.movedUnit.set(index,TRUE);
    }

    /**
     * Removes a unit from the list of alive units.
     *
     * @param unit the unit to remove.
     */
    public void removeUnit(IUnit unit) {
        int index = this.units.indexOf(unit);
        this.units.remove(unit);
        this.movedUnit.remove(index);
    }

    /**
     * Set the map of the game to the tactician.
     *
     * @param map the map where the tactician is going to play.
     */
    public void setMapField(Field map){
        this.mapField = map;
    }

    /**
     * @return the map where the tactician is playing.
     */
    public Field getMapField(){
        return this.mapField;
    }
}

