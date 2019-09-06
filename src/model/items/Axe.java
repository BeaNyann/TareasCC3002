package model.items;

import model.units.IUnit;

/**
 * This class represents an <i>Axe</i> type item.
 * <p>
 * Axes are strong against Spears and MagicBooks but weak against Swords.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public class Axe extends AbstractItem {

  /**
   * Creates a new Axe item.
   *
   * @param name      the name of the Axe.
   * @param power     the base damage of the Axe.
   * @param minRange  the minimum range of the Axe.
   * @param maxRange  the maximum range of the Axe.
   */
  public Axe(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }

  /**
   * Equip this axe to the entered unit.
   *
   * @param unit the unit that will be quipped with the axe.
   */
  @Override
  public void equipTo(final IUnit unit) {
    if(this.getUser()==null){
      unit.equipAxe(this);
    }
  }

  /**
   * Send a message to the target unit with the axe that is going to be used in the attack.
   *
   * @param unit the unit that is going to be attacked.
   */
  @Override
  public void attackWith(IUnit unit) {
    unit.attackedByAxe(this);
  }

  /**
   * Send a message to this axe´s unit with the big damage it received.
   *
   * @param sword the sword with which this axe's unit is being attacked.
   */
  @Override
  public void weAttackedBySword(Sword sword) {
      this.getUser().setBigDamage(sword.getPower());
  }

  /**
   * Send a message to this axe´s unit with the small damage it received.
   *
   * @param spear the spear with which this axe's unit is being attacked.
   */
  @Override
  public void weAttackedBySpear(Spear spear) {
      this.getUser().setSmallDamage(spear.getPower());
  }

  /**
   * Send a message to this axe´s unit with the big damage it received.
   *
   * @param darkMagicBook the dark magic book with which this item's unit is being attacked.
   */
  @Override
  public void weAttackedByDarkMagicBook(DarkMagicBook darkMagicBook) {
      this.getUser().setBigDamage(darkMagicBook.getPower());
  }

  /**
   * Send a message to this axe´s unit with the big damage it received.
   *
   * @param lightMagicBook the light magic book with which this axe's unit is being attacked.
   */
  @Override
  public void weAttackedByLightMagicBook(LightMagicBook lightMagicBook) {
    this.getUser().setBigDamage(lightMagicBook.getPower());
  }

  /**
   * Send a message to this axe´s unit with the big damage it received.
   *
   * @param spiritMagicBook the spirit magic book with which this axe's unit is being attacked.
   */
  @Override
  public void weAttackedBySpiritMagicBook(SpiritMagicBook spiritMagicBook) {
    this.getUser().setBigDamage(spiritMagicBook.getPower());
  }
}
