package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Batter;
import com.canddella.entity.Bowler;

public interface BowlerDAO {
	List<Bowler> findAll();
	int save(Bowler bowler);
	int update(Bowler bowler);

	int delete(Bowler bowler);
	Bowler bowlerinid(int id);


}
