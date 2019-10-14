package model.factories.items;

import model.items.Axe;

public class AxeFactory extends AbstractItemFactory {

    @Override
    public Axe create() {
        Axe axe = new Axe(this.getName(),this.getPower(),this.getMaxRange(),this.getMinRange());
        setDefault();
        return axe;
    }
}
