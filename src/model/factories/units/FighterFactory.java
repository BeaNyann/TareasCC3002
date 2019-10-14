package model.factories.units;

import model.units.Fighter;

public class FighterFactory extends AbstractUnitFactory{

    @Override
    public Fighter create() {
        Fighter fighter = new Fighter(this.getHitPoints(),this.getMovement(),this.getLocation());
        setDefault();
        return fighter;
    }
}
