import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public abstract class BasicSearch {
	
	private HashSet<SearchState> visitedStates;
	private LinkedList<SearchPath> solutions;
	private SearchPath currentPath;
	private int pathsAdded;
	
	public BasicSearch() {
		visitedStates = new HashSet<SearchState>();
		solutions = new  LinkedList<SearchPath>();
		currentPath = new SearchPath(new LinkedList<SearchState>());
		pathsAdded = 0;
	}
	
	public void search(boolean stopAfterFirstSolution, boolean multiplePathPruning, boolean cycleDetection, boolean verbose) {
		while (!isFrontierEmpty()) {
			if (verbose) {
				System.out.println("Frontier-size:" + getFrontierSize() + ", currentPath-cost:" + currentPath.cost());
			}
			currentPath = removeNextPath();
			if (currentPath.getLast().isGoalState()) {
				this.solutions.add(currentPath);
				visitedStates.clear();
				if (verbose) {
					currentPath.print();
				}
				if (stopAfterFirstSolution) {
					break;
				}
				
			}	
			expandCurrentPath(multiplePathPruning, cycleDetection);
			
		}
		if (verbose) {
			System.out.println(solutions.size() + " solutions found, " + pathsAdded + " paths added.");
		}	
	}

	private void expandCurrentPath(boolean multiplePathPruning, boolean cycleDetection) {

		List<SearchState> successors = currentPath.getLast().getSuccessors();
				
		for (SearchState successor : successors) {
			//some more basic pruning - don't add the path if it contains a cycle
			if (cycleDetection && currentPath.contains(successor)) {
				continue;
			}			
			//some basic pruning - don't add the path if the successor has already been visited
			if (multiplePathPruning) {
				if (visitedStates.contains(successor)) {
					continue;
				} 
				visitedStates.add(successor);	
			}
			SearchPath newPath = currentPath.extend(successor);
			addToFrontier(newPath);
			pathsAdded++;	
		}
	}

	public void setStartState(SearchState state) {
		reset();
		LinkedList<SearchState> states = new LinkedList<SearchState>();
		states.add(state);
		addToFrontier(new SearchPath(states));
	}
	

	public void reset() {
		this.visitedStates.clear();
		this.solutions.clear();
		this.currentPath = new SearchPath(new LinkedList<SearchState>());
		pathsAdded = 0;
		clearFrontier();
	};

	abstract public void clearFrontier();
	
	abstract public void addToFrontier(SearchPath newPath);

	abstract public SearchPath removeNextPath();

	abstract public int getFrontierSize();

	abstract public boolean isFrontierEmpty();

	abstract public SearchPath getNextPath();
	
	 
}
