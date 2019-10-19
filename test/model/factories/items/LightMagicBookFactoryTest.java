package model.factories.items;

import model.items.LightMagicBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for the Light Magic Book Factory item.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class LightMagicBookFactoryTest extends AbstractTestItemFactory{
    private LightMagicBookFactory lightMagicBookFactory;

    @Override
    public void setTestItem() {
        expectedName = "light magic book";
        expectedPower = 10;
        expectedMinRange = 1;
        expectedMaxRange = 2;
        lightMagicBookFactory = new LightMagicBookFactory();
    }

    @Override
    public IEquipableItemFactory getTestItem() {
        return lightMagicBookFactory;
    }


    @Test
    void setDefault() {
        lightMagicBookFactory.setMaxRange(20);
        lightMagicBookFactory.setMinRange(0);
        lightMagicBookFactory.setName("owo");
        lightMagicBookFactory.setPower(91);
        lightMagicBookFactory.setDefault();
        assertEquals(getExpectedBasePower(),lightMagicBookFactory.create().getPower());
        assertEquals(getExpectedMaxRange(),lightMagicBookFactory.create().getMaxRange());
        assertEquals(getExpectedMinRange(),lightMagicBookFactory.create().getMinRange());
        assertEquals(getExpectedName(),lightMagicBookFactory.create().getName());
    }

    @Test
    void create() {
        LightMagicBook lightMagicBook = new LightMagicBook("light magic book",10,1,2);
        LightMagicBook lightMagicBook2 = lightMagicBookFactory.create();
        assertEquals(lightMagicBook,lightMagicBook2);
    }
}
