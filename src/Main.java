import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

	//	// read a maze from a .txt file and mapps it into a 2D array of spots
	//	MazeReader mr = new MazeReader(10, 20, "src/mazes/maze01.txt");
	//	Spot[][] maze = mr.getMaze();
	//
	//	// print the maze on the console
	//	mr.printMaze();
	//
	//	System.out.println();
	//
	//	// declare some test indices for the 2D array
	//	int row = 4;
	//	int column = 4;
	//
	//	// retrieve the spot from the location
	//	Spot spot = maze[row][column];
	//
	//	System.out.println("Spot: " + spot);
	//	System.out.println("Spot neighbours: " + spot.getNeighbours());
		
		Maze maze = Maze.createMazeFromFile("src/mazes/maze02.txt");
		maze.print();
		
		MazeSearchState startState = MazeSearchState.getStartStates(maze).get(0);
		// BreadthFirst Demo (original maze takes too long):
		
		LinkedList<LinkedList<SearchState>> stack = new LinkedList<LinkedList<SearchState>>();
		LinkedList<SearchState> initialPath = new LinkedList<SearchState>();
		initialPath.add(startState);
		stack.push(initialPath);
		while (!stack.getFirst().getLast().isGoalState()) {
			LinkedList<SearchState> currentPath = stack.poll();
			for (SearchState successor: currentPath.getLast().getSuccessors()) {
				LinkedList<SearchState> newPath = new LinkedList<SearchState>(currentPath);
				//some basic pruning
				boolean cycle = false;
				for (SearchState state : currentPath) {
					if (successor.equals(state)) {
						cycle = true;
					}
				}
				if (!cycle) {
					newPath.add(successor);
					stack.add(newPath);
				}
				
			}
		}
		for (SearchState state: stack.poll()) {
			state.print();
		}
	
		
		
		// DepthFirst Demo:
//		stack = new LinkedList<LinkedList<SearchState>>();
//		stack.push(initialPath);
//		while (!stack.peek().getLast().isGoalState()) {
//			LinkedList<SearchState> currentPath = stack.pop();
//			for (SearchState successor: currentPath.getLast().getSuccessors()) {
//				LinkedList<SearchState> newPath = new LinkedList<SearchState>(currentPath);
//				boolean cycle = false;
//				for (SearchState state : currentPath) {
//					if (successor.equals(state)) {
//						cycle = true;
//					}
//				}
//				if (!cycle) {
//					newPath.add(successor);
//					stack.push(newPath);
//				}
//				
//			}
//		}
//		for (SearchState state: stack.poll()) {
//			state.print();
//		}	
    }
    
}
	
