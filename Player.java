/**Player.java is an abstract class that controls the instantiation and modification of Player objects
 * @author J. Moses 101724926
 * @date 2019-11-24 
 */
public abstract class Player implements Global{
	private Board gameBoard; // the Board the game is played on
	private String playerName; // cannot be empty
	private int playerSymbol; // must be 1 or 2

	/**Default constructor for Player objects
	 * @param gameBoard is the Board the game is played on
	 * @param symbol is the player's symbol
	 * @param name is the player's name
	 */
	public Player(Board gameBoard, int symbol, String name) {
		this.gameBoard = gameBoard;
		playerName = name;
		playerSymbol = symbol;
	}
	
	/**Override of the toString method for Player objects
	 */
	public String toString() {
		return playerName;
	}
	
	/**Setter for Board of Player object
	 * @param gameBoard is a gameBoard object
	 * @return true if state is set
	 */
	public boolean setBoard(Board gameBoard) {
		this.gameBoard = gameBoard;
		return true;
	}
	
	/**Setter for name of Player object
	 * @param name is a string representing the player's name
	 * @return true if state is set
	 */
	public boolean setName(String name) {
		this.playerName = name;
		return true;
	}
	
	/**Getter for the name of Player
	 * @return the name of the Player
	 */
	public String getName() {
		return playerName;
	}	
	
	public int getPlayerSymbol() {
		return playerSymbol;
	}
	
	/**Abstract method that will be used to enable subclasses of Player make a tictactoe move
	 * @param gameBoard is the board where the move is made
	 */
	public abstract void play(Board gameBoard);
	
}