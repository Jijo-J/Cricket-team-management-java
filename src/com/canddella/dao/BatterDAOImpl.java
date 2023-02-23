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
import com.canddella.entity.Player;

public class BatterDAOImpl implements BatterDAO {
	@Override
	public List<Batter> findAll() {

		List<Batter> batterList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from batters";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int batterId = resultSet.getInt(1);
				int playerId = resultSet.getInt(2);
				String totalRuns = resultSet.getString(3);
				String hundreds = resultSet.getString(4);
				String fifties = resultSet.getString(5);
				Player player = new Player();
				player.setPlayerId(playerId);

				Batter batter = new Batter(batterId, player, totalRuns, hundreds, fifties);
				batterList.add(batter);

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

		return batterList;
	}

	@Override
	public int save(Batter batter) {
		// TODO Auto-generated method stub
		String insertSQL = "insert into batters(player_id,total_runs,hundreds,fifties)" + " values(?,?,?,?)";

		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, batter.getPlayer().getPlayerId());
			preparedStatement.setString(2, batter.getTotalRuns());
			preparedStatement.setString(3, batter.getHundreds());
			preparedStatement.setString(4, batter.getFifties());

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
	public int update(Batter batter) {
		String updateSQL = " update batters set player_id=?,total_runs=?,hundreds=?,fifties=? where batter_id=?";

		PreparedStatement preparedStatement = null;

		Connection connection = null;
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(updateSQL);

			preparedStatement.setInt(1, batter.getPlayer().getPlayerId());
			preparedStatement.setString(2, batter.getTotalRuns());
			preparedStatement.setString(3, batter.getHundreds());
			preparedStatement.setString(4, batter.getFifties());
			preparedStatement.setInt(5, batter.getBatterId());
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

	public int delete(Batter batter) {
		String deleteSQL = "delete from batters where batter_id=? ";

		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, batter.getBatterId());
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
	 public Batter batterinid(int id){
//			Scanner scanner = new Scanner(System.in);
//		    System.out.println("Enter the id:");
//		     int playerid = scanner.nextInt();
		Batter batter =null;
//		    
			String searchSQL = "select * from batters where batter_id="+id;
			PreparedStatement preparedStatement = null;

			Connection connection = null;
			
			try {
				DataSource ds = DBConnectionPool.getDataSource();
				connection = ds.getConnection();
				
				preparedStatement = connection.prepareStatement(searchSQL);
				
				
//				preparedStatement.setInt(1, player.getPlayerId());
				ResultSet resultSet =preparedStatement.executeQuery();
				while(resultSet.next()) {
					int batterId = resultSet.getInt(1);
					int playerId = resultSet.getInt(2);
					String totalRuns = resultSet.getString(3);
					String hundreds = resultSet.getString(4);
					String fifties = resultSet.getString(5);
					Player player = new Player();
					player.setPlayerId(playerId);
					
					batter = new  Batter(batterId, player, totalRuns, hundreds, fifties);
					
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
			return batter;


	 }
}
