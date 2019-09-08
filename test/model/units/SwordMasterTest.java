package model.units;

import model.items.Sword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test set for the Sword Master unit.
 *
 * @author Beatriz Graboloza
 * @since 1.0
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
  @Test
  @Override
  public void equipUnequipSwordTest() {
    assertNull(swordMaster.getEquippedItem());
    swordMaster.addItem(sword);
    sword.equipTo(swordMaster);
    assertEquals(sword, swordMaster.getEquippedItem());
    swordMaster.unequipItem();
    assertNull(swordMaster.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipSwordTest(){
    assertNull(swordMaster.getEquippedItem());
    swordMaster.unequipItem();
    assertNull(swordMaster.getEquippedItem());
    sword.equipTo(swordMaster);
    assertNull(swordMaster.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipBowTest(){
    assertNull(swordMaster.getEquippedItem());
    swordMaster.unequipItem();
    assertNull(swordMaster.getEquippedItem());
    bow.equipTo(swordMaster);
    assertNull(swordMaster.getEquippedItem());
    swordMaster.addItem(bow);
    bow.equipTo(swordMaster);
    assertNull(swordMaster.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipStaffTest(){
    assertNull(swordMaster.getEquippedItem());
    swordMaster.unequipItem();
    assertNull(swordMaster.getEquippedItem());
    staff.equipTo(swordMaster);
    assertNull(swordMaster.getEquippedItem());
    swordMaster.addItem(staff);
    staff.equipTo(swordMaster);
    assertNull(swordMaster.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipAxeTest(){
    assertNull(swordMaster.getEquippedItem());
    swordMaster.unequipItem();
    assertNull(swordMaster.getEquippedItem());
    axe.equipTo(swordMaster);
    assertNull(swordMaster.getEquippedItem());
    swordMaster.addItem(axe);
    axe.equipTo(swordMaster);
    assertNull(swordMaster.getEquippedItem());
  }

  @Override
  public void testRemoveEquippedObj() {
    swordMaster.addItem(sword);
    sword.equipTo(swordMaster);
    assertEquals(swordMaster,sword.getUser());
    assertEquals(sword,swordMaster.equippedItem);
    swordMaster.removeItem(sword);
    assertNull(swordMaster.getEquippedItem());
    assertNull(sword.getUser());
  }

  @Test
  @Override
  public void FailEquipUnequipSpearTest(){
    assertNull(swordMaster.getEquippedItem());
    swordMaster.unequipItem();
    assertNull(swordMaster.getEquippedItem());
    spear.equipTo(swordMaster);
    assertNull(swordMaster.getEquippedItem());
    swordMaster.addItem(spear);
    spear.equipTo(swordMaster);
    assertNull(swordMaster.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipDarkMagicBookTest(){
    assertNull(swordMaster.getEquippedItem());
    swordMaster.unequipItem();
    assertNull(swordMaster.getEquippedItem());
    darkMagicBook.equipTo(swordMaster);
    assertNull(swordMaster.getEquippedItem());
    swordMaster.addItem(darkMagicBook);
    darkMagicBook.equipTo(swordMaster);
    assertNull(swordMaster.getEquippedItem());
  }

  @Test
  @Override
  public void FailEquipUnequipLightMagicBookTest(){
    assertNull(swordMaster.getEquippedItem());
    swordMaster.unequipItem();
    assertNull(swordMaster.getEquippedItem());
    lightMagicBook.equipTo(swordMaster);
    assertNull(swordMaster.getEquippedItem());
    swordMaster.addItem(lightMagicBook);
    lightMagicBook.equipTo(swordMaster);
    assertNull(swordMaster.getEquippedItem());
  }

  @Test
  @Override
  public void FailEquipUnequipSpiritMagicBookTest(){
    assertNull(swordMaster.getEquippedItem());
    swordMaster.unequipItem();
    assertNull(swordMaster.getEquippedItem());
    spiritMagicBook.equipTo(swordMaster);
    assertNull(swordMaster.getEquippedItem());
    swordMaster.addItem(spiritMagicBook);
    spiritMagicBook.equipTo(swordMaster);
    assertNull(swordMaster.getEquippedItem());
  }

  @Test
  @Override
  public void testAttackAlpaca() {
    Alpaca alpaca = getTargetAlpaca();
    swordMaster.attack(alpaca);
    assertEquals(50, alpaca.getCurrentHitPoints(),1E-6);
    swordMaster.addItem(sword);
    sword.equipTo(swordMaster);
    swordMaster.attack(alpaca);
    assertEquals(40, alpaca.getCurrentHitPoints(),1E-6);
  }

  @Override
  public void testAttackFarArcher() {
    Archer archer = new Archer(50, 2, field.getCell(1,0));
    Sword sword2 = new Sword("Sword2",10,1,4);
    swordMaster.addItem(sword2);
    sword2.equipTo(swordMaster);
    archer.moveTo(field.getCell(1,1));
    archer.moveTo(field.getCell(2,2));
    swordMaster.attack(archer);
    assertEquals(40, archer.getCurrentHitPoints(),1E-6);
    assertEquals(50, swordMaster.getCurrentHitPoints(),1E-6);
  }

  @Override
  public void testAttackWithOutLife() {
    SwordMaster swordMaster = new SwordMaster(5,2,field.getCell(0,0));
    Archer archer = new Archer(50,2,field.getCell(1,1));
    archer.addItem(bow);
    bow.equipTo(archer);
    swordMaster.addItem(axe);
    axe.equipTo(swordMaster);
    archer.attack(swordMaster);
    assertEquals(0,swordMaster.getCurrentHitPoints(),1E-6);
    swordMaster.attack(archer);
    assertEquals(50,archer.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackArcher() {
    Archer archer = new Archer(50,2,field.getCell(1,0));
    swordMaster.attack(archer);
    assertEquals(50, archer.getCurrentHitPoints(),1E-6);
    swordMaster.addItem(sword);
    sword.equipTo(swordMaster);
    swordMaster.attack(archer);
    assertEquals(40, archer.getCurrentHitPoints(),1E-6);
    archer.addItem(bow);
    bow.equipTo(archer);
    archer.moveTo(field.getCell(1,1));
    swordMaster.attack(archer);
    assertEquals(30, archer.getCurrentHitPoints(),1E-6);
    assertEquals(40,swordMaster.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackCleric() {
    Cleric cleric = new Cleric(50,2,field.getCell(1,0));
    swordMaster.attack(cleric);
    assertEquals(50, cleric.getCurrentHitPoints(),1E-6);
    swordMaster.addItem(sword);
    sword.equipTo(swordMaster);
    swordMaster.attack(cleric);
    assertEquals(40, cleric.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackFighter() {
    Fighter fighter = new Fighter(50, 2, field.getCell(1,0));
    swordMaster.attack(fighter);
    assertEquals(50, fighter.getCurrentHitPoints(),1E-6);
    swordMaster.addItem(sword);
    sword.equipTo(swordMaster);
    swordMaster.attack(fighter);
    assertEquals(40, fighter.getCurrentHitPoints(),1E-6);
    fighter.addItem(axe);
    axe.equipTo(fighter);
    swordMaster.attack(fighter);
    assertEquals(25,fighter.getCurrentHitPoints(),1E-6);
    assertEquals(50,swordMaster.getCurrentHitPoints(),1E-6);
    swordMaster.attack(fighter); //le quedan 10 de vida
    assertEquals(50,swordMaster.getCurrentHitPoints(),1E-6);
    swordMaster.attack(fighter); //la resta da -5
    assertEquals(0,fighter.getCurrentHitPoints(),1E-6);
    assertEquals(50,swordMaster.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackHero() {
    Hero hero = new Hero(50, 2, field.getCell(1,0));
    swordMaster.attack(hero);
    assertEquals(50, hero.getCurrentHitPoints(),1E-6);
    swordMaster.addItem(sword);
    sword.equipTo(swordMaster);
    swordMaster.attack(hero);
    assertEquals(40, hero.getCurrentHitPoints(),1E-6);
    hero.addItem(spear);
    spear.equipTo(hero);
    swordMaster.attack(hero);
    assertEquals(35,swordMaster.getCurrentHitPoints(),1E-6);
    assertEquals(40,hero.getCurrentHitPoints(),1E-6);
    Sword sword2 = new Sword("sword2",40,1,2);
    swordMaster.addItem(sword2);
    sword2.equipTo(swordMaster);
    assertEquals(sword2,swordMaster.getEquippedItem());
    assertEquals(swordMaster,sword2.getUser());
    assertNull(sword.getUser());
    swordMaster.attack(hero);
    assertEquals(20,hero.getCurrentHitPoints(),1E-6);
    assertEquals(20,swordMaster.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackDarkSorcerer() {
    Sorcerer sorcerer = new Sorcerer(50, 2, field.getCell(1,0));
    swordMaster.attack(sorcerer);
    assertEquals(50, sorcerer.getCurrentHitPoints(),1E-6);
    swordMaster.addItem(sword);
    sword.equipTo(swordMaster);
    swordMaster.attack(sorcerer);
    assertEquals(40, sorcerer.getCurrentHitPoints(),1E-6);
    sorcerer.addItem(darkMagicBook);
    darkMagicBook.equipTo(sorcerer);
    swordMaster.attack(sorcerer);
    assertEquals(25,sorcerer.getCurrentHitPoints(),1E-6);
    assertEquals(35,swordMaster.getCurrentHitPoints(),1E-6);
    swordMaster.attack(sorcerer); //le quedan 10 de vida
    assertEquals(20,swordMaster.getCurrentHitPoints(),1E-6);
    swordMaster.attack(sorcerer); //la resta da -5
    assertEquals(0,sorcerer.getCurrentHitPoints(),1E-6);
    assertEquals(20,swordMaster.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackLightSorcerer() {
    Sorcerer sorcerer = new Sorcerer(50, 2, field.getCell(1,0));
    swordMaster.attack(sorcerer);
    assertEquals(50, sorcerer.getCurrentHitPoints(),1E-6);
    swordMaster.addItem(sword);
    sword.equipTo(swordMaster);
    swordMaster.attack(sorcerer);
    assertEquals(40, sorcerer.getCurrentHitPoints(),1E-6);
    sorcerer.addItem(lightMagicBook);
    lightMagicBook.equipTo(sorcerer);
    swordMaster.attack(sorcerer);
    assertEquals(25,sorcerer.getCurrentHitPoints(),1E-6);
    assertEquals(35,swordMaster.getCurrentHitPoints(),1E-6);
    swordMaster.attack(sorcerer); //le quedan 10 de vida
    assertEquals(20,swordMaster.getCurrentHitPoints(),1E-6);
    swordMaster.attack(sorcerer); //la resta da -5
    assertEquals(0,sorcerer.getCurrentHitPoints(),1E-6);
    assertEquals(20,swordMaster.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackSpiritSorcerer() {
    Sorcerer sorcerer = new Sorcerer(50, 2, field.getCell(1,0));
    swordMaster.attack(sorcerer);
    assertEquals(50, sorcerer.getCurrentHitPoints(),1E-6);
    swordMaster.addItem(sword);
    sword.equipTo(swordMaster);
    swordMaster.attack(sorcerer);
    assertEquals(40, sorcerer.getCurrentHitPoints(),1E-6);
    sorcerer.addItem(spiritMagicBook);
    spiritMagicBook.equipTo(sorcerer);
    swordMaster.attack(sorcerer);
    assertEquals(25,sorcerer.getCurrentHitPoints(),1E-6);
    assertEquals(35,swordMaster.getCurrentHitPoints(),1E-6);
    swordMaster.attack(sorcerer); //le quedan 10 de vida
    assertEquals(20,swordMaster.getCurrentHitPoints(),1E-6);
    swordMaster.attack(sorcerer); //la resta da -5
    assertEquals(0,sorcerer.getCurrentHitPoints(),1E-6);
    assertEquals(20,swordMaster.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackSwordMaster() {
    SwordMaster swordMaster2 = new SwordMaster(50,2,field.getCell(1,0));
    swordMaster.attack(swordMaster2);
    assertEquals(50, swordMaster2.getCurrentHitPoints(),1E-6);
    swordMaster.addItem(sword);
    sword.equipTo(swordMaster);
    swordMaster.attack(swordMaster2);
    assertEquals(40, swordMaster2.getCurrentHitPoints(),1E-6);
    Sword sword2 = new Sword("sword2",10,1,2);
    swordMaster2.addItem(sword2);
    sword2.equipTo(swordMaster2);
    swordMaster.attack(swordMaster2);
    //por el contraataque
    assertEquals(30,swordMaster2.getCurrentHitPoints(),1E-6);
    assertEquals(40,swordMaster.getCurrentHitPoints(),1E-6);
  }
}