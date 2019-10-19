package model.factories.items;
import model.items.LightMagicBook;

/**
 * Light Magic Book Factory.
 * Create light magic books.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class LightMagicBookFactory extends AbstractItemFactory {

    /**
     * Set the default values of a light magic book.
     */
    @Override
    public void setDefault(){
        setName("light magic book");
        setPower(10);
        setMixRange(1);
        setMaxRange(2);
    }

    /**
     * Creates a light magic book.
     *
     * @return the created light magic book.
     */
    @Override
    public LightMagicBook create() {
        LightMagicBook lightMagicBook = new LightMagicBook(this.getName(),this.getPower(),this.getMaxRange(),this.getMinRange());
        setDefault();
        return lightMagicBook;
    }
}
