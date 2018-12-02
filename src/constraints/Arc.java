package constraints;

/**
 * very simple model of an arc <x,c>, where x is a variable and c a constraint (preferably on that variable ;).
 *
 */
public class Arc {

	
	Variable var;
	Constraint con;

	/**
	 * Constructor
	 * 
	 * @param var Variable
	 * @param con Constraint
	 */
	public Arc(Variable var, Constraint con) {
		this.var = var;
		this.con = con;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Arc)) {
			return false;
		}
		return ((Arc) o).var == var && ((Arc) o).con == con;
		
	}
	@Override
	public int hashCode() {
		return var.hashCode()+con.hashCode();
		
	}
	
}
