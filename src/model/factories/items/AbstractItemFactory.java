package model.factories.items;

public abstract class AbstractItemFactory implements IEquipableItemFactory {
    private String name;
    private  double power;
    private int maxRange;
    private int minRange;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPower(double power) {
        this.power = power;
    }

    @Override
    public void setMaxRange(int maxRange) {
        this.maxRange = maxRange;
    }

    @Override
    public void setMixRange(int mixRange) {
        this.minRange = mixRange;
    }
}
