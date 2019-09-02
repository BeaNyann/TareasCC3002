package model.items;

import model.units.IUnit;

/**
 * Abstract class that defines some common information and behaviour between all items.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public abstract class AbstractItem implements IEquipableItem {

  private final String name;
  private final double power;
  protected int maxRange;
  protected int minRange;
  private IUnit user;
  private IUnit onInventory;

  /**
   * Constructor for a default item without any special behaviour.
   *
   * @param name     the name of the item
   * @param power    the power of the item (this could be the amount of damage or healing the item does)
   * @param minRange the minimum range of the item
   * @param maxRange the maximum range of the item
   */
  public AbstractItem(final String name, final double power, final int minRange, final int maxRange) {
    this.name = name;
    this.power = power;
    this.minRange = Math.max(minRange, 1);
    this.maxRange = Math.max(maxRange, this.minRange);
  }

  @Override
  public IUnit getUser() {
    return user;
  }

  @Override
  public void setUser(IUnit owner) {
    this.user = owner;
  }

  @Override
  public IUnit getOnInventory() {
    return onInventory;
  }

  @Override
  public void setOnInventory(IUnit onInventory) {
    this.onInventory = onInventory;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public double getPower() {
    return power;
  }

  @Override
  public int getMinRange() {
    return minRange;
  }

  @Override
  public int getMaxRange() {
    return maxRange;
  }

  @Override
  public boolean equals(Object obj){
    if(obj instanceof IEquipableItem){
      if(((IEquipableItem) obj).getName() == this.getName() &&
              ((IEquipableItem)obj).getPower() == this.getPower() &&
              ((IEquipableItem)obj).getMinRange() == this.getMinRange() &&
              ((IEquipableItem)obj).getMaxRange() == this.getMaxRange()){
        return true;
      }
    }
    return false;
  }

  @Override
  public void weAttackedBySword(Sword sword) {
    this.getUser().setNormalDamage(sword.getPower());
  }

  @Override
  public void weAttackedByStaff(Staff staff) {
    this.getUser().setNormalDamage(staff.getPower());
  }

  @Override
  public void weAttackedBySpear(Spear spear) {
    this.getUser().setNormalDamage(spear.getPower());
  }

  @Override
  public void weAttackedByDarkMagicBook(DarkMagicBook darkMagicBook) {
    this.getUser().setNormalDamage(darkMagicBook.getPower());
  }

  @Override
  public void weAttackedByLightMagicBook(LightMagicBook lightMagicBook) {
    this.getUser().setNormalDamage(lightMagicBook.getPower());
  }

  @Override
  public void weAttackedBySpiritMagicBook(SpiritMagicBook spiritMagicBook) {
    this.getUser().setNormalDamage(spiritMagicBook.getPower());
  }

  @Override
  public void weAttackedByBow(Bow bow) {
    this.getUser().setNormalDamage(bow.getPower());
  }

  @Override
  public void weAttackedByAxe(Axe axe) {
    this.getUser().setNormalDamage(axe.getPower());
  }
}
