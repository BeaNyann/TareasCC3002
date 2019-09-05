package model.items;

import model.units.IUnit;

/**
 * Abstract class that defines common information and behaviour between all Equipable Items.
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
   * Constructor for a default item.
   *
   * @param name     the name of the item.
   * @param power    the power of the item (this could be the amount of damage or healing the item does).
   * @param minRange the minimum range of the item.
   * @param maxRange the maximum range of the item.
   */
  public AbstractItem(final String name, final double power, final int minRange, final int maxRange) {
    this.name = name;
    this.power = power;
    this.minRange = Math.max(minRange, 1);
    this.maxRange = Math.max(maxRange, this.minRange);
  }

    /**
     * @return the unit that has currently equipped this item
     */
  @Override
  public IUnit getUser() {
    return user;
  }

    /**
     * Sets the unit that will equip this item.
     *
     * @param user  the unit that will equip this item.
     */
  @Override
  public void setUser(IUnit user) {
    this.user = user;
  }

    /**
     * @return the unit that has this item on its inventory.
     */
  @Override
  public IUnit getOnInventory() {
    return onInventory;
  }

    /**
     * Sets the the unit that has this item on its inventory.
     *
     * @param onInventory the unit that has this item on its inventory.
     */
  @Override
  public void setOnInventory(IUnit onInventory) {
    this.onInventory = onInventory;
  }

    /**
     * @return the name of this item.
     */
  @Override
  public String getName() {
    return name;
  }

    /**
     * @return the power of this item.
     */
  @Override
  public double getPower() {
    return power;
  }

    /**
     * @return minimum range of the item.
     */
  @Override
  public int getMinRange() {
    return minRange;
  }

    /**
     * @return maximum range of the item.
     */
  @Override
  public int getMaxRange() {
    return maxRange;
  }

    /**
     * @param obj the object to compare with this item.
     * @return    <code>true</code> if this item was the same as the object entered, <code>false</code> otherwise.
     */
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

    /**
     * Send a message to this item´s unit with de type of damage it received.
     *
     * @param sword the sword with which this item's unit is being attacked.
     */
  @Override
  public void weAttackedBySword(Sword sword) {
    this.getUser().setNormalDamage(sword.getPower());
  }

    /**
     * Send a message to this item´s unit with de type of damage it received.
     *
     * @param spear the spear with which this item's unit is being attacked.
     */
  @Override
  public void weAttackedBySpear(Spear spear) {
    this.getUser().setNormalDamage(spear.getPower());
  }

    /**
     * Send a message to this item´s unit with de type of damage it received.
     *
     * @param darkMagicBook the dark magic book with which this item's unit is being attacked.
     */
  @Override
  public void weAttackedByDarkMagicBook(DarkMagicBook darkMagicBook) {
    this.getUser().setNormalDamage(darkMagicBook.getPower());
  }

    /**
     * Send a message to this item´s unit with de type of damage it received.
     *
     * @param lightMagicBook the light magic book with which this item's unit is being attacked.
     */
  @Override
  public void weAttackedByLightMagicBook(LightMagicBook lightMagicBook) {
    this.getUser().setNormalDamage(lightMagicBook.getPower());
  }

    /**
     * Send a message to this item´s unit with de type of damage it received.
     *
     * @param spiritMagicBook the spirit magic book with which this item's unit is being attacked.
     */
  @Override
  public void weAttackedBySpiritMagicBook(SpiritMagicBook spiritMagicBook) {
    this.getUser().setNormalDamage(spiritMagicBook.getPower());
  }

    /**
     * Send a message to this item´s unit with de type of damage it received.
     *
     * @param bow the bow with which this item's unit is being attacked.
     */
  @Override
  public void weAttackedByBow(Bow bow) {
    this.getUser().setNormalDamage(bow.getPower());
  }

    /**
     * Send a message to this item´s unit with de type of damage it received.
     *
     * @param axe the axe with which this item's unit is being attacked.
     */
  @Override
  public void weAttackedByAxe(Axe axe) {
    this.getUser().setNormalDamage(axe.getPower());
  }
}
