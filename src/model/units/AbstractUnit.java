package model.units;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.items.*;
import model.map.Location;

/**
 * This class represents an abstract unit.
 * <p>
 * An abstract unit is a unit that cannot be used in the
 * game, but that contains the implementation of some of the methods that are common for most
 * units.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public abstract class AbstractUnit implements IUnit {

  private final int maxItems;
  protected List<IEquipableItem> items = new ArrayList<>();
  private double currentHitPoints;
  private final double MaxHitPoints;
  private final int movement;
  protected IEquipableItem equippedItem;
  private Location location;

  /**
   * Creates a new Unit.
   *
   * @param hitPoints the maximum amount of damage a unit can sustain.
   * @param movement  the number of panels a unit can move.
   * @param location  the current position of this unit on the map.
   * @param maxItems  maximum amount of items this unit can carry.
   */
  protected AbstractUnit(final int hitPoints, final int movement,
                         final Location location, final int maxItems, final IEquipableItem... items) {
    this.MaxHitPoints = hitPoints;
    this.currentHitPoints = this.MaxHitPoints;
    this.movement = movement;
    this.location = location;
    location.setUnit(this);
    this.items.addAll(Arrays.asList(items).subList(0, min(maxItems, items.length)));
    this.maxItems = maxItems;
  }

  /**
   * @return current hit points of the unit.
   */
  @Override
  public double getCurrentHitPoints() {
    return currentHitPoints;
  }

  /**
   * @return the maximum hit points of the unit.
   */
  @Override
  public double getMaxHitPoints() {
    return MaxHitPoints;
  }

  /**
   * @return the items carried by this unit.
   */
  @Override
  public List<IEquipableItem> getItems() {
    return List.copyOf(items);
  }

  /**
   * @return the currently equipped item.
   */
  @Override
  public IEquipableItem getEquippedItem() {
    return equippedItem;
  }

  /**
   * Unequip the item to the unit.
   */
  @Override
  public void unequipItem() {
    if(getEquippedItem()!= null){
      getEquippedItem().setUser(null);
      equippedItem = null;
    }
  }

  /**
   * @return the current location of the unit.
   */
  @Override
  public Location getLocation() {
    return location;
  }

  /**
   * Sets a new location for this unit.
   *
   * @param location the location where the unit will be set.
   */
  @Override
  public void setLocation(final Location location) {
    this.location = location;
  }

  /**
   * @return the number of cells this unit can move.
   */
  @Override
  public int getMovement() {
    return movement;
  }

  /**
   * Moves this unit to another location.
   * <p>
   * If the other location is out of this unit's movement range, the unit doesn't move.
   *
   * @param targetLocation the location where to move the unit.
   */
  @Override
  public void moveTo(final Location targetLocation) {
    if (getLocation().distanceTo(targetLocation) <= getMovement()
            && targetLocation.getUnit() == null) {
      getLocation().removeUnit();
      setLocation(targetLocation);
      targetLocation.setUnit(this);
    }
  }

  /**
   * Equip an axe to this unit.
   *
   * @param axe the axe to equip.
   */
  @Override
  public void equipAxe(Axe axe) {
  }

  /**
   * Equip a bow to this unit.
   *
   * @param bow the bow to equip.
   */
  @Override
  public void equipBow(Bow bow) {
  }

  /**
   * Equip a spear to this unit.
   *
   * @param spear the spear to equip.
   */
  @Override
  public void equipSpear(Spear spear) {
  }

  /**
   * Equip a staff to this unit.
   *
   * @param staff the staff to equip.
   */
  @Override
  public void equipStaff(Staff staff) {
  }

  /**
   * Equip a sword to this unit.
   *
   * @param sword the sword to equip.
   */
  @Override
  public void equipSword(Sword sword) {
  }

  /**
   * Equip a dark magic book to this unit.
   *
   * @param darkMagicBook the dark magic book to equip.
   */
  @Override
  public void equipDarkMagicBook(DarkMagicBook darkMagicBook) {
  }

  /**
   * Equip a light magic book to this unit.
   *
   * @param lightMagicBook the light magic book to equip.
   */
  @Override
  public void equipLightMagicBook(LightMagicBook lightMagicBook) {
  }

  /**
   * Equip a spirit magic book to this unit.
   *
   * @param spiritMagicBook the spirit magic book to equip.
   */
  @Override
  public void equipSpiritMagicBook(SpiritMagicBook spiritMagicBook) {
  }


  /**
   * Give an item to a unit, if the unit dont have space nothing happen.
   *
   * @param unit the unit to give the item.
   * @param item the item to give to the unit.
   */
  @Override
  public void giveObj(IUnit unit, IEquipableItem item) {
    if (this.items.contains(item) && unit.getLocation().distanceTo(this.location) == 1) {
      boolean X = unit.receiveObj(item);
      if (X) {
        this.removeItem(item);
      }
    }
  }

  /**
   * The unit receive an item, it is only received if the unit has space enough.
   *
   * @param   item the item to receive.
   * @return  <code>true</code> the unit receive the object (if it has space enough), <code>false</code> otherwise.
   */
  @Override
  public boolean receiveObj(IEquipableItem item) {
    if (this.items.size() < this.maxItems) {
      item.setOnInventory(null);
      this.addItem(item);
      return true;
    }
    return false;
  }

  @Override
  public void addItem(IEquipableItem item){
    if(item.getOnInventory()==null) {
      this.items.add(item);
      item.setOnInventory(this);
    }
  }

  @Override
  public void removeItem(IEquipableItem item){
    if(this.items.contains(item)) {
      if (this.getEquippedItem() == item) {
        this.unequipItem();
      }
      this.items.remove(item);
    }
  }

  @Override
  public void counterAttack(IUnit unit){
    if(this.equippedItem!=null &&
            this.getEquippedItem().getMinRange() <= this.getLocation().distanceTo(unit.getLocation()) &&
            this.getLocation().distanceTo(unit.getLocation()) <= this.getEquippedItem().getMaxRange() &&
            this.getCurrentHitPoints()> 0) {
      this.equippedItem.attackWith(unit);
    }
  }

  public void attack(IUnit unit){
    if(this.equippedItem!=null &&
            this.getEquippedItem().getMinRange() <= this.getLocation().distanceTo(unit.getLocation()) &&
            this.getLocation().distanceTo(unit.getLocation()) <= this.getEquippedItem().getMaxRange() &&
            this.getCurrentHitPoints()> 0) {
      this.equippedItem.attackWith(unit);
      unit.counterAttack(this);
    }
  }

  @Override
  public void attackedByAxe(Axe axe) {
    if(this.getEquippedItem() != null){
      this.getEquippedItem().weAttackedByAxe(axe);
    }
    else{
      this.setNormalDamage(axe.getPower());
    }
  }

  @Override
  public void attackedByBow(Bow bow) {
    if(this.getEquippedItem() != null){
      this.getEquippedItem().weAttackedByBow(bow);
    }
    else{
      this.setNormalDamage(bow.getPower());
    }
  }

  @Override
  public void attackedByDarkMagicBook(DarkMagicBook darkMagicBook) {
    if(this.getEquippedItem() != null){
      this.getEquippedItem().weAttackedByDarkMagicBook(darkMagicBook);
    }
    else{
      this.setNormalDamage(darkMagicBook.getPower());
    }
  }

  @Override
  public void attackedByLightMagicBook(LightMagicBook lightMagicBook) {
    if(this.getEquippedItem() != null){
      this.getEquippedItem().weAttackedByLightMagicBook(lightMagicBook);
    }
    else{
      this.setNormalDamage(lightMagicBook.getPower());
    }
  }

  @Override
  public void attackedBySpiritMagicBook(SpiritMagicBook spiritMagicBook) {
    if(this.getEquippedItem() != null){
      this.getEquippedItem().weAttackedBySpiritMagicBook(spiritMagicBook);
    }
    else{
      this.setNormalDamage(spiritMagicBook.getPower());
    }
  }

  @Override
  public void attackedBySpear(Spear spear) {
    if(this.getEquippedItem() != null){
      this.getEquippedItem().weAttackedBySpear(spear);
    }
    else{
      this.setNormalDamage(spear.getPower());
    }
  }

  @Override
  public void attackedBySword(Sword sword) {
    if(this.getEquippedItem() != null){
      this.getEquippedItem().weAttackedBySword(sword);
    }
    else{
      this.setNormalDamage(sword.getPower());
    }
  }

  @Override
  public void setNormalDamage(double power) {
    this.currentHitPoints = max(0,this.currentHitPoints - power);
  }

  @Override
  public void setBigDamage(double power) {
    this.currentHitPoints = max(0,this.currentHitPoints-1.5*power);
  }

  @Override
  public void setSmallDamage(double power) {
    this.currentHitPoints = min(max(0,this.currentHitPoints-(power-20)),this.currentHitPoints);
  }
}
