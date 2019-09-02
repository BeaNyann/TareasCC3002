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

  @Override
  public void equipTo(final IUnit unit) {
    if(this.getUser()==null){
      unit.equipAxe(this);
    }
  }

  @Override
  public void attackWith(IUnit unit) {
    unit.attackedByAxe(this);
  }

  @Override
  public void weAttackedBySword(Sword sword) {
      this.getUser().setBigDamage(sword.getPower());
  }

  @Override
  public void weAttackedBySpear(Spear spear) {
      this.getUser().setSmallDamage(spear.getPower());
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
