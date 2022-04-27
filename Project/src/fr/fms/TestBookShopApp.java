/**
 * 
 */
package fr.fms;

import java.util.Date;
import java.util.Scanner;
import java.util.function.Predicate;

import fr.fms.dao.BookDao;
import fr.fms.dao.Dao;
import fr.fms.dao.DaoFactory;
import fr.fms.dao.OrderDao;
import fr.fms.dao.OrderDetailDao;
import fr.fms.dao.UserDao;
import fr.fms.entities.Book;
import fr.fms.entities.Order;
import fr.fms.entities.OrderDetail;
import fr.fms.entities.User;

/**
 * @author Stagiaires10P
 *
 */
public class TestBookShopApp {

	public static void main(String[] args) {
		//new UserDao().create(new User("toto", "123", "Toto", "Rototo", "toto@mail.com", "0561610561", "11 place du général 31000 Toulouse"));
		//new UserDao().update(new User(5, "toto", "123", "Toto", "Rotototiti", "toto@mail.com", "0561610561", "11 place du général 31000 Toulouse"));
		//new UserDao().delete(5);
		//System.out.println(new UserDao().read(4));
		
		//testUserDao();
		//testUserBook();
		//testBookDao();
		//testDaoFactory();
		
		System.out.println(new BookDao().readAllByCat(11));
		System.out.println("----");
		 
		//order1.create(new Order(10.5, new Date(), 1));
		//new OrderDao().create(new Order(53.5, new Date(), 3));
		Order order1 = new OrderDao().read(1); 
		Book book1 = new BookDao().read(1);
		Book book2 = new BookDao().read(2);
		//new OrderDetailDao().create(new OrderDetail(order1.getIdOrder(), order1.getIdUser(), book2.getIdBook(), book2.getName(), 1, order1.getDateOrder(), book2.getPrice()));
		//System.out.println(new OrderDao().read(1));
		System.out.println(new OrderDetailDao().readOneOrder(1));
		System.out.println(new OrderDetailDao().readAll());
	}

	//display all users from DB
	private static void testUserDao() {
		UserDao userDao = new UserDao();
		
		for(User user : userDao.readAll())
			System.out.println(user);
	}
	
	//check if user exists in DB and display list of books if he exists
	private static void testUserBook() {
		Scanner scan = new Scanner(System.in);
		
		UserDao userDao = new UserDao();		
		System.out.println("saisissez votre identifiant :");
		String login = scan.nextLine();
		System.out.println("saisissez votre password :");
		String pwd = scan.nextLine();	
		
		for(User user : userDao.readAll()) {
			//check in DB
			if(login.equalsIgnoreCase(user.getLogin()) && pwd.equalsIgnoreCase(user.getPassword())) {
				for(Book book : new BookDao().readAll()) {
					System.out.println(book);
				}
			}				
		}	
		
		scan.close();
	}
	
	//test CRUD : BookDao
	private static void testBookDao() {
		BookDao bookDao = new BookDao();
		
		//print all books
		for(Book book : bookDao.readAll()) {
			System.out.println(book);
		}	
		System.out.println();
		
		//Display book read with its id in DB
		Book book = bookDao.read(5);
		System.out.println(book);
		
		/* METHODS ARE NOT CREATED YET -> second step of evaluation
		 * 		
		//Update book in DB
		book.setName("Blabla");
		bookDao.update(book);
		
		//delet book in DB
		if(book != null)		
			bookDao.delete(book.getIdBook());
		
		//create book in DB
		if(book != null)		
			bookDao.create(book);*/
		
	}
	
	//test notre fabrique à objet ou composant d'accès
	private static void testDaoFactory() {
		Dao<User> userDao = DaoFactory.getUserDao();
			
		Predicate<Book> bookPredicate = a -> a.getIdBook()>= 5 && (a.getPrice() > 1 && a.getPrice() < 100); 
		DaoFactory.getBookDao().readAll()
					.stream()
					.filter(bookPredicate)
					.forEach(System.out::println);
			
		System.out.println("---------------------------------------------");
		
		userDao.readAll().forEach(user -> System.out.println(user));
	}
}
