package model.factories.items;
import model.items.DarkMagicBook;

/**
 * Dark Magic Book Factory.
 * Create dark magic books.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class DarkMagicBookFactory extends AbstractItemFactory {

    /**
     * Set the default values of a dark magic book.
     */
    @Override
    public void setDefault(){
        setName("dark magic book");
        setPower(10);
        setMixRange(1);
        setMaxRange(2);
    }

    /**
     * Creates an dark magic book.
     *
     * @return the created dark magic book.
     */
    @Override
    public DarkMagicBook create() {
        DarkMagicBook darkMagicBook = new DarkMagicBook(this.getName(),this.getPower(),this.getMaxRange(),this.getMinRange());
        setDefault();
        return darkMagicBook;
    }
}
