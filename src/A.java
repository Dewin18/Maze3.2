import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class A extends GraphSearch {

    private PriorityQueue<LinkedList<Spot>> openList;
    private HashMap<Spot, Spot> closedList;
    
    public A(Spot s1, Spot s2) {
	openList = new PriorityQueue<>();
	closedList = new HashMap<>();
    }
    
    @Override
    public LinkedList<Spot> search(Spot spot) {
	LinkedList<Spot> initialPath = new LinkedList<>();
	initialPath.add(spot);
	
	openList.add(initialPath);
	closedList.put(spot, null);
	
	// g = (number of nodes in a path - 1 )
	while(!openList.isEmpty()) {
	   LinkedList<Spot> bestPath = openList.poll(); 
	}
	
	return null;
    }

    public int getManhattanDistance(Spot spot1, Spot spot2) {
	Point pos1 = spot1.getSpotPosition();
	Point pos2 = spot2.getSpotPosition();

	return Math.abs(pos1.x - pos2.x) + Math.abs(pos1.y - pos2.y);
    }
}
