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
   * Equips this item to the entered unit.
   *
   * @param unit the unit that will be quipped with the item.
   */
  void equipTo(IUnit unit);

  /**
   * @return the unit that has currently equipped this item.
   */
  IUnit getUser();

  /**
   * Sets the unit that will equip this item.
   *
   * @param user the unit that will equip this item.
   */
  void setUser(IUnit user);

  /**
   * @return the unit that has this item on its inventory.
   */
  IUnit getOnInventory();

  /**
   * Sets the the unit that has this item on its inventory.
   *
   * @param onInventory the unit that has this item on its inventory.
   */
  void setOnInventory(IUnit onInventory);

  /**
   * @return the name of the item.
   */
  String getName();

  /**
   * @return the power of the item.
   */
  double getPower();

  /**
   * @return the minimum range of the item.
   */
  int getMinRange();

  /**
   * @return the maximum range of the item.
   */
  int getMaxRange();

  /**
   * Send a message to the target unit with the item that is going to be used in the attack.
   *
   * @param unit the unit that is going to be attacked.
   */
  void attackWith(IUnit unit);

  /**
   * Send a message to this item´s unit with de type of damage it received.
   *
   * @param sword the sword with which this item's unit is being attacked.
   */
  void weAttackedBySword(Sword sword);

  /**
   * Send a message to this item´s unit with de type of damage it received.
   *
   * @param spear the spear with which this item's unit is being attacked.
   */
  void weAttackedBySpear(Spear spear);

  /**
   * Send a message to this item´s unit with de type of damage it received.
   *
   * @param darkMagicBook the dark magic book with which this item's unit is being attacked.
   */
  void weAttackedByDarkMagicBook(DarkMagicBook darkMagicBook);

  /**
   * Send a message to this item´s unit with de type of damage it received.
   *
   * @param lightMagicBook the light magic book with which this item's unit is being attacked.
   */
  void weAttackedByLightMagicBook(LightMagicBook lightMagicBook);

  /**
   * Send a message to this item´s unit with de type of damage it received.
   *
   * @param spiritMagicBook the spirit magic book with which this item's unit is being attacked.
   */
  void weAttackedBySpiritMagicBook(SpiritMagicBook spiritMagicBook);

  /**
   * Send a message to this item´s unit with de type of damage it received.
   *
   * @param bow the bow with which this item's unit is being attacked.
   */
  void weAttackedByBow(Bow bow);

  /**
   * Send a message to this item´s unit with de type of damage it received.
   *
   * @param axe the axe with which this item's unit is being attacked.
   */
  void weAttackedByAxe(Axe axe);

}
