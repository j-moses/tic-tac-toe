import java.util.Random;

/**AIPlayer.java is-a subclass of Player that controls the instantiation and modification of AIPlayer objects
 * @author J. Moses 101724926
 * @date 2019-11-24 
 */
public class AIPlayer extends Player {
	/**Default constructor for HumanPlayer objects
	 * @param gameBoard is the Board the game is played on
	 * @param symbol is the player's symbol
	 * @param name is the player's name
	 */
	public AIPlayer(Board gameBoard, int symbol, String name) {
		super(gameBoard, symbol, name);
	}
	
	/**Enables AIPlayer objects to make a TicTacToe move
	 * @param gameBoard is the board where the move is made
	 */
	public void play(Board gameBoard) {
		setBoard(gameBoard);
		Random rand = new Random();
		gameBoard.displayBoard();
		while(true) {

			int ran = 0;
			ran = rand.nextInt(9) + 1;
			if(gameBoard.makeMove(ran, getPlayerSymbol())){
				try
				{
					Thread.sleep(1000);
				}
				catch(InterruptedException ex)
				{
					Thread.currentThread().interrupt();
				}		
				System.out.println("I choose: " + ran);
				try
				{
					Thread.sleep(1000);
				}
				catch(InterruptedException ex)
				{
					Thread.currentThread().interrupt();
				}		
				break;
			}
		}
	}
}
