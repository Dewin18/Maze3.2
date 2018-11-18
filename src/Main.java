import java.util.Scanner;

/**
 * Main Entry Point of the Application
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

		// Create the maze from a file
    	Maze maze = Maze.createMazeFromFile("src/mazes/maze01.txt");
		// Get first startstate of the maze. We allow multiple startstates. 
    	MazeSearchState startState = MazeSearchState.getStartStates(maze).get(0);
    	BasicHeuristicSearch aStarSearch;
    	// Measure time and resources of different search strategies:
    	
//    	System.out.println("BFS:");
//        // BreadthFirst Demo:
//        // create new bfs object
//        BreadthFirstSearch bfs = new BreadthFirstSearch();
//        // set start state
//        bfs.setStartState(startState);
//        // we search using cycle detection and multiple path pruning 
//        bfs.search(true, true, true, true);
//        
//        
//        System.out.println("");
//        System.out.println("DFS");
//        // DepthFirst Demo:
//        DepthFirstSearch dfs = new DepthFirstSearch();
//        dfs.setStartState(startState);
//        dfs.search(true, true, true, true);
//
//        System.out.println("");
//        System.out.println("A*");
//    	// A Star Demo
//    	MazeSearchState.setHeuristic(MazeSearchState.MANHATTEN_DISTANCE);
//    	aStarSearch = new BasicHeuristicSearch(new AStarComparator()); 
//    	aStarSearch.setStartState(startState);
//    	aStarSearch.search(true, false, true, true);
// 
//    	maze = Maze.createMazeFromFile("src/mazes/maze08.txt");
//    	startState = MazeSearchState.getStartStates(maze).get(0);
//        System.out.println("");
//        System.out.println("A* with portals");
//    	MazeSearchState.setHeuristic(MazeSearchState.PORTAL_DISTANCE);
//    	aStarSearch.setStartState(startState);
//    	aStarSearch.search(true, true, true, true);    
    	
    	maze = Maze.createMazeFromFile("src/mazes/maze07.txt");
    	startState = MazeSearchState.getStartStates(maze).get(0);    	
    	System.out.println("");
    	System.out.println("A*, mutiple goals, portals");
  		// A Star Demo
  		MazeSearchState.setHeuristic(MazeSearchState.PORTAL_DISTANCE);
  		aStarSearch = new BasicHeuristicSearch(new AStarComparator()); 
  		aStarSearch.setStartState(startState);
  		aStarSearch.search(true, true, true, true);    	
    	
    	
    	// Find multiple solutions:
    	aStarSearch.setStartState(startState);
    	stepByStep: while (aStarSearch.getFrontierSize() > 0) {
    		aStarSearch.search(true, false, true, true);
    		Scanner scanner = new Scanner(System.in);
    		System.out.println("Enter 'q' to terminate search");
    		System.out.println("Press Enter to continue searching");
    		System.out.print("§>");
    		switch(scanner.nextLine()){
    			case "q" : break stepByStep;
    		}
    	}    
    	

    }
    
}
	
