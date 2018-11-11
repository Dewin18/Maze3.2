import java.util.LinkedList;

/**
 * A Class representing a SearchPAth. Modelled by a list of SearchStates
 *
 */
public class SearchPath {

	private LinkedList<SearchState> searchStates;

	/**
	 * Constructor
	 * 
	 * creates a new SearchPath containing all SearchStates in the given list
	 * 
	 * @param searchStates a list of SearchStates
	 */
	public SearchPath(LinkedList<SearchState> searchStates) {
		this.searchStates = searchStates;
	}

	/**
	 * We only model simple costs right now. search space is not weighed.
	 * ie. cost of path = number of arcs
	 * 
	 * @return
	 */
	public int cost() {
		return searchStates.size();
	}

	/**
	 * Get the last State of this path
	 * 
	 * @return last State of this path
	 */
	public SearchState getLast() {
		return searchStates.getLast();
	}

	/**
	 * Get a new path by extending this path with the given SearchStates
	 * 
	 * @param successor a searchState by which to expand the current path
	 * @return the new expanded SearchPath 
	 */
	public SearchPath extend(SearchState successor) {
		LinkedList<SearchState> extendedList = new LinkedList<SearchState>(searchStates);
		extendedList.add(successor);
		return new SearchPath(extendedList);
	}

	/**
	 * Check whether this path contains a search state
	 * 
	 * @param state the state to check for
	 * @return true if state is part of this path
	 */
	public boolean contains(SearchState state) {
		return searchStates.contains(state);
	}

	/**
	 * print the searchPath.
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
	 * get the list of SearchStates representing this path.
	 * 
	 * @return the list of SearchStates that make up this path
	 */
	public LinkedList<SearchState> getStates() {
		return searchStates;
	}
	


}
