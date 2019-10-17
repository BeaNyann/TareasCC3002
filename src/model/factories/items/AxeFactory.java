package model.factories.items;
import model.items.Axe;

/**
 * Axe Factory.
 * Create axes.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class AxeFactory extends AbstractItemFactory {

    @Override
    public void setDefault(){
        setName("axe");
        setPower(10);
        setMixRange(1);
        setMaxRange(2);
    }

    @Override
    public Axe create() {
        Axe axe = new Axe(this.getName(),this.getPower(),this.getMaxRange(),this.getMinRange());
        setDefault();
        return axe;
    }
}
