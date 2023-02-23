package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Batter;
import com.canddella.entity.Player;

public class PlayerDAOImpl implements PlayerDAO {
  
	@Override
	public List<Player> findAll() {
		List<Player> playerList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;
		String selectSQL = "Select * from players";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int playerId = resultSet.getInt(1);
				String playerName = resultSet.getString(2);
				String age = resultSet.getString(3);
				String location = resultSet.getString(4);
				String debutYear = resultSet.getString(5);
				String recentTeam = resultSet.getString(6);
				String contact = resultSet.getString(7);



				Player player = new Player(playerId,playerName,age, location,debutYear,recentTeam,contact);
				playerList.add(player);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

		return playerList;

	}

	@Override
	public int save(Player player) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "insert into players(player_id,player_name,age,location,debut_year,recent_team,contact) values(?,?,?,?,?,?,?)";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setInt(1,player.getPlayerId());
			preparedStatement.setString(2,player.getPlayerName());
			preparedStatement.setString(3, player.getAge());
			preparedStatement.setString(4,player.getLocation());
			preparedStatement.setString(5,player.getDebutYear());
			preparedStatement.setString(6,player.getRecentTeam());
			preparedStatement.setString(7,player.getContact());



			int row = preparedStatement.executeUpdate();
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	public int update(Player player) {
		String updateSQL = " update players set player_name=?,age=?,location=?,debut_year=?,recent_team=?,contact=? where player_id=?";  
		 
		PreparedStatement preparedStatement = null;
	   
	    Connection connection = null; 
	    try 
	      {
	    	DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			
			preparedStatement =  connection.prepareStatement(updateSQL);
			

			preparedStatement.setString(1,player.getPlayerName());
			preparedStatement.setString(2,player.getAge());
			preparedStatement.setString(3,player.getLocation() );
			preparedStatement.setString(4,player.getDebutYear());
			preparedStatement.setString(5,player.getRecentTeam());
			preparedStatement.setString(6,player.getLocation());
			
			preparedStatement.setInt(7,player.getPlayerId());

			int column=preparedStatement.executeUpdate();
			return column;
			
			
			
			
	    
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
	public int delete(Player player) {
		String deleteSQL = "delete from players where player_id=? ";

		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, player.getPlayerId());
			preparedStatement.executeUpdate();
			

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
	 public Player playerInId(int id){
//			Scanner scanner = new Scanner(System.in);
//		    System.out.println("Enter the id:");
//		     int playerid = scanner.nextInt();
		    Player player =null;
//		    
			String searchSQL = "select * from players where player_id="+id;
			PreparedStatement preparedStatement = null;

			Connection connection = null;
			
			try {
				DataSource ds = DBConnectionPool.getDataSource();
				connection = ds.getConnection();
				
				preparedStatement = connection.prepareStatement(searchSQL);
				
				
//				preparedStatement.setInt(1, player.getPlayerId());
				ResultSet resultSet =preparedStatement.executeQuery();
				while(resultSet.next()) {
					int playerId = resultSet.getInt(1);
					String playerName = resultSet.getString(2);
					String age = resultSet.getString(3);
					String location = resultSet.getString(4);
					String debutYear = resultSet.getString(5);
					String recentTeam = resultSet.getString(6);
					String contact = resultSet.getString(7);
					
					player = new  Player(playerId,playerName,age,location,debutYear,recentTeam,contact);
					
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
			return player;


	 }
}	