package model.factories.items;

import model.items.Sword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for the Sword Factory item.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class SwordFactoryTest extends AbstractTestItemFactory{
    private SwordFactory swordFactory;

    @Override
    public void setTestItem() {
        expectedName = "sword";
        expectedPower = 10;
        expectedMinRange = 1;
        expectedMaxRange = 1;
        swordFactory = new SwordFactory();
    }

    @Override
    public IEquipableItemFactory getTestItem() {
        return swordFactory;
    }


    @Test
    void setDefault() {
        swordFactory.setMaxRange(20);
        swordFactory.setMinRange(0);
        swordFactory.setName("owo");
        swordFactory.setPower(91);
        swordFactory.setDefault();
        assertEquals(getExpectedBasePower(),swordFactory.create().getPower());
        assertEquals(getExpectedMaxRange(),swordFactory.create().getMaxRange());
        assertEquals(getExpectedMinRange(),swordFactory.create().getMinRange());
        assertEquals(getExpectedName(),swordFactory.create().getName());
    }

    @Test
    void create() {
        Sword sword = new Sword("sword",10,1,1);
        Sword sword2 = swordFactory.create();
        assertEquals(sword,sword2);
    }
}
