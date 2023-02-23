package com.canddella.service;

import java.util.List;

import com.canddella.entity.AllRounder;
import com.canddella.entity.Batter;

public interface AllRounderService {
	List<AllRounder> findAll();

	int save(AllRounder allrounder);

	int update(AllRounder allrounder);

	int delete(AllRounder allrounder);
	
	AllRounder allrounderinid(int id);
}
