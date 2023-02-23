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
import com.canddella.entity.WicketKeeper;

public class WicketKeeperDAOImpl implements WicketKeeperDAO {
	public List<WicketKeeper> findAll() {

		List<WicketKeeper> wicketkeeperList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from wicket_keeper";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int wicketkeeperId = resultSet.getInt(1);
				int playerId = resultSet.getInt(2);
				String stumps = resultSet.getString(3);
				String catches = resultSet.getString(4);
				Player player = new Player();
				player.setPlayerId(playerId);

				WicketKeeper wicketkeeper = new WicketKeeper(wicketkeeperId, player, stumps, catches);
				wicketkeeperList.add(wicketkeeper);

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

		return wicketkeeperList;
	}

	@Override
	public int save(WicketKeeper wicketkeeper) {
		// TODO Auto-generated method stub
		String insertSQL = "insert into wicket_keeper(player_id,stumps,catches)" + " values(?,?,?)";

		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, wicketkeeper.getPlayer().getPlayerId());
			preparedStatement.setString(2, wicketkeeper.getStumps());
			preparedStatement.setString(3, wicketkeeper.getCatches());
			

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
	public int update(WicketKeeper wicketkeeper) {
		String updateSQL = " update wicket_keeper set player_id=?,stumps=?,catches=? where wicket_keeper_id=?";

		PreparedStatement preparedStatement = null;

		Connection connection = null;
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(updateSQL);

			preparedStatement.setInt(1, wicketkeeper.getPlayer().getPlayerId());
			preparedStatement.setString(2, wicketkeeper.getStumps());
			preparedStatement.setString(3, wicketkeeper.getCatches());
			preparedStatement.setInt(4, wicketkeeper.getWicketkeeperId());
			
		
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

	public int delete(WicketKeeper wicketkeeper) {
		String deleteSQL = "delete from wicket_keeper where wicket_keeper_id=? ";

		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, wicketkeeper.getWicketkeeperId());
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

}
