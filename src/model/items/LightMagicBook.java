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
    public LightMagicBook(String name, final double power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
        this.minRange = Math.max(minRange, 0);
        this.maxRange = Math.max(maxRange, this.minRange);
    }

    /**
     * Equip this light magic book to the entered unit.
     *
     * @param unit the unit that will be quipped with the light magic book.
     */
    @Override
    public void equipTo(IUnit unit) {
        if(this.getUser()==null) {
            unit.equipLightMagicBook(this);
        }
    }

    /**
     * Send a message to the target unit with the light magic book that is going to be used in the attack.
     *
     * @param unit the unit that is going to be attacked.
     */
    @Override
    public void attackWith(IUnit unit) {
        unit.attackedByLightMagicBook(this);
    }

    /**
     * Send a message to this light magic book´s unit with the big damage it received.
     *
     * @param sword the sword with which this light magic book's unit is being attacked.
     */
    @Override
    public void weAttackedBySword(Sword sword) {
        this.getUser().setBigDamage(sword.getPower());
    }

    /**
     * Send a message to this light magic book´s unit with the big damage it received.
     *
     * @param spear the spear with which this light magic book's unit is being attacked.
     */
    @Override
    public void weAttackedBySpear(Spear spear) {
        this.getUser().setBigDamage(spear.getPower());
    }

    /**
     * Send a message to this light magic book´s unit with the big damage it received.
     *
     * @param bow the bow with which this light magic book's unit is being attacked.
     */
    @Override
    public void weAttackedByBow(Bow bow) {
        this.getUser().setBigDamage(bow.getPower());
    }

    /**
     * Send a message to this light magic book´s unit with the big damage it received.
     *
     * @param axe the axe with which this light magic book's unit is being attacked.
     */
    @Override
    public void weAttackedByAxe(Axe axe) {
        this.getUser().setBigDamage(axe.getPower());
    }

    /**
     * Send a message to this light magic book´s unit with the small damage it received.
     *
     * @param darkMagicBook the dark magic book with which this light magic book's unit is being attacked.
     */
    @Override
    public void weAttackedByDarkMagicBook(DarkMagicBook darkMagicBook) {
        this.getUser().setSmallDamage(darkMagicBook.getPower());
    }

    /**
     * Send a message to this light magic book´s unit with the big damage it received.
     *
     * @param spiritMagicBook the spirit magic book with which this light magic book's unit is being attacked.
     */
    @Override
    public void weAttackedBySpiritMagicBook(SpiritMagicBook spiritMagicBook) {
        this.getUser().setBigDamage(spiritMagicBook.getPower());
    }
}
