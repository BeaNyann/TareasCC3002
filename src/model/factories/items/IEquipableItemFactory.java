package model.factories.items;
import model.items.IEquipableItem;

/**
 * Interface for Item Factories.
 * Define all the methods a item factory needs to have.
 *
 * @author Beatriz Graboloza
 * @version 2.0
 * @since v2.0
 */
public interface IEquipableItemFactory {

    void setDefault();

    void setName(String name);

    void setPower(double power);

    void setMaxRange(int maxRange);

    void setMixRange(int mixRange);

    IEquipableItem create();

    String getName();

    double getPower();

    int getMaxRange();

    int getMinRange();
}
