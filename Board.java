/**Board.java controls the instantiation and modification of a tic-tac-toe board
 * @author J. Moses 101724926
 * @date 2019-11-24 
 */
public class Board implements Global {
	private Block[][] board = new Block[ROWS][COLS]; //size of board is 3x3
	private int state; // can be X, O, EMPTY or DRAW
	
	/**Default constructor for Board objects
	 */
	public Board() {
		state = 0;
		for (int i = 0; i < ROWS; i++)
			for (int j = 0; j < COLS; j++)
				board[i][j] = new Block();
	}
	
	/**Helper method for checking a column
	 * @param column is the number of the column to check
	 * @return the state of the column (empty spaces exist, draw, x-win, o-win)
	 */
	private int checkColumn(int column) {
		int xCount = 0;
		int oCount = 0;
		for (int i = 0; i < ROWS; i++) {
			if(board[i][column].getState() == X) {
				xCount++;
			}
			else if(board[i][column].getState() == O) {
				oCount++;
			}
		}
		
		if (xCount == ROWS)
			return X;
		else if(oCount == ROWS)
			return O;
		else if(oCount + xCount == ROWS)
			return DRAW;
		else
			return EMPTY;
	}
	
	/**Helper method for checking a row
	 * @param row is the number of the row to check
	 * @return the state of the column (empty spaces exist, draw, x-win, o-win)
	 */
	private int checkRow(int row) {
		int xCount = 0;
		int oCount = 0;
		for (int i = 0; i < COLS; i++) {
			if(board[row][i].getState() == X) {
				xCount++;
			}
			else if(board[row][i].getState() == O) {
				oCount++;
			}
		}
		
		if (xCount == COLS)
			return X;
		else if(oCount == COLS)
			return O;
		else if(oCount + xCount == COLS)
			return DRAW;
		else
			return EMPTY;
	}
	
	/**Helper method for checking the left diagonal
	 * @return the state of the left diagonal (empty spaces exist, draw, x-win, o-win)
	 */
	private int checkLDiagonal() {
		int xCount = 0;
		int oCount = 0;
		for (int i = 0; i < COLS; i++) {
			if(board[i][i].getState() == X) {
				xCount++;
			}
			else if(board[i][i].getState() == O) {
				oCount++;
			}
		}
		
		if (xCount == COLS)
			return X;
		else if(oCount == COLS)
			return O;
		else if(oCount + xCount == COLS)
			return DRAW;
		else
			return EMPTY;
	}
	
	/**Helper method for checking the right diagonal
	 * @return the state of the right diagonal (empty spaces exist, draw, x-win, o-win)
	 */
	private int checkRDiagonal() {
		int xCount = 0;
		int oCount = 0;
		
		for (int row = 0, col = COLS-1; row < ROWS && col >= 0 ; row++, col--) {
			if(board[row][col].getState() == X) {
				xCount++;
			}
			else if(board[row][col].getState() == O) {
				oCount++;
			}
		}
		
		if (xCount == COLS)
			return X;
		else if(oCount == COLS)
			return O;
		else if(oCount + xCount == COLS)
			return DRAW;
		else
			return EMPTY;
	}
	
	/**Helper method for checking a Board for a draw state
	 * @return 3 if there is a draw state on the board, 0 if not (draw state is when board is full with no winner)
	 */
	private int checkDraw() {
		for (int i = 0 ; i < COLS ; i++) {
			if (checkRow(i) == 0)
				return 0;
		}
		
		return DRAW;
	}
	
	/**Method that checks the board to determine if there is a winner, a draw or neither
	 * @return 3 if there is a draw state on the board, 1 if X wins, 2 if O wins, and 0 if none of the above
	 */
	public int getState(){
		for(int i = 0 ; i < ROWS ; i++) {
			if (checkRow(i) == X || checkColumn(i) == X || checkRDiagonal() == X || checkLDiagonal() == X) 
				return X;
			
			if (checkRow(i) == O || checkColumn(i) == O || checkRDiagonal() == O || checkLDiagonal() == O) 
				return O;
		}
		if(checkDraw() == DRAW)
			return DRAW;
		
		return 0;
	}
    
	/**Allows an X or O to be placed on an empty block of the Board
	 * @param blockNum is the block on the board where the X or O should be placed (1-9)
	 * @param symbol is the symbol to be placed on the board (X or O)
	 * @return the state of the column (empty spaces exist, draw, x-win, o-win)
	 */
    public boolean makeMove(int blockNum, int symbol) {
    	int row = 0;
    	int col = 0;
    	switch(blockNum) {
    	case 1:
    		row = col = 0;
    		break;
    	case 2:
    		row = 0;
    		col = 1;
    		break;
    	case 3:
    		row = 0;
    		col = 2;
    		break;
    	case 4:
    		row = 1;
    		col = 0;
    		break;
    	case 5:
    		row = 1;
    		col = 1;
    		break;
    	case 6:
    		row = 1;
    		col = 2;
    		break;
    	case 7:
    		row = 2;
    		col = 0;
    		break;
    	case 8:
    		row = 2;
    		col = 1;
    		break;
    	case 9:
    		row = 2;
    		col = 2;
    		break;      		
    	default:
    		return false;
    	}
    	
    	if(board[row][col].getState() == EMPTY) {
    		board[row][col].setState(symbol);
    		return true;
    	}
    	
    	return false;
    }    

	/**Prints the state of all the blocks on the board (a graphical representation of the board)
	 */
    public void displayBoard() {
    	System.out.println("");
    	int blockNum = 1;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (board[row][col].getState() == EMPTY)
                	System.out.print(""+blockNum);
                else
                	System.out.print(""+ board[row][col]);
                if(col<2) System.out.print(" | ");
                ++blockNum;
            }
            System.out.print("\n");
            if(row<2) System.out.print("---------\n");
        }    
        System.out.println("");
    }
}
