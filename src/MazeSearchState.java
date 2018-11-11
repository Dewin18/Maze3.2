import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Class representing a search state of the maze problem
 *
 */
public class MazeSearchState implements SearchState {

	/**
	 * @TODO
	 * a constant which is used later on
	 */
	public final static int NONE = 0;
	/**
	 * @TODO
	 * a constant which is used later on
	 */
	public final static int MANHATTEN_DISTANCE = 1;
	
	private static HashMap<Point, MazeSearchState> states;
	
	private Point position;
	private Maze maze;
	private static int heuristicType;
	
	//Initialises the HashMap for the SearchStates. The Map is used to avoid duplicate SearchState generation
	static {
		states = new HashMap<Point, MazeSearchState>();
		heuristicType = NONE;
	}
	
	/**
	 * Basic constructor, kept private to enforce creation with factory method
	 * 
	 * @param p
	 * @param maze
	 */
	private MazeSearchState(Point p, Maze maze) {
		this.maze = maze;
		this.position = p;
	}

	@Override
	public List<SearchState> getSuccessors() {
		List<SearchState> successors = new LinkedList<SearchState>();
		// get Neighbours of current position
		List<Point> neighbours = Maze.getNeighbours(position);
		// iterate over neighbouring points
		for (Point p  : neighbours) {
			if (maze.getPortals().containsKey(p)) {
				// if the spot is a portal, 
				// add the portal destination to return list,
				SearchState otherPortal = getMazeSearchState(maze.getPortals().get(p), maze);
				successors.add(otherPortal);
			} else if (maze.getSymbol(p) != 'x') {
				// add corresponding Sucessor state to return list,
				// if the spot is walkable (ie. not 'x') 
				successors.add(getMazeSearchState(p, maze));
			}
		}
		return successors;
	}

	@Override
	public boolean isGoalState() {
		//Check whether the current position is the goal
		return maze.getSymbol(position) == 'g';
	}
	
	@Override
	public void print() {
		//print out the maze marking the current position
		maze.print(position);
	}
	
	@Override
	public boolean equals(Object state) {
		if (!(state instanceof MazeSearchState)) {
			return false;
		}
		// two MazeSearchStates are equal, if they belong to the same maze and have the same position
		return (maze == ((MazeSearchState) state).maze)
				&& (position == ((MazeSearchState) state).position);
		
	}
	
	@Override
	public int hashCode() {
		return position.hashCode();
	}
	
	/**
	 * 
	 * Returns all startStates for the given maze
	 * 
	 * @param maze the Maze for which the StartStates should be generated
	 * @return a List containing all start states for the given maze.
	 */
	public static List<MazeSearchState> getStartStates(Maze maze) {
		List<MazeSearchState> startStates = new LinkedList<MazeSearchState>();
		// Create and add to return list a MazeSearchState for all Starting points of the maze
		for (Point start: maze.getStartingPoints()) {
			startStates.add(getMazeSearchState(start, maze));
		}
		return startStates;
		
	}
	
	/**
	 * Factory Method for MazeSearchStates to avoid duplicate generation.
	 * 
	 * @param p Point of the desired state
	 * @param m maze of the desired state
	 * 
	 * @return the MazeSearchState representing (p,m) 
	 */
	public static MazeSearchState getMazeSearchState(Point p, Maze m) {
		if (!states.containsKey(p)) {
			states.put(p, new MazeSearchState(p, m));
		}
		return states.get(p);
	}

	/**
	 * @param type
	 */
	public static void setHeuristic(int type) {
		heuristicType = type;
	}
	
	@Override
	public int calcHeuristic() {
		switch (MazeSearchState.heuristicType) {
			case NONE: return 0;
			case MANHATTEN_DISTANCE: return getManhattenDistance();
				
		}
		
		return 0;
	}

	private int getManhattenDistance() {
		int minDistance = maze.getMaxManhattenDistance();
		int distance;
		for (Point goal :maze.getGoalPoints()) {
			distance = Math.abs(goal.x-position.x)+Math.abs(goal.y-position.y);
			minDistance = Math.min(distance,minDistance);
		}
		return minDistance;
	}

	@Override
	public boolean hasDrawablePath() {
		return true;
	}
	
	@Override
	public void printPath(List<SearchState> path) {
		LinkedList<Point> list = new LinkedList<Point>();
		for (SearchState state: path) {
			list.add(((MazeSearchState) state).position);
		}	
		
		maze.print(list);
	}
}
