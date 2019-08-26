package model.items;

import static org.junit.jupiter.api.Assertions.assertTrue;

import model.map.Location;
import model.units.Sorcerer;
import model.units.IUnit;
import org.junit.jupiter.api.Test;

/**
 * Test set for magic books.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public class MagicBookTest extends AbstractTestItem {

    private MagicBook magicbook;
    private MagicBook wrongMagicbook;
    private Sorcerer sorcerer;

    /**
     * Sets which item is going to be tested
     */
    @Override
    public void setTestItem() {
        expectedName = "Common magicbook";
        expectedPower = 8;
        expectedMinRange = 2;
        expectedMaxRange = 4;
        magicbook = new MagicBook(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
    }

    /**
     * Sets up an item with wrong ranges setted.
     */
    @Override
    public void setWrongRangeItem() {
        wrongMagicbook = new MagicBook("Wrong Magic Book", 0, -1, -2);
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
        return wrongMagicbook;
    }

    /**
     * @return the item being tested
     */
    @Override
    public IEquipableItem getTestItem() {
        return magicbook;
    }

    /**
     * @return a unit that can equip the item being tested
     */
    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }
}
