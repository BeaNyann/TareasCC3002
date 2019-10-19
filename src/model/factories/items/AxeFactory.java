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

    /**
     * Set the default values of an axe.
     */
    @Override
    public void setDefault(){
        setName("axe");
        setPower(10);
        setMinRange(1);
        setMaxRange(2);
    }

    /**
     * Creates an axe.
     *
     * @return creates an axe.
     */
    @Override
    public Axe create() {
        Axe axe = new Axe(this.getName(),this.getPower(),this.getMinRange(),this.getMaxRange());
        setDefault();
        return axe;
    }
}
