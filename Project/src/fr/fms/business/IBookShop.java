/**
 * 
 */
package fr.fms.business;

import java.util.ArrayList;

import fr.fms.entities.Book;
import fr.fms.entities.Category;
import fr.fms.entities.OrderDetail;

/**
 * @author Stagiaires10P
 *
 */
public interface IBookShop {
	
	/**
	 * Method to add a book on the user cart.
	 * @param book 
	 */
	public void addToCart(Book book);
	
	/**
	 * This remove book (found by id) from cart.
	 * @param idBook
	 * @return boolean
	 */
	public boolean removeFromCart(int idBook);
	
	/**
	 * This method is used when user wants to validate is order :
	 * - method checks if user exists in DB
	 * - it creates order and order detail in DB
	 * - it remove items from cart
	 * @param idUser
	 * @return boolean
	 */
	public boolean pay(int idUser);
	
	/**
	 * return all elements of cart
	 * @return ArrayList of elements in cart
	 */
	public ArrayList<Book> getCart();
	
	/**
	 * it returns all books saved in table Book, in DB
	 * @return ArrayList of books
	 */
	public ArrayList<Book> readBooks();
	
	/**
	 * method that returns a book
	 * @param idBook - id a the book in DB
	 * @return Book
	 */
	public Book getBookById(int idBook);
	
	/**
	 * method that return a list of all categories in DB
	 * @return ArrayList of category
	 */
	public ArrayList<Category> readCategories();
	
	/**
	 * method that return a list of all book which have id cat in DB
	 * @param idCat
	 * @return ArrayList of Book
	 */
	public ArrayList<Book> readBooksByCatId(int idCat);
	
	/**
	 * return a list of books contains in order
	 * @param idOrder
	 * @return list of detail of order
	 */
	public ArrayList<OrderDetail> readOrderDetail(int idOrder);
	
}
