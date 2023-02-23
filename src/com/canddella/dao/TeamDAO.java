package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Team;

public interface TeamDAO {
	List<Team> findAll();
	int save(Team Team);
	int update(Team team);
	int delete(Team Team);
}
