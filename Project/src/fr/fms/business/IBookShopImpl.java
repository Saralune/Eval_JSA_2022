/**
 * 
 */
package fr.fms.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import fr.fms.dao.BookDao;
import fr.fms.dao.Dao;
import fr.fms.dao.DaoFactory;
import fr.fms.dao.OrderDetailDao;
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
	
	private HashMap<Integer,Book> cart; //id book, book
	private Dao<Book> bookDao = DaoFactory.getBookDao();
	private Dao<User> userDao = DaoFactory.getUserDao();
	private Dao<Category> categoryDao = DaoFactory.getCategoryDao();
	private Dao<Order> orderDao = DaoFactory.getOrderDao();
	private Dao<OrderDetail> orderDetailDao = DaoFactory.getOrderDetailDao();
	
	public IBookShopImpl() {
		this.cart = new HashMap<Integer, Book>();
	}

	@Override
	public void addToCart(Book book) {
		Book bouk = cart.get(book.getIdBook());
		
		if(bouk != null) {
			bouk.setQty(bouk.getQty() + 1);
		} else {
			cart.put(book.getIdBook(), book);
		}
		
	}

	@Override
	public boolean removeFromCart(int idBook) {
		Book book = cart.get(idBook);
		
		if(book != null) {
			if(book.getQty() == 1)	cart.remove(idBook);
			else book.setQty(book.getQty() -1);
			return true;
		}	
		
		return false;
	}

	@Override
	public boolean pay(int idUser) {
		if(userDao.read(idUser) != null) {
			double total = getTotal(); 
			
			Order order = new Order(total, new Date(), idUser);
			
			if(orderDao.create(order)) {	//ajout en base de la commande
				
				for(Book book : cart.values()) {	//ajout des commandes minifiées associées
					orderDetailDao.create(new OrderDetail(order.getIdOrder(), order.getIdUser(), book.getIdBook(), book.getName(), book.getQty(), order.getDateOrder(), book.getPrice()));
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Book> getCart() {
		return new ArrayList<Book> (cart.values());
	}

	@Override
	public ArrayList<Book> readBooks() {
		return bookDao.readAll();
	}

	@Override
	public Book getBookById(int idBook) {
		return bookDao.read(idBook);
	}

	@Override
	public ArrayList<Category> readCategories() {
		return categoryDao.readAll();
	}

	@Override
	public ArrayList<Book> readBooksByCatId(int idCat) {
		return new BookDao().readAllByCat(idCat);
	}

	@Override
	public ArrayList<OrderDetail> readOrderDetail(int idOrder) {
		return new OrderDetailDao().readOneOrder(idOrder);
	}

	/**
	 * delete all items from cart
	 * @return boolean : true if cart cleared, false if not
	 */
	public boolean resetCart() {
		if(cart != null) {
			cart.clear();
			return true;
		}
		return false;
	}
	
	/**
	 * renvoi le total de la commande en cours
	 * @return total
	 */
	public double getTotal() {
		double [] total = {0};
		cart.values().forEach((a) -> total[0] += a.getPrice() * a.getQty()); 	
		return total[0];
	}

	/**
	 * 
	 * @param id
	 * @return name of category
	 */
	public String getCatNameById(int id) {
		return categoryDao.read(id).getName();
	}
	
	/**
	 * check if login & pwd correspon to a user u=in DB
	 * @param log
	 * @param pwd
	 * @return id de l'utilisateur, 0 si non trouvé
	 */
	public int existUser(String log, String pwd) {
		for(User user : userDao.readAll())
			if(user.getLogin().equalsIgnoreCase(log) && user.getPassword().equals(pwd))
				return user.getIdUser();
		return 0;
	}
	
	public boolean createUser(User user) {
		return userDao.create(user);
	}
}
