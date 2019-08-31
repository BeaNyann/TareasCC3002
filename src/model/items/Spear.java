package model.items;

import model.units.IUnit;

/**
 * This class represents a <i>spear</i>.
 * <p>
 * Spears are strong against swords and weak against axes
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public class Spear extends AbstractItem {

  /**
   * Creates a new Axe item
   *
   * @param name     the name of the Axe
   * @param power    the damage of the axe
   * @param minRange the minimum range of the axe
   * @param maxRange the maximum range of the axe
   */
  public Spear(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }

  @Override
  public void equipTo(final IUnit unit) {
    unit.equipSpear(this);
  }

  @Override
  public void attackWith(IUnit unit) {
    unit.attackedBySpear(this);
  }

  @Override
  public void weAttackedBySword(Sword sword) {
    this.getOwner().setSmallDamage(sword.getPower());
  }

  @Override
  public void weAttackedByMagicBook(MagicBook magicbook) {
    this.getOwner().setBigDamage(magicbook.getPower());
  }

  @Override
  public void weAttackedByAxe(Axe axe) {
    this.getOwner().setBigDamage(axe.getPower());
  }
}
