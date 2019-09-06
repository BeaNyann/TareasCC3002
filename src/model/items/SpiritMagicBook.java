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

    /**
     * Equip this spirit magic book to the entered unit.
     *
     * @param unit the unit that will be quipped with the spirit magic book.
     */
    @Override
    public void equipTo(IUnit unit) {
        if(this.getUser()==null) {
            unit.equipSpiritMagicBook(this);
        }
    }

    /**
     * Send a message to the target unit with the spirit magic book that is going to be used in the attack.
     *
     * @param unit the unit that is going to be attacked.
     */
    @Override
    public void attackWith(IUnit unit) {
        unit.attackedBySpiritMagicBook(this);
    }

    /**
     * Send a message to this spirit magic book´s unit with the big damage it received.
     *
     * @param sword the sword with which this spirit magic book's unit is being attacked.
     */
    @Override
    public void weAttackedBySword(Sword sword) {
        this.getUser().setBigDamage(sword.getPower());
    }

    /**
     * Send a message to this spirit magic book´s unit with the big damage it received.
     *
     * @param spear the spear with which this spirit magic book's unit is being attacked.
     */
    @Override
    public void weAttackedBySpear(Spear spear) {
        this.getUser().setBigDamage(spear.getPower());
    }

    /**
     * Send a message to this spirit magic book´s unit with the big damage it received.
     *
     * @param bow the bow with which this spirit magic book's unit is being attacked.
     */
    @Override
    public void weAttackedByBow(Bow bow) {
        this.getUser().setBigDamage(bow.getPower());
    }

    /**
     * Send a message to this spirit magic book´s unit with the big damage it received.
     *
     * @param axe the axe with which this spirit magic book's unit is being attacked.
     */
    @Override
    public void weAttackedByAxe(Axe axe) {
        this.getUser().setBigDamage(axe.getPower());
    }

    /**
     * Send a message to this spirit magic book´s unit with the big damage it received.
     *
     * @param darkMagicBook the dark magic book with which this spirit magic book's unit is being attacked.
     */
    @Override
    public void weAttackedByDarkMagicBook(DarkMagicBook darkMagicBook) {
        this.getUser().setBigDamage(darkMagicBook.getPower());
    }

    /**
     * Send a message to this spirit magic book´s unit with the small damage it received.
     *
     * @param lightMagicBook the light magic book with which this spirit magic book's unit is being attacked.
     */
    @Override
    public void weAttackedByLightMagicBook(LightMagicBook lightMagicBook) {
        this.getUser().setSmallDamage(lightMagicBook.getPower());
    }
}
