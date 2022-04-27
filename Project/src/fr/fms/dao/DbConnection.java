/**
 * 
 */
package fr.fms.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Stagiaires10P - Sara Lefort
 *
 */
public class DbConnection {
	private volatile static Connection connection;		
	private static Properties prop;
	
	private static String driver;
	private static String url;
	private static String login;
	private static String password;

	private DbConnection() {	
		try {
			//config file is read 
			prop = CreateConfigFile.readPropertiesFile("config.properties");
			
			driver = prop.getProperty("db.driver.class");
			url = prop.getProperty("db.url");
			login = prop.getProperty("db.login");
			password = prop.getProperty("db.password");
			
			//driver charged
			Class.forName(driver);	
			//create connection
			connection = DriverManager.getConnection(url,login,password);	
			
		}			
		catch (ClassNotFoundException | SQLException e) {
			System.out.println("Problème de connexion !" + e.getMessage());
		}
		catch (FileNotFoundException e) {
			System.out.println("Il faut générer le fichier de config avant de pouvoir l'utiliser.");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method returns a connection. If it's null, it creates it once
	 * synchronized is used for multi thread
	 * @return Connection
	 */
	public static synchronized Connection getConnection() {
		if(connection == null) 	new DbConnection();
		else System.out.println("La connexion a déjà été crée." + connection.toString());
		return connection;
	}

}
