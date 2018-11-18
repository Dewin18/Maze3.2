import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * A parent class of heuristic searches.
 * The frontier is implemented by a priority queue,
 * which compares the Paths to be added according to
 * a Comparator of SearchPaths passed as constructor argument. 
 *  
 */
public class BasicHeuristicSearch extends BasicSearch {

	private PriorityQueue<SearchPath> queue;
	
	/**
	 * Constructor
	 * 
	 * @param Comparator<SearchPath> comp the Comparator to be used for comparing SearchStates
	 */
	public BasicHeuristicSearch (Comparator<SearchPath> comp) {
		queue =  new PriorityQueue<SearchPath>(comp);
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
