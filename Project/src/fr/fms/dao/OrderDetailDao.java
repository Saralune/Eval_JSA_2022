/**
 * 
 */
package fr.fms.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Order;
import fr.fms.entities.OrderDetail;
import fr.fms.entities.User;

/**
 * @author Stagiaires10P
 *
 */
public class OrderDetailDao implements Dao<OrderDetail> {

	@Override
	public boolean create(OrderDetail obj) {
		String str = "INSERT INTO order_detail (id_order, id_user, id_book, book_name, qty, date_order, unitary_price) VALUES (?,?,?,?,?,?,?);";	
		
		try (PreparedStatement ps = connection.prepareStatement(str)){	
			ps.setInt(1, obj.getIdOrder());
			ps.setInt(2, obj.getIdUser());
			ps.setInt(3, obj.getIdBook());
			ps.setString(4, obj.getBookName());
			ps.setInt(5, obj.getQty());
			ps.setDate(6, java.sql.Date.valueOf(java.time.LocalDate.now()));
			ps.setDouble(7, obj.getUnitaryPrice());
			
			ps.executeUpdate();			
			return true;
		} catch (SQLException e) {
			//e.printStackTrace();
			logger.severe("Problème SQL :" + e);
		}
		return false;
	}

	@Override
	public OrderDetail read(int id) {
//		String strSql = "SELECT * from order_detail WHERE id_order = ?;";
//
//		try(PreparedStatement ps = connection.prepareStatement(strSql)){
//			ps.setInt(1, id);
//			
//			try (ResultSet resultSet = ps.executeQuery()){	
//				resultSet.next();
//				
//				int rsIdOrder = resultSet.getInt(1);
//				int rsIdUser = resultSet.getInt(2);
//				int rsIdBook = resultSet.getInt(3);
//				String rsBookName = resultSet.getString(4);
//				int rsQty = resultSet.getInt(5);
//				Date rsDateOrder = resultSet.getDate(6);
//				Double rsUnitaryPrice = resultSet.getDouble(7);
//				
//				return new OrderDetail(rsIdOrder, rsIdUser, rsIdBook, rsBookName, rsQty, rsDateOrder, rsUnitaryPrice);
//			}
//		
//		} catch(SQLException e) {
//			//e.printStackTrace();
//			logger.severe("pb Sql :" + e);
//		}
		
		return null;
	}

	@Override
	public boolean update(OrderDetail obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<OrderDetail> readAll() {
		ArrayList<OrderDetail> orderDetail = new ArrayList<OrderDetail>();
		String strSql = "SELECT * from order_detail;";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsIdOrder = resultSet.getInt(1);
					int rsIdUser = resultSet.getInt(2);
					int rsIdBook = resultSet.getInt(3);
					String rsBookName = resultSet.getString(4);
					int rsQty = resultSet.getInt(5);
					Date rsDateOrder = resultSet.getDate(6);
					Double rsUnitaryPrice = resultSet.getDouble(7);
																					
					orderDetail.add(new OrderDetail(rsIdOrder, rsIdUser, rsIdBook, rsBookName, rsQty, rsDateOrder, rsUnitaryPrice));						
				}	
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			logger.severe("Problème SQL :" + e);
		}			
		return orderDetail;
	}

	public ArrayList<OrderDetail> readOneOrder(int id) {
		ArrayList<OrderDetail> order = new ArrayList<OrderDetail>();
		
		String strSql = "SELECT * from order_detail where id_order = ?;";	
		
		try(PreparedStatement ps = connection.prepareStatement(strSql)){
			ps.setInt(1, id);
			
			try(ResultSet resultSet = ps.executeQuery()){ 			
				while(resultSet.next()) {
					int rsIdOrder = resultSet.getInt(1);
					int rsIdUser = resultSet.getInt(2);
					int rsIdBook = resultSet.getInt(3);
					String rsBookName = resultSet.getString(4);
					int rsQty = resultSet.getInt(5);
					Date rsDateOrder = resultSet.getDate(6);
					Double rsUnitaryPrice = resultSet.getDouble(7);
																					
					order.add(new OrderDetail(rsIdOrder, rsIdUser, rsIdBook, rsBookName, rsQty, rsDateOrder, rsUnitaryPrice));						
				}	
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			logger.severe("pb Sql :" + e);
		}			
		return order;
	}
}
