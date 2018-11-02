
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
	
	Maze maze2 = Maze.createMazeFromFile("src/mazes/maze01.txt");
	maze2.print();
    }
}
