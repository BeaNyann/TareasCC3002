package model.units;


import model.items.*;
import model.map.Field;
import org.junit.jupiter.api.Test;

/**
 * Interface that defines the common behaviour of all the test for the units classes
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public interface ITestUnit {

  /**
   * Set up the game field
   */
  void setField();

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  void setTestUnit();

  void setTargetAlpaca();

  /**
   * Creates a set of testing weapons
   */
  void setWeapons();

  /**
   * Checks that the constructor works properly.
   */
  @Test
  void constructorTest();

  /**
   * @return the current unit being tested
   */
  IUnit getTestUnit();

  /**
   * Checks if the axe is equipped correctly to the unit
   */
  @Test
  void equipUnequipAxeTest();

  /**
   * Tries to equip a weapon to the alpaca and verifies that it was not equipped
   *
   * @param axe
   *     to be equipped
   */
  void checkEquippedAxe(Axe axe);

  void checkEquippedBow(Bow bow);

  void checkEquippedMagicBook(MagicBook magicbook);

  void checkEquippedSpear(Spear spear);

  void checkEquippedStaff(Staff staff);

  void checkEquippedSword(Sword sword);

  /**
   * @return the test axe
   */
  Axe getAxe();

  @Test
  void equipUnequipSwordTest();

  /**
   * @return the test sword
   */
  Sword getSword();

  @Test
  void equipUnequipSpearTest();

  /**
   * @return the test spear
   */
  Spear getSpear();

  @Test
  void equipUnequipStaffTest();

  /**
   * @return the test staff
   */
  Staff getStaff();

  @Test
  void equipUnequipBowTest();

  /**
   * @return the test bow
   */
  Bow getBow();

  @Test
  void equipUnequipMagicBookTest();

  MagicBook getMagicBook();

  @Test
  void FailEquipUnequipSpearTest();

  @Test
  void FailEquipUnequipMagicBookTest();

  @Test
  void FailEquipUnequipBowTest();

  @Test
  void FailEquipUnequipSwordTest();

  @Test
  void FailEquipUnequipStaffTest();

  @Test
  void FailEquipUnequipAxeTest();

  @Test
  void testGiveObj();

  @Test
  void testFarGiveObj();

  @Test
  void testGiveNotHavingObj();

  @Test
  void testRecieveNoSpaceObj();

  @Test
    void testReceiveObj();

  @Test
  void testAddRemoveObj();

  /**
   * Checks if the unit moves correctly
   */
  @Test
  void testMovement();

  /**
   * @return the test field
   */
  Field getField();

  /**
   * @return the target Alpaca
   */
  Alpaca getTargetAlpaca();

  @Test
  void testAttackAlpaca();
}


