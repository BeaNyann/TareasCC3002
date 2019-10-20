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
            //TODO si el heroe es derrotado se llama a remove tactician po, con todas sus unidades
            //si era su turno lo termina y pierde, si no solo pierde -> eso lo hace remove tactician
            //TODO si todas sus units mueren el controller se encarga de saber que weA?
            gameController.removeTactician((String)evt.getNewValue());

        }
    }
}
