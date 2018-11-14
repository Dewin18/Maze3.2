import java.awt.Point;
import java.io.*;
import java.util.*;

public class MazeReader {

    private ArrayList<LinkedList<Character>> mazeWrapper;
    private TreeSet<Portal> portals;
   
    private Spot[][] maze;
    private int rows;
    private int columns;

    // possible spot symbols
    private final char START = 's';
    private final char GOAL = 'g';
    private final char WALL = 'x';
    private final char SPACE = ' ';

    /**
     * Initialize a new 2D array with rows and columns
     * 
     * @param mazePath local path to the maze.txt
     */
    public MazeReader(String mazePath) {
	portals = new TreeSet<>();

	mazeWrapping(mazePath);
	initMaze();
	mazeMapping();
	setSpotNeighbours();
	activatePortals();
    }

    /**
     * Wraps the maze.txt file in an ArrayList of segments. All segments define the
     * number of rows for the maze. Each segment consist of symbols defining the
     * number of columns.
     * 
     * @param mazePath
     */
    private void mazeWrapping(String mazePath) {
	mazeWrapper = new ArrayList<>();

	try {
	    FileReader fileReader = new FileReader(mazePath);
	    BufferedReader bufferedReader = new BufferedReader(fileReader);
	    String line;

	    while ((line = bufferedReader.readLine()) != null) {

		LinkedList<Character> mazeSegment = new LinkedList<>();

		for (int i = 0; i < line.length(); i++) {
		    mazeSegment.add(line.charAt(i));
		}
		mazeWrapper.add(mazeSegment);
	    }
	    bufferedReader.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    private void initMaze() {
	this.rows = mazeWrapper.size();
	this.columns = mazeWrapper.get(0).size();

	maze = new Spot[rows][columns];
    }

    private void mazeMapping() {
	for (int i = 0; i < rows; i++) {
	    for (int j = 0; j < columns; j++) {
		Point position = new Point(i, j);
		char symbol = mazeWrapper.get(i).get(j);
		Spot spot = new Spot(position, symbol);
		maze[i][j] = spot;

		storePortals(spot, symbol);
	    }
	}
    }

    /**
     * If portals are found during the mapping phase, they are stored in a set of
     * portals
     * 
     * @param spot
     * @param symbol
     */
    private void storePortals(Spot spot, char symbol) {
	if (symbol != WALL && symbol != SPACE && symbol != START && symbol != GOAL) {
	    portals.add(new Portal(spot));
	}
    }

    /**
     * helper method the set all neighbours for each spot
     */
    private void setSpotNeighbours() {
	for (int i = 1; i < rows; i++) {
	    for (int j = 1; j < columns; j++) {

		char symbol = maze[i][j].getSymbol();
		if (symbol != WALL) {
		    setSpotUp(i, j);
		    setSpotDown(i, j);
		    setSpotLeft(i, j);
		    setSpotRight(i, j);
		}
	    }
	}
    }

    private void setSpotUp(int i, int j) {
	if (maze[i - 1][j].getSymbol() != WALL) {
	    maze[i][j].setSpotUp(maze[i - 1][j]);
	}
    }

    private void setSpotDown(int i, int j) {
	if (maze[i + 1][j].getSymbol() != WALL) {
	    maze[i][j].setSpotDown(maze[i + 1][j]);
	}
    }

    private void setSpotLeft(int i, int j) {
	if (maze[i][j - 1].getSymbol() != WALL) {
	    maze[i][j].setSpotLeft(maze[i][j - 1]);
	}
    }

    private void setSpotRight(int i, int j) {
	if (maze[i][j + 1].getSymbol() != WALL) {
	    maze[i][j].setSpotRight(maze[i][j + 1]);
	}
    }

    /**
     * All portals are stored in an ascending ordered TreeSet of symbols (chars).
     */
    private void activatePortals() {
	while (!portals.isEmpty()) {
	    Spot portalSpot1 = portals.pollFirst().getPortalSpot();
	    Spot portalSpot2 = portals.pollFirst().getPortalSpot();

	    portalSpot1.swapSpotNeighbours(portalSpot2);
	}
    }

    // just print the maze char by char on the console
    public void printMaze() {
	for (int i = 0; i < rows; i++) {
	    for (int j = 0; j < columns; j++) {
		System.out.print(maze[i][j].getSymbol());
	    }
	    System.out.println();
	}
    }

    public Spot[][] getMaze() {
	return maze;
    }
}
