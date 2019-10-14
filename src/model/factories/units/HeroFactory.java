package model.factories.units;

import model.units.Hero;

public class HeroFactory extends AbstractUnitFactory{

    @Override
    public Hero create() {
        Hero hero = new Hero(this.getHitPoints(),this.getMovement(),this.getLocation());
        setDefault();
        return hero;
    }
}
