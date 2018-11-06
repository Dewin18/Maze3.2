import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public abstract class BasicSearch {
	
	private HashSet<SearchState> visitedStates;
	private LinkedList<SearchPath> solutions;
	private List<SearchState> successors;
	private SearchPath currentPath;
	
	public BasicSearch() {
		visitedStates = new HashSet<SearchState>();
		solutions = new  LinkedList<SearchPath>();
		successors = new  LinkedList<SearchState>();
		currentPath = new SearchPath(new LinkedList());
	}
	
	public void search(boolean stopAfterFirstSolution, boolean multiplePathPruning, boolean cycleDetection, boolean verbose) {
		while (!isFrontierEmpty()) {
			if (verbose) {
				System.out.println("Frontier-size:" + getFrontierSize() + ", currentPath-cost:" + currentPath.cost());
			}
			boolean solutionFound = doSearchStep( multiplePathPruning, cycleDetection, verbose);
			if (stopAfterFirstSolution && solutionFound) {
				break;
			}
		}
		if (verbose) {
			System.out.println(solutions.size() + " solutions found");
		}	
	}

	private boolean doSearchStep(boolean multiplePathPruning, boolean cycleDetection,
			boolean verbose) {

		if (successors.isEmpty()) {
			currentPath = removeNextPath();
			successors = currentPath.getLast().getSuccessors();
		}		
		SearchState successor;
		while (!successors.isEmpty() && (successor = successors.remove(0)) != null) {
			
			//some basic pruning - don't add the path if the successor has already been visited
			if (multiplePathPruning && visitedStates.contains(successor)) {
				continue;
			}
			visitedStates.add(successor);
			//some more basic pruning - don't add the path if it contains a cycle
			if (cycleDetection && currentPath.contains(successor)) {
				continue;
			}
			
			SearchPath newPath = currentPath.add(successor);
			if (successor.isGoalState()) {
				this.solutions.add(newPath);
				if (verbose) {
					newPath.print();
				}
				return true;
			}	
			addToFrontier(newPath);
			
		}
		return false;
	}

	public void setStartState(SearchState state) {
		reset();
		LinkedList<SearchState> states = new LinkedList<SearchState>();
		states.add(state);
		addToFrontier(new SearchPath(states));
	}
	
	abstract public void reset();

	abstract public void addToFrontier(SearchPath newPath);

	abstract public SearchPath removeNextPath();

	abstract public int getFrontierSize();

	abstract public boolean isFrontierEmpty();

	abstract public SearchPath getNextPath();
	
	 
}
