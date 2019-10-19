package model.factories.units;
import model.units.Alpaca;

/**
 * Alpaca Factory.
 * Create alpacas.
 *
 * @author Beatriz Graboloza
 * @since 2.0
 */
public class AlpacaFactory extends AbstractUnitFactory{

    /**
     * Creates an alpaca.
     *
     * @return the created alpaca.
     */
    @Override
    public Alpaca create() {
        Alpaca alpaca = new Alpaca(this.getHitPoints(),this.getMovement(),this.getLocation());
        setDefault();
        return alpaca;
    }
}
