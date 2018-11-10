import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @TODO Comment
 *
 */
public abstract class BasicSearch {
	
	private HashSet<SearchState> visitedStates;
	private LinkedList<SearchPath> solutions;
	private SearchPath currentPath;
	private int pathsAdded;
	
	/**
	 * @TODO Comment
	 */
	public BasicSearch() {
		visitedStates = new HashSet<SearchState>();
		solutions = new  LinkedList<SearchPath>();
		currentPath = new SearchPath(new LinkedList<SearchState>());
		pathsAdded = 0;
	}
	
	/**
	 * @TODO Comment
	 * 
	 * @param stopAfterFirstSolution
	 * @param multiplePathPruning
	 * @param cycleDetection
	 * @param verbose
	 */
	public void search(boolean stopAfterFirstSolution, boolean multiplePathPruning, boolean cycleDetection, boolean verbose) {
		while (!isFrontierEmpty()) {
			if (verbose) {
				System.out.println("Frontier-size:" + getFrontierSize() + ", currentPath-cost:" + currentPath.cost());
			}
			// get next Path from frontier
			currentPath = removeNextPath();
			// check whether it's a solution
			if (currentPath.getLast().isGoalState()) {
				// add it to solutions list
				this.solutions.add(currentPath);
				// clear visited states to enable the search for different solutions
				visitedStates.clear();
				if (verbose) {
					currentPath.print();
					System.out.println("Frontier-size:" + getFrontierSize() + ", currentPath-cost:" + currentPath.cost());
				}
				// stop if breaking after first solution is desired
				if (stopAfterFirstSolution) {
					break;
				}
			
			}	
			// expand the current path
			expandCurrentPath(multiplePathPruning, cycleDetection);
			
		}
		if (verbose) {
			System.out.println(solutions.size() + " solutions found, " + pathsAdded + " paths added.");
		}	
	}

	private void expandCurrentPath(boolean multiplePathPruning, boolean cycleDetection) {

		List<SearchState> successors = currentPath.getLast().getSuccessors();
				
		for (SearchState successor : successors) {
			//some basic pruning - don't add the path if it contains a cycle
			if (cycleDetection && currentPath.contains(successor)) {
				continue;
			}			
			//some more basic pruning - don't add the path if the successor has already been visited
			if (multiplePathPruning) {
				if (visitedStates.contains(successor)) {
					continue;
				}
				// mark state as visited
				visitedStates.add(successor);	
			}
			// create new path by extending the current path using the current successor.
			SearchPath newPath = currentPath.extend(successor);
			// add the new path to the frontier
			addToFrontier(newPath);
			// count paths added for statistics
			pathsAdded++;	
		}
	}

	/**
	 * @TODO Comment
	 * @param state
	 */
	public void setStartState(SearchState state) {
		reset();
		LinkedList<SearchState> states = new LinkedList<SearchState>();
		states.add(state);
		addToFrontier(new SearchPath(states));
	}
	

	/**
	 * @TODO Comment
	 */
	public void reset() {
		this.visitedStates.clear();
		this.solutions.clear();
		this.currentPath = new SearchPath(new LinkedList<SearchState>());
		pathsAdded = 0;
		clearFrontier();
	};

	/**
	 * @TODO Comment
	 */
	abstract public void clearFrontier();
	
	/**
	 * @TODO Comment
	 * 
	 * @param newPath
	 */
	abstract public void addToFrontier(SearchPath newPath);

	/**
	 * @TODO Comment
	 * 
	 * @return
	 */
	abstract public SearchPath removeNextPath();

	/**
	 * 
	 * @TODO Comment
	 * @return
	 */
	abstract public int getFrontierSize();

	/**
	 * @TODO Comment
	 * @return
	 */
	abstract public boolean isFrontierEmpty();

	/**
	 * @TODO Comment
	 * @return
	 */
	abstract public SearchPath getNextPath();
	
	 
}
