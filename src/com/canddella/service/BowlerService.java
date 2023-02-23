package com.canddella.service;

import java.util.List;

import com.canddella.entity.Batter;
import com.canddella.entity.Bowler;


public interface BowlerService {
	
	List<Bowler> findAll();
	int save(Bowler bowler);
	
	int update(Bowler bowler);

	int delete(Bowler bowler);
	Bowler bowlerinid(int id);

}
