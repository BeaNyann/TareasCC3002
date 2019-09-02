package model.units;

/**
 * Test set for the alpaca unit
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

  @Override
  public void testAttackAlpaca() {}

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