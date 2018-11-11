import java.util.LinkedList;

/**
 * @TODO Comment
 * a class to implement serachPaths which are used for BFS and DFS where we have paths
 *
 */
public class SearchPath {

	private LinkedList<SearchState> searchStates;

	/**
	 * @TODO Comment
	 * construction, intitates searchStates
	 * @param searchStates
	 */
	public SearchPath(LinkedList<SearchState> searchStates) {
		this.searchStates = searchStates;
	}

	/**
	 * @TODO Comment
	 * the cost of the path  in this case its basicly the length
	 * @return
	 */
	public int cost() {
		return searchStates.size();
	}

	/**
	 * @TODO Comment
	 * we want the last node we added to the path for example to check if we already reached the goal
	 * @return the last node of the searchpath
	 */
	public SearchState getLast() {
		return searchStates.getLast();
	}

	/**
	 * @TODO Comment
	 * we extend the current searchpath with the succesor of the last node
	 * @param successor
	 * @return the search path with its succesor added
	 */
	public SearchPath extend(SearchState successor) {
		LinkedList<SearchState> extendedList = new LinkedList<SearchState>(searchStates);
		extendedList.add(successor);
		return new SearchPath(extendedList);
	}

	/**
	 * @TODO Comment
	 * we want to know if a specific state is contained in the searchState
	 * @param state
	 * @return true if the state is contained and false otherwise
	 */
	public boolean contains(SearchState state) {
		return searchStates.contains(state);
	}

	/**
	 * @TODO Comment
	 * we want to print out the way in wich the search path was developed 
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
	 * we want to know wich states have been added so far
	 * @return the states in our searchStates list
	 */
	public LinkedList<SearchState> getStates() {
		return searchStates;
	}
	


}
