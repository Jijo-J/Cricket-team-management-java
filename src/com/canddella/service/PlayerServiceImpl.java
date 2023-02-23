package com.canddella.service;

import java.util.ArrayList;
import java.util.List;

import com.canddella.dao.BatterDAOImpl;
import com.canddella.dao.PlayerDAOImpl;
import com.canddella.entity.Batter;
import com.canddella.entity.Player;


public class PlayerServiceImpl implements PlayerService {

	@Override
	public List<Player> findAll() {
		// TODO Auto-generated method stub
		PlayerDAOImpl playerDAOImpl = new PlayerDAOImpl();
		List<Player> playerList = playerDAOImpl.findAll();
		return playerList ;
	}

	@Override
	public void save(Player player) {
		// TODO Auto-generated method stub
		PlayerDAOImpl playerDAOImpl = new PlayerDAOImpl();
		int row = playerDAOImpl.save(player);
		if (row == 1)
			System.out.println("PLAYER ADDED !!!!!!!!!!!!!!!!!!");
		else
			System.out.println("PLAYER ALREADY EXIST!!!!!!!!!!!!!!!!!!");

	}
	 @Override
     public int update(Player player) {
		    PlayerDAOImpl playerDAOImpl = new PlayerDAOImpl();
			int column = playerDAOImpl.update(player);
			if(column!=0) {
				System.out.println("PLAYER DATA MODIFIEED!!!!!!!!!!!!!!!!!!");
			}
			else {
				System.out.println("DATA MODIFICATION DECLINED!!!!!!!!!!!!!!!!!!");
			}
			return column;
			
			
     }

		@Override
		public int delete(Player player) {
			 PlayerDAOImpl playerDAOImpl = new PlayerDAOImpl();
			 int row = playerDAOImpl.delete(player);
			if (row != 0)
				System.out.println("PLAYER REMOVED!!!!!!!!!!!!!!!!!!");
			else
				System.out.println("PLAYER NOT REMOVED!!!!!!!!!!!!!!!!!!");
			return 0;

		}
		@Override
		public Player playerInId(int id) {
			 PlayerDAOImpl playerDAOImpl = new PlayerDAOImpl();
			 Player row = playerDAOImpl.playerInId(id);
			 return row;

			
		}

}
