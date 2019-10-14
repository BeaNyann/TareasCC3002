package model.factories.items;

import model.items.LightMagicBook;

public class LightMagicBookFactory extends AbstractItemFactory {

    @Override
    public LightMagicBook create() {
        LightMagicBook lightMagicBook = new LightMagicBook(this.getName(),this.getPower(),this.getMaxRange(),this.getMinRange());
        setDefault();
        return lightMagicBook;
    }
}
