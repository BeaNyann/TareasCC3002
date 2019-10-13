package model.factories.units;

import model.map.Location;
import model.units.Fighter;

public class FighterFactory extends AbstractUnitFactory{
    private int hitPoints = 20;
    private Location location = new Location(0,0);
    private int movement = 2;

    public Fighter create() {
        Fighter fighter = new Fighter(hitPoints,movement,location);
        this.hitPoints = 20;
        this.location = new Location(0,0);
        this.movement = 2;
        return fighter;
    }
}
