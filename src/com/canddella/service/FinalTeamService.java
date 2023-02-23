package com.canddella.service;

import java.util.List;

import com.canddella.entity.FinalTeam;

public interface FinalTeamService {
	List<FinalTeam> findAll();

	void save();

	int update(FinalTeam finalteam);

	int delete(FinalTeam finalteam);
	
//	void search(FinalTeam finalteam);

}
