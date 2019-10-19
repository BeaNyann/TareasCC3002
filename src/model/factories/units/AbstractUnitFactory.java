package model.factories.units;
import model.map.Location;

/**
 * Abstract Unit Factory.
 * Define the commons methods of all the unit factories.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public abstract class AbstractUnitFactory implements IUnitFactory{
    private int hitPoints;
    private Location location;
    private int movement;

    /**
     * Calls the method to set the default values when the factory is created.
     */
    public AbstractUnitFactory(){
        setDefault();
    }

    /**
     * Set the default values of the unit.
     */
    @Override
    public void setDefault(){
        setHitPoints(20);
        setLocation(new Location(0,0));
        setMovement(2);
    }

    /**
     * @return the hit points of the unit.
     */
    @Override
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * @return the location of the unit.
     */
    @Override
    public Location getLocation() {
        return location;
    }

    /**
     * @return the number of cells this unit can move.
     */
    @Override
    public int getMovement() {
        return movement;
    }

    /**
     * Set the hit points of the unit.
     *
     * @param hitPoints the hit points of the unit.
     */
    @Override
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    /**
     * Set the location of the unit.
     *
     * @param location the location of the unit.
     */
    @Override
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Set the number of cells this unit can move.
     *
     * @param movement the number of cells this unit can move.
     */
    @Override
    public void setMovement(int movement) {
        this.movement = movement;
    }
}
