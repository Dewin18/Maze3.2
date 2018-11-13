import java.util.LinkedList;

public class MazeWriter {

    /**
     * Changes the Symbol for each spot on the path from s to g
     * 
     * @param maze 
     * @param goalPath path that leads from s (start) to g (goal)
     */
    public void writeGoalPath(Spot[][] maze, LinkedList<Spot> goalPath) {

	for (Spot pathSpot : goalPath) {

	    int xPos = pathSpot.getSpotPosition().x;
	    int yPos = pathSpot.getSpotPosition().y;

	    Spot mazeSpot = maze[xPos][yPos];
	    mazeSpot.setSymbol('#');
	}
    }
}
