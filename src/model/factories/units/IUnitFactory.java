package model.factories.units;

import model.map.Location;
import model.units.IUnit;

public interface IUnitFactory {

    void setHitPoints(int hitPoints);

    void setLocation(Location location);

    void setMovement(int movement);

    IUnit create();

}
