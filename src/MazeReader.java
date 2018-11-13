import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class MazeReader {

    private ArrayList<LinkedList<Character>> mazeWrapper;
    private Spot[][] maze;

    private int rows;
    private int columns;

    /**
     * Initialize a new 2D array with rows and columns
     * 
     * @param mazePath local path to the maze.txt
     */
    public MazeReader(String mazePath) {
	mazeWrapper(mazePath);
	initMaze();
	mazeMapping();
	setSpotNeighbours();
    }

    private void mazeWrapper(String mazePath) {
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
	    }
	}
    }

    /**
     * helper method the set all neighbours for each spot
     */
    private void setSpotNeighbours() {
	for (int i = 1; i < rows; i++) {
	    for (int j = 1; j < columns; j++) {
		if (maze[i][j].getSymbol() != 'x') {
		    setSpotUp(i, j);
		    setSpotDown(i, j);
		    setSpotLeft(i, j);
		    setSpotRight(i, j);
		}
	    }
	}
    }

    private void setSpotUp(int i, int j) {
	if (maze[i - 1][j].getSymbol() != 'x') {
	    maze[i][j].setSpotUp(maze[i - 1][j]);
	}
    }

    private void setSpotDown(int i, int j) {
	if (maze[i + 1][j].getSymbol() != 'x') {
	    maze[i][j].setSpotDown(maze[i + 1][j]);
	}
    }

    private void setSpotLeft(int i, int j) {
	if (maze[i][j - 1].getSymbol() != 'x') {
	    maze[i][j].setSpotLeft(maze[i][j - 1]);
	}
    }

    private void setSpotRight(int i, int j) {
	if (maze[i][j + 1].getSymbol() != 'x') {
	    maze[i][j].setSpotRight(maze[i][j + 1]);
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
