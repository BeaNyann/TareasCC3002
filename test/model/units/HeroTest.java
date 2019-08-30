package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * @author Beatriz Graboloza
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
    hero.equipSpear(spear);
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
    hero.equipSpear(spear);
    assertNull(hero.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipBowTest(){
    assertNull(hero.getEquippedItem());
    hero.unequipItem();
    assertNull(hero.getEquippedItem());
    hero.equipBow(bow);
    assertNull(hero.getEquippedItem());
    hero.addItem(bow);
    hero.equipBow(bow);
    assertNull(hero.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipStaffTest(){
    assertNull(hero.getEquippedItem());
    hero.unequipItem();
    assertNull(hero.getEquippedItem());
    hero.equipStaff(staff);
    assertNull(hero.getEquippedItem());
    hero.addItem(staff);
    hero.equipStaff(staff);
    assertNull(hero.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipAxeTest(){
    assertNull(hero.getEquippedItem());
    hero.unequipItem();
    assertNull(hero.getEquippedItem());
    hero.equipAxe(axe);
    assertNull(hero.getEquippedItem());
    hero.addItem(axe);
    hero.equipAxe(axe);
    assertNull(hero.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipMagicBookTest(){
    assertNull(hero.getEquippedItem());
    hero.unequipItem();
    assertNull(hero.getEquippedItem());
    hero.equipMagicBook(magicbook);
    assertNull(hero.getEquippedItem());
    hero.addItem(magicbook);
    hero.equipMagicBook(magicbook);
    assertNull(hero.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipSwordTest(){
    assertNull(hero.getEquippedItem());
    hero.unequipItem();
    assertNull(hero.getEquippedItem());
    hero.equipSword(sword);
    assertNull(hero.getEquippedItem());
    hero.addItem(sword);
    hero.equipSword(sword);
    assertNull(hero.getEquippedItem());
  }

  @Test
  @Override
  public void testAttackAlpaca() {
    Alpaca alpaca = getTargetAlpaca();
    hero.attack(alpaca);
    assertEquals(50, alpaca.getCurrentHitPoints());
    hero.addItem(spear);
    hero.equipSpear(spear);
    hero.attack(alpaca);
    assertEquals(40, alpaca.getCurrentHitPoints());
  }
}