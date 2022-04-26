/**
 * 
 */
package fr.fms.dao;

import fr.fms.entities.Book;
import fr.fms.entities.Category;
import fr.fms.entities.Order;
import fr.fms.entities.OrderDetail;
import fr.fms.entities.User;

/**
 * @author Stagiaires10P
 *
 */
public class DaoFactory {
	public static Dao<Book> getArticleDao() {
		return new BookDao();		
	}
	
	public static Dao<User> getUserDao() {
		return new UserDao();
	}
	
 	public static Dao<Category> getCategoryDao() {
 		return new CategoryDao();
 	}
 	
 	public static Dao<Order> getOrderDao() {
 		return new OrderDao();
 	}
 	
 	public static Dao<OrderDetail> getOrderDetailDao() {
 		return new OrderDetailDao();
 	}
}
