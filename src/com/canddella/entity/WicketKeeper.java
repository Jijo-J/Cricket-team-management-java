package com.canddella.entity;

public class WicketKeeper {
	private int wicketkeeperId;
	private Player player;
	private String stumps;
	private String catches;
	public WicketKeeper() {
		super();
	}
	public WicketKeeper(int wicketkeeperId, Player player, String stumps, String catches) {
		super();
		this.wicketkeeperId = wicketkeeperId;
		this.player = player;
		this.stumps = stumps;
		this.catches = catches;
	}
	public int getWicketkeeperId() {
		return wicketkeeperId;
	}
	public void setWicketkeeperId(int wicketkeeperId) {
		this.wicketkeeperId = wicketkeeperId;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public String getStumps() {
		return stumps;
	}
	public void setStumps(String stumps) {
		this.stumps = stumps;
	}
	public String getCatches() {
		return catches;
	}
	public void setCatches(String catches) {
		this.catches = catches;
	}
	

}
