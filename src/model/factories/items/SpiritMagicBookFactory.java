package model.factories.items;

import model.items.SpiritMagicBook;

public class SpiritMagicBookFactory extends AbstractItemFactory {
    private String name = "spirit magic book";
    private double power = 8;
    private int maxRange = 2;
    private int minRange = 4;

    @Override
    public SpiritMagicBook create() {
        SpiritMagicBook spiritMagicBook = new SpiritMagicBook(name,power,maxRange,minRange);
        this.name = "spirit magic book";
        this.power = 8;
        this.maxRange = 2;
        this.minRange = 4;
        return spiritMagicBook;
    }
}
