package com.canddella.entity;

public class Substitution {
	private int substitutionId;
	private Player player;
	private String playerroles;

	public Substitution() {
		super();
	}

	public Substitution(int substitutionId, Player player, String playerroles) {
		super();
		this.substitutionId = substitutionId;
		this.player = player;
		this.playerroles = playerroles;
	}

	public int getSubstitutionId() {
		return substitutionId;
	}

	public void setSubstitutionId(int substitutionId) {
		this.substitutionId = substitutionId;
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
	
	
}
