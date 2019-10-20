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
            for (IUnit unit :tactician.getUnits()) {
                if(unit.getCurrentHitPoints() == 0){
                    unit.getLocation().setUnit(null);
                    tactician.removeUnit(unit);
                }
            }
            if(tactician.getUnits().size() == 0){
                gameController.removeTactician(tactician.getName());
            }//TODO testear que pierda al morirsele toas, testear que se muere una
        }
    }
}