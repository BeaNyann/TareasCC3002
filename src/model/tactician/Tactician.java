package model.tactician;

import controller.observers.EndTurnHandler;
import model.map.Location;
import model.units.IUnit;
import model.units.SwordMaster;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

/**
 * The representation of the players of the game.
 *
 * @author Beatriz Graboloza
 * @version 2.0
 * @since v2.0
 */
public class Tactician{

    private final String name;
    private PropertyChangeSupport endTurn;
    private List<IUnit> units = new ArrayList<>();
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
     * Adds a response handler to the end turn message.
     *
     * @param resp the response handler.
     */
    public void addEndTurnObserver(EndTurnHandler resp) {
        endTurn.addPropertyChangeListener(resp); //TODO buscar ej de observer implementados
    }

    /**
     * Sets a change in the end turn event.
     */
    public void setEndTurn() {
        endTurn.firePropertyChange(new PropertyChangeEvent(this, "endTurn",null,true));
            }

    /**
     * Add a unit to the tactician's list of units.
     *
     * @param unit the unit to add to the list of units.
     */
    public void addUnit(IUnit unit) {
        this.units.add(unit);
    }

}

