package model.items;

import model.units.IUnit;

public class LightMagicBook extends AbstractItem{
    /**
     * Constructor for a default item without any special behaviour.
     *
     * @param name     the name of the item
     * @param power    the power of the item (this could be the amount of damage or healing the item does)
     * @param minRange the minimum range of the item
     * @param maxRange the maximum range of the item
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
    public void weAttackedByStaff(Staff staff) {
        this.getUser().setBigDamage(staff.getPower());
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
