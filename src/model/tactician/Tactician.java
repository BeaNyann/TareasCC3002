package model.tactician;

import controller.Pair;
import controller.observers.DeadHeroHandler;
import model.map.Location;
import model.units.IUnit;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

/**
 * The representation of the players of the game.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class Tactician{

    private final String name;
    private PropertyChangeSupport endTurn;
    private List<IUnit> units = new ArrayList<>();
    private List<IUnit> globalUnits = new ArrayList<>();
    private List<Pair> locations = new ArrayList<>();

    //TODO esto
    //el jugador indica que quiere crear? una sola factory, envia el matodo a la factory
    //una gran factory que puede hacer de too
    //el tactician tendria todos los metodos de crear distintas weas
    //TODO las units deben guardar una referencia a su tactician


    /**
     * Constructor for a default Tactician.
     *
     * @param name     the name of the tactician.
     */
    public Tactician(final String name) {
        this.name = name;
        endTurn = new PropertyChangeSupport(this);
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
        endTurn.addPropertyChangeListener(resp); //TODO buscar ej de observer implementados
    }

    /**
     * Sets a change in the dead hero event.
     */
    public void setDeadHero() {
        endTurn.firePropertyChange(new PropertyChangeEvent(this, "deadHero",null,true));
            }

    /**
     * Add a unit to the tactician's list of units.
     *
     * @param unit the unit to add to the list of units.
     */
    public void addUnit(IUnit unit) {
        this.globalUnits.add(unit);
    }

    /**
     * Restore the units of this tactician.
     */
    public void restoreUnits(){
        this.units = new ArrayList<>();
        this.units.addAll(this.globalUnits);
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

}

