/**
 * 
 */
package fr.fms.entities;

/**
 * @author Stagiaires10P
 *
 */
public class Book {
	private int idBook;
	private String author;
	private String name;
	private double price;
	private int idCat1;
	private int idCat2;
	private int idCat3;
	
	public Book(int idBook, String author, String name, double price, int idCat1, int idCat2, int idCat3) {
		setIdBook(idBook);
		setAuthor(author);
		setName(name);
		setPrice(price);
		setIdCat1(idCat1);
		setIdCat2(idCat2);
		setIdCat3(idCat3);
	}
	
	/**
	 * @return the idBook
	 */
	public int getIdBook() {
		return idBook;
	}
	/**
	 * @param idBook the idBook to set
	 */
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
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
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the idCat1
	 */
	public int getIdCat1() {
		return idCat1;
	}
	/**
	 * @param idCat1 the idCat1 to set
	 */
	public void setIdCat1(int idCat1) {
		this.idCat1 = idCat1;
	}
	/**
	 * @return the idCat2
	 */
	public int getIdCat2() {
		return idCat2;
	}
	/**
	 * @param idCat2 the idCat2 to set
	 */
	public void setIdCat2(int idCat2) {
		this.idCat2 = idCat2;
	}
	/**
	 * @return the idCat3
	 */
	public int getIdCat3() {
		return idCat3;
	}
	/**
	 * @param idCat3 the idCat3 to set
	 */
	public void setIdCat3(int idCat3) {
		this.idCat3 = idCat3;
	}

	@Override
	public String toString() {
		String str ="Book [idBook=" + idBook + ", author=" + author + ", name=" + name + ", price=" + price;
		
		if(getIdCat1() != 0) {
			str += ", idCat1="+ idCat1;
		} 
		
		if(getIdCat2() != 0) {
			str += ", idCat2="+ idCat2;
		} 

		if(getIdCat3() != 0) {
			str += ", idCat3="+ idCat3;
		}
		
		str += "]";
		
		return str;
	}
	
}
