package constraints;

import java.util.HashSet;

/**
 * Main Entry Point
 *
 */
public class App {

	public static void main(String[] args) {
		
		// Get HashSet of the domain
		HashSet<String> domain = new HashSet<String>();
		String[] words = {"add", "ado", "age", "ago", "aid", "ail", "aim", "air",
		"and", "any", "ape", "apt", "arc", "are", "ark", "arm",
		"art", "ash", "ask", "auk", "awe", "awl", "aye", "bad",
		"bag", "ban", "bat", "bee", "boa", "ear", "eel", "eft",
		"far", "fat", "fit", "lee", "oaf", "rat", "tar", "tie"};
		
		for (String word: words) {
			domain.add(word);
		}
		
		//init variables' domains with a copy of the full domain.
		Variable a1 = new Variable(new HashSet<String>(domain));
		Variable a2 = new Variable(new HashSet<String>(domain));
		Variable a3 = new Variable(new HashSet<String>(domain));
		Variable d1 = new Variable(new HashSet<String>(domain));
		Variable d2 = new Variable(new HashSet<String>(domain));
		Variable d3 = new Variable(new HashSet<String>(domain));
		
		// Set up Constraints
		Constraint c11 = new Constraint(a1,d1,0,0);
		Constraint c12 = new Constraint(a1,d2,0,1);
		Constraint c13 = new Constraint(a1,d3,0,2);
		Constraint c21 = new Constraint(a2,d1,1,0);
		Constraint c22 = new Constraint(a2,d2,1,1);
		Constraint c23 = new Constraint(a2,d3,1,2);
		Constraint c31 = new Constraint(a3,d1,2,0);
		Constraint c32 = new Constraint(a3,d2,2,1);
		Constraint c33 = new Constraint(a3,d3,2,2);		
		
		Constraint[] consArray = {c11, c12, c13 , c21, c22, c23, c31, c32, c33 };
		// Is there a hashSet from Array method any where?
		HashSet<Constraint> cons = new HashSet<Constraint>();
		for (Constraint con: consArray) {
			cons.add(con);
		}
		
		// run gac on the constraints
		// variables and domains are passed implicitly with the constraints
		GAC gac = new GAC(cons);
		gac.run();
		
		System.out.println("Final domains:");
		//print resulting arc consistent domains for each variable
		System.out.print("a1| "); a1.printDomain();
		System.out.print("a2| "); a2.printDomain();
		System.out.print("a3| "); a3.printDomain();
		System.out.print("d1| "); d1.printDomain();
		System.out.print("d2| "); d2.printDomain();
		System.out.print("d3| "); d3.printDomain();
		System.out.println();
		System.out.println("Solution:");
		System.out.println("boa");
		System.out.println("ear");
		System.out.println("eft");
		
		

	}

}
