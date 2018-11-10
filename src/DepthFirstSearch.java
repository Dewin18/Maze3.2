import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DepthFirstSearch extends BasicSearch {

	private Deque<SearchPath> stack;

	public DepthFirstSearch() {
		stack = new LinkedList<SearchPath>();
	}

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
		super.reset();
		stack.clear();

	}

	@Override
	public void clearFrontier() {
		stack.clear();

	}

	@Override
	public void expandCurrentPath(boolean multiplePathPruning, boolean cycleDetection) {

		Deque<SearchState> successors = new ArrayDeque<SearchState>();
		while (!currentPath.getLast().isGoalState()) {
			successors.addAll(currentPath.getLast().getSuccessors());

			for (SearchState successor : successors) {
				// some more basic pruning - don't add the path if it contains a
				// cycle
				if (cycleDetection && currentPath.contains(successor)) {
					continue;
				}
				// some basic pruning - don't add the path if the successor has
				// already been visited
				if (multiplePathPruning) {
					if (visitedStates.contains(successor)) {
						continue;
					}
					visitedStates.add(successor);
				}

			}

			currentPath = currentPath.extend(successors.pop());
			SearchPath newPath = currentPath;
			pathsAdded++;
			addToFrontier(newPath);
		}
	}

}
