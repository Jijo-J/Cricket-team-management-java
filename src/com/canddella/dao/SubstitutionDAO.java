package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Substitution;

public interface SubstitutionDAO {
	List<Substitution> findAll();

	int save(Substitution substitution);

	int update(Substitution substitution);

	int delete(Substitution substitution);


}
