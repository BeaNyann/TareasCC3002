package model.factories.items;
import model.items.Staff;

/**
 * Staff Factory.
 * Create staffs.
 *
 * @author Beatriz Graboloza
 * @version 2.0
 * @since v2.0
 */
public class StaffFactory extends AbstractItemFactory {

    @Override
    public void setDefault(){
        this.setName("staff");
        this.setPower(5);
        this.setMaxRange(1);
        this.setMixRange(1);
    }

    @Override
    public Staff create() {
        Staff staff = new Staff(this.getName(),this.getPower(),this.getMaxRange(),this.getMinRange());
        setDefault();
        return staff;
    }
}
