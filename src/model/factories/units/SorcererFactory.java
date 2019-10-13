package model.factories.units;

import model.map.Location;
import model.units.Sorcerer;

public class SorcererFactory extends AbstractUnitFactory{
    private int hitPoints = 20;
    private Location location = new Location(0,0);
    private int movement = 2;

    public Sorcerer create() {
        Sorcerer sorcerer = new Sorcerer(hitPoints,movement,location);
        this.hitPoints = 20;
        this.location = new Location(0,0);
        this.movement = 2;
        return sorcerer;
    }
}
