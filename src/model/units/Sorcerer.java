package model.units;

import model.items.*;
import model.map.Location;

/**
 * This class represents a sorcerer type unit.
 * A Sorcerer is a unit that can only use magic book type weapons.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public class Sorcerer extends AbstractUnit {

  public Sorcerer(final int hitPoints, final int movement, final Location location,
                  IEquipableItem... items) {
    super(hitPoints, movement, location, 3, items);
  }

  /**
   * Sets the currently equipped item of this unit.
   *
   * @param darkMagicBook
   *     the item to equip
   */
  @Override
  public void equipDarkMagicBook(final DarkMagicBook darkMagicBook) {
    if(this.items.contains(darkMagicBook)) {
      if(equippedItem!=null){
        equippedItem.setOwner(null);
      }
      equippedItem = darkMagicBook;
      darkMagicBook.setOwner(this);
    }
  }

  /**
   * Sets the currently equipped item of this unit.
   *
   * @param lightMagicBook
   *     the item to equip
   */
  @Override
  public void equipLightMagicBook(final LightMagicBook lightMagicBook) {
    if(this.items.contains(lightMagicBook)) {
      if(equippedItem!=null){
        equippedItem.setOwner(null);
      }
      equippedItem = lightMagicBook;
      lightMagicBook.setOwner(this);
    }
  }

  /**
   * Sets the currently equipped item of this unit.
   *
   * @param spiritMagicBook
   *     the item to equip
   */
  @Override
  public void equipSpiritMagicBook(final SpiritMagicBook spiritMagicBook) {
    if(this.items.contains(spiritMagicBook)) {
      if(equippedItem!=null){
        equippedItem.setOwner(null);
      }
      equippedItem = spiritMagicBook;
      spiritMagicBook.setOwner(this);
    }
  }
}
