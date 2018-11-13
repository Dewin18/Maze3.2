import java.util.LinkedList;
import java.util.Stack;

public class DFS extends GraphSearch {

    private Stack<LinkedList<Spot>> frontier;

    public DFS() {
	super();
	frontier = new Stack<>();
    }

    public LinkedList<Spot> search(Spot spot) {
	initFrontier(spot);
	visitedSpots.add(spot);

	while (!frontier.isEmpty()) {

	    LinkedList<Spot> topOfStack = frontier.pop();
	    Spot lastSpot = topOfStack.getLast();

	    if (isGoal(lastSpot)) {
		return topOfStack;
	    }

	    LinkedList<Spot> neighbours = lastSpot.getNeighbours();

	    for (Spot nextSpot : neighbours) {
		LinkedList<Spot> nextPath = new LinkedList<>(topOfStack);

		if (!isCyclic(nextPath, nextSpot) && !isVisited(nextSpot)) {
		    nextPath.add(nextSpot);
		    visitedSpots.add(nextSpot);
		    frontier.push(nextPath);
		}
	    }
	}
	return null;
    }

    private void initFrontier(Spot spot) {
	LinkedList<Spot> initialPath = new LinkedList<>();
	initialPath.add(spot);
	frontier.add(initialPath);
    }
}
