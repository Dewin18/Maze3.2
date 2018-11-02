
public class Main {

    public static void main(String[] args) {

	// read a maze from a .txt file and mapps it into a 2D array of spots
	MazeReader mr = new MazeReader(10, 20, "src/mazes/maze01.txt");
	Spot[][] maze = mr.getMaze();
	
	// print the maze on the console
	mr.printMaze();

	System.out.println();

	// declare some test indices e.g. maze[4][4];
	int x = 4;
	int y = 4;

	System.out.println("Spot: " + maze[x][y]);
	System.out.println("Spot neighbours: " + maze[x][y].getNeighbours());
    }
}
