package model.factories.items;

import model.items.DarkMagicBook;

public class DarkMagicBookFactory extends AbstractItemFactory {

    @Override
    public DarkMagicBook create() {
        DarkMagicBook darkMagicBook = new DarkMagicBook(this.getName(),this.getPower(),this.getMaxRange(),this.getMinRange());
        setDefault();
        return darkMagicBook;
    }
}
