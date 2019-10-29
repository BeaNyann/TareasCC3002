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

    /**
     * Assign the game controller to this handler.
     *
     * @param gameController the game controller where the methods are going to be called.
     */
    public DeadHeroHandler(GameController gameController){
        this.gameController = gameController;
    }

    /**
     * Remove the tacticians that has lost the hero.
     *
     * @param evt the event that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() != null) {
            Tactician tactician = (Tactician) evt.getNewValue();
            gameController.removeTactician(tactician.getName());

        }
    }
}
