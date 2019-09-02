package model.items;

import model.units.IUnit;

/**
 * This interface represents the <i>weapons</i> that the units of the game can use.
 * <p>
 * The signature for all the common methods of the weapons are defined here. Every weapon have a
 * base damage and is strong or weak against other type of weapons.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public interface IEquipableItem {

  /**
   * Equips this item to a unit.
   *
   * @param unit
   *     the unit that will be quipped with the item
   */
  void equipTo(IUnit unit);

  /**
   * @return the unit that has currently equipped this item
   */
  IUnit getUser();
  void setUser(IUnit unit);

  IUnit getOnInventory();

  void setOnInventory(IUnit onInventory);

  /**
   * @return the name of the item
   */
  String getName();

  /**
   * @return the power of the item
   */
  double getPower();

  /**
   * @return the minimum range of the item
   */
  int getMinRange();

  /**
   * @return the maximum range of the item
   */
  int getMaxRange();

  void attackWith(IUnit unit);

  void weAttackedBySword(Sword sword);

  void weAttackedBySpear(Spear spear);

  void weAttackedByDarkMagicBook(DarkMagicBook darkMagicBook);

  void weAttackedByLightMagicBook(LightMagicBook lightMagicBook);

  void weAttackedBySpiritMagicBook(SpiritMagicBook spiritMagicBook);

  void weAttackedByBow(Bow bow);

  void weAttackedByAxe(Axe axe);

}
