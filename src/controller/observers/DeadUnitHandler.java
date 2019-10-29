package controller.observers;

import controller.GameController;
import model.tactician.Tactician;
import model.units.IUnit;

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

    /**
     * Assign the game controller to this handler.
     *
     * @param gameController the game controller where the methods are going to be called.
     */
    public DeadUnitHandler(GameController gameController) {
        this.gameController = gameController;
    }

    /**
     * Remove the unit that has died and remove the tactician if necessary.
     *
     * @param evt the event that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() != null) {
            Tactician tactician = (Tactician) evt.getNewValue();
            int index =0;
            for (int i = 0; i<tactician.getGlobalUnits().size();i++) {
                IUnit unit = tactician.getUnits().get(index);
                if(unit.getCurrentHitPoints() == 0){
                    unit.getLocation().setUnit(null);
                    tactician.removeUnit(unit);
                }
                else{
                    index++;
                }
            }
            if(tactician.getUnits().size() == 0){
                gameController.removeTactician(tactician.getName());
            }
        }
    }
}