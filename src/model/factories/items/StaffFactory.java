package model.factories.items;

import model.items.Staff;

public class StaffFactory extends AbstractItemFactory {
    private String name = "staff";
    private double power = 5;
    private int maxRange = 1;
    private int minRange = 1;

    @Override
    public Staff create() {
        Staff staff = new Staff(name,power,maxRange,minRange);
        this.name = "staff";
        this.power = 5;
        this.maxRange = 1;
        this.minRange = 1;
        return staff;
    }
}
