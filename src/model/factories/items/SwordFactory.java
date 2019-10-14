package model.factories.items;

import model.items.Sword;

public class SwordFactory extends AbstractItemFactory {

    @Override
    public void setDefault(){
        this.setName("item");
        this.setPower(10);
        this.setMaxRange(1);
        this.setMixRange(1);
    }
    @Override
    public Sword create() {
        Sword sword = new Sword(this.getName(),this.getPower(),this.getMaxRange(),this.getMinRange());
        setDefault();
        return sword;
    }
}
