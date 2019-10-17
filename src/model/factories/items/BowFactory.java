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

    @Override
    public void setDefault(){
        this.setName("bow");
        this.setPower(8);
        this.setMaxRange(4);
        this.setMixRange(2);

    }
    @Override
    public Bow create() {
        Bow bow = new Bow(this.getName(),this.getPower(),this.getMaxRange(),this.getMinRange());
        setDefault();
        return bow;
    }
}
