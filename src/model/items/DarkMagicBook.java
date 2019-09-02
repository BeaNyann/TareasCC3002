package model.items;

import model.units.IUnit;
/**
 * This class represents a <i>DarkMagicBook</i> type item.
 * <p>
 * DarkMagicBooks are strong against all the not-Magic weapons and against SpiritMagicBooks
 * but weak against LightMagicBooks.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public class DarkMagicBook extends AbstractItem {
    /**
     * Creates a new DarkMagicBook item.
     *
     * @param name     the name of the DarkMagicBook.
     * @param power    the base damage of the DarkMagicBook.
     * @param minRange the minimum range of the DarkMagicBook.
     * @param maxRange the maximum range of the DarkMagicBook.
     */
    public DarkMagicBook(String name, double power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
        this.minRange = Math.max(minRange, 0);
        this.maxRange = Math.max(maxRange, this.minRange);

    }

    @Override
    public void equipTo(IUnit unit) {
        if(this.getUser()==null) {
            unit.equipDarkMagicBook(this);
        }
    }

    @Override
    public void attackWith(IUnit unit) {
        unit.attackedByDarkMagicBook(this);
    }

    @Override
    public void weAttackedBySword(Sword sword) {
        this.getUser().setBigDamage(sword.getPower());
    }

    @Override
    public void weAttackedBySpear(Spear spear) {
        this.getUser().setBigDamage(spear.getPower());
    }

    @Override
    public void weAttackedByBow(Bow bow) {
        this.getUser().setBigDamage(bow.getPower());
    }

    @Override
    public void weAttackedByAxe(Axe axe) {
        this.getUser().setBigDamage(axe.getPower());
    }

    @Override
    public void weAttackedByLightMagicBook(LightMagicBook lightMagicBook) {
        this.getUser().setBigDamage(lightMagicBook.getPower());
    }

    @Override
    public void weAttackedBySpiritMagicBook(SpiritMagicBook spiritMagicBook) {
        this.getUser().setSmallDamage(spiritMagicBook.getPower());
    }
}
