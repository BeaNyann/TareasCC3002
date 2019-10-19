package model.factories.units;
import model.units.Cleric;

/**
 * Cleric Factory.
 * Create clerics.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class ClericFactory extends AbstractUnitFactory{

    /**
     * Creates a cleric.
     *
     * @return the created cleric.
     */
    @Override
    public Cleric create() {
        Cleric cleric = new Cleric(this.getHitPoints(),this.getMovement(),this.getLocation());
        setDefault();
        return cleric;
    }
}
