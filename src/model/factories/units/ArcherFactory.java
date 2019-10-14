package model.factories.units;

import model.units.Archer;

public class ArcherFactory extends AbstractUnitFactory{

    @Override
    public Archer create() {
        Archer archer = new Archer(this.getHitPoints(),this.getMovement(),this.getLocation());
        setDefault();
        return archer;
    }

}
