import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * An abstract base class implementing the generic Search Algorithm.
 * Every search strategy can extend this class, implementing only the 
 * frontier and the way paths are added or retrieved.
 *
 */
public abstract class BasicSearch {
	
	private HashSet<SearchState> visitedStates;
	private LinkedList<SearchPath> solutions;
	private SearchPath currentPath;
	private int pathsAdded;
	
	/**
	 * constructor 
	 * 
	 * Initializes a few fields to track the search progress.
	 * @param visitedStates 
	 * @param solutions 
	 * @param currentPath
	 * @param paths added
	 */
	public BasicSearch() {
		
		// the states we have visited so far, we need this for multiple path pruning
		visitedStates = new HashSet<SearchState>();
		// a list which contains every solution we found so far
		solutions = new  LinkedList<SearchPath>();
		// the current searchPath which we need so we know where we are at the moment
		currentPath = new SearchPath(new LinkedList<SearchState>());
		// number of paths added to the frontier during the search. For statistics
		pathsAdded = 0;
	}
	
	/**
	 * a method starting/continuing the search. We use the generic search algorithm. While the frontier is not
	 * empty, a path from the frontier is chosen and checked if it's a solution.
	 * Either the solution is added to a list of solutions or the current path is expanded.
	
	 * we also can decide whether we want to stop after the first solutions (continuing is
	 * possible by calling this method again, search will continue after the last solution. 
	 * multiple path pruning, cycle detection and verbosity are available as options
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

	/*
	 * we do can do multiple path pruning and cycle detection
	 * and we add the successors of the last element of the current path 
	 * in order to get the expanded paths
	 */
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
	 * we need some state to start searching from, 
	 * this function adds this start state to the frontier so that we can use it as a beginning
	 * 
	 * @param state the state from which to start searching.
	 */
	public void setStartState(SearchState state) {
		reset();
		LinkedList<SearchState> states = new LinkedList<SearchState>();
		states.add(state);
		addToFrontier(new SearchPath(states));
	}
	

	/**
	 * this function clears the frontier and all fields representing the 
	 * current progress of the search to restart searching
	 */
	public void reset() {
		this.visitedStates.clear();
		this.solutions.clear();
		this.currentPath = new SearchPath(new LinkedList<SearchState>());
		pathsAdded = 0;
		clearFrontier();
	};

	/**
	 * Clears the frontier of all paths 
	 * 
	 */
	abstract public void clearFrontier();
	
	/**
	 * adds a new path to the frontier
	 * 
	 * @param newPath the path to be added
	 */
	abstract public void addToFrontier(SearchPath newPath);

	/**
	 * remove the next path from the frontier
	 
	 * @return a SearchPath 
	 */
	abstract public SearchPath removeNextPath();

	/**
	 * 
	 * Get the frontier-size
	 * 
	 * @return size of the frontier
	 */
	abstract public int getFrontierSize();

	/**
	 * checks whether the frontier is empty
	 * 
	 * @return true when the frontier is empty otherwise false
	 */
	abstract public boolean isFrontierEmpty();

	/**
	 * Returns the next path to be removed from the frontier 
	 * without removing it
	 * @return the next SearchPath to be removed
	 */
	abstract public SearchPath getNextPath();
	
	 
}
