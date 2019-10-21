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

    public DeadUnitHandler(GameController gameController) {
        this.gameController = gameController;
    }

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