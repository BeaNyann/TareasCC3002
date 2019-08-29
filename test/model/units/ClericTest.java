package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * @author Beatriz Graboloza
 */
public class ClericTest extends AbstractTestUnit {

  private Cleric cleric;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    cleric = new Cleric(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return cleric;
  }


  @Override
  public void equipUnequipStaffTest() {
    assertNull(cleric.getEquippedItem());
    cleric.addItem(staff);
    cleric.equipStaff(staff);
    assertEquals(staff, cleric.getEquippedItem());
    cleric.unequipItem();
    assertNull(cleric.getEquippedItem());
  }

  @Override
  public void FailEquipUnequipBowTest(){
    assertNull(cleric.getEquippedItem());
    cleric.unequipItem();
    assertNull(cleric.getEquippedItem());
    cleric.equipBow(bow);
    assertNull(cleric.getEquippedItem());
    cleric.addItem(bow);
    cleric.equipBow(bow);
    assertNull(cleric.getEquippedItem());
  }


  @Override
  public void FailEquipUnequipStaffTest(){
    assertNull(cleric.getEquippedItem());
    cleric.unequipItem();
    assertNull(cleric.getEquippedItem());
    cleric.equipStaff(staff);
    assertNull(cleric.getEquippedItem());
  }

  @Override
  public void FailEquipUnequipAxeTest(){
    assertNull(cleric.getEquippedItem());
    cleric.unequipItem();
    assertNull(cleric.getEquippedItem());
    cleric.equipAxe(axe);
    assertNull(cleric.getEquippedItem());
    cleric.addItem(axe);
    cleric.equipAxe(axe);
    assertNull(cleric.getEquippedItem());
  }

  @Override
  public void FailEquipUnequipSpearTest(){
    assertNull(cleric.getEquippedItem());
    cleric.unequipItem();
    assertNull(cleric.getEquippedItem());
    cleric.equipSpear(spear);
    assertNull(cleric.getEquippedItem());
    cleric.addItem(spear);
    cleric.equipSpear(spear);
    assertNull(cleric.getEquippedItem());
  }

  @Override
  public void FailEquipUnequipMagicBookTest(){
    assertNull(cleric.getEquippedItem());
    cleric.unequipItem();
    assertNull(cleric.getEquippedItem());
    cleric.equipMagicBook(magicbook);
    assertNull(cleric.getEquippedItem());
    cleric.addItem(magicbook);
    cleric.equipMagicBook(magicbook);
    assertNull(cleric.getEquippedItem());
  }

  @Override
  public void FailEquipUnequipSwordTest(){
    assertNull(cleric.getEquippedItem());
    cleric.unequipItem();
    assertNull(cleric.getEquippedItem());
    cleric.equipSword(sword);
    assertNull(cleric.getEquippedItem());
    cleric.addItem(sword);
    cleric.equipSword(sword);
    assertNull(cleric.getEquippedItem());
  }
}