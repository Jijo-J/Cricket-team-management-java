package com.canddella.service;

import java.util.List;

import com.canddella.dao.FinalTeamDAOImpl;
import com.canddella.entity.FinalTeam;

public class FinalTeamServiceImpl implements FinalTeamService {
	@Override
	public List<FinalTeam> findAll() {

		FinalTeamDAOImpl finalTeamDAOImpl = new FinalTeamDAOImpl();
		List<FinalTeam> finalteamList = finalTeamDAOImpl.findAll();
		return finalteamList;

	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		FinalTeamDAOImpl finalTeamDAOImpl = new FinalTeamDAOImpl();
		 finalTeamDAOImpl.save();
//		if (row == 1)
//			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
//		else
//			System.out.println("INSERTION FAILED!!!!!!!!!!!!");
		
	}

	@Override
	public int update(FinalTeam finalteam) {
		FinalTeamDAOImpl finalTeamDAOImpl = new FinalTeamDAOImpl();
		int column = finalTeamDAOImpl.update(finalteam);
		if (column != 0) {
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!!");
		} else {
			System.out.println("UPDATION FAILED!!!!!!!!!!!!!!!!!!");
		}
		return column;

	}

	@Override
	public int delete(FinalTeam finalteam) {
		FinalTeamDAOImpl finalTeamDAOImpl = new FinalTeamDAOImpl();
		int row = finalTeamDAOImpl.delete(finalteam);
		if (row != 0)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!!");
		else
			System.out.println("DELETION FAILED!!!!!!!!!!!!!!!!!!44");
		return 0;

	}
//	public void search(FinalTeam finalteam) {
//		FinalTeamDAOImpl finalTeamDAOImpl = new FinalTeamDAOImpl();
//		finalTeamDAOImpl.search(finalteam);
//		
//	}


}
