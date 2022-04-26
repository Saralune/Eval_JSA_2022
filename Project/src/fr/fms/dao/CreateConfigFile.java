/**
 * 
 */
package fr.fms.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Create and read on a file with config parameters
 * @author Stagiaires10P - Sara Lefort
 *
 */
public class CreateConfigFile {
	
	public static void main(String args[]) throws IOException {	      
		try (OutputStream ops = new FileOutputStream("config.properties")) {		
			Properties properties = new Properties();	
			properties.setProperty("db.driver", "org.mariadb.jdbc.Driver");
			properties.setProperty("db.url", "jdbc:mariadb://localhost:3306/Shop");
			properties.setProperty("db.login", "root");
			properties.setProperty("db.password", "fms2022");	
			
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
		
	/**
	 * method that read on a config file
	 * @param fileName - the name of config file
	 * @return properties
	 * @throws IOException
	 */
	 public static Properties readPropertiesFile(String fileName) throws IOException {
	    FileInputStream fis = null;
	    Properties prop = null;
	      
	    try {
		    fis = new FileInputStream(fileName);
		    prop = new Properties();
		    prop.load(fis);
	    } catch(FileNotFoundException fnfe) {
	        fnfe.printStackTrace();
	    } catch(IOException ioe) {
	    	ioe.printStackTrace();
	    } finally {
	        fis.close();
	    }
	      
	    return prop;
	 } 
}
