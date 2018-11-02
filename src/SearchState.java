import java.util.List;

/**
 * SearchState Interface
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
	
}
