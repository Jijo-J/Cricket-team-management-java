package com.canddella.entity;

public class AllRounder {
	private int allRounderId;
	private Player player;
	private Batter batter;
	private Bowler bowler;
	public AllRounder() {
		super();
	}
	public AllRounder(int allRounderId,Player player) {
		super();
		this.allRounderId = allRounderId;
		
		this.player=player;
//		this.batter = batter;
//		this.bowler = bowler;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public int getAllRounderId() {
		return allRounderId;
	}
	public void setAllRounderId(int allRounderId) {
		this.allRounderId = allRounderId;
	}
	public Batter getBatter() {
		return batter;
	}
	public void setBatter(Batter batter) {
		this.batter = batter;
	}
	public Bowler getBowler() {
		return bowler;
	}
	public void setBowler(Bowler bowler) {
		this.bowler = bowler;
	}

}
