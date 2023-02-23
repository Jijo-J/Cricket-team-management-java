package com.canddella.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Batter;
import com.canddella.entity.Player;
import com.canddella.entity.Team;
import com.canddella.service.BatterServiceImpl;
import com.canddella.service.PlayerService;
import com.canddella.service.PlayerServiceImpl;
import com.canddella.service.TeamServiceImpl;

public class PlayerUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		getAllTeam();
//		insertintoPlayer();
//		getAllTeam();
//		menudisplay();
//		searchinid();
		getfindbyid();
	}

	private static void insertintoPlayer() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("*********************Inserting into Players***********************");
	System.out.println("Enter the PlayerID:");
	int playerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Playername:");
		String PlayerName = scanner.nextLine();
		System.out.println("Enter the Age:");
		String age = scanner.nextLine();
		System.out.println("Enter the Location:");
		String location = scanner.nextLine();
		System.out.println("Enter the Debut Year:");
		String debutYear = scanner.nextLine();
		System.out.println("Enter the Recent Team:");
		String recentTeam = scanner.nextLine();
		System.out.println("Enter the Contact:");
		String contact = scanner.nextLine();
		Player player = new Player(playerId,PlayerName,age,location,debutYear,recentTeam,contact);
		PlayerServiceImpl PlayerService = new PlayerServiceImpl();
		PlayerService.save(player);
		getAllTeam();
		
	}
public static void getAllTeam() {
		
		PlayerServiceImpl playerServiceImpl = new PlayerServiceImpl();
		List<Player> playerList = playerServiceImpl.findAll();
		display();
		for(Player player :playerList)
		{
			System.out.println(player.getPlayerId()+"\t\t"+player.getPlayerName()+"\t"+player.getAge()+"\t"+player.getLocation()+"    \t "+player.getDebutYear()+"\t\t"+player.getRecentTeam()
			+"     \t"+player.getContact());
		}
}		
	
public static void display() {
	
	System.out.println("*********************PLAYERS---LIST*********************\n");
	System.out.println("Player_ID\tPlayer_Name\tAge\tLocation\t Debut_Year\tRecent_Team\tContact");
	
	}

private static void updatePlayers() {
	getAllTeam();
	Scanner scanner = new Scanner(System.in);
	System.out.println("*********************Inserting into Players***********************");
    System.out.println("Enter the PlayerID:");
    int playerId = scanner.nextInt();
	scanner.nextLine();
	System.out.println("Enter the Playername:");
	String PlayerName = scanner.nextLine();
	System.out.println("Enter the Age:");
	String age = scanner.nextLine();
	System.out.println("Enter the Location:");
	String location = scanner.nextLine();
	System.out.println("Enter the Debut Year:");
	String debutYear = scanner.nextLine();
	System.out.println("Enter the Recent Team:");
	String recentTeam = scanner.nextLine();
	System.out.println("Enter the Contact:");
	String contact = scanner.nextLine();
	Player player = new Player(playerId,PlayerName,age,location,debutYear,recentTeam,contact);
	PlayerServiceImpl PlayerService = new PlayerServiceImpl();
	PlayerService.update(player);
	getAllTeam();
	
}

private static void deletePlayers() {
	getAllTeam();
	Scanner scanner = new Scanner(System.in);
	System.out.println("********Deleting the Players********");
	System.out.println("Enter the Player ID:");
	int playerId = scanner.nextInt();
	scanner.nextLine();
	Player player = new Player(playerId, null, null, null, null, null, null);
	PlayerServiceImpl PlayerService = new PlayerServiceImpl();
	PlayerService.delete(player);
	getAllTeam();


}

private static void getfindbyid() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter the id");
	int playerid = scanner.nextInt();
	PlayerServiceImpl PlayerService = new PlayerServiceImpl();
	Player player = PlayerService.playerInId(playerid);
	if(player!=null)
	System.out.println("Player name:"+ player.getPlayerName()+"\nAge :"+player.getAge()+
			"\nLocation :"+player.getLocation()+"\nDebut Year :"+player.getDebutYear()
			+"\nRecent Team :"+player.getRecentTeam()+"\nContact :"+player.getContact());
//	else {
//	  
//	}
}
public static void menudisplay() {
	Scanner input = new Scanner(System.in);

	char response;
	boolean condition = true;
	int choice;

//	String res;
	do {
		System.out.println("*******************PLAYERS*******************\n");
		System.out.println("Choose an option:\n");
		System.out.println("1. Show Players List");
		System.out.println("2. Add new Players");
		System.out.println("3. Edit Player Details");
		System.out.println("4. Remove from Players");
		System.out.println("5. Search by id");

		System.out.println("0. Exit");
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

					insertintoPlayer();
					
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

					updatePlayers();
					
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

					deletePlayers();
					
				}
			} while (response == 'y');

			break;
		case 5:
//			getAllTeam();
//			do {
//				System.out.println("Do you want to  Delete ? (y/n)");
////				response = input.next().charAt(0);
//				if (response == 'n') {
//					break;
//				} else {

//					deletePlayers();
			getfindbyid();
					
//				}
//			} while (response == 'y');

			break;
		case 0:
			System.out.println("***************All THE BEST THANK YOU***************");
			condition = false;
			break;

		default:
			System.out.println("Invalid option, try again.\n");
		}

	} while (condition);

}



	
}
