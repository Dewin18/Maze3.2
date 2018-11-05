import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Class representing a 2D char-Maze
 *
 */
public class Maze {

	private char[][] maze;
	
	private List<Point> startingPoints;
	
	private int maxRows;
	
	private int maxColumns;
	
    private Maze(char[][] maze, int rows, int columns, List<Point> startingPoints) {
		this.maze = maze;
		this.maxColumns = columns;
		this.maxRows = rows;
		this.startingPoints = startingPoints;
		
	}
    
	/**
	 * Returns all Starting points of the maze
	 * 
	 * @return List of StartingPoints
	 */
	public List<Point> getStartingPoints() {
		return startingPoints;
	}

	/**
     * maps a String to the given row of the given char-array
     * 
     * @param currentRow index of the current row
     * @param line a String consisting of the chars to map to the current row
     * @param maze a 2D char Array onto which the Line should be mapped
     * 
     * @return A List containing the positions of 's' within the String
     */
    private static List<Integer> mapLineToMazeArray(int currentRow, String line, char[][] maze) {
    	char mazeSymbol;
    	//prepare List of starting Points
    	List<Integer> startingPoints = new LinkedList<Integer>();
    	//a loop over each x-postion of the current row of the maze
    	for (int i = 0; i < maze.length; i++) {
		    //if string is too short fill up with 'x's
    		mazeSymbol = (i < line.length()) ? line.charAt(i) : 'x';
		    //if symbol is 's' add x-position to Starting points
    		if (mazeSymbol == 's') {
		    	startingPoints.add(i);
		    }
    		//Fill the current position with the corresponding char of the String 
		    maze[i][currentRow] = mazeSymbol;
		}
    	return startingPoints;
    }
	
	/**
	 * Creates a Maze from a .txt file
	 * 
	 * @param pathToFile PAth to the file containing the maze
	 * @return a Maze
	 */
	public static Maze createMazeFromFile(String pathToFile) {
		try {
		    FileReader fileReader = new FileReader(pathToFile);
		    BufferedReader bufferedReader = new BufferedReader(fileReader);
		    String line;
		    int rowCount = 0;
		    int maxLineLength = 0;
		    // determine dimensions of the encoded maze
		    while ((line = bufferedReader.readLine()) != null) {
		    	//set maxLineLength to be the size of the largest row so far.
		    	maxLineLength = Math.max(maxLineLength, line.length());
		    	rowCount++;
		    }
		    fileReader = new FileReader(pathToFile);
		    bufferedReader = new BufferedReader(fileReader);
		    int row = 0;
		    //setup new 2D char array with the determined dimensions
		    char[][] maze = new char[maxLineLength][rowCount];
		    //prepare List of starting Points
		    List<Point> startingPoints = new LinkedList<Point>();
		    //read maze into 2D char array
		    while ((line = bufferedReader.readLine()) != null) {
		    	//loop over all returned starting positions 
		    	for(Integer xPosition: mapLineToMazeArray(row, line, maze)) {
		    		// add corresponding point to starting point.
		    		startingPoints.add(new Point(xPosition,row));
		    	}
		    	row++;
		    }
		    bufferedReader.close();
		    //return the encoded Maze
		    return new Maze(maze, rowCount, maxLineLength, startingPoints);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	/**
	 *  Prints out the Maze to the console with a Point marked. The style of the mark 
	 *  depends on the type of the point  
	 *  
	 *  @param p a specialPoint to be Marked
	 */
	public void print(Point p) {
		// For all rows, 
		for(int y = 0; y < maxRows; y++) {
			// for all columns
			for(int x = 0; x < maxColumns; x++) {
				//print out current field of the maze if it is not the special point
				if (p == null || !p.equals(new Point(x,y))) {
					System.out.print(maze[x][y]);
				// else print a suitable mark on the spot.
				} else {
					char markedSpot;
					switch(maze[x][y]) {
						case ' ' : markedSpot = '|'; break;
						case 's' : markedSpot = '$'; break;
						case 'g' : markedSpot = '§'; break;
						default: markedSpot = maze[x][y];
					}
					System.out.print(markedSpot);
				}
					
			}	
			System.out.println();
		}
	}
	
	/**
	 *  Prints out the Maze to the console
	 */
	public void print() {
		print(null);
	}	
	
	/**
	 * Returns the symbol at x,y  or 'x' if bound are exceeded;
	 * 
	 * @param x the x position
	 * @param y the y position
	 * 
	 * @return the char at x,y or 'x' if bound are exceeded;
	 */
	public char getSymbol(Point p) {
		// check whether point is inside dimensions and return corresponding element of the 2D char array
		if (p.x >= 0 && p.x < this.maxColumns && p.y >= 0 && p.y < this.maxRows) {
			return this.maze[p.x][p.y];
		// return x if this is not the case
		} else {
			return 'x';
		}
	}

	
	/**
	 * Helper Mathod to generate a list of all neighbouring points.
	 * @param position Point for which the neighbours should be generated 
	 * @return List of neighbouring Points
	 */
	public static List<Point> getNeighbours(Point position) {
		List<Point> neighbours = new LinkedList<Point>();
		neighbours.add(new Point(position.x + 1, position.y));
		neighbours.add(new Point(position.x - 1, position.y));
		neighbours.add(new Point(position.x, position.y + 1));
		neighbours.add(new Point(position.x, position.y - 1));
		return neighbours;
	}
	
}
