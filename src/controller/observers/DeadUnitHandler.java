package controller.observers;

import controller.GameController;
import model.tactician.Tactician;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * A Observer who manages the event when a unit dies.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class DeadUnitHandler implements PropertyChangeListener {
    private GameController gameController;

    public DeadUnitHandler(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //ayuda
    }
}