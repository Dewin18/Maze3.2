
public class Portal implements Comparable<Portal>{
    
    private Spot spot;
    private char symbol;
    
    public Portal(Spot spot) {
	this.spot = spot;
	symbol = spot.getSymbol();
    }
    
    public char getSymbol() {
	return symbol;
    }
    
    public Spot getPortalSpot() {
	return spot;
    }

    @Override
    public int compareTo(Portal p) {
	if(this.getSymbol() < p.getSymbol()) {
	    return -1;
	}
	return 1;
    }
}
