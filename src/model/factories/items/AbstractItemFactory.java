package model.factories.items;

/**
 * Abstract Item Factory.
 * Define the commons methods of all the item factories.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public abstract class AbstractItemFactory implements IEquipableItemFactory {
    private String name;
    private  double power;
    private int maxRange;
    private int minRange;

    /**
     * Calls the method to set the default values.
     */
    public AbstractItemFactory(){
        this.setDefault();
    }

    /**
     * Set the name of the item.
     *
     * @param name the name of the item.
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the power of the item.
     *
     * @param power the name of the item.
     */
    @Override
    public void setPower(double power) {
        this.power = power;
    }

    /**
     * Set the maxRange of the item.
     *
     * @param maxRange the name of the item.
     */
    @Override
    public void setMaxRange(int maxRange) {
        this.maxRange = maxRange;
    }

    /**
     * Set the minRange of the item.
     *
     * @param minRange the name of the item.
     */
    @Override
    public void setMixRange(int minRange) {
        this.minRange = minRange;
    }


    /**
     * @return the name of the item.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @return the power of the item.
     */
    @Override
    public double getPower() {
        return power;
    }

    /**
     * @return the max Range of the item.
     */
    @Override
    public int getMaxRange() {
        return maxRange;
    }

    /**
     * @return the min Range of the item.
     */
    @Override
    public int getMinRange() {
        return minRange;
    }
}
