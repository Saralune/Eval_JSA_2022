/**
 * 
 */
package fr.fms.business;

import java.util.ArrayList;
import java.util.HashMap;

import fr.fms.dao.Dao;
import fr.fms.dao.DaoFactory;
import fr.fms.entities.Book;
import fr.fms.entities.Category;
import fr.fms.entities.Order;
import fr.fms.entities.OrderDetail;
import fr.fms.entities.User;

/**
 * @author Stagiaires10P
 *
 */
public class IBookShopImpl implements IBookShop {
	
	private HashMap<Integer,Book> cart;
	private Dao<Book> articleDao = DaoFactory.getArticleDao();
	private Dao<User> userDao = DaoFactory.getUserDao();
	private Dao<Category> categoryDao = DaoFactory.getCategoryDao();
	private Dao<Order> orderDao = DaoFactory.getOrderDao();
	private Dao<OrderDetail> orderItemDao = DaoFactory.getOrderDetailDao();

	@Override
	public void addToCart(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFromCart(int idBook) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean pay(int idUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Book> getCart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Book> readBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBookById(int idBook) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Category> readCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Book> readBooksByCatId(int idCat) {
		// TODO Auto-generated method stub
		return null;
	}

}
