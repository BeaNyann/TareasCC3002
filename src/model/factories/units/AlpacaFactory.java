package model.factories.units;

import model.units.Alpaca;

public class AlpacaFactory extends AbstractUnitFactory{

    @Override
    public Alpaca create() {
        Alpaca alpaca = new Alpaca(this.getHitPoints(),this.getMovement(),this.getLocation());
        setDefault();
        return alpaca;
    }
}
