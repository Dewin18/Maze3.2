import java.util.LinkedList;

public class SearchPath {

	private LinkedList<SearchState> searchStates;

	public SearchPath(LinkedList<SearchState> searchStates) {
		this.searchStates = searchStates;
	}

	public int cost() {
		return searchStates.size();
	}

	public SearchState getLast() {
		return searchStates.getLast();
	}

	public SearchPath add(SearchState successor) {
		// TODO Auto-generated method stub
		LinkedList<SearchState> extendedList = new LinkedList<SearchState>(searchStates);
		extendedList.add(successor);
		return new SearchPath(extendedList);
	}

	public boolean contains(SearchState state) {
		return searchStates.contains(state);
	}

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

	public LinkedList<SearchState> getStates() {
		return searchStates;
	}
	


}
