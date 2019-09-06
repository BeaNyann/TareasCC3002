package model.items;

import model.units.IUnit;

/**
 * This class represents a <i>Spear</i> type item.
 * <p>
 * Spears are strong against Swords and MagicBooks but weak against Axes.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public class Spear extends AbstractItem {

  /**
   * Creates a new Spear item.
   *
   * @param name     the name of the Spear.
   * @param power    the base damage of the Spear.
   * @param minRange the minimum range of the Spear.
   * @param maxRange the maximum range of the Spear.
   */
  public Spear(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }

  /**
   * Equip this spear to the entered unit.
   *
   * @param unit the unit that will be quipped with the spear.
   */
  @Override
  public void equipTo(final IUnit unit) {
    if(this.getUser()==null) {
      unit.equipSpear(this);
    }
  }

  /**
   * Send a message to the target unit with the spear that is going to be used in the attack.
   *
   * @param unit the unit that is going to be attacked.
   */
  @Override
  public void attackWith(IUnit unit) {
    unit.attackedBySpear(this);
  }

  /**
   * Send a message to this spear´s unit with the small damage it received.
   *
   * @param sword the sword with which this spear's unit is being attacked.
   */
  @Override
  public void weAttackedBySword(Sword sword) {
    this.getUser().setSmallDamage(sword.getPower());
  }

  /**
   * Send a message to this spear´s unit with the big damage it received.
   *
   * @param darkMagicBook the dark magic book with which this spear's unit is being attacked.
   */
  @Override
  public void weAttackedByDarkMagicBook(DarkMagicBook darkMagicBook) {
    this.getUser().setBigDamage(darkMagicBook.getPower());
  }

  /**
   * Send a message to this spear´s unit with the big damage it received.
   *
   * @param lightMagicBook the light magic book with which this spear's unit is being attacked.
   */
  @Override
  public void weAttackedByLightMagicBook(LightMagicBook lightMagicBook) {
    this.getUser().setBigDamage(lightMagicBook.getPower());
  }

  /**
   * Send a message to this spear´s unit with the big damage it received.
   *
   * @param spiritMagicBook the spirit magic book with which this spear's unit is being attacked.
   */
  @Override
  public void weAttackedBySpiritMagicBook(SpiritMagicBook spiritMagicBook) {
    this.getUser().setBigDamage(spiritMagicBook.getPower());
  }

  /**
   * Send a message to this spear´s unit with the big damage it received.
   *
   * @param axe the axe with which this spear's unit is being attacked.
   */
  @Override
  public void weAttackedByAxe(Axe axe) {
    this.getUser().setBigDamage(axe.getPower());
  }
}
