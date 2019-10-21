package controller.observers;

import controller.GameController;
import model.tactician.Tactician;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * A Observer who manages the event when a hero dies.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class DeadHeroHandler implements PropertyChangeListener {
    private GameController gameController;

    public DeadHeroHandler(GameController gameController){
        this.gameController = gameController;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() != null) {
            Tactician tactician = (Tactician) evt.getNewValue();
            gameController.removeTactician(tactician.getName());

        }
    }
}
