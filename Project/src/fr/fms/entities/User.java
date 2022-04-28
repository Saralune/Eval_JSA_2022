/**
 * 
 */
package fr.fms.entities;

/**
 * @author Stagiaires10P - Sara Lefort - 2022
 *
 */
public class User {
	private int idUser;
	private String login;
	private String password;
	private String name;
	private String firstName;
	private String email;
	private String tel;
	private String address;
	
	public User(int idUser, String login, String password, String name, String firstName, String email, String tel,
			String address) {
		setIdUser(idUser);
		setLogin(login);
		setPassword(password);
		setName(name);
		setFirstName(firstName);
		setEmail(email);
		setTel(tel);
		setAddress(address);
	}

	public User(String login, String password, String name, String firstName, String email, String tel,
			String address) {
		setLogin(login);
		setPassword(password);
		setName(name);
		setFirstName(firstName);
		setEmail(email);
		setTel(tel);
		setAddress(address);
	}
	
	/**
	 * @return the idUser
	 */
	public int getIdUser() {
		return idUser;
	}
	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}


	/**
	 * @param tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}


	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}


	/**
	 * @param address : the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", login=" + login + ", password=" + password + ", name=" + name
				+ ", firstName=" + firstName + ", email=" + email + ", tel=" + tel + ", address=" + address + "]";
	}
	
}
