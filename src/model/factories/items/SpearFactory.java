package model.factories.items;
import model.items.Spear;

/**
 * Spear Factory.
 * Create spears.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class SpearFactory extends AbstractItemFactory{

    /**
     * Set the default values of a spear.
     */
    @Override
    public void setDefault(){
        this.setName("spear");
        this.setPower(10);
        this.setMinRange(1);
        this.setMaxRange(3);

    }

    /**
     * Creates a spear.
     *
     * @return the created spear.
     */
    @Override
    public Spear create() {
        Spear spear = new Spear(this.getName(),this.getPower(),this.getMinRange(),this.getMaxRange());
        setDefault();
        return spear;
    }
}
