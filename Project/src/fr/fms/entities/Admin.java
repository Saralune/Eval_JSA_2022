/**
 * 
 */
package fr.fms.entities;

/**
 * @author Stagiaires10P - Sara Lefort - 2022
 *
 */
public class Admin extends User {
	
	///
	
	public Admin(String login, String password, String name, String firstName, String email, String tel,
			String address) {
		super(login, password, name, firstName, email, tel, address);
	}

	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Admin [name=" + name + "]";
	}
	
}
