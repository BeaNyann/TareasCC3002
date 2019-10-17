package model.factories.items;
import model.items.LightMagicBook;

/**
 * Light Magic Book Factory.
 * Create light magic books.
 *
 * @author Beatriz Graboloza
 * @version 2.0
 * @since v2.0
 */
public class LightMagicBookFactory extends AbstractItemFactory {

    @Override
    public void setDefault(){
        setName("light magic book");
        setPower(10);
        setMixRange(1);
        setMaxRange(2);
    }

    @Override
    public LightMagicBook create() {
        LightMagicBook lightMagicBook = new LightMagicBook(this.getName(),this.getPower(),this.getMaxRange(),this.getMinRange());
        setDefault();
        return lightMagicBook;
    }
}
