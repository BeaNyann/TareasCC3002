package model.items;

import model.units.IUnit;

/**
 * @author Beatriz Graboloza
 * @since 1.0
 */
public class MagicBook extends AbstractItem {

    /**
     * Creates a new magicbook.
     * <p>
     * Magic Books are strong against other weapons and the other weapons are strong against Magic Books.
     *
     * @param name
     *     the name of the magic book
     * @param power
     *     the damage power of the magic book
     * @param minRange
     *     the minimum range of the magic book
     * @param maxRange
     *     the maximum range of the magic book
     */
    public MagicBook(final String name, final int power, final int minRange, final int maxRange) {
        super(name, power, minRange, maxRange);
        this.minRange = Math.max(minRange, 0);
        this.maxRange = Math.max(maxRange, this.minRange);
    }
    @Override
    public void equipTo(final IUnit unit) {
        unit.equipMagicBook(this);
    }

    @Override
    public void attackWith(IUnit unit) {
        unit.attackedByMagicBook(this);
    }

    @Override
    public void weAttackedBySword(Sword sword) {
        this.getOwner().setBigDamage(sword.getPower());
    }

    @Override
    public void weAttackedByStaff(Staff staff) {
        this.getOwner().setBigDamage(staff.getPower());
    }

    @Override
    public void weAttackedBySpear(Spear spear) {
        this.getOwner().setBigDamage(spear.getPower());
    }

    @Override
    public void weAttackedByBow(Bow bow) {
        this.getOwner().setBigDamage(bow.getPower());
    }

    @Override
    public void weAttackedByAxe(Axe axe) {
        this.getOwner().setBigDamage(axe.getPower());
    }
}
