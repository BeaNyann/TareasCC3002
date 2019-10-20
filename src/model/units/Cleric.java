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
   * <p>
   * The <i>Cleric</i> can <b>only equip Staffs</b>.
   *
   * @param staff the staff to equip.
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

  /**
   * The cleric cannot attack other units, it send a message to the cleric´s staff to heal other unit.
   *
   * @param unit the unit that is going to be attacked.
   */
  @Override
  public void attack(IUnit unit) {
    if(this.equippedItem!=null &&
            this.getEquippedItem().getMinRange() <= this.getLocation().distanceTo(unit.getLocation()) &&
            this.getLocation().distanceTo(unit.getLocation()) <= this.getEquippedItem().getMaxRange() &&
            this.getCurrentHitPoints()> 0 && unit.getCurrentHitPoints()>0 &&
            unit.getCurrentHitPoints()<this.getMaxHitPoints() ) {
      this.equippedItem.attackWith(unit);
    }
  }
  @Override
  public void counterAttack(IUnit unit) {
    //Purposely left empty.
  }

  @Override
  public boolean equals(Object obj){
    if(obj instanceof Cleric){
      if(((IUnit) obj).getMaxHitPoints() - this.getMaxHitPoints() <= 1E-6&&
              ((IUnit)obj).getMovement() == this.getMovement() &&
              ((IUnit)obj).getLocation().equals(this.getLocation())){
        return true;
      }
    }
    return false;
  }
}
