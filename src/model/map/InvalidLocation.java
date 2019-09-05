package model.map;

/**
 * This class represents an empty or invalid location on the game's map.
 *
 * @author Beatriz Graboloza
 * @since 1.0
 */
public class InvalidLocation extends Location {

  /**
   * Creates an invalid location on the game's map.
   */
  public InvalidLocation() {
    super(-1, -1);
  }

  /**
   * The invalid location cant have neighbours.
   *
   * @param neighbour the location to be added.
   */
  @Override
  public void addNeighbour(final Location neighbour) {
  }

  /**
   * A invalid location cant be added as a neighbour.
   *
   * @param location location to add this as neighbour.
   */
  @Override
  protected void addTo(final Location location) {
  }
}
