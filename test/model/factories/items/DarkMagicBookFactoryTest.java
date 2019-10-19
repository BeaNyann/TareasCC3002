package model.factories.items;

import model.items.DarkMagicBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for the Dark Magic Book Factory item.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class DarkMagicBookFactoryTest extends AbstractTestItemFactory{
    private DarkMagicBookFactory darkMagicBookFactory;

    @Override
    public void setTestItem() {
        expectedName = "dark magic book";
        expectedPower = 10;
        expectedMinRange = 1;
        expectedMaxRange = 2;
        darkMagicBookFactory = new DarkMagicBookFactory();
    }

    @Override
    public IEquipableItemFactory getTestItem() {
        return darkMagicBookFactory;
    }


    @Test
    void setDefault() {
        darkMagicBookFactory.setMaxRange(20);
        darkMagicBookFactory.setMinRange(19);
        darkMagicBookFactory.setName("owo");
        darkMagicBookFactory.setPower(91);
        darkMagicBookFactory.setDefault();
        assertEquals(getExpectedBasePower(),darkMagicBookFactory.create().getPower());
        assertEquals(getExpectedMaxRange(),darkMagicBookFactory.create().getMaxRange());
        assertEquals(getExpectedMinRange(),darkMagicBookFactory.create().getMinRange());
        assertEquals(getExpectedName(),darkMagicBookFactory.create().getName());
    }

    @Test
    void create() {
        DarkMagicBook darkMagicBook = new DarkMagicBook("dark magic book",10,1,2);
        DarkMagicBook darkMagicBook2 = darkMagicBookFactory.create();
        assertEquals(darkMagicBook,darkMagicBook2);
    }
}
