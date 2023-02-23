package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.dao.FinalTeamDAOImpl;
import com.canddella.dao.SubstitutionDAOImpl;
import com.canddella.entity.FinalTeam;
import com.canddella.entity.Player;
import com.canddella.entity.Substitution;
import com.canddella.service.FinalTeamServiceImpl;

public class SubstitutionUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static void insertIntoSubplayers() {

		PlayerUtility.getAllTeam();
		BatterUtility.getAllBatters();
		BowlerUtility.getAllBowlers();
		AllRounderUtility.getAllRounders();
		getAllSubplayers();

		Scanner scanner = new Scanner(System.in);
		System.out.println("********Inserting into Substitution********");
		System.out.println("Enter the Player ID:");
		int playerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Player Roles:");
		String playerroles = scanner.nextLine();
		

		Substitution substitution = new Substitution();
		Player player = new Player();
		player.setPlayerId(playerId);
		substitution.setPlayer(player);

		substitution.setPlayerroles(playerroles);
		
		SubstitutionDAOImpl substitutionDAOImpl = new SubstitutionDAOImpl();
		substitutionDAOImpl.save(substitution);

		getAllSubplayers();
	}

	public static void getAllSubplayers() {

		SubstitutionDAOImpl substitutionDAOImpl = new SubstitutionDAOImpl();
		List<Substitution> substitutionList = substitutionDAOImpl.findAll();
		display();
		for (Substitution substitution : substitutionList) {
			System.out.println(substitution.getSubstitutionId() + "\t\t" + substitution.getPlayer().getPlayerId()
					+ "\t\t" + substitution.getPlayerroles());
		}
	}

	private static void display() {
		System.out.println("*********************FINAL TEAM---LIST*********************");
		System.out.println("SUBSTITUTION_ID\tPlayer_ID\tPlayer_Roles");

	}

	private static void updateSubplayers() {
		
		PlayerUtility.getAllTeam();
		BatterUtility.getAllBatters();
		BowlerUtility.getAllBowlers();
		AllRounderUtility.getAllRounders();
		getAllSubplayers();
		Scanner scanner = new Scanner(System.in);
		System.out.println("********Updatingting into Substitution********");
		System.out.println("Enter the Substitution ID:");
		int substitutionid = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Player ID:");
		int playerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Player Roles:");
		String playerroles = scanner.nextLine();
		
		Player player = new Player();
		player.setPlayerId(playerId);
		
		Substitution substitution = new Substitution(substitutionid,player,playerroles);
	

		SubstitutionDAOImpl substitutionDAOImpl = new SubstitutionDAOImpl();
		substitutionDAOImpl.update(substitution);


		getAllSubplayers();


	}

	private static void deleteSubplayers() {
		PlayerUtility.getAllTeam();
		BatterUtility.getAllBatters();
		BowlerUtility.getAllBowlers();
		AllRounderUtility.getAllRounders();
		getAllSubplayers();

		Scanner scanner = new Scanner(System.in);
		System.out.println("********Deleting the Final Team********");
		System.out.println("Enter the Final Team ID:");
		int substitutionid = scanner.nextInt();
		scanner.nextLine();
		Substitution substitution = new Substitution(substitutionid, null, null);

		SubstitutionDAOImpl substitutionDAOImpl = new SubstitutionDAOImpl();
		substitutionDAOImpl.delete(substitution);

		getAllSubplayers();

	}

	public static void menudisplay() {
		Scanner input = new Scanner(System.in);

		char response;
		boolean condition = true;
		int choice;


		do {
			System.out.println("*******************SUBSTITUTION*******************\n");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show Substitution List");
			System.out.println("2. Add new Substitute players");
			System.out.println("3. Edit Substitution players Details");
			System.out.println("4. Remove  players from Substitution list");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			choice = input.nextInt();

			switch (choice) {

			case 1:
				getAllSubplayers();
				System.out.println("\n");
				break;
			case 2:

				getAllSubplayers();
				do {
				
					System.out.println("Do you want to insert? (y/n)");
					response = input.next().charAt(0);

					if (response == 'n') {
						break;
					} else {

						insertIntoSubplayers();						
					}
				} while (response == 'y');

				break;
			case 3:
				getAllSubplayers();
				do {
					System.out.println("Do you want to Update? (y/n)");
					response = input.next().charAt(0);
					if (response == 'n') {
						break;
					} else {

						updateSubplayers();
						
					}
				} while (response == 'y');

				break;

			case 4:
				getAllSubplayers();
				do {
					System.out.println("Do you want to  Delete ? (y/n)");
					response = input.next().charAt(0);
					if (response == 'n') {
						break;
					} else {

						deleteSubplayers();
						
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
