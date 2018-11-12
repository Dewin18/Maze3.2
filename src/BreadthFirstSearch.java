import java.util.LinkedList;

/**
 * Here we implement the Breadth first Search 
 * by using the Basic Search and 
 * implementing the frontier by a FIFO-Queue
 */
public class BreadthFirstSearch extends BasicSearch {

	private LinkedList<SearchPath> queue;
	
	
	/**
	 * Constructor 
	 * 
	 * Initiates the queue 
	 */
	public BreadthFirstSearch() {
		queue = new LinkedList<SearchPath>();
	}
	
	@Override
	public void addToFrontier(SearchPath newPath) {
		queue.add(newPath);

	}

	@Override
	public SearchPath removeNextPath() {
		return queue.poll();
	}

	@Override
	public int getFrontierSize() {
		return queue.size();
	}

	@Override
	public boolean isFrontierEmpty() {
		return queue.isEmpty();
	}

	@Override
	public SearchPath getNextPath() {
		return queue.peek();
	}

	@Override
	public void clearFrontier() {
		queue.clear();
		
	}

}
