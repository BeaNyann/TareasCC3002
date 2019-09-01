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
   * @param hitPoints the maximum amount of damage a unit can sustain
   * @param movement  the number of panels a unit can move
   * @param location  the current position of this unit on the map
   * @param maxItems  maximum amount of items this unit can carry
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

  @Override
  public double getCurrentHitPoints() {
    return currentHitPoints;
  }

  @Override
  public double getMaxHitPoints() {
    return MaxHitPoints;
  }

  @Override
  public List<IEquipableItem> getItems() {
    return List.copyOf(items);
  }

  @Override
  public IEquipableItem getEquippedItem() {
    return equippedItem;
  }

  @Override
  public void unequipItem() {
    if(getEquippedItem()!= null){
      getEquippedItem().setOwner(null);
      equippedItem = null;
    }
  }

  @Override
  public Location getLocation() {
    return location;
  }

  @Override
  public void setLocation(final Location location) {
    this.location = location;
  }

  @Override
  public int getMovement() {
    return movement;
  }

  @Override
  public void moveTo(final Location targetLocation) {
    if (getLocation().distanceTo(targetLocation) <= getMovement()
            && targetLocation.getUnit() == null) {
      getLocation().removeUnit();
      setLocation(targetLocation);
      targetLocation.setUnit(this);
    }
  }

  @Override
  public void equipAxe(Axe axe) {
  }

  @Override
  public void equipBow(Bow bow) {
  }

  @Override
  public void equipMagicBook(MagicBook magicbook) {
  }

  @Override
  public void equipSpear(Spear spear) {
  }

  @Override
  public void equipStaff(Staff staff) {
  }

  @Override
  public void equipSword(Sword sword) {
  }

  @Override
  public void giveObj(IUnit unit, IEquipableItem item) {
    if (this.items.contains(item) && unit.getLocation().distanceTo(this.location) == 1) {
      boolean X = unit.receiveObj(item);
      if (X) {
        this.removeItem(item);
      }
    }
  }

  @Override
  public boolean receiveObj(IEquipableItem item) {
    if (this.items.size() < this.maxItems) {
      this.addItem(item);
      return true;
    }
    return false;
  }

  @Override
  public void addItem(IEquipableItem item){
    this.items.add(item);
  }

  @Override
  public void removeItem(IEquipableItem item){
    if(this.getEquippedItem()==item){
      this.unequipItem();
    }
    this.items.remove(item);
  }

  public void attack(IUnit unit){
    if(this.equippedItem!=null &&
            this.getEquippedItem().getMinRange() <= this.getLocation().distanceTo(unit.getLocation()) &&
            this.getLocation().distanceTo(unit.getLocation()) <= this.getEquippedItem().getMaxRange()){
      this.equippedItem.attackWith(unit);
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
  public void attackedByMagicBook(MagicBook magicbook) {
    if(this.getEquippedItem() != null){
      this.getEquippedItem().weAttackedByMagicBook(magicbook);
    }
    else{
      this.setNormalDamage(magicbook.getPower());
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
  public void attackedByStaff(Staff staff) {
    if(this.getEquippedItem() != null){
      this.getEquippedItem().weAttackedByStaff(staff);
    }
    else{
      this.setNormalDamage(staff.getPower());
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
