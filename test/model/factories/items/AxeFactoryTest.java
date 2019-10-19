package model.factories.items;
import model.items.Axe;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Test set for the Axe Factory item.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class AxeFactoryTest extends AbstractTestItemFactory{
    private AxeFactory axeFactory;

    @Override
    public void setTestItem() {
        expectedName = "axe";
        expectedPower = 10;
        expectedMinRange = 1;
        expectedMaxRange = 2;
        axeFactory = new AxeFactory();
    }

    @Override
    public IEquipableItemFactory getTestItem() {
        return axeFactory;
    }


    @Test
    void setDefault() {
        axeFactory.setMaxRange(20);
        axeFactory.setMinRange(0);
        axeFactory.setName("owo");
        axeFactory.setPower(91);
        axeFactory.setDefault();
        assertEquals(getExpectedBasePower(),axeFactory.create().getPower());
        assertEquals(getExpectedMaxRange(),axeFactory.create().getMaxRange());
        assertEquals(getExpectedMinRange(),axeFactory.create().getMinRange());
        assertEquals(getExpectedName(),axeFactory.create().getName());
    }

    @Test
    void create() {
        Axe axe = new Axe("axe",10,1,2);
        Axe axe2 = axeFactory.create();
        assertEquals(axe,axe2);
    }
}
