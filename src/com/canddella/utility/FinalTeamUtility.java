package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.dao.FinalTeamDAOImpl;
import com.canddella.entity.Batter;
import com.canddella.entity.FinalTeam;
import com.canddella.entity.Player;
import com.canddella.service.BatterServiceImpl;
import com.canddella.service.FinalTeamServiceImpl;

public class FinalTeamUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		getAllfinalplayers();
////		insertIntofinalplayers();
//		updatefinalplayers();
//		deletefinalplayers();
//		searchfinalPlayers();
		insertIntofinalplayers();
	}

	public static void insertIntofinalplayers() {

//		PlayerUtility.getAllTeam();
//		BatterUtility.getAllBatters();
//		BowlerUtility.getAllBowlers();
//		AllRounderUtility.getAllRounders();
//		getAllfinalplayers();
//
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("********Inserting into Final Players********");
//		System.out.println("Enter the Player ID:");
//		int playerId = scanner.nextInt();
//		scanner.nextLine();
//		System.out.println("Enter the Player Roles:");
//		String playerroles = scanner.nextLine();
//		
//		FinalTeam finalteam = new FinalTeam();
////		int playerid=finalteam.getPlayer().getPlayerId();
////		finalteam.setPlayerroles(finalteam.getPlayerroles());
//		
//		finalteam.setPlayerroles(finalteam.getPlayerroles());
//		Player player = new Player();
//		player.setPlayerId(finalteam.getPlayer().getPlayerId());
//		finalteam.setPlayer(player);
//
//		finalteam = new FinalTeam();
//		
		FinalTeamDAOImpl finalTeamDAOImpl = new FinalTeamDAOImpl();
		finalTeamDAOImpl.save();
		getAllfinalplayers();

//		getAllfinalplayers();
	}

	public static void getAllfinalplayers() {

		FinalTeamServiceImpl finalTeamServiceImpl = new FinalTeamServiceImpl();
		List<FinalTeam> finalteamList = finalTeamServiceImpl.findAll();
		display();
		for (FinalTeam finalteam : finalteamList) {
			System.out.println(finalteam.getFinalteamId() + "\t\t" + finalteam.getPlayer().getPlayerName()
					+ "\t\t\t" + finalteam.getPlayerroles());
		}
	}

	public static void display() {
		System.out.println("*********************FINAL TEAM---LIST*********************");
		System.out.println("SERIAL_NO\tPLAYER_NAME\t\t\tPLAYER_ROLE");

	}

	private static void updatefinalplayers() {
		
		PlayerUtility.getAllTeam();
		BatterUtility.getAllBatters();
		BowlerUtility.getAllBowlers();
		AllRounderUtility.getAllRounders();
		getAllfinalplayers();
		Scanner scanner = new Scanner(System.in);
		System.out.println("********Updatingting into Final Players********");
		System.out.println("Enter the Final Team ID:");
		int finalteamid = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Player ID:");
		int playerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Player Roles:");
		String playerroles = scanner.nextLine();
		
		Player player = new Player();
		player.setPlayerId(playerId);
		
		FinalTeam finalteam = new FinalTeam(finalteamid,player,playerroles);
	

		FinalTeamDAOImpl finalTeamDAOImpl = new FinalTeamDAOImpl();
		finalTeamDAOImpl.update(finalteam);


		getAllfinalplayers();


	}

	private static void deletefinalplayers() {
		PlayerUtility.getAllTeam();
		BatterUtility.getAllBatters();
		BowlerUtility.getAllBowlers();
		AllRounderUtility.getAllRounders();
		getAllfinalplayers();

		Scanner scanner = new Scanner(System.in);
		System.out.println("********Deleting the Final Team********");
		System.out.println("Enter the Final Team ID:");
		int finalteamid = scanner.nextInt();
		scanner.nextLine();
		FinalTeam finalteam = new FinalTeam(finalteamid, null, null);

		FinalTeamDAOImpl finalTeamDAOImpl = new FinalTeamDAOImpl();
		finalTeamDAOImpl.delete(finalteam);

		getAllfinalplayers();

	}
//	public static void searchfinalPlayers() {
//		getAllfinalplayers();
//		Scanner scanner = new Scanner(System.in);
//
//		System.out.println("********Deleting the Final Team********");
//		System.out.println("Enter the Final Team ID:");
//		int finalteamid = scanner.nextInt();
//		scanner.nextLine();
//		FinalTeam finalteam = new FinalTeam(finalteamid, null, null);
//		FinalTeamServiceImpl finalTeamServiceImpl = new FinalTeamServiceImpl();
//		finalTeamServiceImpl.search(finalteam);
//	}

	public static void menudisplay() {
		Scanner input = new Scanner(System.in);

		char response;
		boolean condition = true;
		int choice;


		do {
//			System.out.println("*******************FINAL TEAM*******************\n");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show Final team List");
			System.out.println("2. Take a print");
//			System.out.println("3. Edit final team Details");
//			System.out.println("4. Remove  players from finaal team");
			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");
			choice = input.nextInt();

			switch (choice) {

			case 2:
				Pdfgenerate.generatepdf();
				System.out.println("\n");
			break;
			case 1:

			
//				do {
				
//					System.out.println("Do you want to insert? (y/n)");
//					response = input.next().charAt(0);

//					if (response == 'n') {
//						break;
//					} else {

						insertIntofinalplayers();						
//					}
//				} while (response == 'y');

				break;
//			case 3:
//				getAllfinalplayers();
//				do {
//					System.out.println("Do you want to Update? (y/n)");
//					response = input.next().charAt(0);
//					if (response == 'n') {
//						break;
//					} else {
//
//						updatefinalplayers();
//						
//					}
//				} while (response == 'y');
//
//				break;
//
//			case 4:
//				getAllfinalplayers();
//				do {
//					System.out.println("Do you want to  Delete ? (y/n)");
//					response = input.next().charAt(0);
//					if (response == 'n') {
//						break;
//					} else {
//
//						deletefinalplayers();
//						
//					}
//				} while (response == 'y');
//
//				break;
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
