import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @TODO Comment
 *
 *An abstract class for a few function that we need in the other Searches such as BFS or DFS
 */
public abstract class BasicSearch {
	
	private HashSet<SearchState> visitedStates;
	private LinkedList<SearchPath> solutions;
	private SearchPath currentPath;
	private int pathsAdded;
	
	/**
	 * @TODO Comment
	 * a constructor with a few variables that we need
	 * @param visitedStates the states we have visted so far, we need this for example for cycle detection
	 * @param solutions a list wich contains every soloution we found so far
	 * @param currentPath a searchPath wich we neeed so we know where we are at the moment
	 * @param paths added
	 */
	public BasicSearch() {
		visitedStates = new HashSet<SearchState>();
		solutions = new  LinkedList<SearchPath>();
		currentPath = new SearchPath(new LinkedList<SearchState>());
		pathsAdded = 0;
	}
	
	/**
	 * @TODO Comment
	 * a function we in wich the search is started , we check if we have a soloution and either add that soloution to our solotuion 
	 * or continue looking for a solotuion using the expandCurrentPath function
	 * we also can decide whether we want one or more soloutions, whether we want to use multiple pathpruning and so on
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
	 * and we add new succesors to the current path in order to continue searching for a solution
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
	 * @TODO Comment
	 * we need some states in order to start, this function adds these star states to the frontier so that we can use them
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
	 * this function resets our variables to the default
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
	 * we delete the paths in our frontier
	 */
	abstract public void clearFrontier();
	
	/**
	 * @TODO Comment
	 * we add a new path to the frontier
	 * 
	 * @param newPath
	 */
	abstract public void addToFrontier(SearchPath newPath);

	/**
	 * @TODO Comment
	 * we take one of the paths and start using it
	 * @return a search path
	 */
	abstract public SearchPath removeNextPath();

	/**
	 * 
	 * @TODO Comment
	 * 
	 * @return size of the frontier
	 */
	abstract public int getFrontierSize();

	/**
	 * @TODO Comment
	 * @return ture when the frontier is empty otherwise false
	 */
	abstract public boolean isFrontierEmpty();

	/**
	 * @TODO Comment
	 * we get the next path (very similiar to
	 * @return
	 */
	abstract public SearchPath getNextPath();
	
	 
}
