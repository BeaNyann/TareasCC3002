package model.units;

import model.items.IEquipableItem;
import model.items.MagicBook;
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
   * @param magicbook
   *     the item to equip
   */
  @Override
  public void equipMagicBook(final MagicBook magicbook) {
    if(this.items.contains(magicbook)) {
      if(equippedItem!=null){
        equippedItem.setOwner(null);
      }
      equippedItem = magicbook;
      magicbook.setOwner(this);
    }
  }
}
