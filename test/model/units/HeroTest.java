package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.Spear;
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
    spear.equipTo(hero);
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
    spear.equipTo(hero);
    assertNull(hero.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipBowTest(){
    assertNull(hero.getEquippedItem());
    hero.unequipItem();
    assertNull(hero.getEquippedItem());
    bow.equipTo(hero);
    assertNull(hero.getEquippedItem());
    hero.addItem(bow);
    bow.equipTo(hero);
    assertNull(hero.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipStaffTest(){
    assertNull(hero.getEquippedItem());
    hero.unequipItem();
    assertNull(hero.getEquippedItem());
    staff.equipTo(hero);
    assertNull(hero.getEquippedItem());
    hero.addItem(staff);
    staff.equipTo(hero);
    assertNull(hero.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipAxeTest(){
    assertNull(hero.getEquippedItem());
    hero.unequipItem();
    assertNull(hero.getEquippedItem());
    axe.equipTo(hero);
    assertNull(hero.getEquippedItem());
    hero.addItem(axe);
    axe.equipTo(hero);
    assertNull(hero.getEquippedItem());
  }

  @Override
  public void testRemoveEquippedObj() {
    hero.addItem(spear);
    spear.equipTo(hero);
    assertEquals(hero,spear.getUser());
    assertEquals(spear,hero.equippedItem);
    hero.removeItem(spear);
    assertNull(hero.getEquippedItem());
    assertNull(spear.getUser());
  }

  @Test
  @Override
  public void FailEquipUnequipSpiritMagicBookTest(){
    assertNull(hero.getEquippedItem());
    hero.unequipItem();
    assertNull(hero.getEquippedItem());
    spiritMagicBook.equipTo(hero);
    assertNull(hero.getEquippedItem());
    hero.addItem(spiritMagicBook);
    spiritMagicBook.equipTo(hero);
    assertNull(hero.getEquippedItem());
  }

  @Test
  @Override
  public void FailEquipUnequipDarkMagicBookTest(){
    assertNull(hero.getEquippedItem());
    hero.unequipItem();
    assertNull(hero.getEquippedItem());
    darkMagicBook.equipTo(hero);
    assertNull(hero.getEquippedItem());
    hero.addItem(darkMagicBook);
    darkMagicBook.equipTo(hero);
    assertNull(hero.getEquippedItem());
  }

  @Test
  @Override
  public void FailEquipUnequipLightMagicBookTest(){
    assertNull(hero.getEquippedItem());
    hero.unequipItem();
    assertNull(hero.getEquippedItem());
    lightMagicBook.equipTo(hero);
    assertNull(hero.getEquippedItem());
    hero.addItem(lightMagicBook);
    lightMagicBook.equipTo(hero);
    assertNull(hero.getEquippedItem());
  }
  @Test
  @Override
  public void FailEquipUnequipSwordTest(){
    assertNull(hero.getEquippedItem());
    hero.unequipItem();
    assertNull(hero.getEquippedItem());
    sword.equipTo(hero);
    assertNull(hero.getEquippedItem());
    hero.addItem(sword);
    sword.equipTo(hero);
    assertNull(hero.getEquippedItem());
  }

  @Test
  @Override
  public void testAttackAlpaca() {
    Alpaca alpaca = getTargetAlpaca();
    hero.attack(alpaca);
    assertEquals(50, alpaca.getCurrentHitPoints());
    hero.addItem(spear);
    spear.equipTo(hero);
    hero.attack(alpaca);
    assertEquals(40, alpaca.getCurrentHitPoints());
  }

  @Test
  @Override
  public void testAttackArcher() {
    Archer archer = new Archer(50, 2, field.getCell(1,0));
    hero.attack(archer);
    assertEquals(50, archer.getCurrentHitPoints());
    hero.addItem(spear);
    spear.equipTo(hero);
    hero.attack(archer);
    assertEquals(40, archer.getCurrentHitPoints());
  }

  @Test
  @Override
  public void testAttackCleric() {
    Cleric cleric = new Cleric(50, 2, field.getCell(1,0));
    hero.attack(cleric);
    assertEquals(50, cleric.getCurrentHitPoints());
    hero.addItem(spear);
    spear.equipTo(hero);
    hero.attack(cleric);
    assertEquals(40, cleric.getCurrentHitPoints());
  }

  @Test
  @Override
  public void testAttackFighter() {
    Fighter fighter = new Fighter(50, 2, field.getCell(1,0));
    hero.attack(fighter);
    assertEquals(50, fighter.getCurrentHitPoints());
    hero.addItem(spear);
    spear.equipTo(hero);
    hero.attack(fighter);
    assertEquals(40, fighter.getCurrentHitPoints());
    fighter.addItem(axe);
    axe.equipTo(fighter);
    hero.attack(fighter);
    assertEquals(40,fighter.getCurrentHitPoints());
    Spear spear2 = new Spear("spear2",40,1,2);
    hero.addItem(spear2);
    spear2.equipTo(hero);
    assertEquals(spear2,hero.getEquippedItem());
    assertEquals(hero,spear2.getUser());
    assertNull(spear.getUser());
    hero.attack(fighter);
    assertEquals(20,fighter.getCurrentHitPoints());

  }

  @Test
  @Override
  public void testAttackHero() {
    Hero hero2 = new Hero(50, 2, field.getCell(1,0));
    hero.attack(hero2);
    assertEquals(50, hero2.getCurrentHitPoints());
    hero.addItem(spear);
    spear.equipTo(hero);
    hero.attack(hero2);
    assertEquals(40, hero2.getCurrentHitPoints());
  }

  @Test
  @Override
  public void testAttackDarkSorcerer() {
    Sorcerer sorcerer = new Sorcerer(50, 2, field.getCell(1,0));
    hero.attack(sorcerer);
    assertEquals(50, sorcerer.getCurrentHitPoints());
    hero.addItem(spear);
    spear.equipTo(hero);
    hero.attack(sorcerer);
    assertEquals(40, sorcerer.getCurrentHitPoints());
    sorcerer.addItem(darkMagicBook);
    darkMagicBook.equipTo(sorcerer);
    hero.attack(sorcerer);
    assertEquals(25,sorcerer.getCurrentHitPoints());
    hero.attack(sorcerer); //le quedan 10 de vida
    hero.attack(sorcerer); //la resta da -5
    assertEquals(0,sorcerer.getCurrentHitPoints());
  }

  @Test
  @Override
  public void testAttackLightSorcerer() {
    Sorcerer sorcerer = new Sorcerer(50, 2, field.getCell(1,0));
    hero.attack(sorcerer);
    assertEquals(50, sorcerer.getCurrentHitPoints());
    hero.addItem(spear);
    spear.equipTo(hero);
    hero.attack(sorcerer);
    assertEquals(40, sorcerer.getCurrentHitPoints());
    sorcerer.addItem(lightMagicBook);
    lightMagicBook.equipTo(sorcerer);
    hero.attack(sorcerer);
    assertEquals(25,sorcerer.getCurrentHitPoints());
    hero.attack(sorcerer); //le quedan 10 de vida
    hero.attack(sorcerer); //la resta da -5
    assertEquals(0,sorcerer.getCurrentHitPoints());
  }

  @Test
  @Override
  public void testAttackSpiritSorcerer() {
    Sorcerer sorcerer = new Sorcerer(50, 2, field.getCell(1,0));
    hero.attack(sorcerer);
    assertEquals(50, sorcerer.getCurrentHitPoints());
    hero.addItem(spear);
    spear.equipTo(hero);
    hero.attack(sorcerer);
    assertEquals(40, sorcerer.getCurrentHitPoints());
    sorcerer.addItem(spiritMagicBook);
    spiritMagicBook.equipTo(sorcerer);
    hero.attack(sorcerer);
    assertEquals(25,sorcerer.getCurrentHitPoints());
    hero.attack(sorcerer); //le quedan 10 de vida
    hero.attack(sorcerer); //la resta da -5
    assertEquals(0,sorcerer.getCurrentHitPoints());
  }

  @Test
  @Override
  public void testAttackSwordMaster() {
    SwordMaster swordMaster = new SwordMaster(50, 2, field.getCell(1,0));
    hero.attack(swordMaster);
    assertEquals(50, swordMaster.getCurrentHitPoints());
    hero.addItem(spear);
    spear.equipTo(hero);
    hero.attack(swordMaster);
    assertEquals(40, swordMaster.getCurrentHitPoints());
    swordMaster.addItem(sword);
    sword.equipTo(swordMaster);
    hero.attack(swordMaster);
    assertEquals(25,swordMaster.getCurrentHitPoints());
    hero.attack(swordMaster); //le quedan 10 de vida
    hero.attack(swordMaster); //la resta da -5
    assertEquals(0,swordMaster.getCurrentHitPoints());
  }
}