import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Class representing a 2D char-Maze with portals
 *
 */
public class Maze {

	private char[][] maze;
	
	private List<Point> startingPoints;
	
	private int maxRows;
	
	private int maxColumns;
	
    private HashMap<Point, Point> portals;
	
	private Maze(char[][] maze, int rows, int columns) {
		this.maze = maze;
		this.maxColumns = columns;
		this.maxRows = rows;
		this.startingPoints = new LinkedList<Point>();
		this.portals = new HashMap<Point,Point>();
		
		
	}
    
	/**
	 * Returns all Starting points of the maze
	 * 
	 * @return List of StartingPoints
	 */
	public List<Point> getStartingPoints() {
		return startingPoints;
	}

	public HashMap<Point, Point> getPortals() {
		return portals;
	}

	/**
     * maps a String to the given row of the given char-array
     * 
     * @param currentRow index of the current row
     * @param line a String consisting of the chars to map to the current row
     * @param maze a 2D char Array onto which the Line should be mapped
	 * @throws Exception 
     */
    private static void mapLineToMazeArray(int currentRow, String line, Maze maze, HashMap<Integer,Point> portalPoints) throws Exception {
    	char mazeSymbol;
    	//loop over each x-position of the current row of the maze
    	for (int i = 0; i < maze.maxColumns; i++) {
		    //if string is too short fill up with 'x's
    		mazeSymbol = (i < line.length()) ? line.charAt(i) : 'x';
		    //if symbol is 's' add x-position to Starting points
    		if (mazeSymbol == 's') {
    			maze.startingPoints.add(new Point(i,currentRow));
		    }
    		if (Character.isDigit(mazeSymbol)) {
    			int digit = Character.getNumericValue(mazeSymbol);
    			boolean containsDigit = portalPoints.containsKey(digit);
    			Point p = portalPoints.put(digit, new Point(i,currentRow));
    			if (p != null) {
    				maze.portals.put(new Point(i,currentRow), p);
    			    maze.portals.put(p, new Point(i,currentRow));
    			    portalPoints.put(digit, null);
    			} else if (containsDigit){
    				throw new Exception("Portal mapping ambigous");
    			}
    			
    		}
    		//Fill the current position with the corresponding char of the String 
		    maze.maze[i][currentRow] = mazeSymbol;
		}

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
		    
		    //setup new Maze with the determined dimensions
		    Maze maze = new Maze(new char[maxLineLength][rowCount], rowCount, maxLineLength);
		    
		    //Setup Map for Portal Points
		    HashMap<Integer, Point> portalPoints = new HashMap<Integer, Point>();
		    
		    //read maze into 2D char array		
		    while ((line = bufferedReader.readLine()) != null) {
		    	//loop over all returned starting positions 
		    	
				mapLineToMazeArray(row, line, maze, portalPoints);

		    	row++;
		    }
		    bufferedReader.close();
		    //return the encoded Maze
		    return maze;
		} catch (IOException e) {
		    e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
						default: markedSpot = 'O';
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
