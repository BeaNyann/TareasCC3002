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

    /**
     * Equip this dark magic book to the entered unit.
     *
     * @param unit the unit that will be quipped with the dark magic book.
     */
    @Override
    public void equipTo(IUnit unit) {
        if(this.getUser()==null) {
            unit.equipDarkMagicBook(this);
        }
    }

    /**
     * Send a message to the target unit with the dark magic book that is going to be used in the attack.
     *
     * @param unit the unit that is going to be attacked.
     */
    @Override
    public void attackWith(IUnit unit) {
        unit.attackedByDarkMagicBook(this);
    }

    /**
     * Send a message to this dark magic book´s unit with de type of damage it received.
     *
     * @param sword the sword with which this dark magic book's unit is being attacked.
     */
    @Override
    public void weAttackedBySword(Sword sword) {
        this.getUser().setBigDamage(sword.getPower());
    }

    /**
     * Send a message to this dark magic book´s unit with de type of damage it received.
     *
     * @param spear the spear with which this dark magic book's unit is being attacked.
     */
    @Override
    public void weAttackedBySpear(Spear spear) {
        this.getUser().setBigDamage(spear.getPower());
    }

    /**
     * Send a message to this dark magic book´s unit with de type of damage it received.
     *
     * @param bow the bow with which this dark magic book's unit is being attacked.
     */
    @Override
    public void weAttackedByBow(Bow bow) {
        this.getUser().setBigDamage(bow.getPower());
    }

    /**
     * Send a message to this dark magic book´s unit with de type of damage it received.
     *
     * @param axe the axe with which this dark magic book's unit is being attacked.
     */
    @Override
    public void weAttackedByAxe(Axe axe) {
        this.getUser().setBigDamage(axe.getPower());
    }

    /**
     * Send a message to this dark magic book´s unit with de type of damage it received.
     *
     * @param lightMagicBook the light magic book with which this dark magic book's unit is being attacked.
     */
    @Override
    public void weAttackedByLightMagicBook(LightMagicBook lightMagicBook) {
        this.getUser().setBigDamage(lightMagicBook.getPower());
    }

    /**
     * Send a message to this dark magic book´s unit with de type of damage it received.
     *
     * @param spiritMagicBook the spirit magic book with which this dark magic book's unit is being attacked.
     */
    @Override
    public void weAttackedBySpiritMagicBook(SpiritMagicBook spiritMagicBook) {
        this.getUser().setSmallDamage(spiritMagicBook.getPower());
    }
}
