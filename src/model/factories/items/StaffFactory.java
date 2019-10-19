package model.factories.items;
import model.items.Staff;

/**
 * Staff Factory.
 * Create staffs.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class StaffFactory extends AbstractItemFactory {

    /**
     * Set the default values of a staff.
     */
    @Override
    public void setDefault(){
        this.setName("staff");
        this.setPower(5);
        this.setMaxRange(1);
        this.setMinRange(1);
    }

    /**
     * Creates a staff.
     * @return the created staff.
     */
    @Override
    public Staff create() {
        Staff staff = new Staff(this.getName(),this.getPower(),this.getMinRange(),this.getMaxRange());
        setDefault();
        return staff;
    }
}
