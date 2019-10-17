package model.factories.units;
import model.map.Location;

/**
 * Abstract Unit Factory.
 * Define the commons methods of all the unit factoies.
 *
 * @author Beatriz Graboloza
 * @version 2.0
 * @since v2.0
 */
public abstract class AbstractUnitFactory implements IUnitFactory{
    private int hitPoints;
    private Location location;
    private int movement;

    public AbstractUnitFactory(){
        setDefault();
    }

    @Override
    public void setDefault(){
        setHitPoints(20);
        setLocation(new Location(0,0));
        setMovement(2);
    }

    @Override
    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public int getMovement() {
        return movement;
    }

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
