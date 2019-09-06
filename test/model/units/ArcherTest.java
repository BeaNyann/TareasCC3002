package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.Bow;
import org.junit.jupiter.api.Test;

/**
 * Test set for the Archer unit.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public class ArcherTest extends AbstractTestUnit {

  private Archer archer;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    archer = new Archer(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return archer;
  }

  /**
   * Checks if the bow is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipUnequipBowTest() {
    assertNull(archer.getEquippedItem());
    archer.addItem(bow);
    bow.equipTo(archer);
    assertEquals(bow, archer.getEquippedItem());
    archer.unequipItem();
    assertNull(archer.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipBowTest(){
    assertNull(archer.getEquippedItem());
    archer.unequipItem();
    assertNull(archer.getEquippedItem());
    bow.equipTo(archer);
    assertNull(archer.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipStaffTest(){
    assertNull(archer.getEquippedItem());
    archer.unequipItem();
    assertNull(archer.getEquippedItem());
    staff.equipTo(archer);
    assertNull(archer.getEquippedItem());
    archer.addItem(staff);
    staff.equipTo(archer);
    assertNull(archer.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipAxeTest(){
    assertNull(archer.getEquippedItem());
    archer.unequipItem();
    assertNull(archer.getEquippedItem());
    axe.equipTo(archer);
    assertNull(archer.getEquippedItem());
    archer.addItem(axe);
    axe.equipTo(archer);
    assertNull(archer.getEquippedItem());
  }

  @Test
  @Override
  public void testRemoveEquippedObj() {
    archer.addItem(bow);
    bow.equipTo(archer);
    assertEquals(archer,bow.getUser());
    assertEquals(bow,archer.equippedItem);
    archer.removeItem(bow);
    assertNull(archer.getEquippedItem());
    assertNull(bow.getUser());
  }

  @Test
  @Override
  public void FailEquipUnequipSpearTest(){
    assertNull(archer.getEquippedItem());
    archer.unequipItem();
    assertNull(archer.getEquippedItem());
    spear.equipTo(archer);
    assertNull(archer.getEquippedItem());
    archer.addItem(spear);
    spear.equipTo(archer);
    assertNull(archer.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipDarkMagicBookTest(){
    assertNull(archer.getEquippedItem());
    archer.unequipItem();
    assertNull(archer.getEquippedItem());
    darkMagicBook.equipTo(archer);
    assertNull(archer.getEquippedItem());
    archer.addItem(darkMagicBook);
    darkMagicBook.equipTo(archer);
    assertNull(archer.getEquippedItem());
  }

  @Test
  @Override
  public void FailEquipUnequipLightMagicBookTest(){
    assertNull(archer.getEquippedItem());
    archer.unequipItem();
    assertNull(archer.getEquippedItem());
    lightMagicBook.equipTo(archer);
    assertNull(archer.getEquippedItem());
    archer.addItem(lightMagicBook);
    lightMagicBook.equipTo(archer);
    assertNull(archer.getEquippedItem());
  }

  @Test
  @Override
  public void FailEquipUnequipSpiritMagicBookTest(){
    assertNull(archer.getEquippedItem());
    archer.unequipItem();
    assertNull(archer.getEquippedItem());
    spiritMagicBook.equipTo(archer);
    assertNull(archer.getEquippedItem());
    archer.addItem(spiritMagicBook);
    spiritMagicBook.equipTo(archer);
    assertNull(archer.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipSwordTest(){
    assertNull(archer.getEquippedItem());
    archer.unequipItem();
    assertNull(archer.getEquippedItem());
    sword.equipTo(archer);
    assertNull(archer.getEquippedItem());
    archer.addItem(sword);
    sword.equipTo(archer);
    assertNull(archer.getEquippedItem());
  }

  @Test
  @Override
  public void testAttackAlpaca() {
    Alpaca alpaca = getTargetAlpaca();
    archer.attack(alpaca);
    assertEquals(50, alpaca.getCurrentHitPoints(),1E-6);
    archer.addItem(bow);
    bow.equipTo(archer);
    archer.attack(alpaca);
    assertEquals(50, alpaca.getCurrentHitPoints(),1E-6);
    archer.moveTo(field.getCell(0,1));
    archer.attack(alpaca);
    assertEquals(40, alpaca.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackArcher() {
    Archer archer2 = new Archer(50, 2, field.getCell(1,0));
    archer.attack(archer2);
    assertEquals(50, archer2.getCurrentHitPoints(),1E-6);
    archer.addItem(bow);
    bow.equipTo(archer);
    archer.attack(archer2);
    assertEquals(50, archer2.getCurrentHitPoints(),1E-6);
    archer.moveTo(field.getCell(0,1));
    archer.attack(archer2);
    assertEquals(40, archer2.getCurrentHitPoints(),1E-6);
    Bow bow2 = new Bow("Bow2",10,2,3);
    archer2.addItem(bow2);
    bow2.equipTo(archer2);
    archer.attack(archer2);
    //por el contraataque
    assertEquals(30,archer2.getCurrentHitPoints(),1E-6);
    assertEquals(40,archer.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackFarArcher() {
    Archer archer2 = new Archer(50, 2, field.getCell(1,0));
    archer.addItem(bow);
    bow.equipTo(archer);
    archer.moveTo(field.getCell(0,1));
    Bow bow2 = new Bow("Bow2",10,2,3);
    archer2.addItem(bow2);
    bow2.equipTo(archer2);
    archer.attack(archer2);
    //por el contraataque
    assertEquals(40,archer2.getCurrentHitPoints(),1E-6);
    assertEquals(40,archer.getCurrentHitPoints(),1E-6);
    Bow bow3 = new Bow("Bow3",10,2,4);
    archer.addItem(bow3);
    bow3.equipTo(archer);
    archer.moveTo(field.getCell(0,0));
    archer2.moveTo(field.getCell(1,1));
    archer2.moveTo(field.getCell(2,2));
    archer.attack(archer2);
    assertEquals(30,archer2.getCurrentHitPoints(),1E-6);
    assertEquals(40,archer.getCurrentHitPoints(),1E-6);

  }
  @Test
  @Override
  public void testAttackWithOutLife() {
    Archer archer = new Archer(5,2,field.getCell(0,0));
    Hero hero = new Hero(50,2,field.getCell(1,1));
    hero.addItem(spear);
    spear.equipTo(hero);
    archer.addItem(bow);
    bow.equipTo(archer);
    hero.attack(archer);
    assertEquals(0,archer.getCurrentHitPoints(),1E-6);
    archer.attack(hero);
    assertEquals(50,hero.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackCleric() {
    Cleric cleric = new Cleric(50, 2, field.getCell(1,0));
    archer.attack(cleric);
    assertEquals(50, cleric.getCurrentHitPoints(),1E-6);
    archer.addItem(bow);
    bow.equipTo(archer);
    archer.attack(cleric);
    assertEquals(50, cleric.getCurrentHitPoints(),1E-6);
    archer.moveTo(field.getCell(0,1));
    archer.attack(cleric);
    assertEquals(40, cleric.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackFighter() {
    Fighter fighter = new Fighter(50, 2, field.getCell(1,0));
    archer.attack(fighter);
    assertEquals(50, fighter.getCurrentHitPoints(),1E-6);
    archer.addItem(bow);
    bow.equipTo(archer);
    archer.attack(fighter);
    assertEquals(50, fighter.getCurrentHitPoints(),1E-6);
    archer.moveTo(field.getCell(0,1));
    archer.attack(fighter);
    assertEquals(40, fighter.getCurrentHitPoints(),1E-6);
    fighter.addItem(axe);
    axe.equipTo(fighter);
    archer.attack(fighter);
    //por el contraataque
    assertEquals(30,fighter.getCurrentHitPoints(),1E-6);
    assertEquals(40,archer.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackHero() {
    Hero hero = new Hero(50, 2, field.getCell(1, 0));
    archer.attack(hero);
    assertEquals(50, hero.getCurrentHitPoints(),1E-6);
    archer.addItem(bow);
    bow.equipTo(archer);
    archer.attack(hero);
    assertEquals(50, hero.getCurrentHitPoints(),1E-6);
    archer.moveTo(field.getCell(0, 1));
    archer.attack(hero);
    assertEquals(40, hero.getCurrentHitPoints(),1E-6);
    hero.addItem(spear);
    spear.equipTo(hero);
    archer.attack(hero);
    //por el contraataque
    assertEquals(30,hero.getCurrentHitPoints(),1E-6);
    assertEquals(40,archer.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackDarkSorcerer() {
    Sorcerer sorcerer = new Sorcerer(50, 2, field.getCell(1,0));
    archer.attack(sorcerer);
    assertEquals(50, sorcerer.getCurrentHitPoints(),1E-6);
    archer.addItem(bow);
    bow.equipTo(archer);
    archer.attack(sorcerer);
    assertEquals(50, sorcerer.getCurrentHitPoints(),1E-6);
    archer.moveTo(field.getCell(0,1));
    archer.attack(sorcerer);
    assertEquals(40, sorcerer.getCurrentHitPoints(),1E-6);
    sorcerer.addItem(darkMagicBook);
    darkMagicBook.equipTo(sorcerer);
    archer.attack(sorcerer);
    assertEquals(25, sorcerer.getCurrentHitPoints(),1E-6);
    assertEquals(35, archer.getCurrentHitPoints(),1E-6);
    archer.attack(sorcerer); //le quedan 10 de vida
    assertEquals(20, archer.getCurrentHitPoints(),1E-6);
    archer.attack(sorcerer); //la resta da -5
    assertEquals(20, archer.getCurrentHitPoints(),1E-6);
    assertEquals(0,sorcerer.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackLightSorcerer() {
    Sorcerer sorcerer = new Sorcerer(50, 2, field.getCell(1,0));
    archer.attack(sorcerer);
    assertEquals(50, sorcerer.getCurrentHitPoints(),1E-6);
    archer.addItem(bow);
    bow.equipTo(archer);
    archer.attack(sorcerer);
    assertEquals(50, sorcerer.getCurrentHitPoints(),1E-6);
    archer.moveTo(field.getCell(0,1));
    archer.attack(sorcerer);
    assertEquals(40, sorcerer.getCurrentHitPoints(),1E-6);
    sorcerer.addItem(lightMagicBook);
    lightMagicBook.equipTo(sorcerer);
    archer.attack(sorcerer);
    assertEquals(25, sorcerer.getCurrentHitPoints(),1E-6);
    assertEquals(35, archer.getCurrentHitPoints(),1E-6);
    archer.attack(sorcerer); //le quedan 10 de vida
    assertEquals(20, archer.getCurrentHitPoints(),1E-6);
    archer.attack(sorcerer); //la resta da -5
    assertEquals(0,sorcerer.getCurrentHitPoints(),1E-6);
    assertEquals(20, archer.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackSpiritSorcerer() {
    Sorcerer sorcerer = new Sorcerer(50, 2, field.getCell(1,0));
    archer.attack(sorcerer);
    assertEquals(50, sorcerer.getCurrentHitPoints(),1E-6);
    archer.addItem(bow);
    bow.equipTo(archer);
    archer.attack(sorcerer);
    assertEquals(50, sorcerer.getCurrentHitPoints(),1E-6);
    archer.moveTo(field.getCell(0,1));
    archer.attack(sorcerer);
    assertEquals(40, sorcerer.getCurrentHitPoints(),1E-6);
    sorcerer.addItem(spiritMagicBook);
    spiritMagicBook.equipTo(sorcerer);
    archer.attack(sorcerer);
    assertEquals(25, sorcerer.getCurrentHitPoints(),1E-6);
    assertEquals(35, archer.getCurrentHitPoints(),1E-6);
    archer.attack(sorcerer); //le quedan 10 de vida
    assertEquals(20, archer.getCurrentHitPoints(),1E-6);
    archer.attack(sorcerer); //la resta da -5
    assertEquals(0,sorcerer.getCurrentHitPoints(),1E-6);
    assertEquals(20, archer.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackSwordMaster() {
    SwordMaster swordMaster = new SwordMaster(50, 2, field.getCell(1,0));
    archer.attack(swordMaster);
    assertEquals(50, swordMaster.getCurrentHitPoints(),1E-6);
    archer.addItem(bow);
    bow.equipTo(archer);
    archer.attack(swordMaster);
    assertEquals(50, swordMaster.getCurrentHitPoints(),1E-6);
    archer.moveTo(field.getCell(0,1));
    archer.attack(swordMaster);
    assertEquals(40, swordMaster.getCurrentHitPoints(),1E-6);
    swordMaster.addItem(sword);
    sword.equipTo(swordMaster);
    archer.attack(swordMaster);
    //por el contraataque
    assertEquals(30,swordMaster.getCurrentHitPoints(),1E-6);
    assertEquals(40,archer.getCurrentHitPoints(),1E-6);
  }
}