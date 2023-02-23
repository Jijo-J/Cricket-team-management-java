package com.canddella.service;

import java.util.List;

import com.canddella.dao.PlayerDAOImpl;
import com.canddella.dao.TeamDAOImpl;
import com.canddella.entity.Player;
import com.canddella.entity.Team;



public class TeamServiceImpl implements TeamService {

	@Override
	public List<Team> findAll() {
		// TODO Auto-generated method stub
		TeamDAOImpl teamDAOImpl = new TeamDAOImpl();
		List<Team> teamList = teamDAOImpl.findAll();
		return teamList ;
	}

	@Override
	public void save(Team team) {
		// TODO Auto-generated method stub
		TeamDAOImpl teamDAOImpl = new TeamDAOImpl();
		int row = teamDAOImpl.save(team);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");

	}

	 @Override
     public int update(Team team) {
		 TeamDAOImpl teamDAOImpl = new TeamDAOImpl();
			int column = teamDAOImpl.update(team);
			if(column!=0) {
				System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!");
			}
			else {
				System.out.println("UPDATION FAILED!!!!!!!!!!!!");
			}
			return column;
			
			
     }

		@Override
		public int delete(Team team) {
			 TeamDAOImpl teamDAOImpl = new TeamDAOImpl();
			 int row =  teamDAOImpl.delete(team);
			if (row != 0)
				System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!!");
			else
				System.out.println("DELETION FAILED!!!!!!!!!!!!!!!!!!44");
			return 0;

		}
}
