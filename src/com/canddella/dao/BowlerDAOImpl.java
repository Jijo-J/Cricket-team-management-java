package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Batter;
import com.canddella.entity.Bowler;
import com.canddella.entity.Player;

public class BowlerDAOImpl implements BowlerDAO {

public List<Bowler> findAll() {
		
		List<Bowler> bowlerList = new ArrayList();
		Connection connection = null; 
		PreparedStatement prepStmt = null;
			
	    String selectSQL = "Select * from bowlers";
	    
	    try {
	    	  DataSource ds = DBConnectionPool.getDataSource();
		      connection = ds.getConnection();
		      prepStmt = connection.prepareStatement(selectSQL);
	    	  ResultSet resultSet = prepStmt.executeQuery();
	    	  while(resultSet.next())
	    	  {
					int bowlerId = resultSet.getInt(1);
					int playerId = resultSet.getInt(2);
					String wickets = resultSet.getString(3);
					String economy = resultSet.getString(4);
					String best = resultSet.getString(5);
					Player player = new Player();
					player.setPlayerId(playerId);
					
					Bowler bowler = new Bowler(bowlerId,player,wickets,economy,best);
					bowlerList.add(bowler);
					
				}
    	}
	   	 catch (SQLException e) {
				e.printStackTrace();
		}
	    finally
		{
			try {
				if(connection!=null)
				connection.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
	    return bowlerList;
	}
	@Override
	public int save(Bowler bowler) {
		// TODO Auto-generated method stub
		String insertSQL="insert into bowlers(player_id,wickets,economy,best)"+" values(?,?,?,?)";
	    
		PreparedStatement preparedStatement = null;
	   
	    Connection connection = null; 
	    
	      try 
	      {
	    	DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			
			preparedStatement =  connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1,bowler.getPlayer().getPlayerId() );
			preparedStatement.setString(2,bowler.getWickets());
			preparedStatement.setString(3, bowler.getEconomy());
			preparedStatement.setString(4,bowler.getBest());
			
			int row = preparedStatement.executeUpdate();
			return row;
			
			
	    
	   }
catch (SQLException e) 
		    {
				
				e.printStackTrace();
			}
	      finally {
				try {
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return 0;
	}

	@Override
	public int update(Bowler bowler) {
		String updateSQL = " update bowlers set player_id=?,wickets=?,economy=?,best=? where bowler_id=?";

		PreparedStatement preparedStatement = null;

		Connection connection = null;
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(updateSQL);

			preparedStatement.setInt(1, bowler.getPlayer().getPlayerId());
			preparedStatement.setString(2, bowler.getWickets());
			preparedStatement.setString(3, bowler.getEconomy());
			preparedStatement.setString(4, bowler.getBest());
			preparedStatement.setInt(5, bowler.getBowlerId());
			int column = preparedStatement.executeUpdate();
			return column;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;

	}

	public int delete(Bowler bowler) {
		String deleteSQL = "delete from bowlers where bowler_id=? ";

		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, bowler.getBowlerId());
			int row = preparedStatement.executeUpdate();
			return row;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}


	@Override
	 public Bowler bowlerinid(int id){
//			Scanner scanner = new Scanner(System.in);
//		    System.out.println("Enter the id:");
//		     int playerid = scanner.nextInt();
		Bowler bowler =null;
//		    
			String searchSQL = "select * from bowlers where bowler_id="+id;
			PreparedStatement preparedStatement = null;

			Connection connection = null;
			
			try {
				DataSource ds = DBConnectionPool.getDataSource();
				connection = ds.getConnection();
				
				preparedStatement = connection.prepareStatement(searchSQL);
				
				
//				preparedStatement.setInt(1, player.getPlayerId());
				ResultSet resultSet =preparedStatement.executeQuery();
				while(resultSet.next()) {
					int bowlerId = resultSet.getInt(1);
					int playerId = resultSet.getInt(2);
					String wickets = resultSet.getString(3);
					String economy = resultSet.getString(4);
					String best = resultSet.getString(5);
					Player player = new Player();
					player.setPlayerId(playerId);
					
					 bowler = new Bowler(bowlerId,player,wickets,economy,best);
					
				}

			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				try {
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
			}
			return bowler;


	 }
	


}
