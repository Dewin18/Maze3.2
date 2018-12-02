package constraints;

import java.util.HashSet;

public class Constraint {
	HashSet<Variable> variables;
	private Variable horizontal;
	private Variable vertical;
	private int row;
	private int column;
	
	public Constraint(Variable horizontal, Variable vertical, int row, int column) {
		this.variables = new HashSet<Variable>();
		this.horizontal = horizontal;
		this.vertical = vertical;
		variables.add(vertical);
		variables.add(horizontal);
		this.row = row;
		this.column = column;	
	}
	
	public boolean checkVar(Variable var, String value) {
		if (var == this.horizontal) {
			for (String s : vertical.getDomain()){
				if (s.charAt(row) == value.charAt(column)) {
					return true;
				}
			}
			return false;
		} else if (var == this.vertical) {
			for (String s : horizontal.getDomain()){
				if (s.charAt(column) == value.charAt(row)) {
					return true;
				}
			}
			return false;
		}
		return true;	
	}

	public HashSet<Variable> getVars() {
		return variables;
	}
	
	
}
