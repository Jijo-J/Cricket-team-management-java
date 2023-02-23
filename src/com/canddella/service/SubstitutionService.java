package com.canddella.service;

import java.util.List;

import com.canddella.entity.Substitution;



public interface SubstitutionService {
	
	List<Substitution> findAll();

	int save(Substitution substitution);

	int update(Substitution substitution);

	int delete(Substitution substitution);


}
