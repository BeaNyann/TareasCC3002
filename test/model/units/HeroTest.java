package model.units;

import model.items.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test set for the Hero unit.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public class HeroTest extends AbstractTestUnit {

  private Hero hero;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    hero = new Hero(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return hero;
  }

  @Test
  @Override
  public void equipUnequipSpearTest() {
    assertNull(hero.getEquippedItem());
    hero.addItem(spear);
    spear.equipTo(hero);
    assertEquals(spear, hero.getEquippedItem());
    hero.unequipItem();
    assertNull(hero.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipSpearTest(){
    assertNull(hero.getEquippedItem());
    hero.unequipItem();
    assertNull(hero.getEquippedItem());
    spear.equipTo(hero);
    assertNull(hero.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipBowTest(){
    assertNull(hero.getEquippedItem());
    hero.unequipItem();
    assertNull(hero.getEquippedItem());
    bow.equipTo(hero);
    assertNull(hero.getEquippedItem());
    hero.addItem(bow);
    bow.equipTo(hero);
    assertNull(hero.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipStaffTest(){
    assertNull(hero.getEquippedItem());
    hero.unequipItem();
    assertNull(hero.getEquippedItem());
    staff.equipTo(hero);
    assertNull(hero.getEquippedItem());
    hero.addItem(staff);
    staff.equipTo(hero);
    assertNull(hero.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipAxeTest(){
    assertNull(hero.getEquippedItem());
    hero.unequipItem();
    assertNull(hero.getEquippedItem());
    axe.equipTo(hero);
    assertNull(hero.getEquippedItem());
    hero.addItem(axe);
    axe.equipTo(hero);
    assertNull(hero.getEquippedItem());
  }

  @Test
  @Override
  public void testRemoveEquippedObj() {
    hero.addItem(spear);
    spear.equipTo(hero);
    assertEquals(hero,spear.getUser());
    assertEquals(spear,hero.equippedItem);
    hero.removeItem(spear);
    assertNull(hero.getEquippedItem());
    assertNull(spear.getUser());
  }

  @Test
  @Override
  public void FailEquipUnequipSpiritMagicBookTest(){
    assertNull(hero.getEquippedItem());
    hero.unequipItem();
    assertNull(hero.getEquippedItem());
    spiritMagicBook.equipTo(hero);
    assertNull(hero.getEquippedItem());
    hero.addItem(spiritMagicBook);
    spiritMagicBook.equipTo(hero);
    assertNull(hero.getEquippedItem());
  }

  @Test
  @Override
  public void FailEquipUnequipDarkMagicBookTest(){
    assertNull(hero.getEquippedItem());
    hero.unequipItem();
    assertNull(hero.getEquippedItem());
    darkMagicBook.equipTo(hero);
    assertNull(hero.getEquippedItem());
    hero.addItem(darkMagicBook);
    darkMagicBook.equipTo(hero);
    assertNull(hero.getEquippedItem());
  }

  @Test
  @Override
  public void FailEquipUnequipLightMagicBookTest(){
    assertNull(hero.getEquippedItem());
    hero.unequipItem();
    assertNull(hero.getEquippedItem());
    lightMagicBook.equipTo(hero);
    assertNull(hero.getEquippedItem());
    hero.addItem(lightMagicBook);
    lightMagicBook.equipTo(hero);
    assertNull(hero.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipSwordTest(){
    assertNull(hero.getEquippedItem());
    hero.unequipItem();
    assertNull(hero.getEquippedItem());
    sword.equipTo(hero);
    assertNull(hero.getEquippedItem());
    hero.addItem(sword);
    sword.equipTo(hero);
    assertNull(hero.getEquippedItem());
  }

  @Test
  @Override
  public void testAttackAlpaca() {
    Alpaca alpaca = getTargetAlpaca();
    hero.attack(alpaca);
    assertEquals(50, alpaca.getCurrentHitPoints(),1E-6);
    hero.addItem(spear);
    spear.equipTo(hero);
    hero.attack(alpaca);
    assertEquals(40, alpaca.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackFarArcher() {
    Archer archer2 = new Archer(50, 2, field.getCell(1,1));
    hero.addItem(spear);
    spear.equipTo(hero);
    Bow bow = new Bow("Bow",10,2,3);
    archer2.addItem(bow);
    bow.equipTo(archer2);
    hero.attack(archer2);
    //por el contraataque
    assertEquals(40,archer2.getCurrentHitPoints(),1E-6);
    assertEquals(40,hero.getCurrentHitPoints(),1E-6);
    Spear spear2 = new Spear("Spear",10,2,4);
    hero.addItem(spear2);
    spear2.equipTo(hero);
    archer2.moveTo(field.getCell(2,2));
    hero.attack(archer2);
    assertEquals(30,archer2.getCurrentHitPoints(),1E-6);
    assertEquals(40,hero.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackFarFighter() {
    Fighter figther = new Fighter(50, 2, field.getCell(1,1));
    hero.addItem(spear);
    spear.equipTo(hero);
    Axe axe2 = new Axe("Axe2",10,2,3);
    figther.addItem(axe2);
    axe2.equipTo(figther);
    hero.attack(figther);
    //por el contraataque
    assertEquals(50,figther.getCurrentHitPoints(),1E-6);
    assertEquals(35,hero.getCurrentHitPoints(),1E-6);
    Spear spear2 = new Spear("Spear",40,2,4);
    hero.addItem(spear2);
    spear2.equipTo(hero);
    figther.moveTo(field.getCell(2,2));
    hero.attack(figther);
    assertEquals(30,figther.getCurrentHitPoints(),1E-6);
    assertEquals(35,hero.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackFarHero() {
    Hero hero2 = new Hero(50, 2, field.getCell(1,1));
    hero.addItem(spear);
    spear.equipTo(hero);
    Spear spear3 = new Spear("Spear",10,2,3);
    hero2.addItem(spear3);
    spear3.equipTo(hero2);
    hero.attack(hero2);
    //por el contraataque
    assertEquals(40,hero2.getCurrentHitPoints(),1E-6);
    assertEquals(40,hero.getCurrentHitPoints(),1E-6);
    Spear spear2 = new Spear("Spear",10,2,4);
    hero.addItem(spear2);
    spear2.equipTo(hero);
    hero2.moveTo(field.getCell(2,2));
    hero.attack(hero2);
    assertEquals(30,hero2.getCurrentHitPoints(),1E-6);
    assertEquals(40,hero.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackFarSorcerer() {
    Sorcerer sorcerer = new Sorcerer(50, 2, field.getCell(1,1));
    hero.addItem(spear);
    spear.equipTo(hero);
    DarkMagicBook darkMagicBook = new DarkMagicBook("DarkMagicBook",10,2,3);
    sorcerer.addItem(darkMagicBook);
    darkMagicBook.equipTo(sorcerer);
    hero.attack(sorcerer);
    //por el contraataque
    assertEquals(35,sorcerer.getCurrentHitPoints(),1E-6);
    assertEquals(35,hero.getCurrentHitPoints(),1E-6);
    Spear spear2 = new Spear("Spear",10,2,4);
    hero.addItem(spear2);
    spear2.equipTo(hero);
    sorcerer.moveTo(field.getCell(2,2));
    hero.attack(sorcerer);
    assertEquals(20,sorcerer.getCurrentHitPoints(),1E-6);
    assertEquals(35,hero.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackFarSwordMaster() {
    SwordMaster swordMaster = new SwordMaster(50, 2, field.getCell(1,1));
    hero.addItem(spear);
    spear.equipTo(hero);
    Sword sword = new Sword("Sword",40,2,3);
    swordMaster.addItem(sword);
    sword.equipTo(swordMaster);
    hero.attack(swordMaster);
    //por el contraataque
    assertEquals(35,swordMaster.getCurrentHitPoints(),1E-6);
    assertEquals(30,hero.getCurrentHitPoints(),1E-6);
    Spear spear2 = new Spear("Spear",10,2,4);
    hero.addItem(spear2);
    spear2.equipTo(hero);
    swordMaster.moveTo(field.getCell(2,2));
    hero.attack(swordMaster);
    assertEquals(20,swordMaster.getCurrentHitPoints(),1E-6);
    assertEquals(30,hero.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackWithOutLife() {
    Hero hero = new Hero(5,2,field.getCell(1,1));
    Archer archer = new Archer(50,2,field.getCell(2,2));
    archer.addItem(bow);
    bow.equipTo(archer);
    hero.addItem(spear);
    spear.equipTo(hero);
    archer.attack(hero);
    assertEquals(0,hero.getCurrentHitPoints(),1E-6);
    hero.attack(archer);
    assertEquals(50,archer.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackDeadUnit() {
    Alpaca alpaca = getTargetAlpaca();
    hero.addItem(spear);
    spear.equipTo(hero);
    alpaca.setBigDamage(50);
    assertEquals(0,alpaca.getCurrentHitPoints());
    hero.attack(alpaca);
    assertEquals(0,alpaca.getCurrentHitPoints());
  }

  @Test
  @Override
  public void testAttackArcher() {
    Archer archer = new Archer(50, 2, field.getCell(1,1));
    hero.attack(archer);
    assertEquals(50, archer.getCurrentHitPoints(),1E-6);
    hero.addItem(spear);
    spear.equipTo(hero);
    hero.attack(archer);
    assertEquals(40, archer.getCurrentHitPoints(),1E-6);
    archer.addItem(bow);
    bow.equipTo(archer);
    archer.moveTo(field.getCell(1,1));
    hero.attack(archer);
    //por el contraataque
    assertEquals(30,archer.getCurrentHitPoints(),1E-6);
    assertEquals(40,hero.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackCleric() {
    Cleric cleric = new Cleric(50, 2, field.getCell(1,1));
    hero.attack(cleric);
    assertEquals(50, cleric.getCurrentHitPoints(),1E-6);
    hero.addItem(spear);
    spear.equipTo(hero);
    hero.attack(cleric);
    assertEquals(40, cleric.getCurrentHitPoints(),1E-6);
    assertEquals(50,hero.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackFighter() {
    Fighter fighter = new Fighter(50, 2, field.getCell(1,1));
    hero.attack(fighter);
    assertEquals(50, fighter.getCurrentHitPoints(),1E-6);
    hero.addItem(spear);
    spear.equipTo(hero);
    hero.attack(fighter);
    assertEquals(40, fighter.getCurrentHitPoints(),1E-6);
    fighter.addItem(axe);
    axe.equipTo(fighter);
    hero.attack(fighter);
    assertEquals(40,fighter.getCurrentHitPoints(),1E-6);
    assertEquals(35,hero.getCurrentHitPoints(),1E-6);
    Spear spear2 = new Spear("spear2",40,1,2);
    hero.addItem(spear2);
    spear2.equipTo(hero);
    assertEquals(spear2,hero.getEquippedItem());
    assertEquals(hero,spear2.getUser());
    assertNull(spear.getUser());
    hero.attack(fighter);
    assertEquals(20,fighter.getCurrentHitPoints(),1E-6);
    assertEquals(20,hero.getCurrentHitPoints(),1E-6);

  }

  @Test
  @Override
  public void testAttackHero() {
    Hero hero2 = new Hero(50, 2, field.getCell(1,1));
    hero.attack(hero2);
    assertEquals(50, hero2.getCurrentHitPoints(),1E-6);
    hero.addItem(spear);
    spear.equipTo(hero);
    hero.attack(hero2);
    assertEquals(40, hero2.getCurrentHitPoints(),1E-6);
    Spear spear2 = new Spear("spear2",10,1,2);
    hero2.addItem(spear2);
    spear2.equipTo(hero2);
    hero.attack(hero2);
    //por el contraataque
    assertEquals(30,hero2.getCurrentHitPoints(),1E-6);
    assertEquals(40,hero.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackDarkSorcerer() {
    Sorcerer sorcerer = new Sorcerer(50, 2, field.getCell(1,1));
    hero.attack(sorcerer);
    assertEquals(50, sorcerer.getCurrentHitPoints(),1E-6);
    hero.addItem(spear);
    spear.equipTo(hero);
    hero.attack(sorcerer);
    assertEquals(40, sorcerer.getCurrentHitPoints(),1E-6);
    sorcerer.addItem(darkMagicBook);
    darkMagicBook.equipTo(sorcerer);
    hero.attack(sorcerer);
    assertEquals(25,sorcerer.getCurrentHitPoints(),1E-6);
    assertEquals(35,hero.getCurrentHitPoints(),1E-6);
    hero.attack(sorcerer); //le quedan 10 de vida
    assertEquals(20,hero.getCurrentHitPoints(),1E-6);
    hero.attack(sorcerer); //la resta da -5
    assertEquals(0,sorcerer.getCurrentHitPoints(),1E-6);
    assertEquals(20,hero.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackLightSorcerer() {
    Sorcerer sorcerer = new Sorcerer(50, 2, field.getCell(1,1));
    hero.attack(sorcerer);
    assertEquals(50, sorcerer.getCurrentHitPoints(),1E-6);
    hero.addItem(spear);
    spear.equipTo(hero);
    hero.attack(sorcerer);
    assertEquals(40, sorcerer.getCurrentHitPoints(),1E-6);
    sorcerer.addItem(lightMagicBook);
    lightMagicBook.equipTo(sorcerer);
    hero.attack(sorcerer);
    assertEquals(25,sorcerer.getCurrentHitPoints(),1E-6);
    assertEquals(35,hero.getCurrentHitPoints(),1E-6);
    hero.attack(sorcerer); //le quedan 10 de vida
    assertEquals(20,hero.getCurrentHitPoints(),1E-6);
    hero.attack(sorcerer); //la resta da -5
    assertEquals(0,sorcerer.getCurrentHitPoints(),1E-6);
    assertEquals(20,hero.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackSpiritSorcerer() {
    Sorcerer sorcerer = new Sorcerer(50, 2, field.getCell(1,1));
    hero.attack(sorcerer);
    assertEquals(50, sorcerer.getCurrentHitPoints(),1E-6);
    hero.addItem(spear);
    spear.equipTo(hero);
    hero.attack(sorcerer);
    assertEquals(40, sorcerer.getCurrentHitPoints(),1E-6);
    sorcerer.addItem(spiritMagicBook);
    spiritMagicBook.equipTo(sorcerer);
    hero.attack(sorcerer);
    assertEquals(25,sorcerer.getCurrentHitPoints(),1E-6);
    assertEquals(35,hero.getCurrentHitPoints(),1E-6);
    hero.attack(sorcerer); //le quedan 10 de vida
    assertEquals(20,hero.getCurrentHitPoints(),1E-6);
    hero.attack(sorcerer); //la resta da -5
    assertEquals(0,sorcerer.getCurrentHitPoints(),1E-6);
    assertEquals(20,hero.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackSwordMaster() {
    SwordMaster swordMaster = new SwordMaster(50, 2, field.getCell(1,1));
    hero.attack(swordMaster);
    assertEquals(50, swordMaster.getCurrentHitPoints(),1E-6);
    hero.addItem(spear);
    spear.equipTo(hero);
    hero.attack(swordMaster);
    assertEquals(40, swordMaster.getCurrentHitPoints(),1E-6);
    swordMaster.addItem(sword);
    sword.equipTo(swordMaster);
    hero.attack(swordMaster);
    assertEquals(25,swordMaster.getCurrentHitPoints(),1E-6);
    assertEquals(50,hero.getCurrentHitPoints(),1E-6);
    hero.attack(swordMaster); //le quedan 10 de vida
    assertEquals(50,hero.getCurrentHitPoints(),1E-6);
    hero.attack(swordMaster); //la resta da -5
    assertEquals(0,swordMaster.getCurrentHitPoints(),1E-6);
    assertEquals(50,hero.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testIsHero(){
    assertTrue(getTestUnit().isHero());
  }
}