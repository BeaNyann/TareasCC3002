package model.factories.items;
import model.items.Sword;

/**
 * Sword Factory.
 * Create swords.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class SwordFactory extends AbstractItemFactory {

    /**
     * Set the default values of a sword.
     */
    @Override
    public void setDefault(){
        this.setName("sword");
        this.setPower(10);
        this.setMaxRange(1);
        this.setMinRange(1);
    }

    /**
     * Creates a sword.
     *
     * @return the created sword.
     */
    @Override
    public Sword create() {
        Sword sword = new Sword(this.getName(),this.getPower(),this.getMinRange(),this.getMaxRange());
        setDefault();
        return sword;
    }
}
