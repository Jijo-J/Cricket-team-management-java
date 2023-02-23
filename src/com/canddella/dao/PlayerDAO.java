package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Player;
import com.canddella.entity.Team;

public interface PlayerDAO {
	
	List<Player> findAll();
	int save(Player player);
	int update(Player player);
	int delete(Player player);
	Player playerInId(int id);

	
	

}
