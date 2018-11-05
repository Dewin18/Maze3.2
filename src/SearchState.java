import java.util.List;

/**
 * SearchState Interface
 * 
 * An interface to be implemented by all concrete SearchStates
 *
 */
public interface SearchState {

	/**
	 * This method generates the successor states
	 * 
	 * @return a List containing all valid successor states
	 */
	public List<SearchState> getSuccessors();
	
	/**
	 * Determines whether this state is a goal state
	 * 
	 * @return true, if the current state is a goal state
	 */
	public boolean isGoalState();

	
	/**
	 * Prints out the maze to the console
	 */
	public void print();

	/**
	 * tests whether two states are equal
	 * 
	 * @param state A SearchState to be compared to the present one
	 * @return true if equal
	 */
	public boolean equals(SearchState state);
	
}
