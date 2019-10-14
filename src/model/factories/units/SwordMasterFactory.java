package model.factories.units;

import model.units.SwordMaster;

public class SwordMasterFactory extends AbstractUnitFactory{

    @Override
    public SwordMaster create() {
        SwordMaster swordMaster = new SwordMaster(this.getHitPoints(),this.getMovement(),this.getLocation());
        setDefault();
        return swordMaster;
    }
}
