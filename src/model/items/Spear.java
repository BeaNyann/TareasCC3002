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

  @Override
  public void equipTo(final IUnit unit) {
    if(this.getUser()==null) {
      unit.equipSpear(this);
    }
  }

  @Override
  public void attackWith(IUnit unit) {
    unit.attackedBySpear(this);
  }

  @Override
  public void weAttackedBySword(Sword sword) {
    this.getUser().setSmallDamage(sword.getPower());
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
    this.getUser().setBigDamage(axe.getPower());
  }
}
