import java.util.*;
/**Game.java is a class that controls the instantiation and modification of tictactoe Game objects
 * @author J. Moses 101724926
 * @date 2019-11-24 
 */
public class Game implements Global {
	Board gameBoard;
	Player playerX;
	Player playerO;
	int turn;
	int winner;

	/**Default constructor for Game objects that primarily sets up the game players
	 */
	public Game() {
		boolean flag = true;
		System.out.println("   Welcome  \n     to     \nTic Tac Toe!");
		gameBoard = new Board();
		while(flag) {
			System.out.println("\nSelect an option:\n\n1. Player vs. Player\n2. Player vs. Computer\n3. Computer vs. Computer\n4. Exit");
			switch(readInt()) {
			case 1:
				System.out.println("\nEnter name of Player X:");
				playerX = new HumanPlayer(gameBoard, X, readString());
				
				System.out.println("\nEnter name of Player O:");
				playerO = new HumanPlayer(gameBoard, O, readString());
				start();
				break;
			case 2:
				System.out.println("\nEnter name of Player X:");
				playerX = new HumanPlayer(gameBoard, X, readString());
				
				System.out.println("\nPlayer O is a bot named BOT-1\n");
				playerO = new AIPlayer(gameBoard, O, "BOT-1");
				start();
				break;
			case 3:
				System.out.println("\nPlayer X is a bot named BOT-1");
				playerX = new AIPlayer(gameBoard, X, "BOT-1");
				
				System.out.println("\nPlayer O is a bot named BOT-2\n");
				playerO = new AIPlayer(gameBoard, O, "BOT-2");
				start();
				break;
			case 4:
				System.out.println("\nExiting program\n");
				flag = false;
				break;
			default:
				System.out.println("Invalid Entry");
			}
		}
	}
	
	/**A method that handles the turn based gameplay of tictactoe
	 */	
	public void start() {
		turn = coinToss();
		while(true) {
			if (turn == X) {
				System.out.println("\n" + playerX.getName() + " (X), make a move:");
				playerX.play(gameBoard);
				turn = O;
			}
			else {
				System.out.println("\n" + playerO.getName() + " (O), make a move:");
				playerO.play(gameBoard);
				turn = X;
			}
			
			if((winner = gameBoard.getState()) != 0) {
				
				break;
			}
		}
		switch(winner) {
		case X:
			System.out.println("\n" + playerX.getName() + " (X) wins!");
			break;
		case O:
			System.out.println("\n" + playerO.getName() + " (O) wins!");
			break;
		default:
			System.out.println("\nThe game is a draw");
			break;
		}
		gameBoard.displayBoard();
		System.out.println("Game Over. Play again?");
		gameBoard = new Board();
	}

	
	/**A method that simulates a coin toss using a random number generator
	 * @return the integer 1 (X) or 2 (O)
	 */	
	private int coinToss() {
		Random rand = new Random();
		if(rand.nextInt(2) + 1 == X) {
			System.out.println(playerX.getName() + " won the coin toss.");
			try	{
				Thread.sleep(2000);
			}
			catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}	
			return X;
		}
		else {
			System.out.println(playerO.getName() + " won the coin toss.");
			try	{
				Thread.sleep(2000);
			}
			catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}	
			return O;
		}

	}

	/**A helper method for obtaining alphanumeric input from the user
	 * @return a string of alphanumeric characters
	 */
	public static String readString() {
		String word;
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				word = sc.nextLine();
				if(!blankStringCheck(word) && alphaNumStringCheck(word)) {
					return word.trim();
				}
				else {
					throw new IllegalArgumentException("Invalid entry - please use only alphanumeric characters:");
				}
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}  
		}
	}
	
	/**Helper method for determining if a string is blank (i.e. if it is empty or has only spaces) 
	 * Various derived classes of Item are dependent on this function
	 * @return true if title is a blank string, false if not	 
	 */
	private static boolean blankStringCheck(String temp) {
		if(temp.isEmpty())
			return true;
		
		int count = 0;
		for(int i = 0; i < temp.length() ; i++) {
			if(temp.charAt(i) == ' ')
				count++;
		}
		return count == temp.length(); 
	}

	/**Helper method for determining if a string contains only alphanumeric characters
	 * @return true if title is a blank string, false if not	 
	 */
	private static boolean alphaNumStringCheck(String temp) {
		for(int i = 0; i < temp.length() ; i++) {
			if(!(Character.isLetterOrDigit(temp.charAt(i))))
				return false;
		}
		return true; 
	}	
	
	/**A helper method for obtaining only integer input from the user
	 * @return an integer number
	 */
	public static int readInt() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				return sc.nextInt();
			}
			catch (Exception e) {
				System.out.println("Invalid entry - enter a number from 1 - 9:");
				sc.next();
			}
		}
	}
	
}

