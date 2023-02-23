package com.canddella.service;

import java.util.List;

import com.canddella.entity.Player;

public interface PlayerService {
	
	List<Player> findAll();
	void save(Player player);
	int update(Player player);
	int delete(Player player);
	Player playerInId(int id);
	
}
