package model.factories.items;
import model.items.Axe;

/**
 * Axe Factory.
 * Create axes.
 *
 * @author Beatriz Graboloza
 * @version 2.0
 * @since v2.0
 */
public class AxeFactory extends AbstractItemFactory {

    @Override
    public Axe create() {
        Axe axe = new Axe(this.getName(),this.getPower(),this.getMaxRange(),this.getMinRange());
        setDefault();
        return axe;
    }
}
