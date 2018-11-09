import java.util.LinkedList;

public class BreadthFirstSearch extends BasicSearch {

	private LinkedList<SearchPath> queue;
	
	
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
		return queue.poll();
	}

	@Override
	public void reset() {
		super.reset();
		queue.clear();
		
	}

	@Override
	public void clearFrontier() {
		queue.clear();
		
	}

}
