import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public abstract class BasicSearch {
	
	private HashSet<SearchState> visitedStates;
	private LinkedList<SearchPath> solutions;
	private List<SearchState> successors;
	private SearchPath currentPath;
	private int pathsAdded;
	
	public BasicSearch() {
		visitedStates = new HashSet<SearchState>();
		solutions = new  LinkedList<SearchPath>();
		successors = new  LinkedList<SearchState>();
		currentPath = new SearchPath(new LinkedList<SearchState>());
		pathsAdded = 0;
	}
	
	public void search(boolean stopAfterFirstSolution, boolean multiplePathPruning, boolean cycleDetection, boolean verbose) {
		while (!isFrontierEmpty()) {
			if (verbose) {
				System.out.println("Frontier-size:" + getFrontierSize() + ", currentPath-cost:" + currentPath.cost());
			}
			boolean solutionFound = expandCurrentPath( multiplePathPruning, cycleDetection, verbose);
			if (stopAfterFirstSolution && solutionFound) {
				break;
			}
		}
		if (verbose) {
			System.out.println(solutions.size() + " solutions found, " + pathsAdded + " paths added.");
		}	
	}

	private boolean expandCurrentPath(boolean multiplePathPruning, boolean cycleDetection,
			boolean verbose) {

		if (successors.isEmpty()) {
			currentPath = removeNextPath();
			successors = currentPath.getLast().getSuccessors();
		}		
		SearchState successor;
		while (!successors.isEmpty() && (successor = successors.remove(0)) != null) {
			//some more basic pruning - don't add the path if it contains a cycle
			if (cycleDetection && currentPath.contains(successor)) {
				continue;
			}			
			//some basic pruning - don't add the path if the successor has already been visited
			if (multiplePathPruning && visitedStates.contains(successor)) {
//				for (SearchPath solution: solutions) {
//					if (solution.contains(successor)) {
//						currentPath.print();
//						LinkedList<SearchState> states = solution.getStates();
//						List<SearchState> commonPath = states.subList(states.indexOf(successor), states.size());
//						SearchPath newPath = currentPath.add(successor);
//						for (SearchState state: commonPath) {
//							newPath = newPath.add(state);
//						}
//						this.solutions.add(newPath);
//						if (verbose) {
//							newPath.print();
//						}
//						return true;						
//					}
//				}
				continue;
			}
			visitedStates.add(successor);

			
			SearchPath newPath = currentPath.add(successor);
			if (successor.isGoalState()) {
				this.solutions.add(newPath);
				if (verbose) {
					newPath.print();
				}
				return true;
			}	
			addToFrontier(newPath);
			pathsAdded++;
			
		}
		return false;
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
		this.successors.clear();
		pathsAdded = 0;
	};

	public int getPathsAdded() {
		return pathsAdded;
	}

	abstract public void addToFrontier(SearchPath newPath);

	abstract public SearchPath removeNextPath();

	abstract public int getFrontierSize();

	abstract public boolean isFrontierEmpty();

	abstract public SearchPath getNextPath();
	
	 
}
