package model.factories.items;
import model.items.Sword;

/**
 * Sword Factory.
 * Create swords.
 *
 * @author Beatriz Graboloza
 * @version 2.0
 * @since v2.0
 */
public class SwordFactory extends AbstractItemFactory {

    @Override
    public void setDefault(){
        this.setName("sword");
        this.setPower(10);
        this.setMaxRange(1);
        this.setMixRange(1);
    }
    @Override
    public Sword create() {
        Sword sword = new Sword(this.getName(),this.getPower(),this.getMaxRange(),this.getMinRange());
        setDefault();
        return sword;
    }
}
