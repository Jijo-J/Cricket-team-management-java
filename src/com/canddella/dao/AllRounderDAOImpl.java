package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.AllRounder;
import com.canddella.entity.Batter;
import com.canddella.entity.Bowler;
import com.canddella.entity.Player;

public class AllRounderDAOImpl implements AllRounderDAO {
	public List<AllRounder> findAll() {

		List<AllRounder> allrounderList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from all_rounders";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int allRounderId = resultSet.getInt(1);
				int playerId = resultSet.getInt(2);
//				int bowlerId = resultSet.getInt(3);
//				Batter batter =new Batter();
//				batter.setBatterId(batterId);
//				Bowler bowler = new Bowler();
//				bowler.setBowlerId(bowlerId);
//				 
				Player player = new Player();
				player.setPlayerId(playerId);
				

				AllRounder allrounder = new AllRounder(allRounderId,player);
				allrounderList.add(allrounder);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return allrounderList;
	}

	@Override
	public int save(AllRounder allrounder) {
		// TODO Auto-generated method stub
		String insertSQL = "insert into all_rounders(player_id)" + " values(?)";

		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, allrounder.getPlayer().getPlayerId());
//			preparedStatement.setInt(2, allrounder.getBowler().getBowlerId());
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
	public int update(AllRounder allrounder) {
		String updateSQL = " update all_rounders set player_id=? where all_rounders_id=?";

		PreparedStatement preparedStatement = null;

		Connection connection = null;
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(updateSQL);

			preparedStatement.setInt(1, allrounder.getPlayer().getPlayerId());
//			preparedStatement.setInt(2, allrounder.getBowler().getBowlerId());
			preparedStatement.setInt(2, allrounder.getAllRounderId());
		
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

	public int delete(AllRounder allrounder) {
		String deleteSQL = "delete from all_rounders where all_rounders_id=? ";

		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1,allrounder.getAllRounderId() );
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
	   public   AllRounder  allrounderinid(int id){
//			Scanner scanner = new Scanner(System.in);
//		    System.out.println("Enter the id:");
//		     int playerid = scanner.nextInt();
		     AllRounder allrounder =null;
//		    
			String searchSQL = "select * from all_rounders where all_rounders_id="+id;
			PreparedStatement preparedStatement = null;

			Connection connection = null;
			
			try {
				DataSource ds = DBConnectionPool.getDataSource();
				connection = ds.getConnection();
				
				preparedStatement = connection.prepareStatement(searchSQL);
				
				
//				preparedStatement.setInt(1, player.getPlayerId());
				ResultSet resultSet =preparedStatement.executeQuery();
				while(resultSet.next()) {
					int allRounderId = resultSet.getInt(1);
					int playerId = resultSet.getInt(2);
//					int bowlerId = resultSet.getInt(3);
//					Batter batter =new Batter();
//					batter.setBatterId(batterId);
//					Bowler bowler = new Bowler();
//					bowler.setBowlerId(bowlerId);
					Player player =new Player();
					player.setPlayerId(playerId);
					
					 allrounder = new AllRounder(allRounderId,player);					
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
			return allrounder;


	 }

}
