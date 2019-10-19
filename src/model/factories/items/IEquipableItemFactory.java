package model.factories.items;
import model.items.IEquipableItem;

/**
 * Interface for Item Factories.
 * Define all the methods a item factory needs to have.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public interface IEquipableItemFactory {

    /**
     * Set the default values of an item.
     */
    void setDefault();

    /**
     * Set the name of the item.
     *
     * @param name the mame of the item.
     */
    void setName(String name);

    /**
     * Set the power of the item.
     *
     * @param power the power of the item.
     */
    void setPower(double power);

    /**
     * Set the max range of the item.
     *
     * @param maxRange the max range of the item.
     */
    void setMaxRange(int maxRange);

    /**
     * Set the min range of the item.
     *
     * @param minRange the min range of the item.
     */
    void setMinRange(int minRange);

    /**
     * Creates an item.
     *
     * @return the item created.
     */
    IEquipableItem create();

    /**
     * @return the name of the item.
     */
    String getName();

    /**
     * @return the power of the item.
     */
    double getPower();

    /**
     * @return the max range of the item.
     */
    int getMaxRange();

    /**
     * @return the min range of the item.
     */
    int getMinRange();
}
