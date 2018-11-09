import java.awt.Point;
import java.util.LinkedList;
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
	 * Determines the heuristic value for this searchState
	 * 
	 * @return an int representing the heuristic value
	 */
	public int calcHeuristic();
	
	/**
	 * Prints out the maze to the console
	 */
	public void print();

	/**
	 * tests whether two states are equal
	 * 
	 * @param state an Object to be compared to this seachState
	 * @return true if equal
	 * 
	 * should be overridden
	 */
	 @Override 
	 public boolean equals(Object state);
	 
	 /**
	  * Override HashCode
	  */
	 @Override
	 public int hashCode();

	public Point getPosition();

	public boolean hasDrawablePath();

	public void printPath(List<SearchState> searchStates);
	
	
}
