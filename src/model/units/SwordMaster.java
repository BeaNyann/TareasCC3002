package model.units;

import model.items.IEquipableItem;
import model.items.Sword;
import model.map.Location;

/**
 * This class represents a <i>SwordMaster</i> type unit.
 * <p>
 * A <i>SwordMaster</i> is a unit that <b>can only use Sword type weapons</b>.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public class SwordMaster extends AbstractUnit {
  /**
   * Creates a new SwordMaster unit.
   *
   * @param hitPoints   the amount of damage this unit can receive.
   * @param movement    the amount of cells this unit can move.
   * @param location    current position of the unit.
   * @param items       the items carried by this unit.
   */

  public SwordMaster(final int hitPoints, final int movement, final Location location,
      IEquipableItem... items) {
    super(hitPoints, movement, location, 3, items);
  }

  /**
   * Sets the currently equipped item of this unit.
   * <p>
   * The <i>SwordMaster</i> can <b>only equip Swords</b>.
   *
   * @param sword the sword to equip.
   */
  @Override
  public void equipSword(final Sword sword) {
    if(this.items.contains(sword)) {
      if(equippedItem!=null){
        equippedItem.setUser(null);
      }
      equippedItem = sword;
      sword.setUser(this);
    }
  }

  @Override
  public boolean equals(Object obj){
    if(obj instanceof SwordMaster){
      if(((IUnit) obj).getMaxHitPoints() - this.getMaxHitPoints() <= 1E-6&&
              ((IUnit)obj).getMovement() == this.getMovement() &&
              ((IUnit)obj).getLocation().equals(this.getLocation())){
        return true;
      }
    }
    return false;
  }
}
