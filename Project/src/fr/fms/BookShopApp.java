/**
 * 
 */
package fr.fms;

import java.util.Collections;
import java.util.Scanner;

import fr.fms.business.IBookShopImpl;

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
				break;
				
			case 4:
				break;
				
			case 5:
				break;
				
			case 6:
				break;
				
			case 7:
				break;
				
			}
		}
		
	}
	
	/**
	 * Print menu choices 
	 */
	public static void displayMenu() {
		if(login != null)	System.out.print("Compte : " + login);
		
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

}
