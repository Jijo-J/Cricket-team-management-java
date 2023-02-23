package com.canddella.service;

import java.util.List;

import com.canddella.dao.BatterDAOImpl;
import com.canddella.dao.PlayerDAOImpl;
import com.canddella.entity.Batter;
import com.canddella.entity.Player;

public class BatterServiceImpl implements BatterService {
	@Override
	public List<Batter> findAll() {

		BatterDAOImpl batterDAOImpl = new BatterDAOImpl();
		List<Batter> batterList = batterDAOImpl.findAll();
		return batterList;

	}

	@Override
	public int save(Batter batter) {
		// TODO Auto-generated method stub
		BatterDAOImpl batterDAOImpl = new BatterDAOImpl();
		int row = batterDAOImpl.save(batter);
		if (row == 1)
			System.out.println("PLAYER ADDED !!!!!!!!!!!!!!!!!!");
		else
			System.out.println("PLAYER ALREADY EXIST!!!!!!!!!!!!!!!!!!");
		return 0;
	}

	@Override
	public int update(Batter batter) {
		BatterDAOImpl batterDAOImpl = new BatterDAOImpl();
		int column = batterDAOImpl.update(batter);
		if (column != 0) {
			System.out.println("PLAYER DATA MODIFIEED!!!!!!!!!!!!!!!!!!");
		} else {
			System.out.println("DATA MODIFICATION DECLINED!!!!!!!!!!!!!!!!!!");
		}
		return column;

	}

	@Override
	public int delete(Batter batter) {
		BatterDAOImpl batterDAOImpl = new BatterDAOImpl();
		int row = batterDAOImpl.delete(batter);
		if (row != 0)
			System.out.println("PLAYER REMOVED!!!!!!!!!!!!!!!!!!");
		else
			System.out.println("PLAYER NOT REMOVED!!!!!!!!!!!!!!!!!!");
		return 0;

	}
	@Override
	public Batter batterinid(int id) {
		BatterDAOImpl batterDAOImpl = new BatterDAOImpl();
		 Batter row = batterDAOImpl.batterinid(id);
		 return row;

		
	}
}
