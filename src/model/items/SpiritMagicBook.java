package model.items;

import model.units.IUnit;
/**
 * This class represents a <i>SpiritMagicBook</i> type item.
 * <p>
 * SpiritMagicBooks are strong against all the not-Magic weapons and against LightMagicBooks
 * but weak against DarkMagicBooks.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public class SpiritMagicBook extends AbstractItem {
    /**
     * Creates a new SpiritMagicBook item.
     *
     * @param name     the name of the SpiritMagicBook.
     * @param power    the base damage of the SpiritMagicBook.
     * @param minRange the minimum range of the SpiritMagicBook.
     * @param maxRange the maximum range of the SpiritMagicBook.
     */
    public SpiritMagicBook(String name, double power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
        this.minRange = Math.max(minRange, 0);
        this.maxRange = Math.max(maxRange, this.minRange);
    }

    @Override
    public void equipTo(IUnit unit) {
        if(this.getUser()==null) {
            unit.equipSpiritMagicBook(this);
        }
    }

    @Override
    public void attackWith(IUnit unit) {
        unit.attackedBySpiritMagicBook(this);
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
    public void weAttackedByDarkMagicBook(DarkMagicBook darkMagicBook) {
        this.getUser().setBigDamage(darkMagicBook.getPower());
    }

    @Override
    public void weAttackedByLightMagicBook(LightMagicBook lightMagicBook) {
        this.getUser().setSmallDamage(lightMagicBook.getPower());
    }
}
