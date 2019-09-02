package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.Axe;
import model.items.Spear;
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
  public void testRemoveEquippedObj() {
    fighter.addItem(axe);
    axe.equipTo(fighter);
    assertEquals(fighter,axe.getOwner());
    assertEquals(axe,fighter.equippedItem);
    fighter.removeItem(axe);
    assertNull(fighter.getEquippedItem());
    assertNull(axe.getOwner());
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
  public void FailEquipUnequipDarkMagicBookTest(){
    assertNull(fighter.getEquippedItem());
    fighter.unequipItem();
    assertNull(fighter.getEquippedItem());
    darkMagicBook.equipTo(fighter);
    assertNull(fighter.getEquippedItem());
    fighter.addItem(darkMagicBook);
    darkMagicBook.equipTo(fighter);
    assertNull(fighter.getEquippedItem());
  }

  @Test
  @Override
  public void FailEquipUnequipLightMagicBookTest(){
    assertNull(fighter.getEquippedItem());
    fighter.unequipItem();
    assertNull(fighter.getEquippedItem());
    lightMagicBook.equipTo(fighter);
    assertNull(fighter.getEquippedItem());
    fighter.addItem(lightMagicBook);
    lightMagicBook.equipTo(fighter);
    assertNull(fighter.getEquippedItem());
  }

  @Test
  @Override
  public void FailEquipUnequipSpiritMagicBookTest(){
    assertNull(fighter.getEquippedItem());
    fighter.unequipItem();
    assertNull(fighter.getEquippedItem());
    spiritMagicBook.equipTo(fighter);
    assertNull(fighter.getEquippedItem());
    fighter.addItem(spiritMagicBook);
    spiritMagicBook.equipTo(fighter);
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
    fighter.attack(hero); //le quedan 10 de vida
    fighter.attack(hero); //la resta da -5
    assertEquals(0,hero.getCurrentHitPoints());
  }

  @Test
  @Override
  public void testAttackDarkSorcerer() {
    Sorcerer sorcerer = new Sorcerer(50, 2, field.getCell(1,0));
    fighter.attack(sorcerer);
    assertEquals(50, sorcerer.getCurrentHitPoints());
    fighter.addItem(axe);
    axe.equipTo(fighter);
    fighter.attack(sorcerer);
    assertEquals(40, sorcerer.getCurrentHitPoints());
    sorcerer.addItem(darkMagicBook);
    darkMagicBook.equipTo(sorcerer);
    fighter.attack(sorcerer);
    assertEquals(25,sorcerer.getCurrentHitPoints());
    fighter.attack(sorcerer); //le quedan 10 de vida
    fighter.attack(sorcerer); //la resta da -5
    assertEquals(0,sorcerer.getCurrentHitPoints());
  }
  @Test
  @Override
  public void testAttackLightSorcerer() {
    Sorcerer sorcerer = new Sorcerer(50, 2, field.getCell(1,0));
    fighter.attack(sorcerer);
    assertEquals(50, sorcerer.getCurrentHitPoints());
    fighter.addItem(axe);
    axe.equipTo(fighter);
    fighter.attack(sorcerer);
    assertEquals(40, sorcerer.getCurrentHitPoints());
    sorcerer.addItem(lightMagicBook);
    lightMagicBook.equipTo(sorcerer);
    fighter.attack(sorcerer);
    assertEquals(25,sorcerer.getCurrentHitPoints());
    fighter.attack(sorcerer); //le quedan 10 de vida
    fighter.attack(sorcerer); //la resta da -5
    assertEquals(0,sorcerer.getCurrentHitPoints());
  }

  @Test
  @Override
  public void testAttackSpiritSorcerer() {
    Sorcerer sorcerer = new Sorcerer(50, 2, field.getCell(1,0));
    fighter.attack(sorcerer);
    assertEquals(50, sorcerer.getCurrentHitPoints());
    fighter.addItem(axe);
    axe.equipTo(fighter);
    fighter.attack(sorcerer);
    assertEquals(40, sorcerer.getCurrentHitPoints());
    sorcerer.addItem(spiritMagicBook);
    spiritMagicBook.equipTo(sorcerer);
    fighter.attack(sorcerer);
    assertEquals(25,sorcerer.getCurrentHitPoints());
    fighter.attack(sorcerer); //le quedan 10 de vida
    fighter.attack(sorcerer); //la resta da -5
    assertEquals(0,sorcerer.getCurrentHitPoints());
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
    Axe axe2 = new Axe("axe2",40,1,2);
    fighter.addItem(axe2);
    axe2.equipTo(fighter);
    assertEquals(axe2,fighter.getEquippedItem());
    assertEquals(fighter,axe2.getOwner());
    assertNull(axe.getOwner());
    fighter.attack(swordMaster);
    assertEquals(20,swordMaster.getCurrentHitPoints());
  }

}