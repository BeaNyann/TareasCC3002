package model.factories.items;

import model.items.SpiritMagicBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for the Spirit Magic Book Factory item.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class SpiritMagicBookFactoryTest extends AbstractTestItemFactory{
    private SpiritMagicBookFactory spiritMagicBookFactory;

    @Override
    public void setTestItem() {
        expectedName = "spirit magic book";
        expectedPower = 10;
        expectedMinRange = 1;
        expectedMaxRange = 2;
        spiritMagicBookFactory = new SpiritMagicBookFactory();
    }

    @Override
    public IEquipableItemFactory getTestItem() {
        return spiritMagicBookFactory;
    }


    @Test
    void setDefault() {
        spiritMagicBookFactory.setMaxRange(20);
        spiritMagicBookFactory.setMinRange(0);
        spiritMagicBookFactory.setName("owo");
        spiritMagicBookFactory.setPower(91);
        spiritMagicBookFactory.setDefault();
        assertEquals(getExpectedBasePower(),spiritMagicBookFactory.create().getPower());
        assertEquals(getExpectedMaxRange(),spiritMagicBookFactory.create().getMaxRange());
        assertEquals(getExpectedMinRange(),spiritMagicBookFactory.create().getMinRange());
        assertEquals(getExpectedName(),spiritMagicBookFactory.create().getName());
    }

    @Test
    void create() {
        SpiritMagicBook spiritMagicBook = new SpiritMagicBook("spirit magic book",10,1,2);
        SpiritMagicBook spiritMagicBook2 = spiritMagicBookFactory.create();
        assertEquals(spiritMagicBook,spiritMagicBook2);
    }
}
