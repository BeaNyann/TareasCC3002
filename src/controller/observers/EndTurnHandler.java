package controller.observers;

import controller.GameController;
import model.tactician.Tactician;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EndTurnHandler implements PropertyChangeListener {
    private GameController gameController;

    public EndTurnHandler(GameController gameController){
        this.gameController = gameController;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() != null) {
            Tactician nextTactician = gameController.getCurrentOrder().get(gameController.getCurrentTurn());
            gameController.startTurn(nextTactician);
        }
    }
}
