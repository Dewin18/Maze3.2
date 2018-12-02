package constraints;

public class Arc {

	
	Variable var;
	Constraint con;

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
	
	
}
