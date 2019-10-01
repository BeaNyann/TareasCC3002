package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.tactician.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.units.IUnit;

/**
 * Controller of the game.
 * The controller manages all the input received from de game's GUI.
 *
 * @author Beatriz Graboloza
 * @version 2.0
 * @since v2.0
 */
public class GameController {

  private final int numberOfPlayers;
  private final int mapSize;
  private List<Tactician> currentOrder;
  private int currentTurn;
  private Tactician lastPlayer;
  private int roundNumber;
  private int MaxRounds;

  /**
   * Creates the controller for a new game.
   *
   * @param numberOfPlayers   the number of players for this game
   * @param mapSize           the dimensions of the map, for simplicity, all maps are squares
   */
  public GameController(int numberOfPlayers, int mapSize) {
    this.numberOfPlayers = numberOfPlayers;
    this.mapSize = mapSize;
    this.roundNumber = 0;
  }

  /**
   * @return the list of all the tacticians participating in the game.
   */
  public List<Tactician> getTacticians() {
    List<Tactician> tacticians = new ArrayList<>();
    for(int i=0; i < this.numberOfPlayers; i++){
      Tactician tactician = new Tactician("Player "+i);
      tacticians.add(tactician);
    }
    return tacticians;
  }

  /**
   * @return the map of the current game
   */
  public Field getGameMap() {
    return null;
  }

  /**
   * @return the tactician that's currently playing
   */
  public Tactician getTurnOwner() {
    return null;
  }

  /**
   * @return the number of rounds since the start of the game.
   */
  public int getRoundNumber() {
    return this.roundNumber;
  }

  /**
   * @return the maximum number of rounds a match can last
   */
  public int getMaxRounds() {
    return this.MaxRounds;
  }
  public void newRound(){
      //eligo el orden culiao y le digo al jugador que empiece su turno culiao
  }
  /**
   * Select the round´s order
   */
  public void reorderTurns(){
      Random randomTurnSequence = new Random();
      List<Tactician> tacticians = getTacticians();
      List<Tactician> newturns = new ArrayList<>();
      int i = 0;
      while(i<this.numberOfPlayers){
          int next = randomTurnSequence.nextInt()%this.numberOfPlayers;
          if(!newturns.contains(tacticians.get(next))){
              newturns.add(tacticians.get(next));
              i++;
          }
      }
      if(this.currentOrder.get(currentOrder.size()-1).equals(newturns.get(0))){ //cuando esta vacío que pasa si geteo algo?
          reorderTurns();
      }
      else{
          this.currentOrder = newturns;
      }
  }
  /**
   * Finishes the current player's turn.
   */
  public void endTurn() {
      //pregunto si es el ultimo si es el ultimo empiezo una new rounddd
  }

  /**
   * Removes a tactician and all of it's units from the game.
   *
   * @param tactician   the player to be removed
   */
  public void removeTactician(String tactician) {

  }

  /**
   * Starts the game.
   * @param maxRounds   the maximum number of rounds the game can last
   */
  public void initGame(final int maxRounds) {
    this.MaxRounds = maxRounds;
    //ayuda
  }

  /**
   * Starts a game without a limit of turns.
   */
  public void initEndlessGame() {
    this.MaxRounds = -1;
    //aaaaaaaaa
  }

  /**
   * @return the winner of this game, if the match ends in a draw returns a list of all the winners
   */
  public List<String> getWinners() {
    return null;
  }

  /**
   * @return the current player's selected unit
   */
  public IUnit getSelectedUnit() {
    return null;
  }

  /**
   * Selects a unit in the game map
   *
   * @param x
   *     horizontal position of the unit
   * @param y
   *     vertical position of the unit
   */
  public void selectUnitIn(int x, int y) {

  }

  /**
   * @return the inventory of the currently selected unit.
   */
  public List<IEquipableItem> getItems() {
    return null;
  }

  /**
   * Equips an item from the inventory to the currently selected unit.
   *
   * @param index
   *     the location of the item in the inventory.
   */
  public void equipItem(int index) {

  }

  /**
   * Uses the equipped item on a target
   *
   * @param x
   *     horizontal position of the target
   * @param y
   *     vertical position of the target
   */
  public void useItemOn(int x, int y) {

  }

  /**
   * Selects an item from the selected unit's inventory.
   *
   * @param index
   *     the location of the item in the inventory.
   */
  public void selectItem(int index) {

  }

  /**
   * Gives the selected item to a target unit.
   *
   * @param x
   *     horizontal position of the target
   * @param y
   *     vertical position of the target
   */
  public void giveItemTo(int x, int y) {

  }
}
