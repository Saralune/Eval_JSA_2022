/**
 * Application : Book Shop
 * @author Sara Lefort - 2022
 */
package fr.fms;

import java.util.Collections;
import java.util.Scanner;

import fr.fms.business.IBookShopImpl;
import fr.fms.entities.User;

/**
 * @author Stagiaires10P
 *
 */
public class BookShopApp {
	private static Scanner scan = new Scanner(System.in);
	private static IBookShopImpl business = new IBookShopImpl();
	
	private static int idUser = 0;
	private static String login = null;
	
	public static void main(String[] args) {
		System.out.println("Bonjour et bienvenue sur notre application de vente de livres neuf et d'occasion.");
		
		int choice = 0;
		while(choice != 7) {
			displayMenu();
			
			choice = scanInt();
			
			switch(choice) {
				case 1:
					displayBooks();
					break;
					
				case 2:
					displayBooksInCat();
					break;
					
				case 3: 
					addBookToCart();
					break;
					
				case 4:
					deleteFromCart();
					break;
					
				case 5:
					order();
					break;
					
				case 6:
					connection();
					break;
					
				case 7:
					System.out.println("Au revoir !");
					break;
			}
		}	
	}
	
	/**
	 * Print menu choices 
	 */
	public static void displayMenu() {	
		System.out.println("\nQue souhaitez-vous faire ?");
		System.out.println("1. Visualiser tous les livres disponibles.");
		System.out.println("2. Visualiser tous les livres d'une catégorie.");
		System.out.println("3. Ajouter un livre au panier.");
		System.out.println("4. Supprimer un livre du panier.");
		System.out.println("5. Voir le panier et passer commande.");
		System.out.println("6. Connexion au compte.");
		System.out.println("7. Quitter l'application.");
	}

	/**
	 * Check if answer of user is an int
	 * @return answer in scan 
	 */
	public static int scanInt() {
		while(!scan.hasNextInt()) {
			System.out.println("Merci de saisir un nombre.");
			scan.next();
		}
		
		return scan.nextInt();
	}

	/**
	 * print all books from DB
	 */
	public static void displayBooks() {
		String format  = "%1$-4s | %2$-20s | %3$-30s | %4$-8s |\n";
		
		System.out.println(String.join("", Collections.nCopies(73, "-")));
		System.out.format(format, "REF", "AUTEUR", "NOM", "PRIX");
		System.out.format(format, "----", String.join("", Collections.nCopies(20, "-")), String.join("", Collections.nCopies(30, "-")), "--------");
		
		
		business.readBooks().forEach((n) -> 
		System.out.format(format, n.getIdBook(), n.getAuthor(), n.getName(), n.getPrice() + "€" )); //+ "\n" + String.join("", Collections.nCopies(71, "-"))
		
		System.out.println(String.join("", Collections.nCopies(73, "-")));
	}
	
	/**
	 * print all books in category choose by user
	 */
	public static void displayBooksInCat() {
		displayCat();
		System.out.println("Quelle catégorie souhaitez-vous afficher ?");
		
		int answer = scanInt();
		
		if(!business.readBooksByCatId(answer).isEmpty()) {
			System.out.println("Voici la catégorie " + business.getCatNameById(answer) + " :");
			
			String format  = "%1$-4s | %2$-20s | %3$-30s | %4$-8s |\n";
			
			System.out.println(String.join("", Collections.nCopies(73, "-")));
			System.out.format(format, "REF", "AUTEUR", "NOM", "PRIX");
			System.out.format(format, "----", String.join("", Collections.nCopies(20, "-")), String.join("", Collections.nCopies(30, "-")), "--------");
			
			
			business.readBooksByCatId(answer).forEach((n) -> 
			System.out.format(format, n.getIdBook(), n.getAuthor(), n.getName(), n.getPrice() + "€" )); //+ "\n" + String.join("", Collections.nCopies(71, "-"))
			
			System.out.println(String.join("", Collections.nCopies(73, "-")));
		} else {
			System.out.println("Cette catégorie n'existe pas ou ne contient pas de livres.");
		}
	}
	
	/**
	 * print all categories available
	 */
	public static void displayCat() {
		String format  = "%1$-4s | %2$-20s |\n";
		
		System.out.println(String.join("", Collections.nCopies(29, "-")));
		System.out.format(format, "REF", "NOM DE LA CATEGORIE");
		System.out.format(format, "----", String.join("", Collections.nCopies(20, "-")));
		
		business.readCategories().forEach((n) -> 
		System.out.format(format, n.getIdCat(), n.getName())); 
		
		System.out.println(String.join("", Collections.nCopies(29, "-")));
	}

	/**
	 * Add book to cart
	 */
	public static void addBookToCart() {
		displayBooks();
		System.out.println("Quel livre souhaitez-vous ajouter ? Merci d'indiquer la référence.");
		
		int answer = scanInt();
		
		if(answer <= business.readBooks().size()) {
			if(business.getBookById(answer) != null) {
				business.addToCart(business.getBookById(answer));
				displayCart();
			} 
		} else {
			System.out.println("Le livre demandé n'existe pas.");
		}	
	}
	
	/**
	 * Remove a book from cart 
	 */
	public static void deleteFromCart() {
		displayCart();
		
		if(!business.getCart().isEmpty()) {
			System.out.println("Quel livre souhaitez-vous supprimer ?");
		
			int answer = scanInt();
		
			if(answer <= business.readBooks().size() && answer > 0) {
				boolean bool = false; //used to check if book is in cart. If it's in cart removev, bool = true
				
				//if answer of user exists in cart, it removes it
				for (int j = 0; j < business.getCart().size(); j++) {
					if(business.getCart().get(j).getIdBook() == answer) {
						business.removeFromCart(answer);
						System.out.println("Le livre \"" + business.getBookById(answer).getName() + "\" a bien été supprimé.");
						displayCart();
						bool = true;
					}
				}
				
				if(!bool) {
					System.out.println("Le livre demandé n'est pas dans votre panier.");
				}
			}
			else {
				System.out.println("Le livre demandé n'est pas présent dans votre panier.");
			}
			
		} 
	}
	
	/**
	 * Print cart.
	 * If cart is empty, user is informed about that.
	 */
	public static void displayCart(){
		String format  = "%1$-4s | %2$-20s | %3$-30s | %4$-6s | %5$-8s | %6$-10s |\n";
		
		if(!business.getCart().isEmpty()) {
			System.out.println(String.join("", Collections.nCopies(95, "-")));
			System.out.format(format, "REF", "AUTEUR", "NOM", "PRIX", "QUANTITE", "PRIX TOTAL");
			System.out.format(format, "----", String.join("", Collections.nCopies(20, "-")), String.join("", Collections.nCopies(30, "-")), "------", "--------", "----------");
			
			//loop foreach to print each line of cart (books and quantities)
			business.getCart().forEach((n) -> 
			System.out.format(format, n.getIdBook(), n.getAuthor(), n.getName(), n.getPrice() + "€", n.getQty(), n.getPrice() * n.getQty() + "€")); //+ "\n" + String.join("", Collections.nCopies(71, "-"))
			
			System.out.println(String.join("", Collections.nCopies(95, "-")));
		} else {
			System.out.println("Votre panier est vide.");
		}
	}
	
	/**
	 * Method to display cart + amount of order, and allow user connected to valid his order.
	 * If user is not connected, the application propose him to create an account.
	 */
	public static void order() {
		displayCart();
		
		if(!business.getCart().isEmpty()) {
			System.out.println("Le total de votre panier est de : " + business.getTotal() + "€.");
			
			if(login == null) {
				connection();
			} 
			
			if(login != null) {
				System.out.println("Souhaitez-vous confirmer la commande ? Pour valider, taper oui, sinon, vous serez renvoyé au menu principal.");
				
				String answer = scan.next();
				
				if(answer.equalsIgnoreCase("oui")) {
					business.pay(idUser);
					System.out.println("Votre commande a bien été validée.");
					business.resetCart();
				}
			}
			
		}
	}
	
	/**
	 * connect user
	 */
	private static void connection() {
		if(login != null) {
			User us = business.getUserById(idUser);
			System.out.println("Vous êtes déjà connecté(e) " + us.getFirstName() + " " + us.getName() + " !");
		}
		
		else {
			System.out.println("saisissez votre login : ");
			String log = scan.next();
			
			System.out.println("saisissez votre password : ");
			String pwd = scan.next();
			
			int id = business.existUser(log, pwd);
			
			if(id > 0)	{
				login = log;
				idUser = id;
				
			} else {
				System.out.println("Login ou mot de passe incorrect. Souhaitez-vous créer un compte ? Taper oui pour créer un compte.");
				String answer = scan.next();
				
				if(answer.equalsIgnoreCase("oui")) {
					createAccountUser();
				}
			}
		}
	}
	
	/**
	 * method that creates a user if he doesn't exists in DB
	 */
	public static void createAccountUser() {
		System.out.println("Saisir votre nom : ");
		String name = scan.next();
		
		System.out.println("Saisir votre prénom : ");
		String firstName = scan.next();
		
		System.out.println("Saisir votre login : ");
		String log = scan.next();
		
		System.out.println("Saisir votre mot de passe : ");
		String password = scan.next();
		
		String patternMail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,6}$";
		System.out.println("Saisir votre email : ");
		String email = scan.next();
		
		while(!email.matches(patternMail)) {
			System.out.println("Votre adresse mail doit être sous la forme : exemple@mail.fr");
			email = scan.next();
		}

		String patternTel = "^[+0-9]{1,3}[0-9]{9}$";
		System.out.println("Saisir votre téléphone : ");
		String tel = scan.next();
		
		while(!tel.matches(patternTel)) {
			System.out.println("Votre numéro doit être composé de 10 chiffres ou être sous la forme +33 suivi de 9 chiffres.");
			tel = scan.next();
		}
		
		System.out.println("Saisir votre adresse : ");
		scan.nextLine();
		String address = scan.nextLine();
		
		User user = new User(log, password, name, firstName, email, tel, address);
		business.createUser(user);
				
		login = log;
		idUser = business.existUser(log, password);
		
		if(business.existUser(log, password) > 0) {
			System.out.println("Votre compte a bien été créé.");
		}

	}
}
