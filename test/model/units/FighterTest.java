package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * @author Beatriz Graboloza
 */
public class FighterTest extends AbstractTestUnit {

  private Fighter fighter;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    fighter = new Fighter(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return fighter;
  }

  /**
   * Checks if the axe is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipUnequipAxeTest() {
    assertNull(fighter.getEquippedItem());
    fighter.addItem(axe);
    axe.equipTo(fighter);
    assertEquals(axe, fighter.getEquippedItem());
    fighter.unequipItem();
    assertNull(fighter.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipAxeTest(){
    assertNull(fighter.getEquippedItem());
    fighter.unequipItem();
    assertNull(fighter.getEquippedItem());
    axe.equipTo(fighter);
    assertNull(fighter.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipBowTest(){
    assertNull(fighter.getEquippedItem());
    fighter.unequipItem();
    assertNull(fighter.getEquippedItem());
    bow.equipTo(fighter);
    assertNull(fighter.getEquippedItem());
    fighter.addItem(bow);
    bow.equipTo(fighter);
    assertNull(fighter.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipStaffTest(){
    assertNull(fighter.getEquippedItem());
    fighter.unequipItem();
    assertNull(fighter.getEquippedItem());
    staff.equipTo(fighter);
    assertNull(fighter.getEquippedItem());
    fighter.addItem(staff);
    staff.equipTo(fighter);
    assertNull(fighter.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipSpearTest(){
    assertNull(fighter.getEquippedItem());
    fighter.unequipItem();
    assertNull(fighter.getEquippedItem());
    spear.equipTo(fighter);
    assertNull(fighter.getEquippedItem());
    fighter.addItem(spear);
    spear.equipTo(fighter);
    assertNull(fighter.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipMagicBookTest(){
    assertNull(fighter.getEquippedItem());
    fighter.unequipItem();
    assertNull(fighter.getEquippedItem());
    magicbook.equipTo(fighter);
    assertNull(fighter.getEquippedItem());
    fighter.addItem(magicbook);
    magicbook.equipTo(fighter);
    assertNull(fighter.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipSwordTest(){
    assertNull(fighter.getEquippedItem());
    fighter.unequipItem();
    assertNull(fighter.getEquippedItem());
    sword.equipTo(fighter);
    assertNull(fighter.getEquippedItem());
    fighter.addItem(sword);
    sword.equipTo(fighter);
    assertNull(fighter.getEquippedItem());
  }

  @Test
  @Override
  public void testAttackAlpaca() {
    Alpaca alpaca = getTargetAlpaca();
    fighter.attack(alpaca);
    assertEquals(50, alpaca.getCurrentHitPoints());
    fighter.addItem(axe);
    axe.equipTo(fighter);
    fighter.attack(alpaca);
    assertEquals(40, alpaca.getCurrentHitPoints());
  }

  @Test
  @Override
  public void testAttackArcher() {
    Archer archer = new Archer(50, 2, field.getCell(1,0));
    fighter.attack(archer);
    assertEquals(50, archer.getCurrentHitPoints());
    fighter.addItem(axe);
    axe.equipTo(fighter);
    fighter.attack(archer);
    assertEquals(40, archer.getCurrentHitPoints());
  }

  @Test
  @Override
  public void testAttackCleric() {
    Cleric cleric = new Cleric(50, 2, field.getCell(1,0));
    fighter.attack(cleric);
    assertEquals(50, cleric.getCurrentHitPoints());
    fighter.addItem(axe);
    axe.equipTo(fighter);
    fighter.attack(cleric);
    assertEquals(40, cleric.getCurrentHitPoints());
  }

  @Test
  @Override
  public void testAttackFighter() {
    Fighter fighter2 = new Fighter(50, 2, field.getCell(1,0));
    fighter.attack(fighter2);
    assertEquals(50, fighter2.getCurrentHitPoints());
    fighter.addItem(axe);
    axe.equipTo(fighter);
    fighter.attack(fighter2);
    assertEquals(40, fighter2.getCurrentHitPoints());
  }

  @Test
  @Override
  public void testAttackHero() {
    Hero hero = new Hero(50, 2, field.getCell(1,0));
    fighter.attack(hero);
    assertEquals(50, hero.getCurrentHitPoints());
    fighter.addItem(axe);
    axe.equipTo(fighter);
    fighter.attack(hero);
    assertEquals(40, hero.getCurrentHitPoints());
    hero.addItem(spear);
    spear.equipTo(hero);
    fighter.attack(hero);
    assertEquals(25,hero.getCurrentHitPoints());
    //TODO siento que falta ver que pasa si le quito más de toda la vida que tiene
  }

  @Test
  @Override
  public void testAttackSorcerer() {
    Sorcerer sorcerer = new Sorcerer(50, 2, field.getCell(1,0));
    fighter.attack(sorcerer);
    assertEquals(50, sorcerer.getCurrentHitPoints());
    fighter.addItem(axe);
    axe.equipTo(fighter);
    fighter.attack(sorcerer);
    assertEquals(40, sorcerer.getCurrentHitPoints());
    sorcerer.addItem(magicbook);
    magicbook.equipTo(sorcerer);
    fighter.attack(sorcerer);
    assertEquals(25,sorcerer.getCurrentHitPoints());
    //TODO siento que falta ver que pasa si le quito más de toda la vida que tiene
  }

  @Test
  @Override
  public void testAttackSwordMaster() {
    SwordMaster swordMaster = new SwordMaster(50, 2, field.getCell(1,0));
    fighter.attack(swordMaster);
    assertEquals(50, swordMaster.getCurrentHitPoints());
    fighter.addItem(axe);
    axe.equipTo(fighter);
    fighter.attack(swordMaster);
    assertEquals(40, swordMaster.getCurrentHitPoints());
    swordMaster.addItem(sword);
    sword.equipTo(swordMaster);
    fighter.attack(swordMaster);
    assertEquals(40,swordMaster.getCurrentHitPoints());
    //TODO, darle ataque suficiente para que si haga algo
  }

}