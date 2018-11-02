import java.util.HashSet;
import java.util.Set;

public class Spot {

    private final String spotID;
    private final char spotSymbol;

    private Spot up;
    private Spot down;
    private Spot left;
    private Spot right;

    /**
     * 
     * @param spotID a unique ID for a spot
     * @param spotSymbol a spot symbol consists of 'x' = wall, 's' = start, 'g' = goal or ' ' = no wall
     */
    public Spot(String spotID, char spotSymbol) {
	this.spotID = spotID;
	this.spotSymbol = spotSymbol;
    }

    public char getSymbol() {
	return spotSymbol;
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

    public Spot getSpotUp() {
	return up;
    }

    public Spot getSpotDown() {
	return down;
    }

    public Spot getSpotLeft() {
	return left;
    }

    public Spot getSpotRight() {
	return right;
    }

    public String getSpotID() {
	return spotID;
    }

    /**
     * Get all spot neighbours from a spot
     * @return a spot set of all neighbours from a spot
     */
    public Set<Spot> getNeighbours() {
	Set<Spot> neighbours = new HashSet<>();

	if (up != null)
	    neighbours.add(up);
	if (down != null)
	    neighbours.add(down);
	if (left != null)
	    neighbours.add(left);
	if (right != null)
	    neighbours.add(right);

	return neighbours;
    }

    @Override
    public String toString() {
	return "[spotID=" + spotID + ", spotSymbol=" + spotSymbol + "]";
    }

}
