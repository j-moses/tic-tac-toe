/**Block.java controls the instantiation and modification of a single block on a tic-tac-toe board
 * @author J. Moses 101724926
 * @date 2019-11-24 
 */
public class Block implements Global {
	private int state; // can be EMPTY, X, or O
	
	/**Default constructor for block objects
	 */
	public Block() {
		state = EMPTY;
	}
	
	/**Getter method for block objects
	 * @return the state of the block
	 */
	public int getState() {
		return state;
	}
	
	/**Validator for block objects
	 * @param state is an integer representing X or O
	 * @return true if state == X or state == O
	 */
	private boolean isValidState(int state) {
		return state == X || state == O ;
	}
	
	/**Setter for the state of block objects
	 * @param state is an integer representing X (1), O (2) or EMPTY (0)
	 * @return true if state is set, false if not
	 */
	public boolean setState(int state) {
		if (isValidState(state)) {
			this.state = state;
			return true;
		}
		
		return false;
		
	}
	
	/**Override of toString method for block objects
	 * @return a string containing the state of the block object
	 */
	public String toString() {
		switch(state) {
		case X:
			return "X";
		case O:
			return "O";
		default:
			return " ";
		}
	}
	
}
