package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import model.items.*;
import model.map.Field;
import model.map.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines some common methods for all the unit tests.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public abstract class AbstractTestUnit implements ITestUnit {

  protected Alpaca targetAlpaca;
  protected Bow bow;
  protected Field field;
  protected Axe axe;
  protected Sword sword;
  protected Staff staff;
  protected Spear spear;
  protected DarkMagicBook darkMagicBook;
  protected LightMagicBook lightMagicBook;
  protected SpiritMagicBook spiritMagicBook;

  @Override
  public void setTargetAlpaca() {
    targetAlpaca = new Alpaca(50, 2, field.getCell(1, 0));
  }

  /**
   * Sets up the units and weapons to be tested
   */
  @BeforeEach
  public void setUp() {
    setField();
    setTestUnit();
    setTargetAlpaca();
    setWeapons();
  }

  /**
   * Set up the game field
   */
  @Override
  public void setField() {
    this.field = new Field();
    this.field.addCells(true, new Location(0, 0), new Location(0, 1), new Location(0, 2),
            new Location(1, 0), new Location(1, 1), new Location(1, 2), new Location(2, 0),
            new Location(2, 1), new Location(2, 2));
  }

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public abstract void setTestUnit();

  /**
   * Creates a set of testing weapons
   */
  @Override
  public void setWeapons() {
    this.axe = new Axe("Axe", 10, 1, 2);
    this.sword = new Sword("Sword", 10, 1, 2);
    this.spear = new Spear("Spear", 10, 1, 2);
    this.staff = new Staff("Staff", 10, 1, 2);
    this.bow = new Bow("Bow", 10, 2, 3);
    this.darkMagicBook = new DarkMagicBook("DarkMagicBook", 10, 1, 2);
    this.lightMagicBook = new LightMagicBook("LightMagicBook", 10, 1, 2);
    this.spiritMagicBook = new SpiritMagicBook("SpiritMagicBook", 10, 1, 2);
  }

  /**
   * Checks that the constructor works properly.
   */
  @Override
  @Test
  public void constructorTest() {
    assertEquals(50, getTestUnit().getMaxHitPoints());
    assertEquals(getTestUnit().getMaxHitPoints(), getTestUnit().getCurrentHitPoints(), 1E-6);
    assertEquals(2, getTestUnit().getMovement());
    assertEquals(new Location(0, 0), getTestUnit().getLocation());
    assertTrue(getTestUnit().getItems().isEmpty());
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public abstract IUnit getTestUnit();

  /**
   * Tries to equip a weapon to the alpaca and verifies that it was not equipped
   *
   * @param axe to be equipped
   */
  @Override
  public void checkEquippedAxe(Axe axe) {
    assertNull(getTestUnit().getEquippedItem());
    getTestUnit().equipAxe(axe);
    assertNull(getTestUnit().getEquippedItem());
  }

  @Override
  public void checkEquippedBow(Bow bow) {
    assertNull(getTestUnit().getEquippedItem());
    getTestUnit().equipBow(bow);
    assertNull(getTestUnit().getEquippedItem());
  }

  @Override
  public void checkEquippedDarkMagicBook(DarkMagicBook darkMagicBook) {
    assertNull(getTestUnit().getEquippedItem());
    getTestUnit().equipDarkMagicBook(darkMagicBook);
    assertNull(getTestUnit().getEquippedItem());
  }

  @Override
  public void checkEquippedLightMagicBook(LightMagicBook lightMagicBook) {
    assertNull(getTestUnit().getEquippedItem());
    getTestUnit().equipLightMagicBook(lightMagicBook);
    assertNull(getTestUnit().getEquippedItem());
  }

  @Override
  public void checkEquippedSpiritMagicBook(SpiritMagicBook spiritMagicBook) {
    assertNull(getTestUnit().getEquippedItem());
    getTestUnit().equipSpiritMagicBook(spiritMagicBook);
    assertNull(getTestUnit().getEquippedItem());
  }

  @Override
  public void checkEquippedSpear(Spear spear) {
    assertNull(getTestUnit().getEquippedItem());
    getTestUnit().equipSpear(spear);
    assertNull(getTestUnit().getEquippedItem());
  }

  @Override
  public void checkEquippedStaff(Staff staff) {
    assertNull(getTestUnit().getEquippedItem());
    getTestUnit().equipStaff(staff);
    assertNull(getTestUnit().getEquippedItem());
  }

  @Override
  public void checkEquippedSword(Sword sword) {
    assertNull(getTestUnit().getEquippedItem());
    getTestUnit().equipSword(sword);
    assertNull(getTestUnit().getEquippedItem());
  }

  /**
   * Checks if the axe is equipped correctly to the unit
   */
  @Override
  @Test
  public void equipUnequipAxeTest() {
    checkEquippedAxe(getAxe());
  }

  /**
   * @return the test axe
   */
  @Override
  public Axe getAxe() {
    return axe;
  }

  @Override
  @Test
  public void equipUnequipSwordTest() {
    checkEquippedSword(getSword());
  }

  /**
   * @return the test sword
   */
  @Override
  public Sword getSword() {
    return sword;
  }

  @Override
  @Test
  public void equipUnequipSpearTest() {
    checkEquippedSpear(getSpear());
  }

  /**
   * @return the test spear
   */
  @Override
  public Spear getSpear() {
    return spear;
  }

  @Override
  @Test
  public void equipUnequipStaffTest() {
    checkEquippedStaff(getStaff());
  }

  /**
   * @return the test staff
   */
  @Override
  public Staff getStaff() {
    return staff;
  }

  @Override
  @Test
  public void equipUnequipBowTest() {
    checkEquippedBow(getBow());
  }

  /**
   * @return the test bow
   */
  @Override
  public Bow getBow() {
    return bow;
  }

  @Override
  @Test
  public void equipUnequipDarkMagicBookTest() {
    checkEquippedDarkMagicBook(getDarkMagicBook());
  }

  @Override
  @Test
  public void equipUnequipLightMagicBookTest() {
    checkEquippedLightMagicBook(getLightMagicBook());
  }

  @Override
  @Test
  public void equipUnequipSpiritMagicBookTest() {
    checkEquippedSpiritMagicBook(getSpiritMagicBook());
  }

  /**
   * @return the test magicbook
   */
  @Override
  public DarkMagicBook getDarkMagicBook() {
    return darkMagicBook;
  }

  @Override
  public LightMagicBook getLightMagicBook() {
    return lightMagicBook;
  }

  @Override
  public SpiritMagicBook getSpiritMagicBook() {
    return spiritMagicBook;
  }

  @Override
  @Test
  public void testGiveObj() {
    IUnit unit = getTestUnit();
    IUnit unit2 = new Archer(50, 2, field.getCell(0, 1), bow);
    unit2.giveObj(unit, bow);
    assertTrue(unit2.getItems().isEmpty());
    assertEquals(bow, unit.getItems().get(0));
  }

  @Override
  @Test
  public void testFarGiveObj() {
    IUnit unit = getTestUnit();
    IUnit unit2 = new Archer(50, 2, field.getCell(1, 1), bow);
    unit2.giveObj(unit, bow);
    assertTrue(unit.getItems().isEmpty());
    assertEquals(bow, unit2.getItems().get(0));
  }

  @Override
  @Test
  public void testGiveNotHavingObj() {
    IUnit unit = getTestUnit();
    IUnit unit2 = new Archer(50, 2, field.getCell(0, 1));
    unit2.giveObj(unit, bow);
    assertTrue(unit.getItems().isEmpty());
    assertTrue(unit2.getItems().isEmpty());
  }

  @Override
  @Test
  public void testRecieveNoSpaceObj() {
    IUnit unit = getTestUnit();
    unit.addItem(staff);
    unit.addItem(axe);
    unit.addItem(spear);
    IUnit unit2 = new Archer(50, 2, field.getCell(0, 1), bow);
    unit2.giveObj(unit, bow);
    assertEquals(bow, unit2.getItems().get(0));
    List<IEquipableItem> list = new ArrayList<>();
    list.add(staff);
    list.add(axe);
    list.add(spear);
    assertEquals(list, unit.getItems());
  }

  @Override
  @Test
  public void testReceiveObj() {
    IUnit unit = getTestUnit();
    boolean X = unit.receiveObj(bow);
    assertEquals(bow, unit.getItems().get(0));
    assertTrue(X);
  }

  @Override
  @Test
  public void testAddRemoveObj() {
    IUnit unit = getTestUnit();
    assertTrue(unit.getItems().isEmpty());
    unit.addItem(bow);
    assertEquals(bow, unit.getItems().get(0));
    unit.removeItem(axe);
    assertEquals(bow, unit.getItems().get(0));
    unit.removeItem(bow);
    assertTrue(unit.getItems().isEmpty());
  }

  /**
   * Checks if the unit moves correctly.
   */
  @Override
  @Test
  public void testMovement() {
    getTestUnit().moveTo(getField().getCell(2, 2));
    assertEquals(field.getCell(0, 0), getTestUnit().getLocation());

    getTestUnit().moveTo(getField().getCell(0, 2));
    assertEquals(field.getCell(0, 2), getTestUnit().getLocation());
    assertNull(getField().getCell(0, 0).getUnit());

    getField().getCell(0, 1).setUnit(getTargetAlpaca());
    getTestUnit().moveTo(getField().getCell(0, 1));
    assertEquals(field.getCell(0, 2), getTestUnit().getLocation());
  }

  /**
   * @return the test field
   */
  @Override
  public Field getField() {
    return field;
  }

  /**
   * @return the target Alpaca
   */
  @Override
  public Alpaca getTargetAlpaca() {
    return targetAlpaca;
  }

  @Test
  @Override
  public void testHealUnit() {
    IUnit unit = getTestUnit();
    Cleric cleric = new Cleric(50, 2, field.getCell(0, 1));
    cleric.addItem(staff);
    staff.equipTo(cleric);
    cleric.attack(unit);
    assertEquals(50, unit.getCurrentHitPoints());
    //no debería darle más vida de la que ya tiene
    unit.setBigDamage(10);
    //recibió 15 de daño
    assertEquals(35, unit.getCurrentHitPoints());
    cleric.moveTo(field.getCell(1,2));
    cleric.attack(unit);
    assertEquals(35, unit.getCurrentHitPoints());
    cleric.moveTo(field.getCell(0,1));
    cleric.attack(unit);
    //recupera 10
    assertEquals(45, unit.getCurrentHitPoints());
    unit.setBigDamage(30);
    //se queda sin vida
    cleric.attack(unit);
    assertEquals(0, unit.getCurrentHitPoints());
    //no se puede revivir :C
  }
}//TODO fail counter attack
