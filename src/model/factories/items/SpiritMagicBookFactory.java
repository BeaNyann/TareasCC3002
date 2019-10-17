package model.factories.items;
import model.items.SpiritMagicBook;

/**
 * Spirit Magic Book Factory.
 * Create spirit magic books.
 *
 * @author Beatriz Graboloza
 * @version 2.0
 * @since v2.0
 */
public class SpiritMagicBookFactory extends AbstractItemFactory {

    @Override
    public void setDefault(){
        setName("spirit magic book");
        setPower(10);
        setMixRange(1);
        setMaxRange(2);
    }

    @Override
    public SpiritMagicBook create() {
        SpiritMagicBook spiritMagicBook = new SpiritMagicBook(this.getName(),this.getPower(),this.getMaxRange(),this.getMinRange());
        setDefault();
        return spiritMagicBook;
    }
}
