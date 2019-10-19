package model.factories.units;
import model.units.Fighter;

/**
 * Fighter Factory.
 * Create fighters.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class FighterFactory extends AbstractUnitFactory{

    /**
     * Creates a fighter.
     *
     * @return the created fighter.
     */
    @Override
    public Fighter create() {
        Fighter fighter = new Fighter(this.getHitPoints(),this.getMovement(),this.getLocation());
        setDefault();
        return fighter;
    }
}
