/**
 * 
 */
package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Book;
import fr.fms.entities.User;

/**
 * @author Stagiaires10P
 *
 */
public class BookDao implements Dao<Book> {

	@Override
	public boolean create(Book obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Book read(int id) {
		String strSql = "SELECT * from book WHERE id_book = ?;";

		try(PreparedStatement ps = connection.prepareStatement(strSql)){
			ps.setInt(1, id);
			
			try (ResultSet resultSet = ps.executeQuery()){	
				resultSet.next();
				
				int rsId = resultSet.getInt(1);	
				String rsAuthor = resultSet.getString(2);
				String rsBookName = resultSet.getString(3);
				double rsPrice = resultSet.getDouble(4);
				int rsIdCat1 = resultSet.getInt(5);
				int rsIdCat2= resultSet.getInt(6);
				int rsIdCat3= resultSet.getInt(7);
				
				return new Book(rsId, rsAuthor, rsBookName, rsPrice, rsIdCat1, rsIdCat2, rsIdCat3);
			}
		
		} catch(SQLException e) {
			//e.printStackTrace();
			logger.severe("Problème SQL :" + e);
		}
		
		return null;
	}

	@Override
	public boolean update(Book obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Book> readAll() {
		ArrayList<Book> books = new ArrayList<Book>();
		String strSql = "SELECT * FROM book";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsId = resultSet.getInt(1);	
					String rsAuthor = resultSet.getString(2);
					String rsBookName = resultSet.getString(3);
					double rsPrice = resultSet.getDouble(4);
					int rsIdCat1 = resultSet.getInt(5);
					int rsIdCat2= resultSet.getInt(6);
					int rsIdCat3= resultSet.getInt(7);
												
					books.add((new Book(rsId, rsAuthor, rsBookName, rsPrice, rsIdCat1, rsIdCat2, rsIdCat3)));						
				}	
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			logger.severe("Problème SQL :" + e);
		}			
		return books;
	}
	
	public ArrayList<Book> readAllByCat(int idCat) {
		ArrayList<Book> books = new ArrayList<Book>();
		
		String strSql = "SELECT * FROM book where id_cat1 = ? or id_cat2 = ? or id_cat3 = ?;";	
		
		try(PreparedStatement ps = connection.prepareStatement(strSql)){
			ps.setInt(1, idCat);
			ps.setInt(2, idCat);
			ps.setInt(3, idCat);
			
			try(ResultSet resultSet = ps.executeQuery()){ 			
				while(resultSet.next()) {
					int rsId = resultSet.getInt(1);	
					String rsAuthor = resultSet.getString(2);
					String rsBookName = resultSet.getString(3);
					double rsPrice = resultSet.getDouble(4);
					int rsIdCat1 = resultSet.getInt(5);
					int rsIdCat2= resultSet.getInt(6);
					int rsIdCat3= resultSet.getInt(7);
												
					books.add((new Book(rsId, rsAuthor, rsBookName, rsPrice, rsIdCat1, rsIdCat2, rsIdCat3)));						
				}	
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			logger.severe("Problème SQL :" + e);
		}			
		return books;
	}

}
