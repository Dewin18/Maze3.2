import java.util.LinkedList;

public class Main {


    public static void main(String[] args) {

	// read a maze from a .txt file and mapps it into a 2D array of spots
	MazeReader mr = new MazeReader("src/mazes/maze01.txt");
	Spot[][] maze = mr.getMaze();

	// print the maze on the console
	mr.printMaze();

	System.out.println();

	// declare some indices for the start spot in the 2D array
	int row = 4;
	int column = 4;

	// retrieve the start spot from the location
	Spot spot = maze[row][column];
	
	//Create a new BFS
	BFS bfs = new BFS();
	LinkedList<Spot> goalPath = bfs.search(spot);

	MazeWriter mw = new MazeWriter();
	mw.writeGoalPath(maze, goalPath);
	mr.printMaze();
    }
}
