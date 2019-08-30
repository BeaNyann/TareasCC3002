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
    fighter.equipAxe(axe);
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
    fighter.equipAxe(axe);
    assertNull(fighter.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipBowTest(){
    assertNull(fighter.getEquippedItem());
    fighter.unequipItem();
    assertNull(fighter.getEquippedItem());
    fighter.equipBow(bow);
    assertNull(fighter.getEquippedItem());
    fighter.addItem(bow);
    fighter.equipBow(bow);
    assertNull(fighter.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipStaffTest(){
    assertNull(fighter.getEquippedItem());
    fighter.unequipItem();
    assertNull(fighter.getEquippedItem());
    fighter.equipStaff(staff);
    assertNull(fighter.getEquippedItem());
    fighter.addItem(staff);
    fighter.equipStaff(staff);
    assertNull(fighter.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipSpearTest(){
    assertNull(fighter.getEquippedItem());
    fighter.unequipItem();
    assertNull(fighter.getEquippedItem());
    fighter.equipSpear(spear);
    assertNull(fighter.getEquippedItem());
    fighter.addItem(spear);
    fighter.equipSpear(spear);
    assertNull(fighter.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipMagicBookTest(){
    assertNull(fighter.getEquippedItem());
    fighter.unequipItem();
    assertNull(fighter.getEquippedItem());
    fighter.equipMagicBook(magicbook);
    assertNull(fighter.getEquippedItem());
    fighter.addItem(magicbook);
    fighter.equipMagicBook(magicbook);
    assertNull(fighter.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipSwordTest(){
    assertNull(fighter.getEquippedItem());
    fighter.unequipItem();
    assertNull(fighter.getEquippedItem());
    fighter.equipSword(sword);
    assertNull(fighter.getEquippedItem());
    fighter.addItem(sword);
    fighter.equipSword(sword);
    assertNull(fighter.getEquippedItem());
  }

  @Test
  @Override
  public void testAttackAlpaca() {
    Alpaca alpaca = getTargetAlpaca();
    fighter.attack(alpaca);
    assertEquals(50, alpaca.getCurrentHitPoints());
    fighter.addItem(axe);
    fighter.equipAxe(axe);
    fighter.attack(alpaca);
    assertEquals(40, alpaca.getCurrentHitPoints());
  }

  @Test
  @Override
  public void testAttackArcher() {
//TODO this
  }

  @Test
  @Override
  public void testAttackCleric() {

  }

  @Test
  @Override
  public void testAttackFighter() {

  }

  @Test
  @Override
  public void testAttackHero() {

  }

  @Test
  @Override
  public void testAttackSorcerer() {

  }

  @Test
  @Override
  public void testAttackSwordMaster() {

  }

}