import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DepthFirstSearch extends BasicSearch {

	Deque<SearchPath> stack = new ArrayDeque<SearchPath>();

	@Override
	public void addToFrontier(SearchPath newPath) {
		stack.add(newPath);

	}

	@Override
	public SearchPath removeNextPath() {
		return stack.poll();
	}

	@Override
	public int getFrontierSize() {
		return stack.size();
	}

	@Override
	public boolean isFrontierEmpty() {
		return stack.isEmpty();
	}

	@Override
	public SearchPath getNextPath() {
		return stack.poll();
	}

	@Override
	public void reset() {
		stack.clear();

	}

	@Override
	private boolean doSearchStep(boolean multiplePathPruning, boolean cycleDetection, boolean verbose) {
		Deque statesToVisit = new ArrayDeque();
		//The changes to the normal doSearchStep function are that we dont have a path for each succesor but continue on our current path with the first successor
		
		
		//we save all the States that we "saw" but didnt visit here
		statesToVisit = removeNextPath();
		//while there are still states we have yet to visit we need to continue
		while (!statesToVisit.isEmpty()) {
			
			//if we already used the current successors we need new ones
			if (successors.isEmpty()) {
				successors = statesToVisit.poll().getSuccessors();
				//we continue on our path with the first element of the states we still need to visit
				currentPath = currentPath.add(statesToVisit.getFirst());
			}
			//as long as we havent reached the goal and we still have successors we save the successors 
			if (!currentPath.getLast.isGoalState() && !successors.isEmpty) {
				statesToVisit.add(successors);
				successors.clear();
			}
			//if we reached the goal we are happy and tell the solution
			if (currentPath.getLast.isGoalState()) {
				this.solutions.add(currentPath);
				if (verbose) {
					currentPath.print();
				}
				return true;
			}
		}
		return false;

	}

}
