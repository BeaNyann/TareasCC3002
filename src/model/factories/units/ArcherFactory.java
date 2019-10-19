package model.factories.units;
import model.units.Archer;

/**
 * Archer Factory.
 * Create archers.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class ArcherFactory extends AbstractUnitFactory{

    /**
     * Creates an archer.
     *
     * @return the created archer.
     */
    @Override
    public Archer create() {
        Archer archer = new Archer(this.getHitPoints(),this.getMovement(),this.getLocation());
        setDefault();
        return archer;
    }

}
