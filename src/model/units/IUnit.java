package model.units;

import java.util.List;

import model.items.*;
import model.map.Location;

/**
 * This interface represents all units in the game.
 * <p>
 * The signature of all the common methods that a unit can execute are defined here. All units
 * except some special ones can carry at most 3 weapons.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public interface IUnit {

  /**
   * @return current hit points of the unit.
   */
  double getCurrentHitPoints();

  /**
   * @return the maximum hit points of the unit.
   */
  double getMaxHitPoints();

  /**
   * @return the items carried by this unit.
   */
  List<IEquipableItem> getItems();

  /**
   * @return the currently equipped item.
   */
  IEquipableItem getEquippedItem();

  /**
   * Unequip the item to the unit.
   */
  void unequipItem();

  /**
   * @return the current location of the unit.
   */
  Location getLocation();


  /**
   * Sets a new location for this unit.
   *
   * @param location the location where the unit will be set.
   */
  void setLocation(final Location location);

  /**
   * @return the number of cells this unit can move.
   */
  int getMovement();


  /**
   * Moves this unit to another location.
   * <p>
   * If the other location is out of this unit's movement range, the unit doesn't move.
   *
   * @param targetLocation the location where to move the unit.
   */
  void moveTo(Location targetLocation);

  /**
   * Equip an axe to this unit.
   *
   * @param axe the axe to equip.
   */
  void equipAxe(Axe axe);

  /**
   * Equip a bow to this unit.
   *
   * @param bow the bow to equip.
   */
  void equipBow(Bow bow);

  /**
   * Equip a dark magic book to this unit.
   *
   * @param darkMagicBook the dark magic book to equip.
   */
  void equipDarkMagicBook(DarkMagicBook darkMagicBook);

  /**
   * Equip a light magic book to this unit.
   *
   * @param lightMagicBook the light magic book to equip.
   */
  void equipLightMagicBook(LightMagicBook lightMagicBook);

  /**
   * Equip a spirit magic book to this unit.
   *
   * @param spiritMagicBook the spirit magic book to equip.
   */
  void equipSpiritMagicBook(SpiritMagicBook spiritMagicBook);

  /**
   * Equip a spear to this unit.
   *
   * @param spear the spear to equip.
   */
  void equipSpear(Spear spear);

  /**
   * Equip a staff to this unit.
   *
   * @param staff the staff to equip.
   */
  void equipStaff(Staff staff);

  /**
   * Equip a sword to this unit.
   *
   * @param sword the sword to equip.
   */
  void equipSword(Sword sword);

  /**
   * The unit receive an item, it is only received if the unit has space enough.
   *
   * @param   item the item to receive.
   * @return  <code>true</code> the unit receive the object (if it has space enough), <code>false</code> otherwise.
   */
  boolean receiveObj(IEquipableItem item);

  /**
   * Give an item to a unit, if the unit dont have space nothing happen.
   *
   * @param unit  the unit to give the item.
   * @param item  the item to give to the unit.
   */
  void giveObj(IUnit unit, IEquipableItem item);

  /**
   * @param item
   */
  void addItem(IEquipableItem item);

  /**
   * @param item
   */
  void removeItem(IEquipableItem item);

  /**
   * @param axe
   */
  void attackedByAxe(Axe axe);

  /**
   * @param bow
   */
  void attackedByBow(Bow bow);

  /**
   * @param darkMagicBook
   */
  void attackedByDarkMagicBook(DarkMagicBook darkMagicBook);

  /**
   * @param lightMagicBook
   */
  void attackedByLightMagicBook(LightMagicBook lightMagicBook);

  /**
   * @param spiritMagicBook
   */
  void attackedBySpiritMagicBook(SpiritMagicBook spiritMagicBook);

  /**
   * @param spear
   */
  void attackedBySpear(Spear spear);

  /**
   * @param sword
   */
  void attackedBySword(Sword sword);

  /**
   * @param power
   */
  void setNormalDamage(double power);

  /**
   * @param power
   */
  void setBigDamage(double power);

  /**
   * @param power
   */
  void setSmallDamage(double power);

  /**
   * @param unit
   */
  void counterAttack(IUnit unit);
}

