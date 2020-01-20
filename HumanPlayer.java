/**HumanPlayer.java is-a subclass of Player that controls the instantiation and modification of HumanPlayer objects
 * @author J. Moses 101724926
 * @date 2019-11-24 
 */
public class HumanPlayer extends Player {

	/**Default constructor for HumanPlayer objects
	 * @param gameBoard is the Board the game is played on
	 * @param symbol is the player's symbol
	 * @param name is the player's name
	 */
	public HumanPlayer(Board gameBoard, int symbol, String name) {
		super(gameBoard, symbol, name);
	}
	
	/**Enables HumanPlayer objects to make a TicTacToe move
	 * @param gameBoard is the board where the move is made
	 */
	public void play(Board gameBoard) {
		setBoard(gameBoard);
		while(true) {
			gameBoard.displayBoard();
			if(!gameBoard.makeMove(Game.readInt(), getPlayerSymbol())) {
				System.out.println("\nInvalid Move");
			}
			else
				break;
		}
	}
}

