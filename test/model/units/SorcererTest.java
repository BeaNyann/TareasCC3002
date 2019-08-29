package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

/**
 * @author Beatriz Graboloza
 */
public class SorcererTest extends AbstractTestUnit {

    private Sorcerer sorcerer;

    /**
     * Set up the main unit that's going to be tested in the test set
     */
    @Override
    public void setTestUnit() {
        sorcerer = new Sorcerer(50, 2, field.getCell(0, 0));
    }

    /**
     * @return the current unit being tested
     */
    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }

    /**
     * Checks if the axe is equipped correctly to the unit
     */

    @Override
    public void equipUnequipMagicBookTest() {
        assertNull(sorcerer.getEquippedItem());
        sorcerer.addItem(magicbook);
        sorcerer.equipMagicBook(magicbook);
        assertEquals(magicbook, sorcerer.getEquippedItem());
        sorcerer.unequipItem();
        assertNull(sorcerer.getEquippedItem());
    }

    @Override
    public void FailEquipUnequipMagicBookTest(){
        assertNull(sorcerer.getEquippedItem());
        sorcerer.unequipItem();
        assertNull(sorcerer.getEquippedItem());
        sorcerer.equipMagicBook(magicbook);
        assertNull(sorcerer.getEquippedItem());
    }

    @Override
    public void FailEquipUnequipBowTest(){
        assertNull(sorcerer.getEquippedItem());
        sorcerer.unequipItem();
        assertNull(sorcerer.getEquippedItem());
        sorcerer.equipBow(bow);
        assertNull(sorcerer.getEquippedItem());
        sorcerer.addItem(bow);
        sorcerer.equipBow(bow);
        assertNull(sorcerer.getEquippedItem());
    }

    @Override
    public void FailEquipUnequipStaffTest(){
        assertNull(sorcerer.getEquippedItem());
        sorcerer.unequipItem();
        assertNull(sorcerer.getEquippedItem());
        sorcerer.equipStaff(staff);
        assertNull(sorcerer.getEquippedItem());
        sorcerer.addItem(staff);
        sorcerer.equipStaff(staff);
        assertNull(sorcerer.getEquippedItem());
    }

    @Override
    public void FailEquipUnequipAxeTest(){
        assertNull(sorcerer.getEquippedItem());
        sorcerer.unequipItem();
        assertNull(sorcerer.getEquippedItem());
        sorcerer.equipAxe(axe);
        assertNull(sorcerer.getEquippedItem());
        sorcerer.addItem(axe);
        sorcerer.equipAxe(axe);
        assertNull(sorcerer.getEquippedItem());
    }

    @Override
    public void FailEquipUnequipSpearTest(){
        assertNull(sorcerer.getEquippedItem());
        sorcerer.unequipItem();
        assertNull(sorcerer.getEquippedItem());
        sorcerer.equipSpear(spear);
        assertNull(sorcerer.getEquippedItem());
        sorcerer.addItem(spear);
        sorcerer.equipSpear(spear);
        assertNull(sorcerer.getEquippedItem());
    }

    @Override
    public void FailEquipUnequipSwordTest(){
        assertNull(sorcerer.getEquippedItem());
        sorcerer.unequipItem();
        assertNull(sorcerer.getEquippedItem());
        sorcerer.equipSword(sword);
        assertNull(sorcerer.getEquippedItem());
        sorcerer.addItem(sword);
        sorcerer.equipSword(sword);
        assertNull(sorcerer.getEquippedItem());
    }
}