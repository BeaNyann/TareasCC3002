package model.units;

import model.items.Axe;
import model.items.IEquipableItem;
import model.map.Location;

/**
 * This class represents a <i>Fighter</i> type unit.
 * <p>
 * A <i>Fighter</i> is a unit that <b>can only use Axe type weapons</b>.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public class Fighter extends AbstractUnit {
  /**
   * Creates a new Fighter unit.
   *
   * @param hitPoints   the amount of damage this unit can receive.
   * @param movement    the amount of cells this unit can move.
   * @param location    current position of the unit.
   * @param items       the items carried by this unit.
   */

  public Fighter(final int hitPoints, final int movement, final Location location,
      IEquipableItem... items) {
    super(hitPoints, movement, location, 3, items);
  }

  /**
   * Sets the currently equipped item of this unit.
   * <p>
   * The <i>Fighter</i> can <b>only equip Axes</b>.
   *
   * @param axe the axe to equip.
   */
  @Override
  public void equipAxe(final Axe axe) {
    if(this.items.contains(axe)){
      if(equippedItem!=null){
        equippedItem.setUser(null);
      }
      equippedItem = axe;
      axe.setUser(this);
    }
  }

  @Override
  public boolean equals(Object obj){
    if(obj instanceof Fighter){
      if(((IUnit) obj).getMaxHitPoints() - this.getMaxHitPoints() <= 1E-6&&
              ((IUnit)obj).getMovement() == this.getMovement() &&
              ((IUnit)obj).getLocation().equals(this.getLocation())){
        return true;
      }
    }
    return false;
  }
}
