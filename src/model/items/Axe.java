package model.items;

import model.units.IUnit;

/**
 * This class represents an Axe.
 * <p>
 * Axes are strong against spears but weak against swords.
 *
 * @author IBeatriz Graboloza
 * @since 1.0
 */
public class Axe extends AbstractItem {

  /**
   * Creates a new Axe item
   *
   * @param name
   *     the name of the Axe
   * @param power
   *     the damage of the axe
   * @param minRange
   *     the minimum range of the axe
   * @param maxRange
   *     the maximum range of the axe
   */
  public Axe(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }

  @Override
  public void equipTo(final IUnit unit) {
    unit.equipAxe(this);
  }

  @Override
  public void attackWith(IUnit unit) {
    unit.attackedByAxe(this);
  }

  @Override
  public void weAttackedBySword(Sword sword) {
      this.getOwner().setBigDamage(sword.getPower());
  }

  @Override
  public void weAttackedBySpear(Spear spear) {
      this.getOwner().setSmallDamage(spear.getPower());
  }

  @Override
  public void weAttackedByMagicBook(MagicBook magicbook) {
      this.getOwner().setBigDamage(magicbook.getPower());
  }
}
