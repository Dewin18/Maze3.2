package constraints;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * Class with Generalized arc consistency algorithm
 *
 */
public class GAC {
	
	private HashSet<Constraint> cons;
	private LinkedList<Arc> arcs;
	
	public GAC(HashSet<Constraint> cons) {
		this.arcs = new LinkedList<Arc>();
		this.cons = cons;
	}
	
	 /**
     * used for the solution of constraint satisfaction problems.
     * operates on constraints, variables, and the variables domains (scopes).  
     * domains are made consistent with constraints.
     */
	public void run() {
		for (Constraint con: cons) {
			for (Variable var: con.getVars()) {
				arcs.add(new Arc(var, con));
			}
		}
		while (!arcs.isEmpty()) {
			Arc arc = arcs.poll();
			Iterator<String> domainIterator = arc.var.getDomain().iterator();
			boolean changed = false;
			while (domainIterator.hasNext()) {
				String s = domainIterator.next();
				if (!arc.con.checkVar(arc.var, s)) {
					domainIterator.remove();
					changed = true;
				}
			}
			if (!changed) continue;
			for (Constraint con: cons) {
				if (!con.equals(arc.con) && con.getVars().contains(arc.var)) {
					for (Variable var: con.getVars()) {
						Arc newArc = new Arc(var, con);
						if (!arc.var.equals(var) && !arcs.contains(newArc)) {
							arcs.add(newArc);
						}
					}
					
				}
			}
			
		}
		
		
	}

}
