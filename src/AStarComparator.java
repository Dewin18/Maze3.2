import java.util.Comparator;

/**
 * @TODO Comment
 * A child class of Comparator, to implement SearchPaths of A*-Heuristics. We add with each step the costs of the heuristic search. Our start node is the first node. 
 * We have two types of costs. The one is the distance from the start node to the current node. The second one is the distance from the current node to the end node.
 * We are comparing two Paths by their lowest cost, which is an addition of the two kinds of costs.
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
