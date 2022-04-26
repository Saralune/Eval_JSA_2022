/**
 * 
 */
package fr.fms.entities;

/**
 * @author Stagiaires10P
 *
 */
public class Category {
	private int idCat;
	private String name;
	
	/**
	 * @param idCat
	 * @param name
	 */
	public Category(int idCat, String name) {
		super();
		setIdCat(idCat);
		setName(name);
	}
	
	/**
	 * @return the idCat
	 */
	public int getIdCat() {
		return idCat;
	}
	/**
	 * @param idCat the idCat to set
	 */
	public void setIdCat(int idCat) {
		this.idCat = idCat;
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
		return "Category [idCat=" + idCat + ", name=" + name + "]";
	}
}
