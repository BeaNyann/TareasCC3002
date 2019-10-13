package model.factories.items;

import model.items.Axe;

public class AxeFactory extends AbstractItemFactory {
    private String name = "axe";
    private double power = 10;
    private int maxRange = 1;
    private int minRange = 2;

    @Override
    public Axe create() {
        Axe axe = new Axe(name,power,maxRange,minRange);
        this.name = "axe";
        this.power = 10;
        this.maxRange = 1;
        this.minRange = 2;
        return axe;
    }
}
