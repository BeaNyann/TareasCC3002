package model.units;

import java.util.List;

import model.items.*;
import model.map.Location;
import model.tactician.Tactician;

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
   * @return  <code>true</code> if the unit receive the object (if it has space enough), <code>false</code> otherwise.
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
   * Add a item to the unit´s inventory.
   *
   * @param item the item to add to the unit.
   */
  void addItem(IEquipableItem item);

  /**
   * Remove a item from the unit´s inventory.
   *
   * @param item the item to remove from a unit.
   */
  void removeItem(IEquipableItem item);

  /**
   * Send a message to this unit´s item with the axe that is attacking.
   * If this unit doesnt have any item, it received a normal damage.
   *
   * @param axe the axe which attacks the unit.
   */
  void attackedByAxe(Axe axe);

  /**
   * Send a message to this unit´s item with the bow that is attacking.
   * If this unit doesnt have any item, it received a normal damage.
   *
   * @param bow the bow which attacks the unit.
   */
  void attackedByBow(Bow bow);

  /**
   * Send a message to this unit´s item with the dark magic book that is attacking.
   * If this unit doesnt have any item, it received a normal damage.
   *
   * @param darkMagicBook the dark magic book which attacks the unit.
   */
  void attackedByDarkMagicBook(DarkMagicBook darkMagicBook);

  /**
   * Send a message to this unit´s item with the light magic book that is attacking.
   * If this unit doesnt have any item, it received a normal damage.
   *
   * @param lightMagicBook the light magic book which attacks the unit.
   */
  void attackedByLightMagicBook(LightMagicBook lightMagicBook);

  /**
   * Send a message to this unit´s item with the spirit magic book that is attacking.
   * If this unit doesnt have any item, it received a normal damage.
   *
   * @param spiritMagicBook the spirit magic book which attacks the unit.
   */
  void attackedBySpiritMagicBook(SpiritMagicBook spiritMagicBook);

  /**
   * Send a message to this unit´s item with the spear that is attacking.
   * If this unit doesnt have any item, it received a normal damage.
   *
   * @param spear the spear which attacks the unit.
   */
  void attackedBySpear(Spear spear);

  /**
   * Send a message to this unit´s item with the sword that is attacking.
   * If this unit doesnt have any item, it received a normal damage.
   *
   * @param sword the sword which attacks the unit.
   */
  void attackedBySword(Sword sword);

  /**
   * Discount the corresponding normal damage to the unit´s hit points.
   *
   * @param power the base power of the weapon that attacks the unit.
   */
  void setNormalDamage(double power);

  /**
   * Discount the corresponding big damage to the unit´s hit points.
   *
   * @param power the base power of the weapon that attacks the unit.
   */
  void setBigDamage(double power);

  /**
   * Discount the corresponding small damage to the unit´s hit points.
   *
   * @param power the base power of the weapon that attacks the unit.
   */
  void setSmallDamage(double power);

  /**
   * Send a message to this unit´s item with the target unit to the counter attack.
   *
   * @param unit the unit that is going to receive the counter attack.
   */
  void counterAttack(IUnit unit);

  /**
   * Heal this unit with the staff received.
   *
   * @param staff the staff which heals the unit.
   */
  void healedByStaff(Staff staff);

  /**
   * Send a message to this unit´s item to attack the target unit.
   *
   * @param unit the unit that is going to be attacked.
   */
  void attack(IUnit unit);

  /**
   * Heal the unit.
   */
  void heal();

  /**
   * Set the owner of the unit.
   *
   * @param tactician the unit's owner.
   */
  void setTactician(Tactician tactician);

  /**
   * @return the unit's owner.
   */
  Tactician getTactician();

  /**
   * @return if this unit is a hero or not.
   */
  boolean isHero();

}

