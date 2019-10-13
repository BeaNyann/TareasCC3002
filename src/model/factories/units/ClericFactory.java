package model.factories.units;

import model.map.Location;
import model.units.Cleric;

public class ClericFactory extends AbstractUnitFactory{
    private int hitPoints = 20;
    private Location location = new Location(0,0);
    private int movement = 2;

    public Cleric create() {
        Cleric cleric = new Cleric(hitPoints,movement,location);
        this.hitPoints = 20;
        this.location = new Location(0,0);
        this.movement = 2;
        return cleric;
    }
}
