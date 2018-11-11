import java.util.Deque;
import java.util.LinkedList;

/**
 * Here we implement the Depth first Search by using the Basic Search 
 * and implementing frontier by a FIFO-Queue (a stack)
 */
public class DepthFirstSearch extends BasicSearch {

	private Deque<SearchPath> stack;

	/**
	 * Constructor 
	 * Initiating the stack
	 */
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
		return stack.peek();
	}


	@Override
	public void clearFrontier() {
		stack.clear();

	}

}
