import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

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
    
	public List<Point> getStartingPoints() {
		return startingPoints;
	}

	/**
     * create for each char from the maze.txt file a new Spot object and place it
     * into the 2D array (maze[][]).
     * 
     * @param currentRow index of the current row
     * @param line a String consisting of the chars of the current row
     * 
     * @return A List containing the positions  's'
     */
    private static List<Integer> mapLineToMazeArray(int currentRow, String line, char[][] maze) {
    	char mazeSymbol;
    	List<Integer> startingPoints = new LinkedList<Integer>();
    	for (int i = 0; i < maze.length; i++) {
		    mazeSymbol = (i < line.length()) ? line.charAt(i) : 'x';
		    if (mazeSymbol == 's') {
		    	startingPoints.add(i);
		    }
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
		    while ((line = bufferedReader.readLine()) != null) {
		    	maxLineLength = Math.max(maxLineLength, line.length());
		    	rowCount++;
		    }
		    fileReader = new FileReader(pathToFile);
		    bufferedReader = new BufferedReader(fileReader);
		    int row = 0;
		    char[][] maze = new char[maxLineLength][rowCount];
		    List<Point> startingPoints = new LinkedList<Point>();
		    while ((line = bufferedReader.readLine()) != null) {
		    	for(Integer xPosition: mapLineToMazeArray(row, line, maze)) {
		    		startingPoints.add(new Point(xPosition,row));
		    	}
		    	row++;
		    }
		    bufferedReader.close();
		    return new Maze(maze, rowCount, maxLineLength, startingPoints);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	/**
	 *  Prints out the Maze to the console
	 *  
	 *  @param p a specialPoint to be Marked
	 */
	public void print(Point p) {
		for(int y = 0; y < maxRows; y++) {
			for(int x = 0; x < maxColumns; x++) {
				if (p == null || !p.equals(new Point(x,y))) {
					System.out.print(maze[x][y]);
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
		if (p.x >= 0 && p.x < this.maxColumns && p.y >= 0 && p.y < this.maxRows) {
			return this.maze[p.x][p.y];
		} else {
			return 'x';
		}
	}

	public static List<Point> getNeighbours(Point position) {
		List<Point> neighbours = new LinkedList<Point>();
		neighbours.add(new Point(position.x + 1, position.y));
		neighbours.add(new Point(position.x - 1, position.y));
		neighbours.add(new Point(position.x, position.y + 1));
		neighbours.add(new Point(position.x, position.y - 1));
		return neighbours;
	}
	
}
