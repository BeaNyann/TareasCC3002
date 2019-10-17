package model.factories.items;
import model.items.DarkMagicBook;

/**
 * Dark Magic Book Factory.
 * Create dark magic books.
 *
 * @author Beatriz Graboloza
 * @version 2.0
 * @since v2.0
 */
public class DarkMagicBookFactory extends AbstractItemFactory {

    @Override
    public DarkMagicBook create() {
        DarkMagicBook darkMagicBook = new DarkMagicBook(this.getName(),this.getPower(),this.getMaxRange(),this.getMinRange());
        setDefault();
        return darkMagicBook;
    }
}
