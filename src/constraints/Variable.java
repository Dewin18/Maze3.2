package constraints;

import java.util.HashSet;

/**
 * class Variable
 *
 */
public class Variable {
	private HashSet<String> domain;

	public Variable(HashSet<String> domain) {
		this.domain = domain;
	}
	
	public HashSet<String> getDomain() {
		return domain;
	}

	public void printDomain() {
		for (String s : domain) {
			System.out.print(s + ", ");
		}
		System.out.println();
	}
	
}
