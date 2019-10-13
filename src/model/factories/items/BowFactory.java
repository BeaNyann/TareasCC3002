package model.factories.items;

import model.items.Bow;

public class BowFactory extends AbstractItemFactory {
    private String name = "bow";
    private double power = 8;
    private int maxRange = 2;
    private int minRange = 4;

    @Override
    public Bow create() {
        Bow bow = new Bow(name,power,maxRange,minRange);
        this.name = "bow";
        this.power = 8;
        this.maxRange = 2;
        this.minRange = 4;
        return bow;
    }
}
