package com.canddella.dao;

import java.util.List;

import com.canddella.entity.WicketKeeper;

public interface WicketKeeperDAO {
	List<WicketKeeper> findAll();

	int save(WicketKeeper wicketkeeper);

	int update(WicketKeeper wicketkeeper);

	int delete(WicketKeeper wicketkeeper);

}
