package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.DarkMagicBook;
import model.items.LightMagicBook;
import model.items.SpiritMagicBook;
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
        assertEquals(50, alpaca.getCurrentHitPoints());
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        sorcerer.attack(alpaca);
        assertEquals(40, alpaca.getCurrentHitPoints());
        sorcerer.addItem(lightMagicBook);
        lightMagicBook.equipTo(sorcerer);
        sorcerer.attack(alpaca);
        assertEquals(30, alpaca.getCurrentHitPoints());
        sorcerer.addItem(spiritMagicBook);
        spiritMagicBook.equipTo(sorcerer);
        sorcerer.attack(alpaca);
        assertEquals(20, alpaca.getCurrentHitPoints());
    }

    @Override
    public void testAttackArcher() {
        testAttackArcherDark();
        testAttackArcherLight();
        testAttackArcherSpirit();
    }
    public void testAttackArcherDark() {
        Archer archer = new Archer(50, 2, field.getCell(1,0));
        sorcerer.attack(archer);
        assertEquals(50, archer.getCurrentHitPoints());
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        sorcerer.attack(archer);
        assertEquals(40, archer.getCurrentHitPoints());
        archer.addItem(bow);
        bow.equipTo(archer);
        sorcerer.attack(archer);
        assertEquals(25,archer.getCurrentHitPoints());
        sorcerer.attack(archer); //le quedan 10 de vida
        sorcerer.attack(archer); //la resta da -5
        assertEquals(0,archer.getCurrentHitPoints());
    }

    public void testAttackArcherLight() {
        Archer archer = new Archer(50, 2, field.getCell(1,0));
        sorcerer.attack(archer);
        assertEquals(50, archer.getCurrentHitPoints());
        sorcerer.addItem(lightMagicBook);
        lightMagicBook.equipTo(sorcerer);
        sorcerer.attack(archer);
        assertEquals(40, archer.getCurrentHitPoints());
        archer.addItem(bow);
        bow.equipTo(archer);
        sorcerer.attack(archer);
        assertEquals(25,archer.getCurrentHitPoints());
        sorcerer.attack(archer); //le quedan 10 de vida
        sorcerer.attack(archer); //la resta da -5
        assertEquals(0,archer.getCurrentHitPoints());
    }

    public void testAttackArcherSpirit() {
        Archer archer = new Archer(50, 2, field.getCell(1,0));
        sorcerer.attack(archer);
        assertEquals(50, archer.getCurrentHitPoints());
        sorcerer.addItem(spiritMagicBook);
        spiritMagicBook.equipTo(sorcerer);
        sorcerer.attack(archer);
        assertEquals(40, archer.getCurrentHitPoints());
        archer.addItem(bow);
        bow.equipTo(archer);
        sorcerer.attack(archer);
        assertEquals(25,archer.getCurrentHitPoints());
        sorcerer.attack(archer); //le quedan 10 de vida
        sorcerer.attack(archer); //la resta da -5
        assertEquals(0,archer.getCurrentHitPoints());
    }

    @Override
    public void testAttackCleric() {
        testAttackClericDark();
        testAttackClericLight();
        testAttackClericSpirit();
    }
    public void testAttackClericDark() {
        Cleric cleric = new Cleric(50, 2, field.getCell(1,0));
        sorcerer.attack(cleric);
        assertEquals(50, cleric.getCurrentHitPoints());
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        sorcerer.attack(cleric);
        assertEquals(40, cleric.getCurrentHitPoints());
        cleric.addItem(staff);
        staff.equipTo(cleric);
        sorcerer.attack(cleric);
        assertEquals(25,cleric.getCurrentHitPoints());
        sorcerer.attack(cleric); //le quedan 10 de vida
        sorcerer.attack(cleric); //la resta da -5
        assertEquals(0,cleric.getCurrentHitPoints());
    }

    public void testAttackClericLight() {
        Cleric cleric = new Cleric(50, 2, field.getCell(1,0));
        sorcerer.attack(cleric);
        assertEquals(50, cleric.getCurrentHitPoints());
        sorcerer.addItem(lightMagicBook);
        lightMagicBook.equipTo(sorcerer);
        sorcerer.attack(cleric);
        assertEquals(40, cleric.getCurrentHitPoints());
        cleric.addItem(staff);
        staff.equipTo(cleric);
        sorcerer.attack(cleric);
        assertEquals(25,cleric.getCurrentHitPoints());
        sorcerer.attack(cleric); //le quedan 10 de vida
        sorcerer.attack(cleric); //la resta da -5
        assertEquals(0,cleric.getCurrentHitPoints());
    }

    public void testAttackClericSpirit() {
        Cleric cleric = new Cleric(50, 2, field.getCell(1,0));
        sorcerer.attack(cleric);
        assertEquals(50, cleric.getCurrentHitPoints());
        sorcerer.addItem(spiritMagicBook);
        spiritMagicBook.equipTo(sorcerer);
        sorcerer.attack(cleric);
        assertEquals(40, cleric.getCurrentHitPoints());
        cleric.addItem(staff);
        staff.equipTo(cleric);
        sorcerer.attack(cleric);
        assertEquals(25,cleric.getCurrentHitPoints());
        sorcerer.attack(cleric); //le quedan 10 de vida
        sorcerer.attack(cleric); //la resta da -5
        assertEquals(0,cleric.getCurrentHitPoints());
    }

    @Override
    public void testAttackFighter(){
        testAttackFighterDark();
        testAttackFighterLight();
        testAttackFighterSpirit();
    }


    public void testAttackFighterDark() {
        Fighter fighter = new Fighter(50, 2, field.getCell(1,0));
        sorcerer.attack(fighter);
        assertEquals(50, fighter.getCurrentHitPoints());
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        sorcerer.attack(fighter);
        assertEquals(40, fighter.getCurrentHitPoints());
        fighter.addItem(axe);
        axe.equipTo(fighter);
        sorcerer.attack(fighter);
        assertEquals(25,fighter.getCurrentHitPoints());
        sorcerer.attack(fighter); //le quedan 10 de vida
        sorcerer.attack(fighter); //la resta da -5
        assertEquals(0,fighter.getCurrentHitPoints());
    }

    public void testAttackFighterLight() {
        Fighter fighter = new Fighter(50, 2, field.getCell(1,0));
        sorcerer.attack(fighter);
        assertEquals(50, fighter.getCurrentHitPoints());
        sorcerer.addItem(lightMagicBook);
        lightMagicBook.equipTo(sorcerer);
        sorcerer.attack(fighter);
        assertEquals(40, fighter.getCurrentHitPoints());
        fighter.addItem(axe);
        axe.equipTo(fighter);
        sorcerer.attack(fighter);
        assertEquals(25,fighter.getCurrentHitPoints());
        sorcerer.attack(fighter); //le quedan 10 de vida
        sorcerer.attack(fighter); //la resta da -5
        assertEquals(0,fighter.getCurrentHitPoints());
    }

    public void testAttackFighterSpirit() {
        Fighter fighter = new Fighter(50, 2, field.getCell(1,0));
        sorcerer.attack(fighter);
        assertEquals(50, fighter.getCurrentHitPoints());
        sorcerer.addItem(spiritMagicBook);
        spiritMagicBook.equipTo(sorcerer);
        sorcerer.attack(fighter);
        assertEquals(40, fighter.getCurrentHitPoints());
        fighter.addItem(axe);
        axe.equipTo(fighter);
        sorcerer.attack(fighter);
        assertEquals(25,fighter.getCurrentHitPoints());
        sorcerer.attack(fighter); //le quedan 10 de vida
        sorcerer.attack(fighter); //la resta da -5
        assertEquals(0,fighter.getCurrentHitPoints());
    }

    @Override
    public void testAttackHero(){
        testAttackHeroDark();
        testAttackHeroLight();
        testAttackHeroSpirit();
    }

    public void testAttackHeroDark() {
        Hero hero = new Hero(50, 2, field.getCell(1,0));
        sorcerer.attack(hero);
        assertEquals(50, hero.getCurrentHitPoints());
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        sorcerer.attack(hero);
        assertEquals(40, hero.getCurrentHitPoints());
        hero.addItem(spear);
        spear.equipTo(hero);
        sorcerer.attack(hero);
        assertEquals(25,hero.getCurrentHitPoints());
        sorcerer.attack(hero); //le quedan 10 de vida
        sorcerer.attack(hero); //la resta da -5
        assertEquals(0,hero.getCurrentHitPoints());
    }

    public void testAttackHeroLight() {
        Hero hero = new Hero(50, 2, field.getCell(1,0));
        sorcerer.attack(hero);
        assertEquals(50, hero.getCurrentHitPoints());
        sorcerer.addItem(lightMagicBook);
        lightMagicBook.equipTo(sorcerer);
        sorcerer.attack(hero);
        assertEquals(40, hero.getCurrentHitPoints());
        hero.addItem(spear);
        spear.equipTo(hero);
        sorcerer.attack(hero);
        assertEquals(25,hero.getCurrentHitPoints());
        sorcerer.attack(hero); //le quedan 10 de vida
        sorcerer.attack(hero); //la resta da -5
        assertEquals(0,hero.getCurrentHitPoints());
    }

    public void testAttackHeroSpirit() {
        Hero hero = new Hero(50, 2, field.getCell(1,0));
        sorcerer.attack(hero);
        assertEquals(50, hero.getCurrentHitPoints());
        sorcerer.addItem(spiritMagicBook);
        spiritMagicBook.equipTo(sorcerer);
        sorcerer.attack(hero);
        assertEquals(40, hero.getCurrentHitPoints());
        hero.addItem(spear);
        spear.equipTo(hero);
        sorcerer.attack(hero);
        assertEquals(25,hero.getCurrentHitPoints());
        sorcerer.attack(hero); //le quedan 10 de vida
        sorcerer.attack(hero); //la resta da -5
        assertEquals(0,hero.getCurrentHitPoints());
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
        Sorcerer sorcerer2 = new Sorcerer(50, 2, field.getCell(1, 0));
        sorcerer.attack(sorcerer2);
        assertEquals(50, sorcerer2.getCurrentHitPoints());
        sorcerer.addItem(lightMagicBook);
        lightMagicBook.equipTo(sorcerer);
        sorcerer.attack(sorcerer2);
        assertEquals(40, sorcerer2.getCurrentHitPoints());
        LightMagicBook lightMagicBook2 = new LightMagicBook("lightMagicBook2",10,1,2);
        sorcerer2.addItem(lightMagicBook2); //TODO una unidad muerta esta declarada muerta? tengo que restringir las weas si tiene 0 de vida?
        lightMagicBook2.equipTo(sorcerer2);
        sorcerer.attack(sorcerer2);
        assertEquals(30, sorcerer2.getCurrentHitPoints());
    }
    @Test
    public void testAttackLightSorcererwithDark() {
        Sorcerer sorcerer2 = new Sorcerer(50, 2, field.getCell(1,0));
        sorcerer.attack(sorcerer2);
        assertEquals(50, sorcerer2.getCurrentHitPoints());
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        sorcerer.attack(sorcerer2);
        assertEquals(40, sorcerer2.getCurrentHitPoints());
        sorcerer2.addItem(lightMagicBook);
        lightMagicBook.equipTo(sorcerer2);
        sorcerer.attack(sorcerer2);
        assertEquals(40, sorcerer2.getCurrentHitPoints());
        DarkMagicBook darkMagicBook2 = new DarkMagicBook("darkMagicBook2", 40, 1, 2);
        sorcerer.addItem(darkMagicBook2);
        darkMagicBook2.equipTo(sorcerer);
        sorcerer.attack(sorcerer2);
        assertEquals(20, sorcerer2.getCurrentHitPoints());
    }
    @Test
    public void testAttackLightSorcererwithSpirit() {
        Sorcerer sorcerer2 = new Sorcerer(50, 2, field.getCell(1,0));
        sorcerer.attack(sorcerer2);
        assertEquals(50, sorcerer2.getCurrentHitPoints());
        sorcerer.addItem(spiritMagicBook);
        spiritMagicBook.equipTo(sorcerer);
        sorcerer.attack(sorcerer2);
        assertEquals(40, sorcerer2.getCurrentHitPoints());
        sorcerer2.addItem(lightMagicBook);
        lightMagicBook.equipTo(sorcerer2);
        sorcerer.attack(sorcerer2);
        assertEquals(25,sorcerer2.getCurrentHitPoints());
        sorcerer.attack(sorcerer2); //le quedan 10 de vida
        sorcerer.attack(sorcerer2); //la resta da -5
        assertEquals(0,sorcerer2.getCurrentHitPoints());
    }
    @Test
    public void testAttackDarkSorcererwithLight() {
        Sorcerer sorcerer2 = new Sorcerer(50, 2, field.getCell(1,0));
        sorcerer.attack(sorcerer2);
        assertEquals(50, sorcerer2.getCurrentHitPoints());
        sorcerer.addItem(lightMagicBook);
        lightMagicBook.equipTo(sorcerer);
        sorcerer.attack(sorcerer2);
        assertEquals(40, sorcerer2.getCurrentHitPoints());
        sorcerer2.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer2);
        sorcerer.attack(sorcerer2);
        assertEquals(25,sorcerer2.getCurrentHitPoints());
        sorcerer.attack(sorcerer2); //le quedan 10 de vida
        sorcerer.attack(sorcerer2); //la resta da -5
        assertEquals(0,sorcerer2.getCurrentHitPoints());
    }
    @Test
    public void testAttackDarkSorcererwithDark(){
        Sorcerer sorcerer2 = new Sorcerer(50, 2, field.getCell(1, 0));
        sorcerer.attack(sorcerer2);
        assertEquals(50, sorcerer2.getCurrentHitPoints());
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        sorcerer.attack(sorcerer2);
        assertEquals(40, sorcerer2.getCurrentHitPoints());
        DarkMagicBook darkMagicBook2 = new DarkMagicBook("darkMagicBook",10,1,2);
        sorcerer2.addItem(darkMagicBook2); //TODO una unidad muerta esta declarada muerta? tengo que restringir las weas si tiene 0 de vida?
        darkMagicBook2.equipTo(sorcerer2);
        sorcerer.attack(sorcerer2);
        assertEquals(30, sorcerer2.getCurrentHitPoints());
    }
    @Test
    public void testAttackDarkSorcererwithSpirit(){
        Sorcerer sorcerer2 = new Sorcerer(50, 2, field.getCell(1,0));
        sorcerer.attack(sorcerer2);
        assertEquals(50, sorcerer2.getCurrentHitPoints());
        sorcerer.addItem(spiritMagicBook);
        spiritMagicBook.equipTo(sorcerer);
        sorcerer.attack(sorcerer2);
        assertEquals(40, sorcerer2.getCurrentHitPoints());
        sorcerer2.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer2);
        sorcerer.attack(sorcerer2);
        assertEquals(40, sorcerer2.getCurrentHitPoints());
        SpiritMagicBook spiritMagicBook2 = new SpiritMagicBook("spiritMagicBook2", 40, 1, 2);
        sorcerer.addItem(spiritMagicBook2);
        spiritMagicBook2.equipTo(sorcerer);
        sorcerer.attack(sorcerer2);
        assertEquals(20, sorcerer2.getCurrentHitPoints());
    }
    @Test
    public void testAttackSpiritSorcererwithLight() {
        Sorcerer sorcerer2 = new Sorcerer(50, 2, field.getCell(1,0));
        sorcerer.attack(sorcerer2);
        assertEquals(50, sorcerer2.getCurrentHitPoints());
        sorcerer.addItem(lightMagicBook);
        lightMagicBook.equipTo(sorcerer);
        sorcerer.attack(sorcerer2);
        assertEquals(40, sorcerer2.getCurrentHitPoints());
        sorcerer2.addItem(spiritMagicBook);
        spiritMagicBook.equipTo(sorcerer2);
        sorcerer.attack(sorcerer2);
        assertEquals(40, sorcerer2.getCurrentHitPoints());
        LightMagicBook lightMagicBook2 = new LightMagicBook("lightMagicBook2", 40, 1, 2);
        sorcerer.addItem(lightMagicBook2);
        lightMagicBook2.equipTo(sorcerer);
        sorcerer.attack(sorcerer2);
        assertEquals(20, sorcerer2.getCurrentHitPoints());
    }
    @Test
    public void testAttackSpiritSorcererwithDark() {
        Sorcerer sorcerer2 = new Sorcerer(50, 2, field.getCell(1,0));
        sorcerer.attack(sorcerer2);
        assertEquals(50, sorcerer2.getCurrentHitPoints());
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        sorcerer.attack(sorcerer2);
        assertEquals(40, sorcerer2.getCurrentHitPoints());
        sorcerer2.addItem(spiritMagicBook);
        spiritMagicBook.equipTo(sorcerer2);
        sorcerer.attack(sorcerer2);
        assertEquals(25,sorcerer2.getCurrentHitPoints());
        sorcerer.attack(sorcerer2); //le quedan 10 de vida
        sorcerer.attack(sorcerer2); //la resta da -5
        assertEquals(0,sorcerer2.getCurrentHitPoints());
    }
    @Test
    public void testAttackSpiritSorcererwithSpirit() {
        Sorcerer sorcerer2 = new Sorcerer(50, 2, field.getCell(1, 0));
        sorcerer.attack(sorcerer2);
        assertEquals(50, sorcerer2.getCurrentHitPoints());
        sorcerer.addItem(spiritMagicBook);
        spiritMagicBook.equipTo(sorcerer);
        sorcerer.attack(sorcerer2);
        assertEquals(40, sorcerer2.getCurrentHitPoints());
        SpiritMagicBook spiritMagicBook2 = new SpiritMagicBook("spiriMagicBook2", 10, 1, 2);
        sorcerer2.addItem(spiritMagicBook2); //una unidad muerta esta declarada muerta? tengo que restringir las weas si tiene 0 de vida?
        spiritMagicBook2.equipTo(sorcerer2);
        sorcerer.attack(sorcerer2);
        assertEquals(30, sorcerer2.getCurrentHitPoints());
    }

    @Override
    public void testAttackSwordMaster(){
        testAttackSwordMasterDark();
        testAttackSwordMasterLight();
        testAttackSwordMasterSpirit();
    }
    @Test
    public void testAttackSwordMasterDark() {
        SwordMaster swordMaster = new SwordMaster(50, 2, field.getCell(1,0));
        sorcerer.attack(swordMaster);
        assertEquals(50, swordMaster.getCurrentHitPoints());
        sorcerer.addItem(darkMagicBook);
        darkMagicBook.equipTo(sorcerer);
        sorcerer.attack(swordMaster);
        assertEquals(40, swordMaster.getCurrentHitPoints());
        swordMaster.addItem(sword);
        sword.equipTo(swordMaster);
        sorcerer.attack(swordMaster);
        assertEquals(25,swordMaster.getCurrentHitPoints());
        sorcerer.attack(swordMaster); //le quedan 10 de vida
        sorcerer.attack(swordMaster); //la resta da -5
        assertEquals(0,swordMaster.getCurrentHitPoints());
    }
    @Test
    public void testAttackSwordMasterLight() {
        SwordMaster swordMaster = new SwordMaster(50, 2, field.getCell(1,0));
        sorcerer.attack(swordMaster);
        assertEquals(50, swordMaster.getCurrentHitPoints());
        sorcerer.addItem(lightMagicBook);
        lightMagicBook.equipTo(sorcerer);
        sorcerer.attack(swordMaster);
        assertEquals(40, swordMaster.getCurrentHitPoints());
        swordMaster.addItem(sword);
        sword.equipTo(swordMaster);
        sorcerer.attack(swordMaster);
        assertEquals(25,swordMaster.getCurrentHitPoints());
        sorcerer.attack(swordMaster); //le quedan 10 de vida
        sorcerer.attack(swordMaster); //la resta da -5
        assertEquals(0,swordMaster.getCurrentHitPoints());
    }
    @Test
    public void testAttackSwordMasterSpirit() {
        SwordMaster swordMaster = new SwordMaster(50, 2, field.getCell(1,0));
        sorcerer.attack(swordMaster);
        assertEquals(50, swordMaster.getCurrentHitPoints());
        sorcerer.addItem(spiritMagicBook);
        spiritMagicBook.equipTo(sorcerer);
        sorcerer.attack(swordMaster);
        assertEquals(40, swordMaster.getCurrentHitPoints());
        swordMaster.addItem(sword);
        sword.equipTo(swordMaster);
        sorcerer.attack(swordMaster);
        assertEquals(25,swordMaster.getCurrentHitPoints());
        sorcerer.attack(swordMaster); //le quedan 10 de vida
        sorcerer.attack(swordMaster); //la resta da -5
        assertEquals(0,swordMaster.getCurrentHitPoints());
    }
}