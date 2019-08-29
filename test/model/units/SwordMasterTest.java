package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Beatriz Graboloza
 */
public class SwordMasterTest extends AbstractTestUnit {

  private SwordMaster swordMaster;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    swordMaster = new SwordMaster(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return swordMaster;
  }

  @Override
  public void equipUnequipSwordTest() {
    assertNull(swordMaster.getEquippedItem());
    swordMaster.addItem(sword);
    swordMaster.equipSword(sword);
    assertEquals(sword, swordMaster.getEquippedItem());
    swordMaster.unequipItem();
    assertNull(swordMaster.getEquippedItem());
  }

  @Override
  public void FailEquipUnequipSwordTest(){
    assertNull(swordMaster.getEquippedItem());
    swordMaster.unequipItem();
    assertNull(swordMaster.getEquippedItem());
    swordMaster.equipSword(sword);
    assertNull(swordMaster.getEquippedItem());
  }

  @Override
  public void FailEquipUnequipBowTest(){
    assertNull(swordMaster.getEquippedItem());
    swordMaster.unequipItem();
    assertNull(swordMaster.getEquippedItem());
    swordMaster.equipBow(bow);
    assertNull(swordMaster.getEquippedItem());
    swordMaster.addItem(bow);
    swordMaster.equipBow(bow);
    assertNull(swordMaster.getEquippedItem());
  }

  @Override
  public void FailEquipUnequipStaffTest(){
    assertNull(swordMaster.getEquippedItem());
    swordMaster.unequipItem();
    assertNull(swordMaster.getEquippedItem());
    swordMaster.equipStaff(staff);
    assertNull(swordMaster.getEquippedItem());
    swordMaster.addItem(staff);
    swordMaster.equipStaff(staff);
    assertNull(swordMaster.getEquippedItem());
  }

  @Override
  public void FailEquipUnequipAxeTest(){
    assertNull(swordMaster.getEquippedItem());
    swordMaster.unequipItem();
    assertNull(swordMaster.getEquippedItem());
    swordMaster.equipAxe(axe);
    assertNull(swordMaster.getEquippedItem());
    swordMaster.addItem(axe);
    swordMaster.equipAxe(axe);
    assertNull(swordMaster.getEquippedItem());
  }

  @Override
  public void FailEquipUnequipSpearTest(){
    assertNull(swordMaster.getEquippedItem());
    swordMaster.unequipItem();
    assertNull(swordMaster.getEquippedItem());
    swordMaster.equipSpear(spear);
    assertNull(swordMaster.getEquippedItem());
    swordMaster.addItem(spear);
    swordMaster.equipSpear(spear);
    assertNull(swordMaster.getEquippedItem());
  }

  @Override
  public void FailEquipUnequipMagicBookTest(){
    assertNull(swordMaster.getEquippedItem());
    swordMaster.unequipItem();
    assertNull(swordMaster.getEquippedItem());
    swordMaster.equipMagicBook(magicbook);
    assertNull(swordMaster.getEquippedItem());
    swordMaster.addItem(magicbook);
    swordMaster.equipMagicBook(magicbook);
    assertNull(swordMaster.getEquippedItem());
  }
}