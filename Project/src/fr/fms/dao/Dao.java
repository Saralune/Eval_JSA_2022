/**
 * 
 */
package fr.fms.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * @author Stagiaires10P - Sara Lefort - 2022
 *
 */
public interface Dao<T> {
	public Connection connection =  DbConnection.getConnection();
	
	public static final Logger logger = Logger.getLogger( "SqlExceptions" );
	
	/**
	 * add item in DB
	 * @param obj (Object -> item)
	 */
	public boolean create(T obj);	
	
	/**
	 * return item corresponding to id in DB
	 * @param id object
	 * @return object or null
	 */
	public T read(int id);		
	
	/**
	 * update object in DB
	 * @param object
	 * @return boolean : true if done, false if not
	 */
	public boolean update(T obj);	
	
	/**
	 * delete an object in DB
	 * @param object
	 * @return boolean : true if done, false if not
	 */
	public boolean delete(T obj);	
	
	/**
	 * return all objects in table in DB
	 * @return ArrayList<T> 
	 */
	public ArrayList<T> readAll();

}
