package model.factories.units;

import model.map.Location;

public abstract class AbstractUnitFactory implements IUnitFactory{
    private int hitPoints = 20;
    private Location location = new Location(0,0);
    private int movement = 2;

    @Override
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public void setMovement(int movement) {
        this.movement = movement;
    }
}
