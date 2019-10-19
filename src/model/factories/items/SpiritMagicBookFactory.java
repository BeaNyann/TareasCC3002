package model.factories.items;
import model.items.SpiritMagicBook;

/**
 * Spirit Magic Book Factory.
 * Create spirit magic books.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class SpiritMagicBookFactory extends AbstractItemFactory {

    /**
     * Set the default values of a spirit magic book.
     */
    @Override
    public void setDefault(){
        setName("spirit magic book");
        setPower(10);
        setMixRange(1);
        setMaxRange(2);
    }

    /**
     * Creates a spirit magic book.
     *
     * @return the created spirit magic book.
     */
    @Override
    public SpiritMagicBook create() {
        SpiritMagicBook spiritMagicBook = new SpiritMagicBook(this.getName(),this.getPower(),this.getMaxRange(),this.getMinRange());
        setDefault();
        return spiritMagicBook;
    }
}
