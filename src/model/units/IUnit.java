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
   * @return hit points of the unit
   */
  double getCurrentHitPoints();

    double getMaxHitPoints();

    /**
   * @return the items carried by this unit
   */
  List<IEquipableItem> getItems();

  /**
   * @return the currently equipped item
   */
  IEquipableItem getEquippedItem();

  void unequipItem();

  /**
   * @return the current location of the unit
   */
  Location getLocation();

  /**
   * Sets a new location for this unit,
   */
  void setLocation(final Location location);

  /**
   * @return the number of cells this unit can move
   */
  int getMovement();

  /**
   * Moves this unit to another location.
   * <p>
   * If the other location is out of this unit's movement range, the unit doesn't move.
   */
  void moveTo(Location targetLocation);

  void equipAxe(Axe axe);

  void equipBow(Bow bow);

  void equipMagicBook(MagicBook magicbook);

  void equipSpear(Spear spear);

  void equipStaff(Staff staff);

  void equipSword(Sword sword);

  boolean receiveObj(IEquipableItem item);

  void giveObj(IUnit unit, IEquipableItem item);

  void addItem(IEquipableItem item);

  void removeItem(IEquipableItem item);

  void attackedByAxe(Axe axe);

  void attackedByBow(Bow bow);

  void attackedByMagicBook(MagicBook magicBook);

  void attackedBySpear(Spear spear);

  void attackedByStaff(Staff staff);

  void attackedBySword(Sword sword);

  void setNormalDamage(double power);

  void setBigDamage(double power);

  void setSmallDamage(double power);


}

