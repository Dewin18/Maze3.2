import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public abstract class GraphSearch {

    protected HashSet<Spot> visitedSpots;

    public GraphSearch() {
	visitedSpots = new HashSet<>();
    }

    /*
     * Search strategy which is implemented by the sub classes DFS and BFS.
     */
    public abstract LinkedList<Spot> search(Spot spot);
    
    /**
     * 
     * @param spot
     * @return true if a spot holds the symbol 'g'
     */
    protected boolean isGoal(Spot spot) {
	return spot.getSymbol() == 'g';
    }

    /**
     * Multiple path pruning 
     * 
     * @param spot 
     * @return true if the spot is already visited by a path, false otherwise
     */
    protected boolean isVisited(Spot spot) {
	return visitedSpots.contains(spot);
    }

    /**
     * Cycle detection
     * 
     * @param path 
     * @param spot
     * @return true if a path contains already a new spot, false otherwise
     */
    protected boolean isCyclic(Collection<Spot> path, Spot spot) {
	return path.contains(spot);
    }
}
