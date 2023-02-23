package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.FinalTeam;
import com.canddella.entity.Player;
import com.canddella.entity.Substitution;

public class SubstitutionDAOImpl implements SubstitutionDAO {

	public List<Substitution > findAll() {

		List<Substitution> substitionList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from substitution";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int substitutionId = resultSet.getInt(1);
				int playerId = resultSet.getInt(2);
				String playerroles = resultSet.getString(3);
				
				Player player = new Player();
				player.setPlayerId(playerId);

				Substitution substitution = new Substitution(substitutionId, player, playerroles);
				substitionList.add(substitution);

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

		return substitionList;
	}

	@Override
	public int save(Substitution substitution) {
		// TODO Auto-generated method stub
		String insertSQL = "insert into substitution(player_id,player_roles)" + " values(?,?)";

		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, substitution.getPlayer().getPlayerId());
			preparedStatement.setString(2,substitution.getPlayerroles());
			

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
	public int update(Substitution substitution) {
		String updateSQL = " update substitution set player_id=?,player_roles=? where substitution_id=?";

		PreparedStatement preparedStatement = null;

		Connection connection = null;
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(updateSQL);

			preparedStatement.setInt(1, substitution.getPlayer().getPlayerId());
			preparedStatement.setString(2, substitution.getPlayerroles());
			preparedStatement.setInt(3, substitution.getSubstitutionId());
		
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

	public int delete(Substitution substitution) {
		String deleteSQL = "delete from substitution where substitution_id=? ";

		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1,substitution.getSubstitutionId());
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
