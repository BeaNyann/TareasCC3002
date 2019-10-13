package model.factories.units;

import model.map.Location;
import model.units.Alpaca;

public class AlpacaFactory extends AbstractUnitFactory{
    private int hitPoints = 20;
    private Location location = new Location(0,0);
    private int movement = 2;

    public Alpaca create() {
        Alpaca alpaca = new Alpaca(hitPoints,movement,location);
        this.hitPoints = 20;
        this.location = new Location(0,0);
        this.movement = 2;
        return alpaca;
    }
}
