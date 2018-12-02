package constraints;

import java.util.HashSet;

/**
 * Model of a Variable, along with its domain
 *
 */
public class Variable {
	private HashSet<String> domain;

	/**
	 * Constructor for a variable with an initial domain
	 * 
	 * @param domain A HashSet of Strings
	 */
	public Variable(HashSet<String> domain) {
		this.domain = domain;
	}
	
	/**
	 * @return the current domain
	 */
	public HashSet<String> getDomain() {
		return domain;
	}

	/**
	 * print current domain
	 */
	public void printDomain() {
		for (String s : domain) {
			System.out.print(s + ", ");
		}
		System.out.println();
	}
	
}
