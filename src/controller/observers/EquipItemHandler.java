package controller.observers;

import controller.GameController;
import model.tactician.Tactician;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EquipItemHandler implements PropertyChangeListener {
    private GameController gameController;

    public EquipItemHandler(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //ayuda
    }
}