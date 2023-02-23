package com.canddella.dao;

import java.util.List;

import com.canddella.entity.AllRounder;
import com.canddella.entity.Batter;

public interface AllRounderDAO {
	
	List<AllRounder> findAll();

	int save(AllRounder allrounder);

	int update(AllRounder allrounder);

	int delete(AllRounder allrounder);
	
	AllRounder allrounderinid(int id);


}
