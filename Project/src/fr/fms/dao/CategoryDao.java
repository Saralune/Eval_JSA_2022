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
import fr.fms.entities.Category;

/**
 * @author Stagiaires10P
 *
 */
public class CategoryDao implements Dao<Category> {

	@Override
	public boolean create(Category obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category read(int id) {
		String strSql = "SELECT * from category WHERE id_cat = ?;";

		try(PreparedStatement ps = connection.prepareStatement(strSql)){
			ps.setInt(1, id);
			
			try (ResultSet resultSet = ps.executeQuery()){	
				resultSet.next();
				
				int rsId = resultSet.getInt(1);	
				String rsName = resultSet.getString(2);
				
				return new Category(rsId, rsName);
			}
		
		} catch(SQLException e) {
			//e.printStackTrace();
			logger.severe("Problème SQL :" + e);
		}
		
		return null;
	}

	@Override
	public boolean update(Category obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Category> readAll() {
		ArrayList<Category> categories = new ArrayList<Category>();
		String strSql = "SELECT * FROM category;";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsId = resultSet.getInt(1);	
					String rsName = resultSet.getString(2);
												
					categories.add((new Category(rsId, rsName)));						
				}	
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			logger.severe("Problème SQL :" + e);
		}			
		return categories;
	}

}
