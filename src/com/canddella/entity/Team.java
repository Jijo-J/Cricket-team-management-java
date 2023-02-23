package com.canddella.entity;

public class Team {
	private int teamID;
	private String teamName;
	private String teamOwner;
	private String sponsers;
	public Team(int teamID, String teamName, String teamOwner, String sponsers) {
		super();
		this.teamID = teamID;
		this.teamName = teamName;
		this.teamOwner = teamOwner;
		this.sponsers = sponsers;
	}
	public int getTeamID() {
		return teamID;
	}
	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamOwner() {
		return teamOwner;
	}
	public void setTeamOwner(String teamOwner) {
		this.teamOwner = teamOwner;
	}
	public String getSponsers() {
		return sponsers;
	}
	public void setSponsers(String sponsers) {
		this.sponsers = sponsers;
	}
	
}
