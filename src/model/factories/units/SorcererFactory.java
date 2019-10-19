package model.factories.units;
import model.units.Sorcerer;

/**
 * Sorcerer Factory.
 * Create sorcerers.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class SorcererFactory extends AbstractUnitFactory{

    /**
     * Creates a sorcerer.
     *
     * @return the created sorcerer.
     */
    @Override
    public Sorcerer create() {
        Sorcerer sorcerer = new Sorcerer(this.getHitPoints(),this.getMovement(),this.getLocation());
        setDefault();
        return sorcerer;
    }
}
