package model.factories.units;
import model.units.SwordMaster;

/**
 * Sword Factory.
 * Create sword.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class SwordMasterFactory extends AbstractUnitFactory{

    /**
     * Creates a sword.
     *
     * @return the created sword.
     */
    @Override
    public SwordMaster create() {
        SwordMaster swordMaster = new SwordMaster(this.getHitPoints(),this.getMovement(),this.getLocation());
        setDefault();
        return swordMaster;
    }
}
