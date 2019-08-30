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
    archer.equipBow(bow);
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
    archer.equipBow(bow);
    assertNull(archer.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipStaffTest(){
    assertNull(archer.getEquippedItem());
    archer.unequipItem();
    assertNull(archer.getEquippedItem());
    archer.equipStaff(staff);
    assertNull(archer.getEquippedItem());
    archer.addItem(staff);
    archer.equipStaff(staff);
    assertNull(archer.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipAxeTest(){
    assertNull(archer.getEquippedItem());
    archer.unequipItem();
    assertNull(archer.getEquippedItem());
    archer.equipAxe(axe);
    assertNull(archer.getEquippedItem());
    archer.addItem(axe);
    archer.equipAxe(axe);
    assertNull(archer.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipSpearTest(){
    assertNull(archer.getEquippedItem());
    archer.unequipItem();
    assertNull(archer.getEquippedItem());
    archer.equipSpear(spear);
    assertNull(archer.getEquippedItem());
    archer.addItem(spear);
    archer.equipSpear(spear);
    assertNull(archer.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipMagicBookTest(){
    assertNull(archer.getEquippedItem());
    archer.unequipItem();
    assertNull(archer.getEquippedItem());
    archer.equipMagicBook(magicbook);
    assertNull(archer.getEquippedItem());
    archer.addItem(magicbook);
    archer.equipMagicBook(magicbook);
    assertNull(archer.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipSwordTest(){
    assertNull(archer.getEquippedItem());
    archer.unequipItem();
    assertNull(archer.getEquippedItem());
    archer.equipSword(sword);
    assertNull(archer.getEquippedItem());
    archer.addItem(sword);
    archer.equipSword(sword);
    assertNull(archer.getEquippedItem());
  }

  @Test
  @Override
  public void testAttackAlpaca() {
    Alpaca alpaca = getTargetAlpaca();
    archer.attack(alpaca);
    assertEquals(50, alpaca.getCurrentHitPoints());
    archer.addItem(bow);
    archer.equipBow(bow);
    archer.attack(alpaca);
    assertEquals(50, alpaca.getCurrentHitPoints());
    archer.moveTo(field.getCell(0,1));
    archer.attack(alpaca);
    assertEquals(40, alpaca.getCurrentHitPoints());
  }

}