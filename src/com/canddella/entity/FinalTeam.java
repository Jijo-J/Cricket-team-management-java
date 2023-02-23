package com.canddella.entity;

public class FinalTeam {
	 private int finalteamId;
	 private Player player;
	 
	
	private String playerroles;
	public int getFinalteamId() {
		return finalteamId;
	}
	public void setFinalteamId(int finalteamId) {
		this.finalteamId = finalteamId;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public String getPlayerroles() {
		return playerroles;
	}
	public void setPlayerroles(String playerroles) {
		this.playerroles = playerroles;
	}
	public FinalTeam(int finalteamId, Player player, String playerroles) {
		super();
		this.finalteamId = finalteamId;
		this.player = player;
		this.playerroles = playerroles;
	}
	public FinalTeam() {
		super();
	}

}
