/**
 * 
 */
package fr.fms.entities;

import java.util.Date;

/**
 * @author Stagiaires10P
 *
 */
public class OrderDetail {
	private int idOrder;
	private int idUser;
	private int idBook;
	private String bookName;
	private int qty;
	private Date date;
	private double unitaryPrice;

	public OrderDetail(int idOrder, int idUser, int idBook, String bookName, int qty, Date date, double unitaryPrice) {
		setIdOrder(idOrder);
		setIdUser(idUser);
		setIdBook(idBook);
		setBookName(bookName);
		setQty(qty);
		setDate(date);
		setUnitaryPrice(unitaryPrice);
	}

	/**
	 * @return the idOrder
	 */
	public int getIdOrder() {
		return idOrder;
	}

	/**
	 * @param idOrder the idOrder to set
	 */
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
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
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @return the qty
	 */
	public int getQty() {
		return qty;
	}

	/**
	 * @param qty the qty to set
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the unitaryPrice
	 */
	public double getUnitaryPrice() {
		return unitaryPrice;
	}

	/**
	 * @param unitaryPrice the unitaryPrice to set
	 */
	public void setUnitaryPrice(double unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}

	@Override
	public String toString() {
		return "OrderDetail [idOrder=" + idOrder + ", idUser=" + idUser + ", idBook=" + idBook + ", bookName="
				+ bookName + ", qty=" + qty + ", date=" + date + ", unitaryPrice=" + unitaryPrice + "]";
	}
	
	
}
