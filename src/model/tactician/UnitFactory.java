package model.tactician;

import model.map.Location;
import model.units.*;

public class UnitFactory {
    private int hitPoints = 20;
    private Location location = new Location(0,0);
    private int movement = 2;

    //TODO que tenga esta cuestion todos los create no hace que sea menos extensible
    // pq si se crea un nuevo unit rip hay que alterar este?

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public Alpaca createAlpaca() {
        Alpaca alpaca = new Alpaca(hitPoints,movement,location);
        this.hitPoints = 20;
        this.location = new Location(0,0);
        this.movement = 2;
        return alpaca;
    }

    public Archer createArcher() {
        Archer archer = new Archer(hitPoints,movement,location);
        this.hitPoints = 20;
        this.location = new Location(0,0);
        this.movement = 2;
        return archer;
    }

    public Cleric createCleric() {
        Cleric cleric = new Cleric(hitPoints,movement,location);
        this.hitPoints = 20;
        this.location = new Location(0,0);
        this.movement = 2;
        return cleric;
    }

    public Fighter createFighter() {
        Fighter fighter = new Fighter(hitPoints,movement,location);
        this.hitPoints = 20;
        this.location = new Location(0,0);
        this.movement = 2;
        return fighter;
    }

    public Hero createHero() {
        Hero hero = new Hero(hitPoints,movement,location);
        this.hitPoints = 20;
        this.location = new Location(0,0);
        this.movement = 2;
        return hero;
    }

    public Sorcerer createSorcerer() {
        Sorcerer sorcerer = new Sorcerer(hitPoints,movement,location);
        this.hitPoints = 20;
        this.location = new Location(0,0);
        this.movement = 2;
        return sorcerer;
    }

    public SwordMaster createSwordMaster() {
        SwordMaster swordMaster = new SwordMaster(hitPoints,movement,location);
        this.hitPoints = 20;
        this.location = new Location(0,0);
        this.movement = 2;
        return swordMaster;
    }
}
