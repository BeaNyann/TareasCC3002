package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.*;
import org.junit.jupiter.api.Test;

/**
 * Test set for the Sorcerer unit.
 *
 * @author Beatriz Graboloza
 * @since 1.0
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
    public void equipUnequipDarkMagicBookTest() {
        assertNull(sorcerer.getEquippedItem());
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        assertEquals(darkMagicBook, sorcerer.getEquippedItem());
        sorcerer.unequipItem();
        assertNull(sorcerer.getEquippedItem());
    }

    @Test
    @Override
    public void equipUnequipLightMagicBookTest() {
        assertNull(sorcerer.getEquippedItem());
        sorcerer.addItem(lightMagicBook);
        lightMagicBook.equipTo(sorcerer);
        assertEquals(lightMagicBook, sorcerer.getEquippedItem());
        sorcerer.unequipItem();
        assertNull(sorcerer.getEquippedItem());
    }

    @Test
    @Override
    public void equipUnequipSpiritMagicBookTest() {
        assertNull(sorcerer.getEquippedItem());
        sorcerer.addItem(spiritMagicBook);
        spiritMagicBook.equipTo(sorcerer);
        assertEquals(spiritMagicBook, sorcerer.getEquippedItem());
        sorcerer.unequipItem();
        assertNull(sorcerer.getEquippedItem());
    }
    @Test
    @Override
    public void FailEquipUnequipDarkMagicBookTest(){
        assertNull(sorcerer.getEquippedItem());
        sorcerer.unequipItem();
        assertNull(sorcerer.getEquippedItem());
        darkMagicBook.equipTo(sorcerer);
        assertNull(sorcerer.getEquippedItem());
    }

    @Test
    @Override
    public void FailEquipUnequipLightMagicBookTest(){
        assertNull(sorcerer.getEquippedItem());
        sorcerer.unequipItem();
        assertNull(sorcerer.getEquippedItem());
        lightMagicBook.equipTo(sorcerer);
        assertNull(sorcerer.getEquippedItem());
    }

    @Test
    @Override
    public void FailEquipUnequipSpiritMagicBookTest(){
        assertNull(sorcerer.getEquippedItem());
        sorcerer.unequipItem();
        assertNull(sorcerer.getEquippedItem());
        spiritMagicBook.equipTo(sorcerer);
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
    public void testRemoveEquippedObj() {
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        assertEquals(sorcerer,darkMagicBook.getUser());
        assertEquals(darkMagicBook,sorcerer.equippedItem);
        sorcerer.removeItem(darkMagicBook);
        assertNull(sorcerer.getEquippedItem());
        assertNull(darkMagicBook.getUser());
        sorcerer.addItem(lightMagicBook);
        lightMagicBook.equipTo(sorcerer);
        assertEquals(sorcerer,lightMagicBook.getUser());
        assertEquals(lightMagicBook,sorcerer.equippedItem);
        sorcerer.removeItem(lightMagicBook);
        assertNull(sorcerer.getEquippedItem());
        assertNull(lightMagicBook.getUser());
        sorcerer.addItem(spiritMagicBook);
        spiritMagicBook.equipTo(sorcerer);
        assertEquals(sorcerer,spiritMagicBook.getUser());
        assertEquals(spiritMagicBook,sorcerer.equippedItem);
        sorcerer.removeItem(spiritMagicBook);
        assertNull(sorcerer.getEquippedItem());
        assertNull(spiritMagicBook.getUser());
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
        assertEquals(50, alpaca.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        sorcerer.attack(alpaca);
        assertEquals(40, alpaca.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(lightMagicBook);
        lightMagicBook.equipTo(sorcerer);
        sorcerer.attack(alpaca);
        assertEquals(30, alpaca.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(spiritMagicBook);
        spiritMagicBook.equipTo(sorcerer);
        sorcerer.attack(alpaca);
        assertEquals(20, alpaca.getCurrentHitPoints(),1E-6);
    }

    @Test
    @Override
    public void testAttackFarArcher() {
        Archer archer2 = new Archer(50, 2, field.getCell(1,1));
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        Bow bow = new Bow("Bow",10,2,3);
        archer2.addItem(bow);
        bow.equipTo(archer2);
        sorcerer.attack(archer2);
        //por el contraataque
        assertEquals(35,archer2.getCurrentHitPoints(),1E-6);
        assertEquals(35,sorcerer.getCurrentHitPoints(),1E-6);
        DarkMagicBook darkMagicBook2 = new DarkMagicBook("Dark magic book",10,2,4);
        sorcerer.addItem(darkMagicBook2);
        darkMagicBook2.equipTo(sorcerer);
        archer2.moveTo(field.getCell(2,2));
        sorcerer.attack(archer2);
        assertEquals(20,archer2.getCurrentHitPoints(),1E-6);
        assertEquals(35,sorcerer.getCurrentHitPoints(),1E-6);
    }

    @Test
    @Override
    public void testAttackFarFighter() {
        Fighter fighter = new Fighter(50, 2, field.getCell(1,1));
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        Axe axe = new Axe("Axe",10,2,3);
        fighter.addItem(axe);
        axe.equipTo(fighter);
        sorcerer.attack(fighter);
        //por el contraataque
        assertEquals(35,fighter.getCurrentHitPoints(),1E-6);
        assertEquals(35,sorcerer.getCurrentHitPoints(),1E-6);
        DarkMagicBook darkMagicBook2 = new DarkMagicBook("Dark magic book",10,2,4);
        sorcerer.addItem(darkMagicBook2);
        darkMagicBook2.equipTo(sorcerer);
        fighter.moveTo(field.getCell(2,2));
        sorcerer.attack(fighter);
        assertEquals(20,fighter.getCurrentHitPoints(),1E-6);
        assertEquals(35,sorcerer.getCurrentHitPoints(),1E-6);
    }

    @Test
    @Override
    public void testAttackFarHero() {
        Hero hero = new Hero(50, 2, field.getCell(1,1));
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        Spear spear = new Spear("Spear",10,2,3);
        hero.addItem(spear);
        spear.equipTo(hero);
        sorcerer.attack(hero);
        //por el contraataque
        assertEquals(35,hero.getCurrentHitPoints(),1E-6);
        assertEquals(35,sorcerer.getCurrentHitPoints(),1E-6);
        DarkMagicBook darkMagicBook2 = new DarkMagicBook("Dark magic book",10,2,4);
        sorcerer.addItem(darkMagicBook2);
        darkMagicBook2.equipTo(sorcerer);
        hero.moveTo(field.getCell(2,2));
        sorcerer.attack(hero);
        assertEquals(20,hero.getCurrentHitPoints(),1E-6);
        assertEquals(35,sorcerer.getCurrentHitPoints(),1E-6);
    }

    @Test
    @Override
    public void testAttackFarSorcerer() {
        Sorcerer sorcerer2 = new Sorcerer(50, 2, field.getCell(1,1));
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        DarkMagicBook darkMagicBook3 = new DarkMagicBook("Dark magic book3",10,2,3);
        sorcerer2.addItem(darkMagicBook3);
        darkMagicBook3.equipTo(sorcerer2);
        sorcerer.attack(sorcerer2);
        //por el contraataque
        assertEquals(40,sorcerer2.getCurrentHitPoints(),1E-6);
        assertEquals(40,sorcerer.getCurrentHitPoints(),1E-6);
        DarkMagicBook darkMagicBook2 = new DarkMagicBook("Dark magic book",10,2,4);
        sorcerer.addItem(darkMagicBook2);
        darkMagicBook2.equipTo(sorcerer);
        sorcerer2.moveTo(field.getCell(2,2));
        sorcerer.attack(sorcerer2);
        assertEquals(30,sorcerer2.getCurrentHitPoints(),1E-6);
        assertEquals(40,sorcerer.getCurrentHitPoints(),1E-6);
    }

    @Test
    @Override
    public void testAttackFarSwordMaster() {
        SwordMaster swordMaster = new SwordMaster(50, 2, field.getCell(1,1));
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        Sword sword = new Sword("sword",10,2,3);
        swordMaster.addItem(sword);
        sword.equipTo(swordMaster);
        sorcerer.attack(swordMaster);
        //por el contraataque
        assertEquals(35,swordMaster.getCurrentHitPoints(),1E-6);
        assertEquals(35,sorcerer.getCurrentHitPoints(),1E-6);
        DarkMagicBook darkMagicBook2 = new DarkMagicBook("Dark magic book",10,2,4);
        sorcerer.addItem(darkMagicBook2);
        darkMagicBook2.equipTo(sorcerer);
        swordMaster.moveTo(field.getCell(2,2));
        sorcerer.attack(swordMaster);
        assertEquals(20,swordMaster.getCurrentHitPoints(),1E-6);
        assertEquals(35,sorcerer.getCurrentHitPoints(),1E-6);
    }

    @Test
    @Override
    public void testAttackWithOutLife() {
        Sorcerer sorcerer = new Sorcerer(5,2,field.getCell(1,1));
        Hero hero = new Hero(50,2,field.getCell(2,1));
        hero.addItem(spear);
        spear.equipTo(hero);
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        hero.attack(sorcerer);
        assertEquals(0,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(hero);
        assertEquals(50,hero.getCurrentHitPoints(),1E-6);
    }

    @Test
    @Override
    public void testAttackDeadUnit() {
        Alpaca alpaca = getTargetAlpaca();
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        alpaca.setBigDamage(50);
        assertEquals(0,alpaca.getCurrentHitPoints());
        sorcerer.attack(alpaca);
        assertEquals(0,alpaca.getCurrentHitPoints());
    }

    @Override
    public void testAttackArcher() {
        testAttackArcherDark();
        testAttackArcherLight();
        testAttackArcherSpirit();
    }
    @Test
    public void testAttackArcherDark() {
        Archer archer = new Archer(50, 2, field.getCell(1,1));
        sorcerer.attack(archer);
        assertEquals(50, archer.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        sorcerer.attack(archer);
        assertEquals(40, archer.getCurrentHitPoints(),1E-6);
        archer.addItem(bow);
        bow.equipTo(archer);
        archer.moveTo(field.getCell(1,1));
        sorcerer.attack(archer);
        assertEquals(25,archer.getCurrentHitPoints(),1E-6);
        assertEquals(35,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(archer); //le quedan 10 de vida
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(archer); //la resta da -5
        assertEquals(0,archer.getCurrentHitPoints(),1E-6);
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
    }
    @Test
    public void testAttackArcherLight() {
        Archer archer = new Archer(50, 2, field.getCell(1,1));
        sorcerer.attack(archer);
        assertEquals(50, archer.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(lightMagicBook);
        lightMagicBook.equipTo(sorcerer);
        sorcerer.attack(archer);
        assertEquals(40, archer.getCurrentHitPoints(),1E-6);
        archer.addItem(bow);
        bow.equipTo(archer);
        archer.moveTo(field.getCell(1,1));
        sorcerer.attack(archer);
        assertEquals(25,archer.getCurrentHitPoints(),1E-6);
        assertEquals(35,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(archer); //le quedan 10 de vida
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(archer); //la resta da -5
        assertEquals(0,archer.getCurrentHitPoints(),1E-6);
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
    }
    @Test
    public void testAttackArcherSpirit() {
        Archer archer = new Archer(50, 2, field.getCell(1,1));
        sorcerer.attack(archer);
        assertEquals(50, archer.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(spiritMagicBook);
        spiritMagicBook.equipTo(sorcerer);
        sorcerer.attack(archer);
        assertEquals(40, archer.getCurrentHitPoints(),1E-6);
        archer.addItem(bow);
        bow.equipTo(archer);
        archer.moveTo(field.getCell(1,1));
        sorcerer.attack(archer);
        assertEquals(25,archer.getCurrentHitPoints(),1E-6);
        assertEquals(35,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(archer); //le quedan 10 de vida
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(archer); //la resta da -5
        assertEquals(0,archer.getCurrentHitPoints(),1E-6);
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
    }

    @Override
    public void testAttackCleric() {
        testAttackClericDark();
        testAttackClericLight();
        testAttackClericSpirit();
    }
    @Test
    public void testAttackClericDark() {
        Cleric cleric = new Cleric(50, 2, field.getCell(1,1));
        sorcerer.attack(cleric);
        assertEquals(50, cleric.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        sorcerer.attack(cleric);
        assertEquals(40, cleric.getCurrentHitPoints(),1E-6);
        cleric.addItem(staff);
        staff.equipTo(cleric);
        sorcerer.attack(cleric);
        assertEquals(25,cleric.getCurrentHitPoints(),1E-6);
        assertEquals(50,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(cleric); //le quedan 10 de vida
        assertEquals(50,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(cleric); //la resta da -5
        assertEquals(0,cleric.getCurrentHitPoints(),1E-6);
        assertEquals(50,sorcerer.getCurrentHitPoints(),1E-6);
    }
    @Test
    public void testAttackClericLight() {
        Cleric cleric = new Cleric(50, 2, field.getCell(1,1));
        sorcerer.attack(cleric);
        assertEquals(50, cleric.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(lightMagicBook);
        lightMagicBook.equipTo(sorcerer);
        sorcerer.attack(cleric);
        assertEquals(40, cleric.getCurrentHitPoints(),1E-6);
        cleric.addItem(staff);
        staff.equipTo(cleric);
        sorcerer.attack(cleric);
        assertEquals(25,cleric.getCurrentHitPoints(),1E-6);
        assertEquals(50,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(cleric); //le quedan 10 de vida
        assertEquals(50,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(cleric); //la resta da -5
        assertEquals(0,cleric.getCurrentHitPoints(),1E-6);
        assertEquals(50,sorcerer.getCurrentHitPoints(),1E-6);
    }
    @Test
    public void testAttackClericSpirit() {
        Cleric cleric = new Cleric(50, 2, field.getCell(1,1));
        sorcerer.attack(cleric);
        assertEquals(50, cleric.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(spiritMagicBook);
        spiritMagicBook.equipTo(sorcerer);
        sorcerer.attack(cleric);
        assertEquals(40, cleric.getCurrentHitPoints(),1E-6);
        cleric.addItem(staff);
        staff.equipTo(cleric);
        sorcerer.attack(cleric);
        assertEquals(25,cleric.getCurrentHitPoints(),1E-6);
        assertEquals(50,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(cleric); //le quedan 10 de vida
        assertEquals(50,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(cleric); //la resta da -5
        assertEquals(0,cleric.getCurrentHitPoints(),1E-6);
        assertEquals(50,sorcerer.getCurrentHitPoints(),1E-6);
    }

    @Override
    public void testAttackFighter(){
        testAttackFighterDark();
        testAttackFighterLight();
        testAttackFighterSpirit();
    }

    @Test
    public void testAttackFighterDark() {
        Fighter fighter = new Fighter(50, 2, field.getCell(1,1));
        sorcerer.attack(fighter);
        assertEquals(50, fighter.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        sorcerer.attack(fighter);
        assertEquals(40, fighter.getCurrentHitPoints(),1E-6);
        fighter.addItem(axe);
        axe.equipTo(fighter);
        sorcerer.attack(fighter);
        assertEquals(25,fighter.getCurrentHitPoints(),1E-6);
        assertEquals(35,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(fighter); //le quedan 10 de vida
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(fighter); //la resta da -5
        assertEquals(0,fighter.getCurrentHitPoints(),1E-6);
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
    }
    @Test
    public void testAttackFighterLight() {
        Fighter fighter = new Fighter(50, 2, field.getCell(1,1));
        sorcerer.attack(fighter);
        assertEquals(50, fighter.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(lightMagicBook);
        lightMagicBook.equipTo(sorcerer);
        sorcerer.attack(fighter);
        assertEquals(40, fighter.getCurrentHitPoints(),1E-6);
        fighter.addItem(axe);
        axe.equipTo(fighter);
        sorcerer.attack(fighter);
        assertEquals(25,fighter.getCurrentHitPoints(),1E-6);
        assertEquals(35,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(fighter); //le quedan 10 de vida
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(fighter); //la resta da -5
        assertEquals(0,fighter.getCurrentHitPoints(),1E-6);
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
    }
    @Test
    public void testAttackFighterSpirit() {
        Fighter fighter = new Fighter(50, 2, field.getCell(1,1));
        sorcerer.attack(fighter);
        assertEquals(50, fighter.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(spiritMagicBook);
        spiritMagicBook.equipTo(sorcerer);
        sorcerer.attack(fighter);
        assertEquals(40, fighter.getCurrentHitPoints(),1E-6);
        fighter.addItem(axe);
        axe.equipTo(fighter);
        sorcerer.attack(fighter);
        assertEquals(25,fighter.getCurrentHitPoints(),1E-6);
        assertEquals(35,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(fighter); //le quedan 10 de vida
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(fighter); //la resta da -5
        assertEquals(0,fighter.getCurrentHitPoints(),1E-6);
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
    }

    @Override
    public void testAttackHero(){
        testAttackHeroDark();
        testAttackHeroLight();
        testAttackHeroSpirit();
    }
    @Test
    public void testAttackHeroDark() {
        Hero hero = new Hero(50, 2, field.getCell(1,1));
        sorcerer.attack(hero);
        assertEquals(50, hero.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        sorcerer.attack(hero);
        assertEquals(40, hero.getCurrentHitPoints(),1E-6);
        hero.addItem(spear);
        spear.equipTo(hero);
        sorcerer.attack(hero);
        assertEquals(25,hero.getCurrentHitPoints(),1E-6);
        assertEquals(35,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(hero); //le quedan 10 de vida
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(hero); //la resta da -5
        assertEquals(0,hero.getCurrentHitPoints(),1E-6);
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
    }
    @Test
    public void testAttackHeroLight() {
        Hero hero = new Hero(50, 2, field.getCell(1,1));
        sorcerer.attack(hero);
        assertEquals(50, hero.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(lightMagicBook);
        lightMagicBook.equipTo(sorcerer);
        sorcerer.attack(hero);
        assertEquals(40, hero.getCurrentHitPoints(),1E-6);
        hero.addItem(spear);
        spear.equipTo(hero);
        sorcerer.attack(hero);
        assertEquals(25,hero.getCurrentHitPoints(),1E-6);
        assertEquals(35,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(hero); //le quedan 10 de vida
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(hero); //la resta da -5
        assertEquals(0,hero.getCurrentHitPoints(),1E-6);
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
    }
    @Test
    public void testAttackHeroSpirit() {
        Hero hero = new Hero(50, 2, field.getCell(1,1));
        sorcerer.attack(hero);
        assertEquals(50, hero.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(spiritMagicBook);
        spiritMagicBook.equipTo(sorcerer);
        sorcerer.attack(hero);
        assertEquals(40, hero.getCurrentHitPoints(),1E-6);
        hero.addItem(spear);
        spear.equipTo(hero);
        sorcerer.attack(hero);
        assertEquals(25,hero.getCurrentHitPoints(),1E-6);
        assertEquals(35,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(hero); //le quedan 10 de vida
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(hero); //la resta da -5
        assertEquals(0,hero.getCurrentHitPoints(),1E-6);
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
    }

    @Override
    public void testAttackLightSorcerer() {
        testAttackLightSorcererwithLight();
        testAttackLightSorcererwithDark();
        testAttackLightSorcererwithSpirit();
    }

    @Override
    public void testAttackDarkSorcerer() {
        testAttackDarkSorcererwithLight();
        testAttackDarkSorcererwithDark();
        testAttackDarkSorcererwithSpirit();
    }

    @Override
    public void testAttackSpiritSorcerer() {
        testAttackSpiritSorcererwithLight();
        testAttackSpiritSorcererwithDark();
        testAttackSpiritSorcererwithSpirit();
    }

    @Test
    public void testAttackLightSorcererwithLight() {
        Sorcerer sorcerer2 = new Sorcerer(50, 2, field.getCell(1, 1));
        sorcerer.attack(sorcerer2);
        assertEquals(50, sorcerer2.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(lightMagicBook);
        lightMagicBook.equipTo(sorcerer);
        sorcerer.attack(sorcerer2);
        assertEquals(40, sorcerer2.getCurrentHitPoints(),1E-6);
        LightMagicBook lightMagicBook2 = new LightMagicBook("lightMagicBook2",10,1,2);
        sorcerer2.addItem(lightMagicBook2);
        lightMagicBook2.equipTo(sorcerer2);
        sorcerer.attack(sorcerer2);
        assertEquals(30, sorcerer2.getCurrentHitPoints(),1E-6);
        assertEquals(40,sorcerer.getCurrentHitPoints(),1E-6);
    }
    @Test
    public void testAttackLightSorcererwithDark() {
        Sorcerer sorcerer2 = new Sorcerer(50, 2, field.getCell(1,1));
        sorcerer.attack(sorcerer2);
        assertEquals(50, sorcerer2.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        sorcerer.attack(sorcerer2);
        assertEquals(40, sorcerer2.getCurrentHitPoints(),1E-6);
        sorcerer2.addItem(lightMagicBook);
        lightMagicBook.equipTo(sorcerer2);
        sorcerer.attack(sorcerer2);
        assertEquals(40, sorcerer2.getCurrentHitPoints(),1E-6);
        assertEquals(35,sorcerer.getCurrentHitPoints(),1E-6);
        DarkMagicBook darkMagicBook2 = new DarkMagicBook("darkMagicBook2", 40, 1, 2);
        sorcerer.addItem(darkMagicBook2);
        darkMagicBook2.equipTo(sorcerer);
        sorcerer.attack(sorcerer2);
        assertEquals(20, sorcerer2.getCurrentHitPoints(),1E-6);
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
    }
    @Test
    public void testAttackLightSorcererwithSpirit() {
        Sorcerer sorcerer2 = new Sorcerer(50, 2, field.getCell(1,1));
        sorcerer.attack(sorcerer2);
        assertEquals(50, sorcerer2.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(spiritMagicBook);
        spiritMagicBook.equipTo(sorcerer);
        sorcerer.attack(sorcerer2);
        assertEquals(40, sorcerer2.getCurrentHitPoints(),1E-6);
        sorcerer2.addItem(lightMagicBook);
        lightMagicBook.equipTo(sorcerer2);
        sorcerer.attack(sorcerer2);
        assertEquals(25,sorcerer2.getCurrentHitPoints(),1E-6);
        assertEquals(50,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(sorcerer2); //le quedan 10 de vida
        assertEquals(50,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(sorcerer2); //la resta da -5
        assertEquals(0,sorcerer2.getCurrentHitPoints(),1E-6);
        assertEquals(50,sorcerer.getCurrentHitPoints(),1E-6);
    }
    @Test
    public void testAttackDarkSorcererwithLight() {
        Sorcerer sorcerer2 = new Sorcerer(50, 2, field.getCell(1,1));
        sorcerer.attack(sorcerer2);
        assertEquals(50, sorcerer2.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(lightMagicBook);
        lightMagicBook.equipTo(sorcerer);
        sorcerer.attack(sorcerer2);
        assertEquals(40, sorcerer2.getCurrentHitPoints(),1E-6);
        sorcerer2.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer2);
        sorcerer.attack(sorcerer2);
        assertEquals(25,sorcerer2.getCurrentHitPoints(),1E-6);
        assertEquals(50,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(sorcerer2); //le quedan 10 de vida
        assertEquals(50,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(sorcerer2); //la resta da -5
        assertEquals(0,sorcerer2.getCurrentHitPoints(),1E-6);
        assertEquals(50,sorcerer.getCurrentHitPoints(),1E-6);
    }
    @Test
    public void testAttackDarkSorcererwithDark(){
        Sorcerer sorcerer2 = new Sorcerer(50, 2, field.getCell(1, 1));
        sorcerer.attack(sorcerer2);
        assertEquals(50, sorcerer2.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        sorcerer.attack(sorcerer2);
        assertEquals(40, sorcerer2.getCurrentHitPoints(),1E-6);
        DarkMagicBook darkMagicBook2 = new DarkMagicBook("darkMagicBook",10,1,2);
        sorcerer2.addItem(darkMagicBook2);
        darkMagicBook2.equipTo(sorcerer2);
        sorcerer.attack(sorcerer2);
        assertEquals(30, sorcerer2.getCurrentHitPoints(),1E-6);
        assertEquals(40,sorcerer.getCurrentHitPoints(),1E-6);

    }
    @Test
    public void testAttackDarkSorcererwithSpirit(){
        Sorcerer sorcerer2 = new Sorcerer(50, 2, field.getCell(1,1));
        sorcerer.attack(sorcerer2);
        assertEquals(50, sorcerer2.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(spiritMagicBook);
        spiritMagicBook.equipTo(sorcerer);
        sorcerer.attack(sorcerer2);
        assertEquals(40, sorcerer2.getCurrentHitPoints(),1E-6);
        sorcerer2.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer2);
        sorcerer.attack(sorcerer2);
        assertEquals(40, sorcerer2.getCurrentHitPoints(),1E-6);
        assertEquals(35,sorcerer.getCurrentHitPoints(),1E-6);
        SpiritMagicBook spiritMagicBook2 = new SpiritMagicBook("spiritMagicBook2", 40, 1, 2);
        sorcerer.addItem(spiritMagicBook2);
        spiritMagicBook2.equipTo(sorcerer);
        sorcerer.attack(sorcerer2);
        assertEquals(20, sorcerer2.getCurrentHitPoints(),1E-6);
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);

    }
    @Test
    public void testAttackSpiritSorcererwithLight() {
        Sorcerer sorcerer2 = new Sorcerer(50, 2, field.getCell(1,1));
        sorcerer.attack(sorcerer2);
        assertEquals(50, sorcerer2.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(lightMagicBook);
        lightMagicBook.equipTo(sorcerer);
        sorcerer.attack(sorcerer2);
        assertEquals(40, sorcerer2.getCurrentHitPoints(),1E-6);
        sorcerer2.addItem(spiritMagicBook);
        spiritMagicBook.equipTo(sorcerer2);
        sorcerer.attack(sorcerer2);
        assertEquals(40, sorcerer2.getCurrentHitPoints(),1E-6);
        assertEquals(35,sorcerer.getCurrentHitPoints(),1E-6);
        LightMagicBook lightMagicBook2 = new LightMagicBook("lightMagicBook2", 40, 1, 2);
        sorcerer.addItem(lightMagicBook2);
        lightMagicBook2.equipTo(sorcerer);
        sorcerer.attack(sorcerer2);
        assertEquals(20, sorcerer2.getCurrentHitPoints(),1E-6);
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);

    }
    @Test
    public void testAttackSpiritSorcererwithDark() {
        Sorcerer sorcerer2 = new Sorcerer(50, 2, field.getCell(1,1));
        sorcerer.attack(sorcerer2);
        assertEquals(50, sorcerer2.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        sorcerer.attack(sorcerer2);
        assertEquals(40, sorcerer2.getCurrentHitPoints(),1E-6);
        sorcerer2.addItem(spiritMagicBook);
        spiritMagicBook.equipTo(sorcerer2);
        sorcerer.attack(sorcerer2);
        assertEquals(25,sorcerer2.getCurrentHitPoints(),1E-6);
        assertEquals(50,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(sorcerer2); //le quedan 10 de vida
        assertEquals(50,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(sorcerer2); //la resta da -5
        assertEquals(0,sorcerer2.getCurrentHitPoints(),1E-6);
        assertEquals(50,sorcerer.getCurrentHitPoints(),1E-6);
    }
    @Test
    public void testAttackSpiritSorcererwithSpirit() {
        Sorcerer sorcerer2 = new Sorcerer(50, 2, field.getCell(1, 1));
        sorcerer.attack(sorcerer2);
        assertEquals(50, sorcerer2.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(spiritMagicBook);
        spiritMagicBook.equipTo(sorcerer);
        sorcerer.attack(sorcerer2);
        assertEquals(40, sorcerer2.getCurrentHitPoints(),1E-6);
        SpiritMagicBook spiritMagicBook2 = new SpiritMagicBook("spiriMagicBook2", 10, 1, 2);
        sorcerer2.addItem(spiritMagicBook2); //una unidad muerta esta declarada muerta? tengo que restringir las weas si tiene 0 de vida?
        spiritMagicBook2.equipTo(sorcerer2);
        sorcerer.attack(sorcerer2);
        assertEquals(30, sorcerer2.getCurrentHitPoints(),1E-6);
        assertEquals(40,sorcerer.getCurrentHitPoints(),1E-6);
    }

    @Override
    public void testAttackSwordMaster(){
        testAttackSwordMasterDark();
        testAttackSwordMasterLight();
        testAttackSwordMasterSpirit();
    }
    @Test
    public void testAttackSwordMasterDark() {
        SwordMaster swordMaster = new SwordMaster(50, 2, field.getCell(1,1));
        sorcerer.attack(swordMaster);
        assertEquals(50, swordMaster.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        sorcerer.attack(swordMaster);
        assertEquals(40, swordMaster.getCurrentHitPoints(),1E-6);
        swordMaster.addItem(sword);
        sword.equipTo(swordMaster);
        sorcerer.attack(swordMaster);
        assertEquals(25,swordMaster.getCurrentHitPoints(),1E-6);
        assertEquals(35,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(swordMaster); //le quedan 10 de vida
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(swordMaster); //la resta da -5
        assertEquals(0,swordMaster.getCurrentHitPoints(),1E-6);
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
    }
    @Test
    public void testAttackSwordMasterLight() {
        SwordMaster swordMaster = new SwordMaster(50, 2, field.getCell(1,1));
        sorcerer.attack(swordMaster);
        assertEquals(50, swordMaster.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(lightMagicBook);
        lightMagicBook.equipTo(sorcerer);
        sorcerer.attack(swordMaster);
        assertEquals(40, swordMaster.getCurrentHitPoints(),1E-6);
        swordMaster.addItem(sword);
        sword.equipTo(swordMaster);
        sorcerer.attack(swordMaster);
        assertEquals(25,swordMaster.getCurrentHitPoints(),1E-6);
        assertEquals(35,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(swordMaster); //le quedan 10 de vida
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(swordMaster); //la resta da -5
        assertEquals(0,swordMaster.getCurrentHitPoints(),1E-6);
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
    }
    @Test
    public void testAttackSwordMasterSpirit() {
        SwordMaster swordMaster = new SwordMaster(50, 2, field.getCell(1,1));
        sorcerer.attack(swordMaster);
        assertEquals(50, swordMaster.getCurrentHitPoints(),1E-6);
        sorcerer.addItem(spiritMagicBook);
        spiritMagicBook.equipTo(sorcerer);
        sorcerer.attack(swordMaster);
        assertEquals(40, swordMaster.getCurrentHitPoints(),1E-6);
        swordMaster.addItem(sword);
        sword.equipTo(swordMaster);
        sorcerer.attack(swordMaster);
        assertEquals(25,swordMaster.getCurrentHitPoints(),1E-6);
        assertEquals(35,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(swordMaster); //le quedan 10 de vida
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
        sorcerer.attack(swordMaster); //la resta da -5
        assertEquals(0,swordMaster.getCurrentHitPoints(),1E-6);
        assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
    }
}