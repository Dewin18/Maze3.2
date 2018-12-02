package constraints;

import java.util.HashSet;

/**
 * initializes a list of domains and it´s variables.
 * starts the class GAC with Generalized arc consistency algorithm.
 */
public class App {

	public static void main(String[] args) {
		HashSet<String> domain = new HashSet<String>();
		
		String[] words = {"add", "ado", "age", "ago", "aid", "ail", "aim", "air",
		"and", "any", "ape", "apt", "arc", "are", "ark", "arm",
		"art", "ash", "ask", "auk", "awe", "awl", "aye", "bad",
		"bag", "ban", "bat", "bee", "boa", "ear", "eel", "eft",
		"far", "fat", "fit", "lee", "oaf", "rat", "tar", "tie"};
		
		for (String word: words) {
			domain.add(word);
		}
		
		Variable a1 = new Variable(new HashSet<String>(domain));
		Variable a2 = new Variable(new HashSet<String>(domain));
		Variable a3 = new Variable(new HashSet<String>(domain));
		Variable d1 = new Variable(new HashSet<String>(domain));
		Variable d2 = new Variable(new HashSet<String>(domain));
		Variable d3 = new Variable(new HashSet<String>(domain));
		
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
		HashSet<Constraint> cons = new HashSet<Constraint>();
		for (Constraint con: consArray) {
			cons.add(con);
		}
		
		GAC gac = new GAC(cons);
		gac.run();
		
		a1.printDomain();
		a2.printDomain();
		a3.printDomain();
		d1.printDomain();
		d2.printDomain();
		d3.printDomain();
		

	}

}
