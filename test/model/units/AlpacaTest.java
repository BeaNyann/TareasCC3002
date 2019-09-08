package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for the Alpaca unit.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public class AlpacaTest extends AbstractTestUnit {

  private Alpaca alpaca;

  @Override
  public void setTestUnit() {
    alpaca = new Alpaca(50, 2, field.getCell(0, 0));
  }

  @Override
  public Alpaca getTestUnit() {
    return alpaca;
  }

  @Override
  public void testRecieveNoSpaceObj() {}

  @Override
  public void testRemoveEquippedObj() {}

  @Test
  @Override
  public void testAttackArcher() {
    Archer archer = new Archer(50,2,field.getCell(0, 0));
    alpaca.attack(archer);
    assertEquals(50,archer.getCurrentHitPoints(),1E-6);
    assertEquals(50,alpaca.getCurrentHitPoints(),1E-6);
  }
  @Test
  @Override
  public void testAttackCleric() {
    Cleric cleric2 = new Cleric(50,2,field.getCell(0, 0));
    alpaca.attack(cleric2);
    assertEquals(50,cleric2.getCurrentHitPoints(),1E-6);
    assertEquals(50,alpaca.getCurrentHitPoints(),1E-6);

  }
  @Test
  @Override
  public void testAttackFighter() {
    Fighter fighter = new Fighter(50,2,field.getCell(0, 0));
    alpaca.attack(fighter);
    assertEquals(50,fighter.getCurrentHitPoints(),1E-6);
    assertEquals(50,alpaca.getCurrentHitPoints(),1E-6);
  }
  @Test
  @Override
  public void testAttackHero() {
    Hero hero = new Hero(50,2,field.getCell(0, 0));
    alpaca.attack(hero);
    assertEquals(50,hero.getCurrentHitPoints(),1E-6);
    assertEquals(50,alpaca.getCurrentHitPoints(),1E-6);
  }
  @Test
  @Override
  public void testAttackDarkSorcerer() {
    Sorcerer sorcerer = new Sorcerer(50,2,field.getCell(0, 0));
    sorcerer.addItem(darkMagicBook);
    darkMagicBook.equipTo(sorcerer);
    alpaca.attack(sorcerer);
    assertEquals(50,sorcerer.getCurrentHitPoints(),1E-6);
    assertEquals(50,alpaca.getCurrentHitPoints(),1E-6);
  }
  @Test
  @Override
  public void testAttackLightSorcerer() {
    Sorcerer sorcerer = new Sorcerer(50,2,field.getCell(0, 0));
    sorcerer.addItem(lightMagicBook);
    lightMagicBook.equipTo(sorcerer);
    alpaca.attack(sorcerer);
    assertEquals(50,sorcerer.getCurrentHitPoints(),1E-6);
    assertEquals(50,alpaca.getCurrentHitPoints(),1E-6);
  }
  @Test
  @Override
  public void testAttackSpiritSorcerer() {
    Sorcerer sorcerer = new Sorcerer(50,2,field.getCell(0, 0));
    sorcerer.addItem(spiritMagicBook);
    spiritMagicBook.equipTo(sorcerer);
    alpaca.attack(sorcerer);
    assertEquals(50,sorcerer.getCurrentHitPoints(),1E-6);
    assertEquals(50,alpaca.getCurrentHitPoints(),1E-6);
  }
  @Test
  @Override
  public void testAttackSwordMaster() {
    SwordMaster swordMaster = new SwordMaster(50,2,field.getCell(0, 0));
    alpaca.attack(swordMaster);
    assertEquals(50,swordMaster.getCurrentHitPoints(),1E-6);
    assertEquals(50,alpaca.getCurrentHitPoints(),1E-6);
  }
  @Test
  @Override
  public void testAttackAlpaca() {
    Alpaca alpaca = getTargetAlpaca();
    alpaca.attack(alpaca);
    assertEquals(50, alpaca.getCurrentHitPoints(),1E-6);
    assertEquals(50, alpaca.getCurrentHitPoints(),1E-6);
  }
  @Test
  @Override
  public void testAttackFarArcher() {
    Archer archer = new Archer(50, 2, field.getCell(1,0));
    archer.moveTo(field.getCell(1,1));
    archer.moveTo(field.getCell(2,2));
    alpaca.attack(archer);
    assertEquals(50, archer.getCurrentHitPoints(),1E-6);
    assertEquals(50, alpaca.getCurrentHitPoints(),1E-6);
  }

  @Test
  @Override
  public void testAttackWithOutLife() {
    Alpaca alpaca = new Alpaca(5,2,field.getCell(0,0));
    Hero hero = new Hero(50,2,field.getCell(1,0));
    hero.addItem(spear);
    spear.equipTo(hero);
    hero.attack(alpaca);
    assertEquals(0,alpaca.getCurrentHitPoints(),1E-6);
    alpaca.attack(hero);
    assertEquals(50,hero.getCurrentHitPoints(),1E-6);
  }

  @Override
  public void FailEquipUnequipSpearTest() {}

  @Override
  public void FailEquipUnequipDarkMagicBookTest() {}
  @Override
  public void FailEquipUnequipLightMagicBookTest() {}
  @Override
  public void FailEquipUnequipSpiritMagicBookTest() {}

  @Override
  public void FailEquipUnequipBowTest() {}

  @Override
  public void FailEquipUnequipSwordTest() {}

  @Override
  public void FailEquipUnequipStaffTest() {}

  @Override
  public void FailEquipUnequipAxeTest() {}


}