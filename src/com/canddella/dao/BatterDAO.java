package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Batter;

public interface BatterDAO {
	List<Batter> findAll();

	int save(Batter batter);

	int update(Batter batter);

	int delete(Batter batter);
	Batter batterinid(int id);
	
}
