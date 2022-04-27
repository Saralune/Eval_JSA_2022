/**
 * 
 */
package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;

import fr.fms.entities.User;

/**
 * @author Stagiaires10P
 *
 */
public class UserDao implements Dao<User> {

	@Override
	public boolean create(User obj) {
		String str = "INSERT INTO user (login, pwd, user_name, first_name, email, tel, address) "
				+ "VALUES (?,?,?,?,?,?,?);";
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getLogin());
			ps.setString(2, obj.getPassword());		
			ps.setString(3, obj.getName());	
			ps.setString(4, obj.getFirstName());	
			ps.setString(5, obj.getEmail());	
			ps.setString(6, obj.getTel());	
			ps.setString(7, obj.getAddress());	
			
			if( ps.executeUpdate() == 1)	return true;				
		} catch (SQLException e) {
			//e.printStackTrace();
			logger.log(Level.SEVERE,"Problème SQL sur la création d'un utilisateur.");
		} 				
		return false;
	}

	@Override
	public User read(int id) {
		
		String strSql = "SELECT * from user WHERE id_user = ?;";

		try(PreparedStatement ps = connection.prepareStatement(strSql)){
			ps.setInt(1, id);
			
			try (ResultSet resultSet = ps.executeQuery()){	
				resultSet.next();
				
				int rsIdUser = resultSet.getInt(1);
				String rsLogin = resultSet.getString(2);
				String rsPassword = resultSet.getString(3);
				String rsName = resultSet.getString(4);
				String rsFirstName = resultSet.getString(5);
				String rsEmail = resultSet.getString(6);
				String rsTel = resultSet.getString(7);
				String rsAddress = resultSet.getString(8);
				
				return new User(rsIdUser, rsLogin, rsPassword, rsName, rsFirstName, rsEmail, rsTel, rsAddress);
			}
		
		} catch(SQLException e) {
			//e.printStackTrace();
			logger.severe("pb Sql :" + e);
		}
		
		return null;
	}

	@Override
	public boolean update(User obj) {
		String str = "UPDATE user SET first_name = ? WHERE id_user = ?;";
		
		try(PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getFirstName());
			ps.setInt(2, obj.getIdUser());
			
			if(ps.executeUpdate() == 1) {
				return true;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}	
		
		return false;
	}

	@Override
	public boolean delete(int id) {
		String str = "DELETE FROM user WHERE id_user = ?;";
		 
		try(PreparedStatement ps = connection.prepareStatement(str)){
			ps.setInt(1, id);
			
			if(ps.executeUpdate() == 1) {
				return true;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public ArrayList<User> readAll() {
		ArrayList<User> users = new ArrayList<User>();
		String strSql = "SELECT * FROM user";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsId = resultSet.getInt(1);	
					String rsLogin = resultSet.getString(2);
					String rsPassword = resultSet.getString(3);							
					String rsName = resultSet.getString(4);							
					String rsFirstName = resultSet.getString(5);							
					String rsEmail = resultSet.getString(6);							
					String rsTel = resultSet.getString(7);													
					String rsAddress = resultSet.getString(8);													
					users.add((new User(rsId, rsLogin, rsPassword, rsName, rsFirstName, rsEmail, rsTel, rsAddress)));						
				}	
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			logger.severe("pb Sql :" + e);
		}			
		return users;
	}

}
