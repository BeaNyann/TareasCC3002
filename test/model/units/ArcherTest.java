package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.map.Location;
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
    assertEquals(archer,bow.getOwner());
    assertEquals(bow,archer.equippedItem);
    archer.removeItem(bow);
    assertNull(archer.getEquippedItem());
    assertNull(bow.getOwner());
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
  public void FailEquipUnequipMagicBookTest(){
    assertNull(archer.getEquippedItem());
    archer.unequipItem();
    assertNull(archer.getEquippedItem());
    magicbook.equipTo(archer);
    assertNull(archer.getEquippedItem());
    archer.addItem(magicbook);
    magicbook.equipTo(archer);
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
    assertEquals(50, alpaca.getCurrentHitPoints());
    archer.addItem(bow);
    bow.equipTo(archer);
    archer.attack(alpaca);
    assertEquals(50, alpaca.getCurrentHitPoints());
    archer.moveTo(field.getCell(0,1));
    archer.attack(alpaca);
    assertEquals(40, alpaca.getCurrentHitPoints());
  }

  @Test
  @Override
  public void testAttackArcher() {
    Archer archer2 = new Archer(50, 2, field.getCell(1,0));
    archer.attack(archer2);
    assertEquals(50, archer2.getCurrentHitPoints());
    archer.addItem(bow);
    bow.equipTo(archer);
    archer.attack(archer2);
    assertEquals(50, archer2.getCurrentHitPoints());
    archer.moveTo(field.getCell(0,1));
    archer.attack(archer2);
    assertEquals(40, archer2.getCurrentHitPoints());
  }

  @Test
  @Override
  public void testAttackCleric() {
    Cleric cleric = new Cleric(50, 2, field.getCell(1,0));
    archer.attack(cleric);
    assertEquals(50, cleric.getCurrentHitPoints());
    archer.addItem(bow);
    bow.equipTo(archer);
    archer.attack(cleric);
    assertEquals(50, cleric.getCurrentHitPoints());
    archer.moveTo(field.getCell(0,1));
    archer.attack(cleric);
    assertEquals(40, cleric.getCurrentHitPoints());
  }

  @Test
  @Override
  public void testAttackFighter() {
    Fighter fighter = new Fighter(50, 2, field.getCell(1,0));
    archer.attack(fighter);
    assertEquals(50, fighter.getCurrentHitPoints());
    archer.addItem(bow);
    bow.equipTo(archer);
    archer.attack(fighter);
    assertEquals(50, fighter.getCurrentHitPoints());
    archer.moveTo(field.getCell(0,1));
    archer.attack(fighter);
    assertEquals(40, fighter.getCurrentHitPoints());
  }

  @Test
  @Override
  public void testAttackHero() {
    Hero hero = new Hero(50, 2, field.getCell(1,0));
    archer.attack(hero);
    assertEquals(50, hero.getCurrentHitPoints());
    archer.addItem(bow);
    bow.equipTo(archer);
    archer.attack(hero);
    assertEquals(50, hero.getCurrentHitPoints());
    archer.moveTo(field.getCell(0,1));
    archer.attack(hero);
    assertEquals(40, hero.getCurrentHitPoints());
  }

  @Test
  @Override
  public void testAttackSorcerer() {
    Sorcerer sorcerer = new Sorcerer(50, 2, field.getCell(1,0));
    archer.attack(sorcerer);
    assertEquals(50, sorcerer.getCurrentHitPoints());
    archer.addItem(bow);
    bow.equipTo(archer);
    archer.attack(sorcerer);
    assertEquals(50, sorcerer.getCurrentHitPoints());
    archer.moveTo(field.getCell(0,1));
    archer.attack(sorcerer);
    assertEquals(40, sorcerer.getCurrentHitPoints());
    sorcerer.addItem(magicbook);
    magicbook.equipTo(sorcerer);
    archer.attack(sorcerer);
    assertEquals(25, sorcerer.getCurrentHitPoints());
    archer.attack(sorcerer); //le quedan 10 de vida
    archer.attack(sorcerer); //la resta da -5
    assertEquals(0,sorcerer.getCurrentHitPoints());
  }

  @Test
  @Override
  public void testAttackSwordMaster() {
    SwordMaster swordMaster = new SwordMaster(50, 2, field.getCell(1,0));
    archer.attack(swordMaster);
    assertEquals(50, swordMaster.getCurrentHitPoints());
    archer.addItem(bow);
    bow.equipTo(archer);
    archer.attack(swordMaster);
    assertEquals(50, swordMaster.getCurrentHitPoints());
    archer.moveTo(field.getCell(0,1));
    archer.attack(swordMaster);
    assertEquals(40, swordMaster.getCurrentHitPoints());
  }
}