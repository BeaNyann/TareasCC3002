package model.factories.units;

import model.units.Sorcerer;

public class SorcererFactory extends AbstractUnitFactory{

    @Override
    public Sorcerer create() {
        Sorcerer sorcerer = new Sorcerer(this.getHitPoints(),this.getMovement(),this.getLocation());
        setDefault();
        return sorcerer;
    }
}
