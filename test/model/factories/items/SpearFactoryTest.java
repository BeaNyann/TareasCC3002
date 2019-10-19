package model.factories.items;

import model.items.Spear;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for the Spear Factory item.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class SpearFactoryTest extends AbstractTestItemFactory{
    private SpearFactory spearFactory;

    @Override
    public void setTestItem() {
        expectedName = "spear";
        expectedPower = 10;
        expectedMinRange = 1;
        expectedMaxRange = 3;
        spearFactory = new SpearFactory();
    }

    @Override
    public IEquipableItemFactory getTestItem() {
        return spearFactory;
    }


    @Test
    void setDefault() {
        spearFactory.setMaxRange(20);
        spearFactory.setMinRange(19);
        spearFactory.setName("owo");
        spearFactory.setPower(91);
        spearFactory.setDefault();
        assertEquals(getExpectedBasePower(),spearFactory.create().getPower());
        assertEquals(getExpectedMaxRange(),spearFactory.create().getMaxRange());
        assertEquals(getExpectedMinRange(),spearFactory.create().getMinRange());
        assertEquals(getExpectedName(),spearFactory.create().getName());
    }

    @Test
    void create() {
        Spear spear = new Spear("spear",10,1,3);
        Spear spear2 = spearFactory.create();
        assertEquals(spear,spear2);
    }
}
