package model.units;

import model.items.*;
import model.map.Location;

/**
 * This class represents a <i>Sorcerer</i> type unit.
 * <p>
 * A <i>Sorcerer</i> is a unit that <b>can only use MagicBook type weapons</b>.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public class Sorcerer extends AbstractUnit {
  /**
   * Creates a new Sorcerer unit.
   *
   * @param hitPoints   the amount of damage this unit can receive.
   * @param movement    the amount of cells this unit can move.
   * @param location    current position of the unit.
   * @param items       the items carried by this unit.
   */
  public Sorcerer(final int hitPoints, final int movement, final Location location,
                  IEquipableItem... items) {
    super(hitPoints, movement, location, 3, items);
  }

  /**
   * Sets the currently equipped item of this unit.
   * <p>
   * The <i>Sorcerer</i> can <b>only equip Magic Books</b>.
   *
   * @param darkMagicBook the dark magic book to equip.
   */
  @Override
  public void equipDarkMagicBook(final DarkMagicBook darkMagicBook) {
    if(this.items.contains(darkMagicBook)) {
      if(equippedItem!=null){
        equippedItem.setUser(null);
      }
      equippedItem = darkMagicBook;
      darkMagicBook.setUser(this);
    }
  }

  /**
   * Sets the currently equipped item of this unit.
   * <p>
   * The <i>Sorcerer</i> can <b>only equip Magic Books</b>.
   *
   * @param lightMagicBook the light magic book to equip.
   */
  @Override
  public void equipLightMagicBook(final LightMagicBook lightMagicBook) {
    if(this.items.contains(lightMagicBook)) {
      if(equippedItem!=null){
        equippedItem.setUser(null);
      }
      equippedItem = lightMagicBook;
      lightMagicBook.setUser(this);
    }
  }

  /**
   * Sets the currently equipped item of this unit.
   * <p>
   * The <i>Sorcerer</i> can <b>only equip Magic Books</b>.
   *
   * @param spiritMagicBook the spirit magic book to equip.
   */
  @Override
  public void equipSpiritMagicBook(final SpiritMagicBook spiritMagicBook) {
    if(this.items.contains(spiritMagicBook)) {
      if(equippedItem!=null){
        equippedItem.setUser(null);
      }
      equippedItem = spiritMagicBook;
      spiritMagicBook.setUser(this);
    }
  }

  @Override
  public boolean equals(Object obj){
    if(obj instanceof Sorcerer){
      if(((IUnit) obj).getMaxHitPoints() - this.getMaxHitPoints() <= 1E-6&&
              ((IUnit)obj).getMovement() == this.getMovement() &&
              ((IUnit)obj).getLocation().equals(this.getLocation())){
        return true;
      }
    }
    return false;
  }
}
