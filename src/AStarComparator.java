import java.util.Comparator;

/**
 * Test
 *
 */
public class AStarComparator implements Comparator<SearchPath> {

	@Override
	public int compare(SearchPath o1, SearchPath o2) {
		int value1 = o1.cost() + o1.getLast().calcHeuristic();
		int value2 = o2.cost() + o2.getLast().calcHeuristic();
		return value1 - value2;
	}

}
