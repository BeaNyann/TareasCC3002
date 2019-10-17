package model.factories.items;
import model.items.DarkMagicBook;

/**
 * Dark Magic Book Factory.
 * Create dark magic books.
 *
 * @author Beatriz Graboloza
 * @version 2.0 //TODO quitar los version xd
 * @since v2.0
 */
public class DarkMagicBookFactory extends AbstractItemFactory {

    @Override
    public void setDefault(){
        setName("dark magic book");
        setPower(10);
        setMixRange(1);
        setMaxRange(2);
    }

    @Override
    public DarkMagicBook create() {
        DarkMagicBook darkMagicBook = new DarkMagicBook(this.getName(),this.getPower(),this.getMaxRange(),this.getMinRange());
        setDefault();
        return darkMagicBook;
    }
}
