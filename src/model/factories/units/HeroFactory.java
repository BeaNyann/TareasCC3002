package model.factories.units;
import model.units.Hero;

/**
 * Hero Factory.
 * Create heroes.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class HeroFactory extends AbstractUnitFactory{

    /**
     * Creates a hero.
     *
     * @return the created hero.
     */
    @Override
    public Hero create() {
        Hero hero = new Hero(this.getHitPoints(),this.getMovement(),this.getLocation());
        setDefault();
        return hero;
    }
}
