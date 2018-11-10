import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Main Entry Point of the Application
 *
 */
public class Main {

    public static void main(String[] args) {

		// Create the maze from a file
    	Maze maze = Maze.createMazeFromFile("src/mazes/maze03.txt");
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
    	BreadthFirstSearch bfs = new BreadthFirstSearch();
    	bfs.setStartState(startState);
    	stepByStep: while (bfs.getFrontierSize() > 0) {
    		bfs.search(true, false, true, true);
    		Scanner scanner = new Scanner(System.in);
    		System.out.println("Enter 'q' to terminate search");
    		System.out.print("§>");
    		switch(scanner.nextLine()){
    			case "q" : break stepByStep;
    		}
    	}
    	
    	// DepthFirst Demo:
    	DepthFirstSearch dfs = new DepthFirstSearch();
    	dfs.setStartState(startState);
    	stepByStep: while (dfs.getFrontierSize() > 0) {
    		dfs.search(true, false, true, true);
    		Scanner scanner = new Scanner(System.in);
    		System.out.println("Enter 'q' to terminate search");
    		System.out.print("§>");
    		switch(scanner.nextLine()){
    			case "q" : break stepByStep;
    		}
    	}
    	
    	//A* Demo
    	/*
    	MazeSearchState.setHeuristic(MazeSearchState.MANHATTEN_DISTANCE);
    	BasicHeuristicSearch aStarSearch = new BasicHeuristicSearch(new AStarComparator()); 
    	aStarSearch.setStartState(startState);
    	stepByStep: while (aStarSearch.getFrontierSize() > 0) {
    		aStarSearch.search(true, true, true, true);
    		Scanner scanner = new Scanner(System.in);
    		System.out.println("Enter 'q' to terminate search");
    		System.out.print("§>");
    		switch(scanner.nextLine()){
    			case "q" : break stepByStep;
    		}
    	}    
    	*/	

    }
    
}
	
