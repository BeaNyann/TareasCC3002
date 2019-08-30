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
        this.setOwner(unit);

    }

    @Override
    public void attackWith(IUnit unit) {
        unit.attackedByMagicBook(this);
    }
}
