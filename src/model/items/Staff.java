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
  @Override
  public void equipTo(final IUnit unit) {
    if(this.getUser()==null) {
      unit.equipStaff(this);
    }
  }

  @Override
  public void attackWith(IUnit unit) {}

  @Override
  public void weAttackedByDarkMagicBook(DarkMagicBook darkMagicBook) {
    this.getUser().setBigDamage(darkMagicBook.getPower());
  }
  @Override
  public void weAttackedByLightMagicBook(LightMagicBook lightMagicBook) {
    this.getUser().setBigDamage(lightMagicBook.getPower());
  }
  @Override
  public void weAttackedBySpiritMagicBook(SpiritMagicBook spiritMagicBook) {
    this.getUser().setBigDamage(spiritMagicBook.getPower());
  }
}
