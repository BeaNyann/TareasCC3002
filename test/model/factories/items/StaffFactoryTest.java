package model.factories.items;

import model.items.Staff;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for the Staff Factory item.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class StaffFactoryTest extends AbstractTestItemFactory{
    private StaffFactory staffFactory;

    @Override
    public void setTestItem() {
        expectedName = "staff";
        expectedPower = 5;
        expectedMinRange = 1;
        expectedMaxRange = 1;
        staffFactory = new StaffFactory();
    }

    @Override
    public IEquipableItemFactory getTestItem() {
        return staffFactory;
    }


    @Test
    void setDefault() {
        staffFactory.setMaxRange(20);
        staffFactory.setMinRange(0);
        staffFactory.setName("owo");
        staffFactory.setPower(91);
        staffFactory.setDefault();
        assertEquals(getExpectedBasePower(),staffFactory.create().getPower());
        assertEquals(getExpectedMaxRange(),staffFactory.create().getMaxRange());
        assertEquals(getExpectedMinRange(),staffFactory.create().getMinRange());
        assertEquals(getExpectedName(),staffFactory.create().getName());
    }

    @Test
    void create() {
        Staff staff = new Staff("staff",5,1,1);
        Staff staff2 = staffFactory.create();
        assertEquals(staff,staff2);
    }
}
