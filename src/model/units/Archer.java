package model.units;

import model.items.Bow;
import model.items.IEquipableItem;
import model.map.Location;

/**
 * This class represents an <i>Archer</i> type unit.
 * <p>
 * An <i>Archer</i> is a unit that <b>can only use Bow type weapons</b>.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public class Archer extends AbstractUnit {

  /**
   * Creates a new Archer unit.
   *
   * @param hitPoints   the amount of damage this unit can receive.
   * @param movement    the amount of cells this unit can move.
   * @param location    current position of the unit.
   * @param items       the items carried by this unit.
   */
  public Archer(final int hitPoints, final int movement, final Location location,
      final IEquipableItem... items) {
    super(hitPoints, movement, location, 3, items);
  }

  /**
   * Sets the currently equipped item of this unit.
   * <p>
   * The <i>Archer</i> can <b>only equip Bows</b>.
   *
   * @param bow the item to equip.
   */
  @Override
  public void equipBow(final Bow bow) {
    if(this.items.contains(bow)){
      if(equippedItem!=null){
        equippedItem.setUser(null);
      }
      equippedItem = bow;
      bow.setUser(this);
    }
  }

  @Override
  public boolean equals(Object obj){
    return super.equals(obj) && obj instanceof Archer;
  }
}
