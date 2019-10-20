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
        if (evt.getNewValue() != null) {
            int index = this.gameController.getCurrentOrder().indexOf(new Tactician((String)evt.getNewValue()));

        }
        //ayuda

        //TODO si una unit muere se saca de la celda,el controler sabe cuando mueren todas? cuando comprueba eso??
    }
}