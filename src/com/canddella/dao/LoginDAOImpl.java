package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Batter;
import com.canddella.entity.Login;
import com.canddella.entity.Player;

public class LoginDAOImpl  {
	 

	
	
		
		Login login =null;

		Connection connection = null;
		PreparedStatement prepStmt = null;
		
		String loginsql="select * from login where user_name=? and pass_word=?";
		public boolean login(String username,String password) throws SQLException {
			
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(loginsql);
			prepStmt.setString(1, username);
			prepStmt.setString(2, password);
			ResultSet resultSet = prepStmt.executeQuery();
		
	return resultSet.next();
	 
 }
}		
			
			
			
			
			
			
//			
//		}
//			DataSource ds = DBConnectionPool.getDataSource();
//			connection = ds.getConnection();
//			prepStammt = connection.prepareStatement(loginsql);
//			
//			prepStmt.setString(1, username);
//			prepStmt.setString(2, password);
//			ResultSet resultSet = prepStmt.executeQuery();
//			if(resultSet.next()) {
//				
//				String  username1 = resultSet.getString(1);
//				String password1 = resultSet.getString(2);
//				
//				
//			}
////				String username1 = resultSet.getString(1);
////				String password2 = resultSet.getString(2);
////				String totalRuns = resultSet.getString(3);
////				String hundreds = resultSet.getString(4);
////				String fifties = resultSet.getString(5);
////				Player player = new Player();
////				player.setPlayerId(playerId);
//				login.setUsername(username);
//				login.setPassword(password);
//				 
////				batterList.add(batter);
//
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (connection != null)
//					connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return login;
//
//	}
//		
//
//	
//
//	@Override
//	public void searchlogin(String username, String password) {
//		String searchsql ="";
//		
//	}
//	


