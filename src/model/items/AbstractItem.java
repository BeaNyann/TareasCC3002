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
  private IUnit owner;

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
  public IUnit getOwner() {
    return owner;
  }

  @Override
  public void setOwner(IUnit owner) {
    this.owner = owner;
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
    this.getOwner().setNormalDamage(sword.getPower());
  }

  @Override
  public void weAttackedByStaff(Staff staff) {
    this.getOwner().setNormalDamage(staff.getPower());
  }

  @Override
  public void weAttackedBySpear(Spear spear) {
    this.getOwner().setNormalDamage(spear.getPower());
  }
//TODO cambiar lo de getowner
  @Override
  public void weAttackedByDarkMagicBook(DarkMagicBook darkMagicBook) {
    this.getOwner().setNormalDamage(darkMagicBook.getPower());
  }

  @Override
  public void weAttackedByLightMagicBook(LightMagicBook lightMagicBook) {
    this.getOwner().setNormalDamage(lightMagicBook.getPower());
  }

  @Override
  public void weAttackedBySpiritMagicBook(SpiritMagicBook spiritMagicBook) {
    this.getOwner().setNormalDamage(spiritMagicBook.getPower());
  }

  @Override
  public void weAttackedByBow(Bow bow) {
    this.getOwner().setNormalDamage(bow.getPower());
  }

  @Override
  public void weAttackedByAxe(Axe axe) {
    this.getOwner().setNormalDamage(axe.getPower());
  }
}
