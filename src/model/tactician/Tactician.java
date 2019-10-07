package model.tactician;

import controller.GameController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;


public class Tactician {

    private final String name;
    private PropertyChangeSupport endTurn;

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

