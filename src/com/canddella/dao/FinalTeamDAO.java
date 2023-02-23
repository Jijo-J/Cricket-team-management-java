package com.canddella.dao;

import java.util.List;

import com.canddella.entity.FinalTeam;

public interface FinalTeamDAO {
	List<FinalTeam> findAll();

	void save();

	int update(FinalTeam finalteam);

	int delete(FinalTeam finalteam);
	 
//	void search(FinalTeam finalteam);
	
	

}
