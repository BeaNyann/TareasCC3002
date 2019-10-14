package model.factories.units;

import model.map.Location;
import model.units.IUnit;

public interface IUnitFactory {

    void setDefault();

    void setHitPoints(int hitPoints);

    void setLocation(Location location);

    void setMovement(int movement);

    int getHitPoints();

    Location getLocation();

    int getMovement();

    IUnit create();

}
