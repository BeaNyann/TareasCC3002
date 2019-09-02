package model.items;

import model.units.IUnit;

/**
 * This class represents a <i>Bow</i> type item.
 * <p>
 * Bows are strong against MagicBooks.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public class Bow extends AbstractItem {

  /**
   * Creates a new Bow item.
   * <p>
   * Bows are weapons that can't attack adjacent units, so it's minimum range must me greater than
   * one.
   *
   * @param name      the name of the Bow.
   * @param power     the base damage power of the Bow.
   * @param minRange  the minimum range of the Bow.
   * @param maxRange  the maximum range of the Bow.
   */
  public Bow(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
    this.minRange = Math.max(minRange, 2);
    this.maxRange = Math.max(maxRange, this.minRange);
  }
  @Override
  public void equipTo(final IUnit unit) {
    if(this.getUser()==null) {
      unit.equipBow(this);
    }
  }

  @Override
  public void attackWith(IUnit unit) {
    unit.attackedByBow(this);
  }

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
