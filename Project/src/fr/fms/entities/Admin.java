/**
 * 
 */
package fr.fms.entities;

/**
 * @author Stagiaires10P - Sara Lefort - 2022
 *
 */
public class Admin extends User {
	private String name;
	
	public Admin(int idUser, String login, String password, String name) {
		super(idUser, login, password);
		setName(name);
	}

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
