import java.awt.Point;
import java.util.LinkedList;

public class Spot {

    private final Point position;
    private char symbol;

    private Spot up;
    private Spot down;
    private Spot left;
    private Spot right;

    /**
     * 
     * @param position a unique position for a spot
     * @param symbol a spot symbol consists of 'x' = wall, 's' = start, 'g' = goal or ' ' = no wall
     */
    public Spot(Point position, char symbol) {
	this.position = position;
	this.symbol = symbol;
    }

    public char getSymbol() {
	return symbol;
    }

    public void setSymbol(char symbol) {
	this.symbol = symbol;
    }
    
    public void setSpotUp(Spot up) {
	this.up = up;
    }

    public void setSpotDown(Spot down) {
	this.down = down;
    }

    public void setSpotLeft(Spot left) {
	this.left = left;
    }

    public void setSpotRight(Spot right) {
	this.right = right;
    }

    public Point getSpotPosition() {
	return position;
    }
    
    /**
     * Get all spot neighbours from a spot
     * @return a spot set of all neighbours from a spot
     */
    public LinkedList<Spot> getNeighbours() {
	LinkedList<Spot> neighbours = new LinkedList<>();

	if (up != null)
	    neighbours.add(up);
	if (right != null)
	    neighbours.add(right);
	if (down != null)
	    neighbours.add(down);
	if (left != null)
	    neighbours.add(left);

	return neighbours;
    }
    
    public boolean hasNeighbours() {
	return up != null || down != null || left != null || right != null;
    }

    @Override
    public String toString() {
	return "spotID=" + "(" +position.x + "." + position.y + ")";
    }

}
