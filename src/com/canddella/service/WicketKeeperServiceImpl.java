package com.canddella.service;

import java.util.List;

import com.canddella.dao.WicketKeeperDAOImpl;

import com.canddella.entity.WicketKeeper;

public class WicketKeeperServiceImpl implements WicketKeeperService {

	@Override
	public List<WicketKeeper> findAll() {

		WicketKeeperDAOImpl wicketKeeperDAOImpl = new WicketKeeperDAOImpl();
		List<WicketKeeper> wicketkeeperList = wicketKeeperDAOImpl.findAll();
		return wicketkeeperList;

	}

	@Override
	public int save(WicketKeeper  wicketkeeper) {
		// TODO Auto-generated method stub
		WicketKeeperDAOImpl wicketKeeperDAOImpl = new WicketKeeperDAOImpl();
		int row = wicketKeeperDAOImpl.save(wicketkeeper);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");
		return 0;
	}

	@Override
	public int update(WicketKeeper  wicketkeeper) {
		WicketKeeperDAOImpl wicketKeeperDAOImpl = new WicketKeeperDAOImpl();
		int column = wicketKeeperDAOImpl.update(wicketkeeper);
		if (column != 0) {
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!!");
		} else {
			System.out.println("UPDATION FAILED!!!!!!!!!!!!!!!!!!");
		}
		return column;

	}

	@Override
	public int delete(WicketKeeper  wicketkeeper) {
		WicketKeeperDAOImpl wicketKeeperDAOImpl = new WicketKeeperDAOImpl();
		int row = wicketKeeperDAOImpl.delete(wicketkeeper);
		if (row != 0)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!!");
		else
			System.out.println("DELETION FAILED!!!!!!!!!!!!!!!!!!44");
		return 0;

	}

}
