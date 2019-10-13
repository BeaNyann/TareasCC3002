package model.factories.items;

import model.items.Sword;

public class SwordFactory extends AbstractItemFactory {
    private String name = "sword";
    private double power = 10;
    private int maxRange = 1;
    private int minRange = 1;

    @Override
    public Sword create() {
        Sword sword = new Sword(name,power,maxRange,minRange);
        this.name = "sword";
        this.power = 10;
        this.maxRange = 1;
        this.minRange = 1;
        return sword;
    }
}
