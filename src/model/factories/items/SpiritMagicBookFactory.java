package model.factories.items;

import model.items.SpiritMagicBook;

public class SpiritMagicBookFactory extends AbstractItemFactory {

    @Override
    public SpiritMagicBook create() {
        SpiritMagicBook spiritMagicBook = new SpiritMagicBook(this.getName(),this.getPower(),this.getMaxRange(),this.getMinRange());
        setDefault();
        return spiritMagicBook;
    }
}
