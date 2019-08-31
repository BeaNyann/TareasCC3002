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
    @Test
    @Override
    public void equipUnequipMagicBookTest() {
        assertNull(sorcerer.getEquippedItem());
        sorcerer.addItem(magicbook);
        magicbook.equipTo(sorcerer);
        assertEquals(magicbook, sorcerer.getEquippedItem());
        sorcerer.unequipItem();
        assertNull(sorcerer.getEquippedItem());
    }
    @Test
    @Override
    public void FailEquipUnequipMagicBookTest(){
        assertNull(sorcerer.getEquippedItem());
        sorcerer.unequipItem();
        assertNull(sorcerer.getEquippedItem());
        magicbook.equipTo(sorcerer);
        assertNull(sorcerer.getEquippedItem());
    }
    @Test
    @Override
    public void FailEquipUnequipBowTest(){
        assertNull(sorcerer.getEquippedItem());
        sorcerer.unequipItem();
        assertNull(sorcerer.getEquippedItem());
        bow.equipTo(sorcerer);
        assertNull(sorcerer.getEquippedItem());
        sorcerer.addItem(bow);
        bow.equipTo(sorcerer);
        assertNull(sorcerer.getEquippedItem());
    }
    @Test
    @Override
    public void FailEquipUnequipStaffTest(){
        assertNull(sorcerer.getEquippedItem());
        sorcerer.unequipItem();
        assertNull(sorcerer.getEquippedItem());
        staff.equipTo(sorcerer);
        assertNull(sorcerer.getEquippedItem());
        sorcerer.addItem(staff);
        staff.equipTo(sorcerer);
        assertNull(sorcerer.getEquippedItem());
    }
    @Test
    @Override
    public void FailEquipUnequipAxeTest(){
        assertNull(sorcerer.getEquippedItem());
        sorcerer.unequipItem();
        assertNull(sorcerer.getEquippedItem());
        axe.equipTo(sorcerer);
        assertNull(sorcerer.getEquippedItem());
        sorcerer.addItem(axe);
        axe.equipTo(sorcerer);
        assertNull(sorcerer.getEquippedItem());
    }
    @Test
    @Override
    public void FailEquipUnequipSpearTest(){
        assertNull(sorcerer.getEquippedItem());
        sorcerer.unequipItem();
        assertNull(sorcerer.getEquippedItem());
        spear.equipTo(sorcerer);
        assertNull(sorcerer.getEquippedItem());
        sorcerer.addItem(spear);
        spear.equipTo(sorcerer);
        assertNull(sorcerer.getEquippedItem());
    }
    @Test
    @Override
    public void FailEquipUnequipSwordTest(){
        assertNull(sorcerer.getEquippedItem());
        sorcerer.unequipItem();
        assertNull(sorcerer.getEquippedItem());
        sword.equipTo(sorcerer);
        assertNull(sorcerer.getEquippedItem());
        sorcerer.addItem(sword);
        sword.equipTo(sorcerer);
        assertNull(sorcerer.getEquippedItem());
    }

    @Test
    @Override
    public void testAttackAlpaca() {
        Alpaca alpaca = getTargetAlpaca();
        sorcerer.attack(alpaca);
        assertEquals(50, alpaca.getCurrentHitPoints());
        sorcerer.addItem(magicbook);
        magicbook.equipTo(sorcerer);
        sorcerer.attack(alpaca);
        assertEquals(40, alpaca.getCurrentHitPoints());
    }

    @Test
    @Override
    public void testAttackArcher() {
        Archer archer = new Archer(50, 2, field.getCell(1,0));
        sorcerer.attack(archer);
        assertEquals(50, archer.getCurrentHitPoints());
        sorcerer.addItem(magicbook);
        magicbook.equipTo(sorcerer);
        sorcerer.attack(archer);
        assertEquals(40, archer.getCurrentHitPoints());
        archer.addItem(bow);
        bow.equipTo(archer);
        sorcerer.attack(archer);
        assertEquals(25,archer.getCurrentHitPoints());
        //TODO siento que falta ver que pasa si le quito más de toda la vida que tiene
    }

    @Test
    @Override
    public void testAttackCleric() {
        Cleric cleric = new Cleric(50, 2, field.getCell(1,0));
        sorcerer.attack(cleric);
        assertEquals(50, cleric.getCurrentHitPoints());
        sorcerer.addItem(magicbook);
        magicbook.equipTo(sorcerer);
        sorcerer.attack(cleric);
        assertEquals(40, cleric.getCurrentHitPoints());
        cleric.addItem(staff);
        staff.equipTo(cleric);
        sorcerer.attack(cleric);
        assertEquals(25,cleric.getCurrentHitPoints());
        //TODO siento que falta ver que pasa si le quito más de toda la vida que tiene
    }

    @Test
    @Override
    public void testAttackFighter() {
        Fighter fighter = new Fighter(50, 2, field.getCell(1,0));
        sorcerer.attack(fighter);
        assertEquals(50, fighter.getCurrentHitPoints());
        sorcerer.addItem(magicbook);
        magicbook.equipTo(sorcerer);
        sorcerer.attack(fighter);
        assertEquals(40, fighter.getCurrentHitPoints());
        fighter.addItem(axe);
        axe.equipTo(fighter);
        sorcerer.attack(fighter);
        assertEquals(25,fighter.getCurrentHitPoints());
        //TODO siento que falta ver que pasa si le quito más de toda la vida que tiene
    }

    @Test
    @Override
    public void testAttackHero() {
        Hero hero = new Hero(50, 2, field.getCell(1,0));
        sorcerer.attack(hero);
        assertEquals(50, hero.getCurrentHitPoints());
        sorcerer.addItem(magicbook);
        magicbook.equipTo(sorcerer);
        sorcerer.attack(hero);
        assertEquals(40, hero.getCurrentHitPoints());
        hero.addItem(spear);
        spear.equipTo(hero);
        sorcerer.attack(hero);
        assertEquals(25,hero.getCurrentHitPoints());
        //TODO siento que falta ver que pasa si le quito más de toda la vida que tiene
    }

    @Test
    @Override
    public void testAttackSorcerer() {
        Sorcerer sorcerer2 = new Sorcerer(50, 2, field.getCell(1,0));
        sorcerer.attack(sorcerer2);
        assertEquals(50, sorcerer2.getCurrentHitPoints());
        sorcerer.addItem(magicbook);
        magicbook.equipTo(sorcerer);
        sorcerer.attack(sorcerer2);
        assertEquals(40, sorcerer2.getCurrentHitPoints());
    }

    @Test
    @Override
    public void testAttackSwordMaster() {
        SwordMaster swordMaster = new SwordMaster(50, 2, field.getCell(1,0));
        sorcerer.attack(swordMaster);
        assertEquals(50, swordMaster.getCurrentHitPoints());
        sorcerer.addItem(magicbook);
        magicbook.equipTo(sorcerer);
        sorcerer.attack(swordMaster);
        assertEquals(40, swordMaster.getCurrentHitPoints());
        swordMaster.addItem(sword);
        sword.equipTo(swordMaster);
        sorcerer.attack(swordMaster);
        assertEquals(25,swordMaster.getCurrentHitPoints());
        //TODO siento que falta ver que pasa si le quito más de toda la vida que tiene
    }
}