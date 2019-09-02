package model.units;

import model.items.IEquipableItem;
import model.items.Staff;
import model.map.Location;

/**
 * This class represents a <i>Cleric</i> type unit.
 * <p>
 * A <i>Cleric</i> is a unit that <b>can only use Staff type weapons</b>.
 * Which means that it can receive attacks but can't counter attack any of those.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public class Cleric extends AbstractUnit {

  /**
   * Creates a new Cleric unit.
   *
   * @param hitPoints   the amount of damage this unit can receive.
   * @param movement    the amount of cells this unit can move.
   * @param location    current position of the unit.
   * @param items       the items carried by this unit.
   */
  public Cleric(final int hitPoints, final int movement, final Location location,
      IEquipableItem... items) {
    super(hitPoints, movement, location, 3, items);
  }

  /**
   * Sets the currently equipped item of this unit.
   *
   * @param staff
   *     the item to equip
   */
  @Override
  public void equipStaff(final Staff staff) {
    if(this.items.contains(staff)){
      if(equippedItem!=null){
        equippedItem.setUser(null);
      }
      equippedItem = staff;
      staff.setUser(this);
    }
  }

  @Override
  public void attack(IUnit unit) {}
}
