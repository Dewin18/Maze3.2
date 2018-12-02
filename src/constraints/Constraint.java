package constraints;

import java.util.HashSet;

/**
 * Model of a Constraint for the crossword puzzle
 * We only take care of constraints of the form varh[i] = varv[j] 
 * (where varh is horizontal variable, varv a vertical,
 * and var[x] is the letter with index x of the value of var) 
 *
 */
public class Constraint {
	HashSet<Variable> variables;
	private Variable horizontal;
	private Variable vertical;
	private int row;
	private int column;
	
	/**
	 * Constructor
	 * 
	 * @param horizontal a horizontal variable
	 * @param vertical a vertical variable
	 * @param row the row of the horizontal var
	 * @param column the column of the vertical var
	 */
	public Constraint(Variable horizontal, Variable vertical, int row, int column) {
		this.variables = new HashSet<Variable>();
		this.horizontal = horizontal;
		this.vertical = vertical;
		variables.add(vertical);
		variables.add(horizontal);
		this.row = row;
		this.column = column;	
	}
	
	/**
	 * Checks the satisfiability of this Constraint if
	 * a variable is bound to a specific value  
	 * 
	 * @param var
	 * @param value
	 * @return
	 */
	public boolean checkVar(Variable var, String value) {
		// we check whether the variable our horizontal var
		if (var == this.horizontal) {
			// for all Strings in the domain of the vertical var
			for (String s : vertical.getDomain()){
				// check if the constraint is satisfied
				if (s.charAt(row) == value.charAt(column)) {
					//if so, return true, 
					//because the constraint is satisfiable under this binding
					return true;
				}
			}
			// if this constraint is not satisfiable under any binding
			// it is not satisfiable at all
			return false;
		// we check whether the variable our vertical var
		} else if (var == this.vertical) {
			// for all Strings in the domain of the horizontal var
			for (String s : horizontal.getDomain()){
				// check if the constraint is satisfied
				if (s.charAt(column) == value.charAt(row)) {
					//if so, return true, 
					//because the constraint is satisfiable under this binding
					return true;
				}
			}
			// if this constraint is not satisfiable under any binding
			// it is not satisfiable at all
			return false;
		}
		//if the variable is not involved in the constraint
		// returns true, because the constraint does not care about the
		//binding of the variable
		return true;	
	}

	/**
	 * @return HashSet of the variables involved in this Constraint
	 */
	public HashSet<Variable> getVars() {
		return variables;
	}
	
	
}
