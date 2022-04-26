/**
 * 
 */
package fr.fms.entities;

/**
 * @author Stagiaires10P
 *
 */
public class Customer extends User {
	private String name;
	private String firstName;
	private String email;
	private String tel;
	private String address;
	

	public Customer(int idUser, String login, String password) {
		super(idUser, login, password);
	}

	public Customer(int idUser, String login, String password, String name, String firstName, String email, String tel,
			String address) {
		super(idUser, login, password);
		setName(name);
		setFirstName(firstName);
		setEmail(email);
		setTel(tel);
		setAddress(address);
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
	 * @param tel the tel to set
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
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", firstName=" + firstName + ", email=" + email + ", tel=" + tel
				+ ", address=" + address + "]";
	}
	
	
}
