package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.Staff;
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
    Staff staff2 = new Staff("staff2",10,1,2);
    cleric.addItem(staff2);
    staff.equipTo(cleric);
    staff2.equipTo(cleric);
    assertEquals(staff2,cleric.getEquippedItem());
    assertNull(staff.getUser());
    assertEquals(cleric,staff2.getUser());
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
  @Test
  @Override
  public void testAttackAlpaca() {
    Alpaca alpaca = getTargetAlpaca();
    cleric.addItem(staff);
    staff.equipTo(cleric);
    cleric.attack(alpaca);
    assertEquals(50,alpaca.getCurrentHitPoints(),1E-6);
    assertEquals(50,cleric.getCurrentHitPoints(),1E-6);
  }

  @Override
  public void testAttackFarArcher() {
    Archer archer = new Archer(50,2,field.getCell(1, 1));
    cleric.addItem(staff);
    staff.equipTo(cleric);
    cleric.attack(archer);
    assertEquals(50,archer.getCurrentHitPoints(),1E-6);
    assertEquals(50,cleric.getCurrentHitPoints(),1E-6);
  }
  @Test
  @Override
  public void testAttackWithOutLife() {
    Cleric cleric = new Cleric(5,2,field.getCell(0,0));
    Hero hero = new Hero(50,2,field.getCell(1,0));
    hero.addItem(spear);
    spear.equipTo(hero);
    cleric.addItem(staff);
    staff.equipTo(cleric);
    hero.attack(cleric);
    assertEquals(0,cleric.getCurrentHitPoints(),1E-6);
    cleric.attack(hero);
    assertEquals(50,hero.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackArcher() {
    Archer archer = new Archer(50,2,field.getCell(0, 1));
    cleric.addItem(staff);
    staff.equipTo(cleric);
    cleric.attack(archer);
    assertEquals(50,archer.getCurrentHitPoints(),1E-6);
    assertEquals(50,cleric.getCurrentHitPoints(),1E-6);
  }
  @Test
  @Override
  public void testAttackCleric() {
    Cleric cleric2 = new Cleric(50,2,field.getCell(0, 1));
    cleric.addItem(staff);
    staff.equipTo(cleric);
    cleric.attack(cleric2);
    assertEquals(50,cleric2.getCurrentHitPoints(),1E-6);
    assertEquals(50,cleric.getCurrentHitPoints(),1E-6);
  }
  @Test
  @Override
  public void testAttackFighter() {
    Fighter fighter = new Fighter(50,2,field.getCell(0, 1));
    cleric.addItem(staff);
    staff.equipTo(cleric);
    cleric.attack(fighter);
    assertEquals(50,fighter.getCurrentHitPoints(),1E-6);
    assertEquals(50,cleric.getCurrentHitPoints(),1E-6);
  }

  @Override
  public void testAttackHero() {
    Hero hero = new Hero(50,2,field.getCell(0, 1));
    cleric.addItem(staff);
    staff.equipTo(cleric);
    cleric.attack(hero);
    assertEquals(50,hero.getCurrentHitPoints(),1E-6);
    assertEquals(50,cleric.getCurrentHitPoints(),1E-6);
  }
  @Test
  @Override
  public void testAttackDarkSorcerer() {
    Sorcerer sorcerer = new Sorcerer(50,2,field.getCell(0, 1));
    sorcerer.addItem(darkMagicBook);
    darkMagicBook.equipTo(sorcerer);
    cleric.addItem(staff);
    staff.equipTo(cleric);
    cleric.attack(sorcerer);
    assertEquals(50,sorcerer.getCurrentHitPoints(),1E-6);
    assertEquals(50,cleric.getCurrentHitPoints(),1E-6);
  }

  @Override
  public void testAttackLightSorcerer() {
    Sorcerer sorcerer = new Sorcerer(50,2,field.getCell(0, 1));
    sorcerer.addItem(lightMagicBook);
    lightMagicBook.equipTo(sorcerer);
    cleric.addItem(staff);
    staff.equipTo(cleric);
    cleric.attack(sorcerer);
    assertEquals(50,sorcerer.getCurrentHitPoints(),1E-6);
    assertEquals(50,cleric.getCurrentHitPoints(),1E-6);
  }

  @Override
  public void testAttackSpiritSorcerer() {
    Sorcerer sorcerer = new Sorcerer(50,2,field.getCell(0, 1));
    sorcerer.addItem(spiritMagicBook);
    spiritMagicBook.equipTo(sorcerer);
    cleric.addItem(staff);
    staff.equipTo(cleric);
    cleric.attack(sorcerer);
    assertEquals(50,sorcerer.getCurrentHitPoints(),1E-6);
    assertEquals(50,cleric.getCurrentHitPoints(),1E-6);
  }

  @Override
  public void testAttackSwordMaster() {
    SwordMaster swordMaster = new SwordMaster(50,2,field.getCell(0, 1));
    cleric.addItem(staff);
    staff.equipTo(cleric);
    cleric.attack(swordMaster);
    assertEquals(50,swordMaster.getCurrentHitPoints(),1E-6);
    assertEquals(50,cleric.getCurrentHitPoints(),1E-6);
  }
}