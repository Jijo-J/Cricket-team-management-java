package com.canddella.service;

import java.util.List;

import com.canddella.entity.Batter;
import com.canddella.entity.Player;

public interface BatterService {

	List<Batter> findAll();

	int save(Batter batter);

	int update(Batter batter);

	int delete(Batter batter);
	
	Batter batterinid(int id);

}
