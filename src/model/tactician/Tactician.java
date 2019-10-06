package model.tactician;

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

    public void addObserver(ModuleLayer.Controller resp) {
        endTurn.addPropertyChangeListener(resp); //TODO ayuda
    }

    public void setEndTurn() {
        endTurn.firePropertyChange(new PropertyChangeEvent(this, "endTurn",null,true));
            }

    }
}
