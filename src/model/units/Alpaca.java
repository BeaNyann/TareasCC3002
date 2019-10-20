package model.units;

import model.items.IEquipableItem;
import model.map.Location;

/**
 * This class represents an <i>Alpaca</i> type unit.
 * <p>
 * This are a special kind of unit that can carry an unlimited amount of items but can't use any of
 * them.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public class Alpaca extends AbstractUnit {

  /**
   * Creates a new Alpaca unit.
   *
   * @param hitPoints   the amount of damage this unit can receive.
   * @param movement    the amount of cells this unit can move.
   * @param location    current position of the unit.
   */
  public Alpaca(final int hitPoints, final int movement, final Location location,
      final IEquipableItem... items) {
    super(hitPoints, movement, location, Integer.MAX_VALUE, items);
  }

  /**
   * The unit receive an item, it is only received if the unit has space enough.
   * The alpaca always has space enough.
   *
   * @param   item the item to receive.
   * @return  <code>true</code> always.
   */
  @Override
  public boolean receiveObj(IEquipableItem item) {
    this.addItem(item);
    return true;
  }

  @Override
  public boolean equals(Object obj){
    if(obj instanceof Alpaca){
      if(((IUnit) obj).getMaxHitPoints() - this.getMaxHitPoints() <= 1E-6&&
              ((IUnit)obj).getMovement() == this.getMovement() &&
              ((IUnit)obj).getLocation().equals(this.getLocation())){
        return true;
      }
    }
    return false;
  }
}
