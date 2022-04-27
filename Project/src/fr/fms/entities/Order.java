/**
 * 
 */
package fr.fms.entities;

import java.util.Date;

/**
 * @author Stagiaires10P - Sara Lefort - 2022
 *
 */
public class Order {
	private int idOrder;
	private double amount;
	private Date dateOrder;
	private int idUser;

	public Order(int idOrder, double amount, Date date, int idUser) {
		setIdOrder(idOrder);
		setAmount(amount);
		setDateOrder(date);
		setIdUser(idUser);
	}
	
	public Order(double amount, Date date, int idUser) {
		setAmount(amount);
		setDateOrder(date);
		setIdUser(idUser);
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
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * @return the date
	 */
	public Date getDateOrder() {
		return dateOrder;
	}
	/**
	 * @param date the date to set
	 */
	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
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

	@Override
	public String toString() {
		return "Order [idOrder=" + idOrder + ", amount=" + amount + ", dateOrder=" + dateOrder + ", idUser=" + idUser + "]";
	}
	
}
