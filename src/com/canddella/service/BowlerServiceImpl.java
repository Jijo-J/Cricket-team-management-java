package com.canddella.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dao.BatterDAOImpl;
import com.canddella.dao.BowlerDAOImpl;
import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Batter;
import com.canddella.entity.Bowler;
import com.canddella.entity.Player;

public class BowlerServiceImpl implements BowlerService {

	 @Override
	 public List<Bowler> findAll() {
			
		    BowlerDAOImpl bowlerDAOImpl = new BowlerDAOImpl();
			List<Bowler> bowlerList = bowlerDAOImpl.findAll();
			return bowlerList;
			
		}
        @Override
		public int save(Bowler bowler) {
			// TODO Auto-generated method stub
        	BowlerDAOImpl bowlerDAOImpl = new BowlerDAOImpl();
			int row = bowlerDAOImpl.save(bowler);
			if (row == 1)
				System.out.println("PLAYER ADDED !!!!!!!!!!!!!!!!!!");
			else
				System.out.println("PLAYER ALREADY EXIST!!!!!!!!!!!!!!!!!!");
			return 0;
		}

    	@Override
    	public int update(Bowler bowler) {
    		BowlerDAOImpl bowlerDAOImpl = new BowlerDAOImpl();
			int column = bowlerDAOImpl.save(bowler);
    		if (column != 0) {
    			System.out.println("PLAYER DATA MODIFIEED!!!!!!!!!!!!!!!!!!");
    		} else {
    			System.out.println("DATA MODIFICATION DECLINED!!!!!!!!!!!!!!!!!!");
    		}
    		return column;

    	}

    	@Override
    	public int delete(Bowler bowler) {
    		BowlerDAOImpl bowlerDAOImpl = new BowlerDAOImpl();
			int row = bowlerDAOImpl.delete(bowler);
    		if (row != 0)
    			System.out.println("PLAYER REMOVED!!!!!!!!!!!!!!!!!!");
    		else
    			System.out.println("PLAYER NOT REMOVED!!!!!!!!!!!!!!!!!!");
    		return 0;

    	}

    	@Override
    	public Bowler bowlerinid(int id) {
    		BowlerDAOImpl bowlerDAOImpl = new BowlerDAOImpl();
    		 Bowler row = bowlerDAOImpl.bowlerinid(id);
    		 return row;

    		
    	}
}
