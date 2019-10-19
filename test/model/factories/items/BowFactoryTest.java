package model.factories.items;

import model.items.Bow;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for the Bow Factory item.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class BowFactoryTest extends AbstractTestItemFactory{
    private BowFactory bowFactory;

    @Override
    public void setTestItem() {
        expectedName = "bow";
        expectedPower = 8;
        expectedMinRange = 2;
        expectedMaxRange = 4;
        bowFactory = new BowFactory();
    }

    @Override
    public IEquipableItemFactory getTestItem() {
        return bowFactory;
    }


    @Test
    void setDefault() {
        bowFactory.setMaxRange(20);
        bowFactory.setMinRange(19);
        bowFactory.setName("owo");
        bowFactory.setPower(91);
        bowFactory.setDefault();
        assertEquals(getExpectedBasePower(),bowFactory.create().getPower());
        assertEquals(getExpectedMaxRange(),bowFactory.create().getMaxRange());
        assertEquals(getExpectedMinRange(),bowFactory.create().getMinRange());
        assertEquals(getExpectedName(),bowFactory.create().getName());
    }

    @Test
    void create() {
        Bow bow = new Bow("bow",8,2,4);
        Bow bow2 = bowFactory.create();
        assertEquals(bow,bow2);
    }
}

