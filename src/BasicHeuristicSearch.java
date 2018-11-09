import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class BasicHeuristicSearch extends BasicSearch {

	private PriorityQueue<SearchPath> queue;
	
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

}
