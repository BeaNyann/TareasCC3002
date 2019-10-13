package model.factories.units;

import model.map.Location;
import model.units.Hero;

public class HeroFactory extends AbstractUnitFactory{
    private int hitPoints = 20;
    private Location location = new Location(0,0);
    private int movement = 2;

    public Hero create() {
        Hero hero = new Hero(hitPoints,movement,location);
        this.hitPoints = 20;
        this.location = new Location(0,0);
        this.movement = 2;
        return hero;
    }
}
