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
		stack.push(newPath);

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

}
