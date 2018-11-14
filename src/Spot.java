import java.awt.Point;
import java.util.LinkedList;

public class Spot {

    private LinkedList<Spot> neighbours;
    
    private final Point position;
    private char symbol;

    /**
     * 
     * @param position a unique position for a spot
     * @param symbol   a spot symbol has different meanings:
     * 			'x' = wall, 
     * 			's' = start, 
     * 			'g' = goal
     *                  ' ' = no wall
     *              [1..n]  = any different char (number or letter) is a portal
     */
    public Spot(Point position, char symbol) {
	neighbours = new LinkedList<>();
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
	neighbours.add(up);
    }

    public void setSpotDown(Spot down) {
	neighbours.add(down);
    }

    public void setSpotLeft(Spot left) {
	neighbours.add(left);
    }

    public void setSpotRight(Spot right) {
	neighbours.add(right);
    }

    public Point getSpotPosition() {
	return position;
    }

    /**
     * Get all spot neighbours from a spot
     * 
     * @return a set of spots with all neighbours
     */
    public LinkedList<Spot> getNeighbours() {
	return neighbours;
    }
    
    public void swapSpotNeighbours(Spot spot) {
	LinkedList<Spot> thisSpot = new LinkedList<>(neighbours);
	LinkedList<Spot> nextSpot = new LinkedList<>(spot.neighbours);
	
	spot.neighbours = thisSpot;
	neighbours = nextSpot;
    }

    @Override
    public String toString() {
	return "spotID=" + "(" + position.x + "." + position.y + ")";
    }
}
