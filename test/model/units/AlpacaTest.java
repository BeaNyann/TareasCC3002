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
  public void testAttackAlpaca() {}

  @Override
  public void FailEquipUnequipSpearTest() {}

  @Override
  public void FailEquipUnequipMagicBookTest() {}

  @Override
  public void FailEquipUnequipBowTest() {}

  @Override
  public void FailEquipUnequipSwordTest() {}

  @Override
  public void FailEquipUnequipStaffTest() {}

  @Override
  public void FailEquipUnequipAxeTest() {}
}