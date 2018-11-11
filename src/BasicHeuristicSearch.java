import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @TODO Comment
 * A parent class of heuristic searches, which allows to reset StateSearches and to add and remove paths from the frontier.
 * It also allows to get the frontierSize, to check if frontier is empty, to get next frontier path and to clear it. 
 * @param Comparator<SearchPath> comp 
 */
public class BasicHeuristicSearch extends BasicSearch {

	private PriorityQueue<SearchPath> queue;
	
	/**
	 * @TODO
	 */
	public BasicHeuristicSearch (Comparator<SearchPath> comp) {
		queue =  new PriorityQueue<SearchPath>(comp);
	}
	
	@Override
	public void reset() {
		super.reset();
		queue.clear();

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
