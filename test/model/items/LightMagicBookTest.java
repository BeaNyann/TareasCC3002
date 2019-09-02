package model.items;

import model.map.Location;
import model.units.IUnit;
import model.units.Sorcerer;

public class LightMagicBookTest extends AbstractTestItem{
    private LightMagicBook lightMagicBook;
    private LightMagicBook wrongLightMagicbook;
    private Sorcerer sorcerer;

    /**
     * Sets which item is going to be tested
     */
    @Override
    public void setTestItem() {
        expectedName = "Common lightmagicbook";
        expectedPower = 8;
        expectedMinRange = 2;
        expectedMaxRange = 4;
        lightMagicBook = new LightMagicBook(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
    }

    /**
     * Sets up an item with wrong ranges setted.
     */
    @Override
    public void setWrongRangeItem() {
        wrongLightMagicbook = new LightMagicBook("Wrong Light Magic Book", 0, -1, -2);
    }

    /**
     * Sets the unit that will be equipped with the test item
     */
    @Override
    public void setTestUnit() {
        sorcerer = new Sorcerer(10, 5, new Location(0, 0));
    }

    @Override
    public IEquipableItem getWrongTestItem() {
        return wrongLightMagicbook;
    }

    /**
     * @return the item being tested
     */
    @Override
    public IEquipableItem getTestItem() {
        return lightMagicBook;
    }

    /**
     * @return a unit that can equip the item being tested
     */
    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }
}

