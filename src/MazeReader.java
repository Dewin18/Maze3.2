import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MazeReader {

    private Spot[][] maze;
    private final int rows;
    private final int columns;

    /**
     * Initialize a new 2D array with rows and columns
     * 
     * @param rows of the maze
     * @param columns of the maze
     * @param mazePath local path to the maze.txt
     */
    public MazeReader(int rows, int columns, String mazePath) {
	this.rows = rows;
	this.columns = columns;

	maze = new Spot[rows][columns];
	analyzeMaze(mazePath);
	setSpotNeighbours();
    }

    private void analyzeMaze(String mazePath) {
	try {
	    FileReader fileReader = new FileReader(mazePath);
	    BufferedReader bufferedReader = new BufferedReader(fileReader);
	    String line;
	    int row = 0;

	    while ((line = bufferedReader.readLine()) != null) {
		mazeMapping(row, line);
		row++;
	    }
	    bufferedReader.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * Maps each char from the maze.txt file to the 2D array as a spot
     * 
     * @param currentRow
     * @param line of chars
     */
    private void mazeMapping(int currentRow, String line) {
	for (int i = 0; i < line.length(); i++) {
	    char mazeSymbol = line.charAt(i);
	    maze[currentRow][i] = new Spot(currentRow + "" + i, mazeSymbol);
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

    
    //just print the maze char by char on the console
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
