package constraints;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * A Class that runs gac on a set of constraints.
 *
 */
public class GAC {
	
	private HashSet<Constraint> cons;
	private LinkedList<Arc> arcs;
	
	/**
	 * The Constraints (along with the variables and their domains) 
	 * are passed as a Constructor argument
	 * 
	 * @param cons Constraints
	 */
	public GAC(HashSet<Constraint> cons) {
		this.arcs = new LinkedList<Arc>();
		this.cons = cons;
	}
	
	/**
	 * runs the algorithm
	 */
	public void run() {
		// for each constrain
		for (Constraint con: cons) {
			// for all its variables
			for (Variable var: con.getVars()) {
				//add the corresponding arc to the arc list
				arcs.add(new Arc(var, con));
			}
		}
		// while the list of arcs is not empty
		while (!arcs.isEmpty()) {
			//get next arc
			Arc arc = arcs.poll();
			//get an iterator over the variable's domain
			Iterator<String> domainIterator = arc.var.getDomain().iterator();
			boolean changed = false;
			// for all Strings in the domain
			while (domainIterator.hasNext()) {
				String s = domainIterator.next();
				//check whether the constraint is satisfiable if
				//the var is bound the String
				if (!arc.con.checkVar(arc.var, s)) {
					domainIterator.remove();
					changed = true;
				}
			}
			if (!changed) continue;
			// for all constraints
			for (Constraint con: cons) {
				// if they are different from the current one
				// and contain the variable
				if (!con.equals(arc.con) && con.getVars().contains(arc.var)) {
					// for each variable of that constraint 
					for (Variable var: con.getVars()) {
						//construct corresponding arc 
						Arc newArc = new Arc(var, con);
						 //if the variable is different from the current
						 //and the corresponding arc is not already on the list
						if (!arc.var.equals(var) && !arcs.contains(newArc)) {
							// add arc
							arcs.add(newArc);
						}
					}
				}
			}
		}
	}

}
