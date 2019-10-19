package model.factories.units;
import model.map.Location;
import model.units.IUnit;

/**
 * Interface for Unit Factories.
 * Define all the methods a unit factory needs to have.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public interface IUnitFactory {

    /**
     * Set the default values of an unit.
     */
    void setDefault();

    /**
     * Set the hit points of the unit.
     *
     * @param hitPoints the hit points of the unit.
     */
    void setHitPoints(int hitPoints);

    /**
     * Set the location of the unit.
     *
     * @param location the location of the unit.
     */
    void setLocation(Location location);

    /**
     * Set the number of cells this unit can move.
     *
     * @param movement the number of cells this unit can move.
     */
    void setMovement(int movement);

    /**
     * @return the hit points of the unit.
     */
    int getHitPoints();

    /**
     * @return the location of the unit.
     */
    Location getLocation();

    /**
     * @return the number of cells this unit can move.
     */
    int getMovement();

    /**
     * Creates a unit.
     *
     * @return the unit created.
     */
    IUnit create();

}
