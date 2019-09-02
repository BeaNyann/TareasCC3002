package model.items;

import model.map.Location;
import model.units.IUnit;
import model.units.SwordMaster;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for swords
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public class SwordTest extends AbstractTestItem {

  private Sword sword;
  private Sword wrongSword;
  private SwordMaster swordMaster;

  /**
   * Sets which item is going to be tested
   */
  @Override
  public void setTestItem() {
    expectedName = "Common sword";
    expectedPower = 10;
    expectedMinRange = 1;
    expectedMaxRange = 1;
    sword = new Sword(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
  }

  /**
   * Sets up an item with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongSword = new Sword("Wrong sword", 0, -1, -2);
  }

  /**
   * Sets the unit that will be equipped with the test item
   */
  @Override
  public void setTestUnit() {
    swordMaster = new SwordMaster(10, 5, new Location(0, 0));
  }

  @Override
  public IEquipableItem getWrongTestItem() {
    return wrongSword;
  }

  /**
   * @return the item being tested
   */
  @Override
  public IEquipableItem getTestItem() {
    return sword;
  }

  /**
   * @return a unit that can equip the item being tested
   */
  @Override
  public IUnit getTestUnit() {
    return swordMaster;
  }

  @Test
  @Override
  public void equippedToOverloadTest() {
    SwordMaster swordMaster2 = new SwordMaster(10, 5, new Location(0, 0));
    swordMaster2.addItem(sword);
    swordMaster.addItem(sword);
    assertTrue(swordMaster.getItems().isEmpty());
    sword.equipTo(swordMaster2);
    sword.equipTo(swordMaster);
    assertNull(swordMaster.getEquippedItem());
    assertEquals(swordMaster2,sword.getUser());
    assertEquals(sword,swordMaster2.getEquippedItem());
  }
}
