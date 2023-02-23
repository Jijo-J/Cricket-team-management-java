package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.dao.AllRounderDAOImpl;
import com.canddella.entity.AllRounder;
import com.canddella.entity.Batter;
import com.canddella.entity.Bowler;
import com.canddella.entity.Player;
import com.canddella.service.BatterServiceImpl;

public class AllRounderUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 menudisplay();
	
	}
	private static void insertIntoAllRounders() {

		
		BatterUtility.getAllBatters();
		BowlerUtility.getAllBowlers();
		
		getAllRounders();

		Scanner scanner = new Scanner(System.in);
		System.out.println("********Inserting into All ROUNDERS********");
//		System.out.println("Enter the All Rounder ID:");
//		int allrounderId = scanner.nextInt();
//		scanner.nextLine();
		System.out.println("Enter the player ID:");
		int playerId = scanner.nextInt();
		scanner.nextLine();
//		System.out.println("Enter the Bowler ID:");
//		int bowlerId = scanner.nextInt();
//		scanner.nextLine();
		AllRounder allrounder =new AllRounder();
//		Batter batter = new Batter();
//		batter.setBatterId(batterId);
//		allrounder.setBatter(batter);
//		Bowler bowler = new Bowler();
//		bowler.setBowlerId(bowlerId);
//		allrounder.setBowler(bowler);
		Player player = new Player();
		player.setPlayerId(playerId);
		allrounder.setPlayer(player);
		AllRounderDAOImpl allRounderDAOImpl = new AllRounderDAOImpl();
		allRounderDAOImpl.save(allrounder);

		

		getAllRounders();
	}

	public static void getAllRounders() {

		AllRounderDAOImpl allRounderDAOImpl = new AllRounderDAOImpl();
		List<AllRounder> allrounderList = allRounderDAOImpl.findAll();
		display();
		for (AllRounder allrounder : allrounderList) {
			System.out.println(allrounder.getAllRounderId()+ "\t\t" + allrounder.getPlayer().getPlayerId());
		}
	}

	private static void display() {
		System.out.println("*********************ALL ROUNDER---LIST*********************");
		System.out.println("All_Rounder_ID\tPlayer_ID");

	}

	private static void updateAllRounders() {
		BatterUtility.getAllBatters();
		BowlerUtility.getAllBowlers();
		getAllRounders();
		Scanner scanner = new Scanner(System.in);
		System.out.println("********Updatingting into All Rounders********");
		System.out.println("Enter the All Rounder ID:");
		int allrounderid = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the player ID:");
		int playerId = scanner.nextInt();
		scanner.nextLine();
//		System.out.println("Enter the Bowler ID:");
//		int bowlerId = scanner.nextInt();
//		Batter batter = new Batter();
//		batter.setBatterId(batterId);
//		Bowler bowler = new Bowler();
//		bowler.setBowlerId(bowlerId);
		Player player = new Player();
		player.setPlayerId(playerId);
		AllRounder allrounder =new AllRounder(allrounderid,player);
		
		AllRounderDAOImpl allRounderDAOImpl = new AllRounderDAOImpl();
		allRounderDAOImpl.update(allrounder);
		// Setting department id to employee
		

//		batter.setBatterId(batterid);
//		batter.setTotalRuns(totalRuns);
//		batter.setHundreds(hundreds);
//		batter.setFifties(fifties);

		
		getAllRounders();

	}

	private static void deleteAllRounders() {
		getAllRounders();
		Scanner scanner = new Scanner(System.in);
		System.out.println("********Deleting the All Rounders********");
		System.out.println("Enter the All Rounder ID:");
		int allrounderid = scanner.nextInt();
		scanner.nextLine();
		AllRounder allrounder = new AllRounder(allrounderid, null);
//		batter.setBatterId(batterid);
		AllRounderDAOImpl allRounderDAOImpl = new AllRounderDAOImpl();
		allRounderDAOImpl.delete(allrounder);

		getAllRounders();

	}
	private static void allroundersfindbyid() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id");
		int allrounderid = scanner.nextInt();
		AllRounderDAOImpl allRounderDAOImpl = new AllRounderDAOImpl();
		AllRounder allrounder = allRounderDAOImpl.allrounderinid(allrounderid);
		if(allrounder!=null)
		System.out.println("All ROUNDER ID:"+allrounder.getAllRounderId() +"\nplayer ID :"+allrounder.getPlayer().getPlayerId()
				);
//		else
//			System.out.println("Id not found");
//		
	}

	public static void menudisplay() {
		Scanner input = new Scanner(System.in);

		char response;
		boolean condition = true;
		int choice;

//		String res;
		do {
			System.out.println("*******************BATTERS*******************\n");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show All rounder List");
			System.out.println("2. Add new All rounders");
			System.out.println("3. Edit All Rounder Details");
			System.out.println("4. Remove from All Rounders");
			System.out.println("5. Search player by id");
			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");
			choice = input.nextInt();

			switch (choice) {

			case 1:
				getAllRounders();
				System.out.println("\n");
				break;
			case 2:

				getAllRounders();
				do {
					// code to be executed
					System.out.println("Do you want to insert? (y/n)");
					response = input.next().charAt(0);

					if (response == 'n') {
						break;
					} else {
						
						insertIntoAllRounders();
						
					}
				} while (response == 'y');

				break;
			case 3:
				getAllRounders();
				do {
					System.out.println("Do you want to Update? (y/n)");
					response = input.next().charAt(0);
					if (response == 'n') {
						break;
					} else {
						
						updateAllRounders();
						
					}
				} while (response == 'y');

				break;

			case 4:
				getAllRounders();
				do {
					System.out.println("Do you want to  Delete ? (y/n)");
					response = input.next().charAt(0);
					if (response == 'n') {
						break;
					} else {

						deleteAllRounders();
						
					}
				} while (response == 'y');

				break;
			case 5:
				 allroundersfindbyid();
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
