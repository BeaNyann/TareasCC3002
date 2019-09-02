package model.items;

import model.units.IUnit;

public class SpiritMagicBook extends AbstractItem {
    /**
     * Constructor for a default item without any special behaviour.
     *
     * @param name     the name of the item
     * @param power    the power of the item (this could be the amount of damage or healing the item does)
     * @param minRange the minimum range of the item
     * @param maxRange the maximum range of the item
     */
    public SpiritMagicBook(String name, double power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
        this.minRange = Math.max(minRange, 0);
        this.maxRange = Math.max(maxRange, this.minRange);
    }

    @Override
    public void equipTo(IUnit unit) {
        unit.equipSpiritMagicBook(this);
    }

    @Override
    public void attackWith(IUnit unit) {
        unit.attackedBySpiritMagicBook(this);
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

    @Override
    public void weAttackedByDarkMagicBook(DarkMagicBook darkMagicBook) {
        this.getOwner().setBigDamage(darkMagicBook.getPower());
    }

    @Override
    public void weAttackedByLightMagicBook(LightMagicBook lightMagicBook) {
        this.getOwner().setSmallDamage(lightMagicBook.getPower());
    }
}
