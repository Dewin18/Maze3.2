import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @TODO
 *
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
