package model.factories.items;

import model.items.IEquipableItem;

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
