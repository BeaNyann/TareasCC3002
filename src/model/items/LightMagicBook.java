package model.items;

import model.units.IUnit;
/**
 * This class represents a <i>LightMagicBook</i> type item.
 * <p>
 * LightMagicBooks are strong against all the not-Magic weapons and against DarkMagicBooks
 * but weak against SpiritMagicBooks.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public class LightMagicBook extends AbstractItem{
    /**
     * Creates a new LightMagicBook item.
     *
     * @param name     the name of the LightMagicBook.
     * @param power    the base damage of the LightMagicBook.
     * @param minRange the minimum range of the LightMagicBook.
     * @param maxRange the maximum range of the LightMagicBook.
     */
    public LightMagicBook(String name, double power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
        this.minRange = Math.max(minRange, 0);
        this.maxRange = Math.max(maxRange, this.minRange);
    }

    @Override
    public void equipTo(IUnit unit) {
        if(this.getUser()==null) {
            unit.equipLightMagicBook(this);
        }
    }

    @Override
    public void attackWith(IUnit unit) {
        unit.attackedByLightMagicBook(this);
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
        this.getUser().setSmallDamage(darkMagicBook.getPower());
    }

    @Override
    public void weAttackedBySpiritMagicBook(SpiritMagicBook spiritMagicBook) {
        this.getUser().setBigDamage(spiritMagicBook.getPower());
    }
}
