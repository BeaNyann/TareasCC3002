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
  public Sword(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }
  @Override
  public void equipTo(final IUnit unit) {
    if(this.getUser()==null) {
      unit.equipSword(this);
    }
  }

  @Override
  public void attackWith(IUnit unit) {
    unit.attackedBySword(this);
  }

  @Override
  public void weAttackedBySpear(Spear spear) {
    this.getUser().setBigDamage(spear.getPower());
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

  @Override
  public void weAttackedByAxe(Axe axe) {
    this.getUser().setSmallDamage(axe.getPower());
  }
}
