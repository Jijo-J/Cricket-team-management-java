package com.canddella.entity;

public class Batter {
	private int batterId;
	private Player player;
	private String totalRuns;
	private String hundreds;
	private String fifties;
	public Batter() {
		super();
	}
	public Batter(int batterId, Player player, String totalRuns, String hundreds, String fifties) {
		super();
		this.batterId = batterId;
		this.player = player;
		this.totalRuns = totalRuns;
		this.hundreds = hundreds;
		this.fifties = fifties;
	}
	public int getBatterId() {
		return batterId;
	}
	public void setBatterId(int batterId) {
		this.batterId = batterId;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public String getTotalRuns() {
		return totalRuns;
	}
	public void setTotalRuns(String totalRuns) {
		this.totalRuns = totalRuns;
	}
	public String getHundreds() {
		return hundreds;
	}
	public void setHundreds(String hundreds) {
		this.hundreds = hundreds;
	}
	public String getFifties() {
		return fifties;
	}
	public void setFifties(String fifties) {
		this.fifties = fifties;
	}
	
	
	
	
}
