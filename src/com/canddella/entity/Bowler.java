package com.canddella.entity;

public class Bowler {

	private int bowlerId;
	private Player player;
	private String wickets;
	private String economy;
	private String best;
	public Bowler() {
		super();
	}
	public Bowler(int bowlerId, Player player, String wickets, String economy, String best) {
		super();
		this.bowlerId = bowlerId;
		this.player = player;
		this.wickets = wickets;
		this.economy = economy;
		this.best = best;
	}
	public int getBowlerId() {
		return bowlerId;
	}
	public void setBowlerId(int bowlerId) {
		this.bowlerId = bowlerId;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public String getWickets() {
		return wickets;
	}
	public void setWickets(String wickets) {
		this.wickets = wickets;
	}
	public String getEconomy() {
		return economy;
	}
	public void setEconomy(String economy) {
		this.economy = economy;
	}
	public String getBest() {
		return best;
	}
	public void setBest(String best) {
		this.best = best;
	}
	
	
}
