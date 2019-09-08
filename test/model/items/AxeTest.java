package model.items;

import model.map.Location;
import model.units.Fighter;
import model.units.IUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test set for the Axe item.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
class AxeTest extends AbstractTestItem {

  private Axe axe;
  private Axe wrongAxe;
  private Fighter fighter;

  /**
   * Sets up a correctly implemented axe that's going to be tested.
   */
  @Override
  public void setTestItem() {
    expectedName = "Common axe";
    expectedPower = 10;
    expectedMinRange = 1;
    expectedMaxRange = 2;
    axe = new Axe(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
  }

  /**
   * Sets up an axe with wrong ranges setted.
   */
  @Override
  public void setWrongRangeItem() {
    wrongAxe = new Axe("Wrong axe", 0, -1, -2);
  }

  /**
   * Sets the unit that will be equipped with the test axe.
   */
  @Override
  public void setTestUnit() {
    fighter = new Fighter(10, 5, new Location(0, 0));
  }

  /**
   * @return a wrong axe to test.
   */
  @Override
  public IEquipableItem getWrongTestItem() {
    return wrongAxe;
  }

  /**
   * @return the item being tested.
   */
  @Override
  public IEquipableItem getTestItem() {
    return axe;
  }

  /**
   * @return a unit that can equip the item being tested.
   */
  @Override
  public IUnit getTestUnit() {
    return fighter;
  }

  @Test
  @Override
  public void equippedToOverloadTest() {
    Fighter fighter2 = new Fighter(10, 5, new Location(0, 0));
    fighter2.addItem(axe);
    fighter.addItem(axe);
    assertTrue(fighter.getItems().isEmpty());
    axe.equipTo(fighter2);
    axe.equipTo(fighter);
    assertNull(fighter.getEquippedItem());
    assertEquals(fighter2,axe.getUser());
    assertEquals(axe,fighter2.getEquippedItem());
  }
}