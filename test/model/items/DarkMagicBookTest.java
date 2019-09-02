package model.items;

import model.map.Location;
import model.units.IUnit;
import model.units.Sorcerer;

public class DarkMagicBookTest extends AbstractTestItem{
    private DarkMagicBook darkMagicBook;
    private DarkMagicBook wrongDarkMagicbook;
    private Sorcerer sorcerer;

    /**
     * Sets which item is going to be tested
     */
    @Override
    public void setTestItem() {
        expectedName = "Common darkmagicbook";
        expectedPower = 8;
        expectedMinRange = 2;
        expectedMaxRange = 4;
        darkMagicBook = new DarkMagicBook(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
    }

    /**
     * Sets up an item with wrong ranges setted.
     */
    @Override
    public void setWrongRangeItem() {
        wrongDarkMagicbook = new DarkMagicBook("Wrong Dark Magic Book", 0, -1, -2);
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
        return wrongDarkMagicbook;
    }

    /**
     * @return the item being tested
     */
    @Override
    public IEquipableItem getTestItem() {
        return darkMagicBook;
    }

    /**
     * @return a unit that can equip the item being tested
     */
    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }
}
