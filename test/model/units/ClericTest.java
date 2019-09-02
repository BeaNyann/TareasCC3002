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

  @Test
  @Override
  public void equipUnequipStaffTest() {
    assertNull(cleric.getEquippedItem());
    cleric.addItem(staff);
    staff.equipTo(cleric);
    assertEquals(staff, cleric.getEquippedItem());
    cleric.unequipItem();
    assertNull(cleric.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipBowTest(){
    assertNull(cleric.getEquippedItem());
    cleric.unequipItem();
    assertNull(cleric.getEquippedItem());
    bow.equipTo(cleric);
    assertNull(cleric.getEquippedItem());
    cleric.addItem(bow);
    bow.equipTo(cleric);
    assertNull(cleric.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipStaffTest(){
    assertNull(cleric.getEquippedItem());
    cleric.unequipItem();
    assertNull(cleric.getEquippedItem());
    staff.equipTo(cleric);
    assertNull(cleric.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipAxeTest(){
    assertNull(cleric.getEquippedItem());
    cleric.unequipItem();
    assertNull(cleric.getEquippedItem());
    axe.equipTo(cleric);
    assertNull(cleric.getEquippedItem());
    cleric.addItem(axe);
    axe.equipTo(cleric);
    assertNull(cleric.getEquippedItem());
  }

  @Test
  @Override
  public void testRemoveEquippedObj() {
    cleric.addItem(staff);
    staff.equipTo(cleric);
    assertEquals(cleric,staff.getUser());
    assertEquals(staff,cleric.equippedItem);
    cleric.removeItem(staff);
    assertNull(cleric.getEquippedItem());
    assertNull(staff.getUser());
  }

  @Test
  @Override
  public void FailEquipUnequipSpearTest(){
    assertNull(cleric.getEquippedItem());
    cleric.unequipItem();
    assertNull(cleric.getEquippedItem());
    spear.equipTo(cleric);
    assertNull(cleric.getEquippedItem());
    cleric.addItem(spear);
    spear.equipTo(cleric);
    assertNull(cleric.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipDarkMagicBookTest(){
    assertNull(cleric.getEquippedItem());
    cleric.unequipItem();
    assertNull(cleric.getEquippedItem());
    darkMagicBook.equipTo(cleric);
    assertNull(cleric.getEquippedItem());
    cleric.addItem(darkMagicBook);
    darkMagicBook.equipTo(cleric);
    assertNull(cleric.getEquippedItem());
  }

  @Test
  @Override
  public void FailEquipUnequipLightMagicBookTest(){
    assertNull(cleric.getEquippedItem());
    cleric.unequipItem();
    assertNull(cleric.getEquippedItem());
    lightMagicBook.equipTo(cleric);
    assertNull(cleric.getEquippedItem());
    cleric.addItem(lightMagicBook);
    lightMagicBook.equipTo(cleric);
    assertNull(cleric.getEquippedItem());
  }

  @Test
  @Override
  public void FailEquipUnequipSpiritMagicBookTest(){
    assertNull(cleric.getEquippedItem());
    cleric.unequipItem();
    assertNull(cleric.getEquippedItem());
    spiritMagicBook.equipTo(cleric);
    assertNull(cleric.getEquippedItem());
    cleric.addItem(spiritMagicBook);
    spiritMagicBook.equipTo(cleric);
    assertNull(cleric.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipSwordTest(){
    assertNull(cleric.getEquippedItem());
    cleric.unequipItem();
    assertNull(cleric.getEquippedItem());
    sword.equipTo(cleric);
    assertNull(cleric.getEquippedItem());
    cleric.addItem(sword);
    sword.equipTo(cleric);
    assertNull(cleric.getEquippedItem());
  }

  @Override
  public void testAttackAlpaca() {}

  @Override
  public void testAttackArcher() {}

  @Override
  public void testAttackCleric() {}

  @Override
  public void testAttackFighter() {}

  @Override
  public void testAttackHero() {}

  @Override
  public void testAttackDarkSorcerer() {}

  @Override
  public void testAttackLightSorcerer() {}

  @Override
  public void testAttackSpiritSorcerer() {}

  @Override
  public void testAttackSwordMaster() {}

}