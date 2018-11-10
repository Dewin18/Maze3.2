import java.util.LinkedList;

/**
 * @TODO Comment
 *
 */
public class SearchPath {

	private LinkedList<SearchState> searchStates;

	/**
	 * @TODO Comment
	 * 
	 * @param searchStates
	 */
	public SearchPath(LinkedList<SearchState> searchStates) {
		this.searchStates = searchStates;
	}

	/**
	 * @TODO Comment
	 * 
	 * @return
	 */
	public int cost() {
		return searchStates.size();
	}

	/**
	 * @TODO Comment
	 * 
	 * @return
	 */
	public SearchState getLast() {
		return searchStates.getLast();
	}

	/**
	 * @TODO Comment
	 * 
	 * @param successor
	 * @return
	 */
	public SearchPath extend(SearchState successor) {
		LinkedList<SearchState> extendedList = new LinkedList<SearchState>(searchStates);
		extendedList.add(successor);
		return new SearchPath(extendedList);
	}

	/**
	 * @TODO Comment
	 * 
	 * @param state
	 * @return
	 */
	public boolean contains(SearchState state) {
		return searchStates.contains(state);
	}

	/**
	 * @TODO Comment
	 */
	public void print() {
		SearchState first = searchStates.getFirst();
		if (first.hasDrawablePath()) {
			first.printPath(searchStates);
		} else {
			for (SearchState state: searchStates) {
				state.print();
			}			
		}
	}

	/**
	 * @TODO Comment
	 * 
	 * @return
	 */
	public LinkedList<SearchState> getStates() {
		return searchStates;
	}
	


}
