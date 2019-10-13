package model.factories.units;

import model.map.Location;
import model.units.*;

public class ArcherFactory extends AbstractUnitFactory{
    private int hitPoints = 20;
    private Location location = new Location(0,0);
    private int movement = 2;

    public Archer create() {
        Archer archer = new Archer(hitPoints,movement,location);
        this.hitPoints = 20;
        this.location = new Location(0,0);
        this.movement = 2;
        return archer;
    }

}
