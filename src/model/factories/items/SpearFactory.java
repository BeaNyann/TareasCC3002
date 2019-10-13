package model.factories.items;

import model.items.Spear;

public class SpearFactory extends AbstractItemFactory{
    private String name = "javelin";
    private double power = 10;
    private int maxRange = 1;
    private int minRange = 3;

    @Override
    public Spear create() {
        Spear spear = new Spear(name,power,maxRange,minRange);
        this.name = "javelin";
        this.power = 10;
        this.maxRange = 1;
        this.minRange = 3;
        return spear;
    }
}
