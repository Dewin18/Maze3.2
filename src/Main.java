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
	int startRow = 4;
	int startColumn = 4;

	// retrieve the start spot from the location
	Spot spot = maze[startRow][startColumn];
	Spot spot2 =  maze[7][14];
	System.out.println(spot2.getSymbol());
	//Create a new BFS
	
	A a = new A(spot,spot2);
	
	BFS  bfs = new BFS();
	LinkedList<Spot> goalPath = bfs.search(spot);

	MazeWriter mw = new MazeWriter();
	mw.writeGoalPath(maze, goalPath);
	mr.printMaze();
    }
}
