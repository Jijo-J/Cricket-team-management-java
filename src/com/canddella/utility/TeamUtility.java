package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Player;
import com.canddella.entity.Team;
import com.canddella.entity.Team;
import com.canddella.entity.Team;
import com.canddella.service.PlayerServiceImpl;
import com.canddella.service.TeamServiceImpl;
import com.canddella.service.TeamServiceImpl;
import com.canddella.service.TeamServiceImpl;

public class TeamUtility {

	public static void main(String[] args) {
//		 getAllTeam();

		
	}
	
	
	private static void insertintoTeam() {
		getAllTeam();
		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Inserting into Team***********************");
	System.out.println("Enter the TeamID:");
	int teamID = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Teamname:");
		String teamName = scanner.nextLine();
		System.out.println("Enter the Teamowner:");
		String teamOwner = scanner.nextLine();
		System.out.println("Enter the sponsers:");
		String sponsers = scanner.nextLine();
		Team team = new Team(teamID,teamName,teamOwner,sponsers);
		TeamServiceImpl TeamService = new TeamServiceImpl();
		TeamService.save(team);
		getAllTeam();
	}
private static void getAllTeam() {
		
		TeamServiceImpl teamServiceImpl = new TeamServiceImpl();
		List<Team> teamList = teamServiceImpl.findAll();
		display();
		for(Team team :teamList)
		{
			System.out.println(team.getTeamID()+"\t"+team.getTeamName()+"\t\t  "+team.getTeamOwner()+"\t"+team.getSponsers());
		}
		
	}
public static void display() {
	
	System.out.println("*********************Team---LIST*********************\n");
	System.out.println("Team_ID\tTeam_Name\t\tTeam_Owner\tSponser");
	
	}
private static void updateTeams() {
	getAllTeam();
	Scanner scanner = new Scanner(System.in);
	System.out.println("*********************Inserting into Team***********************");
    System.out.println("Enter the TeamID:");
    int teamID = scanner.nextInt();
	scanner.nextLine();
	System.out.println("Enter the TeamName:");
	String teamName = scanner.nextLine();
	System.out.println("Enter the TeamOwner:");
	String teamOwner = scanner.nextLine();
	System.out.println("Enter the sponsers:");
	String sponsers = scanner.nextLine();
	
	Team team = new Team(teamID,teamName,teamOwner,sponsers);
	TeamServiceImpl TeamService = new TeamServiceImpl();
	TeamService.update(team);
	getAllTeam();
	
}

private static void deleteTeams() {
	getAllTeam();
	Scanner scanner = new Scanner(System.in);
	System.out.println("********Deleting the Team********");
	System.out.println("Enter the Team ID:");
	int teamID = scanner.nextInt();
	scanner.nextLine();
	Team team = new Team(teamID, null, null, null);
	TeamServiceImpl TeamService = new TeamServiceImpl();
	TeamService.delete(team);
	getAllTeam();


}
public static void menudisplay() {
	Scanner input = new Scanner(System.in);

	char response;
	boolean condition = true;
	int choice;

//	String res;
	do {
		System.out.println("*******************Team*******************\n");
		System.out.println("Choose an option:\n");
		System.out.println("1. Show Team List");
		System.out.println("2. Add new Team");
		System.out.println("3. Edit Team Details");
		System.out.println("4. Remove from Team");
		System.out.println("5. Exit");
		System.out.print("Enter your choice: ");
		choice = input.nextInt();

		switch (choice) {

		case 1:
			getAllTeam();
			System.out.println("\n");
			break;
		case 2:

			getAllTeam();
			do {
				// code to be executed
				System.out.println("Do you want to insert? (y/n)");
				response = input.next().charAt(0);

				if (response == 'n') {
					break;
				} else {

					insertintoTeam();
					
				}
			} while (response == 'y');

			break;
		case 3:
			getAllTeam();
			do {
				System.out.println("Do you want to Update? (y/n)");
				response = input.next().charAt(0);
				if (response == 'n') {
					break;
				} else {

					updateTeams();
					
				}
			} while (response == 'y');

			break;

		case 4:
			getAllTeam();
			do {
				System.out.println("Do you want to  Delete ? (y/n)");
				response = input.next().charAt(0);
				if (response == 'n') {
					break;
				} else {

					deleteTeams();
					
				}
			} while (response == 'y');

			break;
		case 5:
			System.out.println("***************All THE BEST THANK YOU***************");
			condition = false;
			break;

		default:
			System.out.println("Invalid option, try again.\n");
		}

	} while (condition);
}


}
