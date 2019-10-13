package model.factories.items;

import model.items.DarkMagicBook;

public class DarkMagicBookFactory extends AbstractItemFactory {
    private String name = "dark magic book";
    private double power = 8;
    private int maxRange = 2;
    private int minRange = 4;

    @Override
    public DarkMagicBook create() {
        DarkMagicBook darkMagicBook = new DarkMagicBook(name,power,maxRange,minRange);
        this.name = "dark magic book";
        this.power = 8;
        this.maxRange = 2;
        this.minRange = 4;
        return darkMagicBook;
    }
}
