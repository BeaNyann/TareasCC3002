package model.factories.items;
import model.items.Bow;

/**
 * Bow Factory.
 * Create bows.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class BowFactory extends AbstractItemFactory {

    /**
     * Set the default values of a bow.
     */
    @Override
    public void setDefault(){
        this.setName("bow");
        this.setPower(8);
        this.setMaxRange(4);
        this.setMinRange(2);

    }

    /**
     * Creates a bow.
     *
     * @return the created bow.
     */
    @Override
    public Bow create() {
        Bow bow = new Bow(this.getName(),this.getPower(),this.getMinRange(),this.getMaxRange());
        setDefault();
        return bow;
    }
}
