package model.factories.items;

import model.items.LightMagicBook;

public class LightMagicBookFactory extends AbstractItemFactory {
    private String name = "light magic book";
    private double power = 8;
    private int maxRange = 2;
    private int minRange = 4;

    @Override
    public LightMagicBook create() {
        LightMagicBook lightMagicBook = new LightMagicBook(name,power,maxRange,minRange);
        this.name = "light magic book";
        this.power = 8;
        this.maxRange = 2;
        this.minRange = 4;
        return lightMagicBook;
    }
}
