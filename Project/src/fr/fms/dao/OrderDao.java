/**
 * 
 */
package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import fr.fms.entities.Order;
import fr.fms.entities.User;

/**
 * @author Stagiaires10P
 *
 */
public class OrderDao implements Dao<Order> {

	@Override
	public boolean create(Order obj) {
		String str = "INSERT INTO u_order (amount, date_order, id_user) VALUES (?,?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str,Statement.RETURN_GENERATED_KEYS)){	
			ps.setDouble(1, obj.getAmount());
			ps.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now())); //add date of the day
			ps.setInt(3, obj.getIdUser());
			ps.executeUpdate();
			try(ResultSet generatedKeySet = ps.getGeneratedKeys()){
				if(generatedKeySet.next()) {
					obj.setIdOrder(generatedKeySet.getInt(1));
					return true;
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Order read(int id) {
		String strSql = "SELECT * from u_order WHERE id_order = ?;";

		try(PreparedStatement ps = connection.prepareStatement(strSql)){
			ps.setInt(1, id);
			
			try (ResultSet resultSet = ps.executeQuery()){	
				resultSet.next();
				
				int rsIdOrder = resultSet.getInt(1);
				Double rsAmount = resultSet.getDouble(2);
				Date rsDateOrder = resultSet.getDate(3);
				int rsIdUser = resultSet.getInt(4);
				
				return new Order(rsIdOrder, rsAmount, rsDateOrder, rsIdUser);
			}
		
		} catch(SQLException e) {
			//e.printStackTrace();
			logger.severe("pb Sql :" + e);
		}
		
		return null;
	}

	@Override
	public boolean update(Order obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Order> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
