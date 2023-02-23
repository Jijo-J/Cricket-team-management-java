package com.canddella.entity;

public class Player {
	
	private int playerId;
	private String playerName;
	private String age;
	private String location;
	private String debutYear;
	private String recentTeam;
	private String contact;
	public Player(int playerId, String playerName, String age, String location, String debutYear, String recentTeam,
			String contact) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.age = age;
		this.location = location;
		this.debutYear = debutYear;
		this.recentTeam = recentTeam;
		this.contact = contact;
	}
	public Player() {
		super();
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDebutYear() {
		return debutYear;
	}
	public void setDebutYear(String debutYear) {
		this.debutYear = debutYear;
	}
	public String getRecentTeam() {
		return recentTeam;
	}
	public void setRecentTeam(String recentTeam) {
		this.recentTeam = recentTeam;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	

}
