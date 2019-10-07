package model.tactician;

import controller.GameController;
import model.units.IUnit;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;


public class Tactician {

    private final String name;
    private PropertyChangeSupport endTurn;
    private List<IUnit> units = new ArrayList<>();
    //private UnitFactory unitFactory;
    //TODO esto
    //el jugador indica que quiere crear? una sola factory, envia el matodo a la factory
    //una gran factory que puede hacer de too
    //el tactician tendria todos los metodos de crear distintas weas



    /**
     * Constructor for a default Tactician.
     *
     * @param name     the name of the tactician.
     */
    public Tactician(final String name) {
        this.name = name;
        endTurn = new PropertyChangeSupport(this);
    }

    public String getName() {
        return name;
    }

    public List<IUnit> getUnits(){
        return this.units;
    }

    @Override
    public boolean equals(Object tactician){
        if(tactician instanceof Tactician){
            return this.getName().equals(((Tactician) tactician).getName());
        }
        return false;
    }

    public void addObserver(GameController resp) {
        endTurn.addPropertyChangeListener(resp); //TODO buscar ej de observer implementados
    }

    public void setEndTurn() {
        endTurn.firePropertyChange(new PropertyChangeEvent(this, "endTurn",null,true));
            }

}

