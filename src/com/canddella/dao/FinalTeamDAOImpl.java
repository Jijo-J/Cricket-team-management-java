package com.canddella.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Batter;
import com.canddella.entity.FinalTeam;
import com.canddella.entity.Player;

public class FinalTeamDAOImpl implements FinalTeamDAO {
	public List<FinalTeam > findAll() {

		List<FinalTeam> finalteamList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "SELECT  final_team.final_team_id as SERIAL_NO,players.player_name as PLAYER_NAME,final_team.player_roles as PLAYER_ROLE FROM final_team join players on final_team.player_id=players.player_id where year =2020";
		
				

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int finalteamId = resultSet.getInt(1);
				String playerId = resultSet.getString(2);
				String playerroles = resultSet.getString(3);
				
				Player player = new Player();
				player.setPlayerName(playerId);

				FinalTeam finalteam = new FinalTeam(finalteamId, player, playerroles);
				finalteamList.add(finalteam);

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

		return finalteamList;
	}

	@Override
	public void save() {
		String insertsql= "INSERT INTO final_team (player_id,player_roles)\r\n"
				+ " SELECT t1.player_id,'ALL ROUNDER' as player_roles\r\n"
				+ " FROM (    select all_rounders.player_id from all_rounders join batters on all_rounders.player_id=batters.player_id join bowlers on batters.player_id=bowlers.player_id order by batters.total_runs desc,bowlers.wickets desc limit 2 ) t1 \r\n"
				+ " UNION ALL SELECT t2.player_id ,'BATTER' AS player_roles\r\n"
				+ " FROM \r\n"
				+ " (   SELECT player_id   FROM batters   ORDER BY total_runs DESC   LIMIT 5 ) \r\n"
				+ " t2\r\n"
				+ "  UNION ALL SELECT t3.player_id ,'BOWLER' AS player_roles\r\n"
				+ " FROM \r\n"
				+ " (   SELECT player_id   FROM bowlers   ORDER BY wickets DESC   LIMIT 4 ) \r\n"
				+ " t3 limit 11" ;
	            
                PreparedStatement preparedStatement = null;
				Connection connection = null;
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertsql);
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
	}
	
			
//		
//				
            
	

	@Override
	public int update(FinalTeam finalteam) {
		String updateSQL = " update final_team set player_id=?,player_roles=? where final_team_id=?";

		PreparedStatement preparedStatement = null;

		Connection connection = null;
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(updateSQL);

			preparedStatement.setInt(1, finalteam.getPlayer().getPlayerId());
			preparedStatement.setString(2, finalteam.getPlayerroles());
			preparedStatement.setInt(3, finalteam.getFinalteamId());
		
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

	public int delete(FinalTeam finalteam) {
		String deleteSQL = "delete from final_team where final_team_id=? ";

		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1,finalteam.getFinalteamId() );
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

