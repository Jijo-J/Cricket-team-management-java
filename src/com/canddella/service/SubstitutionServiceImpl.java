package com.canddella.service;

import java.util.List;

import com.canddella.dao.FinalTeamDAOImpl;
import com.canddella.dao.SubstitutionDAOImpl;
import com.canddella.entity.FinalTeam;
import com.canddella.entity.Substitution;

public class SubstitutionServiceImpl implements SubstitutionService {

	@Override
	public List<Substitution> findAll() {

		SubstitutionDAOImpl substitutionDAOImpl = new SubstitutionDAOImpl();
		List<Substitution> substitutionList = substitutionDAOImpl.findAll();
		return substitutionList;

	}

	@Override
	public int save(Substitution substitution) {
		// TODO Auto-generated method stub
		SubstitutionDAOImpl substitutionDAOImpl = new SubstitutionDAOImpl();
		int row = substitutionDAOImpl.save(substitution);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");
		return 0;
	}

	@Override
	public int update(Substitution substitution) {
		SubstitutionDAOImpl substitutionDAOImpl = new SubstitutionDAOImpl();
		int column = substitutionDAOImpl.update(substitution);
		if (column != 0) {
			System.out.println("UPDATED SUCCESSFULLY!!!!!!!!!!!!!");
		} else {
			System.out.println("UPDATION FAILED!!!!!!!!!!!!!!!!!!");
		}
		return column;

	}

	@Override
	public int delete(Substitution substitution) {
		SubstitutionDAOImpl substitutionDAOImpl = new SubstitutionDAOImpl();
		int row = substitutionDAOImpl.delete(substitution);		
		if (row != 0)
			System.out.println("DELETED SUCCESSFULLY!!!!!!!!!!!!!");
		else
			System.out.println("DELETION FAILED!!!!!!!!!!!!!!!!!!44");
		return 0;

	}
	

	
}
