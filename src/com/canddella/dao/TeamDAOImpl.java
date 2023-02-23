package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Player;
import com.canddella.entity.Team;

public class TeamDAOImpl implements TeamDAO {
	
	
	@Override
	public List<Team> findAll() {
		List<Team> teamList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;
		String selectSQL = "Select * from team";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int teamID = resultSet.getInt(1);
				String teamName = resultSet.getString(2);
				String teamOwner = resultSet.getString(3);
				String sponsers = resultSet.getString(4);

				Team team = new Team(teamID,teamName,teamOwner, sponsers);
				teamList.add(team);

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

		return teamList;

	}

	@Override
	public int save(Team team) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "insert into team(Team_ID,Team_Name,Team_Owner,Sponsers) values(?,?,?,?)";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setInt(1,team.getTeamID());
			preparedStatement.setString(2,team.getTeamName());
			preparedStatement.setString(3, team.getTeamOwner());
			preparedStatement.setString(4,team.getSponsers());
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
	public int update(Team team) {
		String updateSQL = " update team set team_name=?,team_owner=?,sponsers=? where team_id=?";  
		 
		PreparedStatement preparedStatement = null;
	   
	    Connection connection = null; 
	    try 
	      {
	    	DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			
			preparedStatement =  connection.prepareStatement(updateSQL);
			

			preparedStatement.setString(1,team.getTeamName());
			preparedStatement.setString(2,team.getTeamOwner());
			preparedStatement.setString(3,team.getSponsers() );
			preparedStatement.setInt(4,team.getTeamID());
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
	public int delete(Team team) {
		String deleteSQL = "delete from team where team_id=? ";

		PreparedStatement preparedStatement = null;

		Connection connection = null;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, team.getTeamID());
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
