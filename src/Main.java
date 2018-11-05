import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Main Entry Point of the Application
 *
 */
public class Main {

    public static void main(String[] args) {

		// Create the maze from a file
    	Maze maze = Maze.createMazeFromFile("src/mazes/maze01.txt");
		// Get first startstate of the maze. We allow multiple startstates. 
    	MazeSearchState startState = MazeSearchState.getStartStates(maze).get(0);
		
//    	//print StartState
//    	System.out.println("The start state of the maze:");
//		startState.print();
//		//print all successor of the startstate
//    	System.out.println("All successors of the start state:");
//		for (SearchState state: startState.getSuccessors()) {
//			state.print();
//		}
		
		// BreadthFirst Demo:
		List<SearchState> addedStates = new LinkedList<SearchState>();
		LinkedList<LinkedList<SearchState>> stack = new LinkedList<LinkedList<SearchState>>();
		LinkedList<SearchState> initialPath = new LinkedList<SearchState>();
		initialPath.add(startState);
		stack.push(initialPath);
		while (!stack.getFirst().getLast().isGoalState()) {
			System.out.println(stack.size() + ", " + stack.getFirst().size());
			LinkedList<SearchState> currentPath = stack.poll();
			for (SearchState successor: currentPath.getLast().getSuccessors()) {
				//some basic pruning - don't add the path if the successor has already been visited
				if (addedStates.contains(successor)) {
					continue;
				}
				LinkedList<SearchState> newPath = new LinkedList<SearchState>(currentPath);
				//some more basic pruning - don't add the path if it contains a cycle
				boolean cycle = false;
				for (SearchState state : currentPath) {
					if (successor.equals(state)) {
						cycle = true;
						break;
					}
				}
				if (!cycle) {
					newPath.add(successor);
					addedStates.add(successor);
					stack.add(newPath);
				}
				
			}
		}
		for (SearchState state: stack.poll()) {
			state.print();
		}
	
		
		
		// DepthFirst Demo:
//		addedStates = new LinkedList<SearchState>();
//		stack = new LinkedList<LinkedList<SearchState>>();
//		stack.push(initialPath);
//		while (!stack.peek().getLast().isGoalState()) {
//			LinkedList<SearchState> currentPath = stack.pop();
//			for (SearchState successor: currentPath.getLast().getSuccessors()) {
//				if (addedStates.contains(successor)) {
//					continue;
//				}
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
	
