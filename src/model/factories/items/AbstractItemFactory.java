package model.factories.items;

public abstract class AbstractItemFactory implements IEquipableItemFactory {
    private String name;
    private  double power;
    private int maxRange;
    private int minRange;

    public AbstractItemFactory(){
        this.setDefault();
    }

    @Override
    public void setDefault(){
        setName("item");
        setPower(10);
        setMixRange(1);
        setMaxRange(2);
    }

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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPower() {
        return power;
    }

    @Override
    public int getMaxRange() {
        return maxRange;
    }

    @Override
    public int getMinRange() {
        return minRange;
    }
}
