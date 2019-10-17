package model.factories.items;
import model.items.Spear;

/**
 * Spear Factory.
 * Create spears.
 *
 * @author Beatriz Graboloza
 * @version 2.0
 * @since v2.0
 */
public class SpearFactory extends AbstractItemFactory{

    @Override
    public void setDefault(){
        this.setName("item");
        this.setPower(10);
        this.setMaxRange(1);
        this.setMixRange(3);

    }
    @Override
    public Spear create() {
        Spear spear = new Spear(this.getName(),this.getPower(),this.getMaxRange(),this.getMinRange());
        setDefault();
        return spear;
    }
}
