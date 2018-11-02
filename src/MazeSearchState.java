import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

/**
 * Class representing a search state of the maze problem
 *
 */
public class MazeSearchState implements SearchState {

	private Point position;
	private Maze maze;
	
	/**
	 * @param maze
	 * @param p
	 */
	public MazeSearchState(Maze maze, Point p) {
		this.maze = maze;
		this.position = p;
	}

	@Override
	public List<SearchState> getSuccessors() {
		List<SearchState> successors = new LinkedList<SearchState>();
		//top
		List<Point> neighbours = Maze.getNeighbours(position);
		for (Point p  : neighbours) {
			if (maze.getSymbol(p) != 'x') {
				successors.add(new MazeSearchState(maze, p));
			}
		}
		return successors;
	}

	@Override
	public boolean isGoalState() {
		return maze.getSymbol(position) == 'g';
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
		for (Point start: maze.getStartingPoints()) {
			startStates.add(new MazeSearchState(maze, start));
		}
		return startStates;
		
	}
	
	public void print() {
		maze.print(position);
	}
	
	@Override
	public boolean equals(SearchState state) {
		if (!(state instanceof MazeSearchState)) {
			return false;
		}
		return position == ((MazeSearchState) state).position;
		
	}

}
