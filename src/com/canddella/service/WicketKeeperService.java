package com.canddella.service;

import java.util.List;

import com.canddella.entity.WicketKeeper;

public interface WicketKeeperService {
	List<WicketKeeper> findAll();

	int save(WicketKeeper wicketkeeper);

	int update(WicketKeeper wicketkeeper);

	int delete(WicketKeeper wicketkeeper);


}
