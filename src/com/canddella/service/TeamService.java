package com.canddella.service;

import java.util.List;

import com.canddella.entity.Team;



public interface TeamService {
	
	  List<Team> findAll();
	  void save(Team team);
	  int update(Team team);
	  int delete(Team team);
}
