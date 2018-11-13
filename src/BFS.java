import java.util.LinkedList;
import java.util.Queue;

public class BFS extends GraphSearch {

    private Queue<LinkedList<Spot>> frontier;

    public BFS() {
	super();
	frontier = new LinkedList<>();
    }

    public LinkedList<Spot> search(Spot spot) {
	initFrontier(spot);
	visitedSpots.add(spot);

	while (!frontier.isEmpty()) {

	    LinkedList<Spot> path = frontier.poll();
	    Spot lastSpot = path.getLast();

	    if (isGoal(lastSpot)) {
		return path;
	    }

	    LinkedList<Spot> neighbours = lastSpot.getNeighbours();

	    for (Spot nextSpot : neighbours) {
		LinkedList<Spot> nextPath = new LinkedList<>(path);

		if (!isCyclic(nextPath, nextSpot) && !isVisited(nextSpot)) {
		    nextPath.add(nextSpot);
		    visitedSpots.add(nextSpot);
		    frontier.add(nextPath);
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
