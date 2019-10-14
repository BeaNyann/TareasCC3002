package model.factories.units;

import model.units.Cleric;

public class ClericFactory extends AbstractUnitFactory{

    @Override
    public Cleric create() {
        Cleric cleric = new Cleric(this.getHitPoints(),this.getMovement(),this.getLocation());
        setDefault();
        return cleric;
    }
}
