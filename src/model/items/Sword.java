package model.items;

import model.units.IUnit;

/**
 * This class represents a <i>sword</i> type item.
 * <p>
 * Swords are strong against Axes and MagicBooks but weak against Spears.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public class Sword extends AbstractItem {

  /**
   * Creates a new Sword.
   *
   * @param name      the name that identifies the Sword.
   * @param power     the base damage of the Sword.
   * @param minRange  the minimum range of the Sword.
   * @param maxRange  the maximum range of the Sword.
   */
  public Sword(final String name, final double power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }

  /**
   * Equip this sword to the entered unit.
   *
   * @param unit the unit that will be quipped with the item.
   */
  @Override
  public void equipTo(final IUnit unit) {
    if(this.getUser()==null) {
      unit.equipSword(this);
    }
  }

  /**
   * Send a message to the target unit with the sword that is going to be used in the attack.
   *
   * @param unit the unit that is going to be attacked.
   */
  @Override
  public void attackWith(IUnit unit) {
    unit.attackedBySword(this);
  }

  /**
   * Send a message to this sword´s unit with the big damage it received.
   *
   * @param spear the spear with which this sword's unit is being attacked.
   */
  @Override
  public void weAttackedBySpear(Spear spear) {
    this.getUser().setBigDamage(spear.getPower());
  }

  /**
   * Send a message to this sword´s unit with the big damage it received.
   *
   * @param darkMagicBook the dark magic book with which this sword's unit is being attacked.
   */
  @Override
  public void weAttackedByDarkMagicBook(DarkMagicBook darkMagicBook) {
    this.getUser().setBigDamage(darkMagicBook.getPower());
  }

  /**
   * Send a message to this sword´s unit with the big damage it received.
   *
   * @param lightMagicBook the light magic book with which this sword's unit is being attacked.
   */
  @Override
  public void weAttackedByLightMagicBook(LightMagicBook lightMagicBook) {
    this.getUser().setBigDamage(lightMagicBook.getPower());
  }

  /**
   * Send a message to this sword´s unit with the big damage it received.
   *
   * @param spiritMagicBook the spirit magic book with which this sword's unit is being attacked.
   */
  @Override
  public void weAttackedBySpiritMagicBook(SpiritMagicBook spiritMagicBook) {
    this.getUser().setBigDamage(spiritMagicBook.getPower());
  }

  /**
   * Send a message to this sword´s unit with the small damage it received.
   *
   * @param axe the axe with which this item's sword is being attacked.
   */
  @Override
  public void weAttackedByAxe(Axe axe) {
    this.getUser().setSmallDamage(axe.getPower());
  }
}
