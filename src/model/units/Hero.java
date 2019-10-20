package model.units;

import model.items.IEquipableItem;
import model.items.Spear;
import model.map.Location;

/**
 * This class represents a <i>Hero</i> type unit.
 * <p>
 * A <i>Hero</i> is a unit that <b>can only use Spear type weapons</b>.
 * This is a special kind of unit, the player that defeats this unit wins the game.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public class Hero extends AbstractUnit {

  /**
   * Creates a new Hero unit.
   *
   * @param hitPoints   the amount of damage this unit can receive.
   * @param movement    the amount of cells this unit can move.
   * @param location    current position of the unit.
   * @param items       the items carried by this unit.
   */
  public Hero(final int hitPoints, final int movement, final Location location,
      IEquipableItem... items) {
    super(hitPoints, movement, location, 3, items);
  }

  /**
   * Sets the currently equipped item of this unit.
   * <p>
   * The <i>Hero</i> can <b>only equip Spears</b>.
   *
   * @param spear the spear to equip.
   */
  @Override
  public void equipSpear(final Spear spear) {
    if(this.items.contains(spear)) {
      if(equippedItem!=null){
        equippedItem.setUser(null);
      }
      equippedItem = spear;
      spear.setUser(this);
    }
  }

  @Override
  public boolean equals(Object obj){
    if(obj instanceof Hero){
      if(((IUnit) obj).getMaxHitPoints() - this.getMaxHitPoints() <= 1E-6&&
              ((IUnit)obj).getMovement() == this.getMovement() &&
              ((IUnit)obj).getLocation().equals(this.getLocation())){
        return true;
      }
    }
    return false;
  }

  /**
   * @return if the unit is a Hero or not.
   */
  @Override
  public boolean isHero(){
    return true;
  }
}
