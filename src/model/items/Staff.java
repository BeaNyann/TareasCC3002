package model.items;

import model.units.IUnit;

/**
 * This class represents a <i>Staff</i> type item.
 * <p>
 * A Staff is an item that can heal other units nut cannot counter any attack
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public class Staff extends AbstractItem {

  /**
   * Creates a new Staff item.
   *
   * @param name      the name of the Staff.
   * @param power     the healing power of the Staff.
   * @param minRange  the minimum range of the Staff.
   * @param maxRange  the maximum range of the Staff.
   */
  public Staff(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }

  /**
   * Equip this staff to the entered unit.
   *
   * @param unit the unit that will be quipped with the staff.
   */
  @Override
  public void equipTo(final IUnit unit) {
    if(this.getUser()==null) {
      unit.equipStaff(this);
    }
  }

  /**
   * The staffs cant attack other units.
   *
   * @param unit the unit that is going to be attacked.
   */
  @Override
  public void attackWith(IUnit unit) {}

  /**
   * Send a message to this staff´s unit with de type of damage it received.
   *
   * @param darkMagicBook the dark magic book with which this staff's unit is being attacked.
   */
  @Override
  public void weAttackedByDarkMagicBook(DarkMagicBook darkMagicBook) {
    this.getUser().setBigDamage(darkMagicBook.getPower());
  }

  /**
   * Send a message to this staff´s unit with de type of damage it received.
   *
   * @param lightMagicBook the light magic book with which this staff's unit is being attacked.
   */
  @Override
  public void weAttackedByLightMagicBook(LightMagicBook lightMagicBook) {
    this.getUser().setBigDamage(lightMagicBook.getPower());
  }

  /**
   * Send a message to this staff´s unit with de type of damage it received.
   *
   * @param spiritMagicBook the spirit magic book with which this staff's unit is being attacked.
   */
  @Override
  public void weAttackedBySpiritMagicBook(SpiritMagicBook spiritMagicBook) {
    this.getUser().setBigDamage(spiritMagicBook.getPower());
  }
}
