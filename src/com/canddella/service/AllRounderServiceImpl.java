package com.canddella.service;

import java.util.List;

import com.canddella.dao.AllRounderDAOImpl;
import com.canddella.dao.BatterDAOImpl;
import com.canddella.entity.AllRounder;
import com.canddella.entity.Batter;

public class AllRounderServiceImpl implements AllRounderService {

	@Override
	public List<AllRounder> findAll() {

		AllRounderDAOImpl allRounderDAOImpl = new AllRounderDAOImpl();
		List<AllRounder> allrounderList = allRounderDAOImpl.findAll();
		return allrounderList;

	}

	@Override
	public int save(AllRounder allrounder) {
		// TODO Auto-generated method stub
		AllRounderDAOImpl allRounderDAOImpl = new AllRounderDAOImpl();
		int row = allRounderDAOImpl.save(allrounder);
		if (row == 1)
			System.out.println("PLAYER ADDED !!!!!!!!!!!!!!!!!!");
		else
			System.out.println("player already exist!!!!!!!!!!!!!!!!!!");
		return 0;
	}

	@Override
	public int update(AllRounder allrounder) {
		AllRounderDAOImpl allRounderDAOImpl = new AllRounderDAOImpl();
		int column = allRounderDAOImpl.update(allrounder);
		if (column != 0) {
			System.out.println("PLAYER DATA MODIFIEED!!!!!!!!!!!!!!!!!!");
		} else {
			System.out.println("DATA MODIFICATION DECLINED!!!!!!!!!!!!!!!!!!");
		}
		return column;

	}

	@Override
	public int delete(AllRounder allrounder) {
		AllRounderDAOImpl allRounderDAOImpl = new AllRounderDAOImpl();
		int row = allRounderDAOImpl.delete(allrounder);
		if (row != 0)
			System.out.println("PLAYER REMOVED!!!!!!!!!!!!!!!!!!");
		else
			System.out.println("PLAYER NOT REMOVED!!!!!!!!!!!!!!!!!!");
		return 0;

	}
	@Override
	public AllRounder allrounderinid(int id) {
		AllRounderDAOImpl allRounderDAOImpl = new AllRounderDAOImpl();
		AllRounder row = allRounderDAOImpl.allrounderinid(id);
		 return row;

		
	}


}
