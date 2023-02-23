package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Batter;
import com.canddella.entity.Bowler;
import com.canddella.entity.Player;
import com.canddella.service.BatterServiceImpl;
import com.canddella.service.BowlerServiceImpl;

public class BowlerUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//
//		insertIntoBowler();
//		getAllBowlers();
//		menudisplay();
		bowlersfindbyid();
	}
	
	
	private static void insertIntoBowler() {

		PlayerUtility.getAllTeam();
		getAllBowlers();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("********Inserting into Bowlers********");
		System.out.println("Enter the Player ID:");
		int playerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Wickets:");
		String wickets = scanner.nextLine();
		System.out.println("Enter the Economy:");
		String economy = scanner.nextLine();
		System.out.println("Enter the Best:");
		String best = scanner.nextLine();

		Bowler bowler = new Bowler();
		// Setting department id to employee
		Player player = new Player();
		player.setPlayerId(playerId);
		bowler.setPlayer(player);

		bowler.setWickets(wickets);
		bowler.setEconomy(economy);
		bowler.setBest(best);
		
		BowlerServiceImpl bowlerServiceImpl = new BowlerServiceImpl();
		bowlerServiceImpl.save(bowler);
		getAllBowlers();
	}
public static void getAllBowlers() {
	
	BowlerServiceImpl bowlerServiceImpl = new BowlerServiceImpl();
		List<Bowler> bowlerList = bowlerServiceImpl.findAll();
		display();
		for (Bowler bowler : bowlerList) {
			System.out.println(bowler.getBowlerId()+"\t\t"+bowler.getPlayer().getPlayerId() + "\t\t" + bowler.getWickets() + "\t\t"
					+ bowler.getEconomy() + "\t\t" + bowler.getBest());
		}
	}
private static void display() {
	System.out.println("************BOWLERS LIST*********");
	System.out.println("Bowler_ID\tPlayer_ID\tWickets\t\tEconomy\t\tBest");
	
	
}
private static void updateBowlers() {
	PlayerUtility.getAllTeam();
	getAllBowlers();
	Scanner scanner = new Scanner(System.in);
	System.out.println("********Updatingting into Bowlers********");
	System.out.println("Enter the Bowler ID:");
	int bowlerid = scanner.nextInt();
	scanner.nextLine();
	System.out.println("Enter the Player ID:");
	int playerId = scanner.nextInt();
	scanner.nextLine();
	System.out.println("Enter the  Wickets:");
	String wickets = scanner.nextLine();
	System.out.println("Enter the Economy:");
	String economy = scanner.nextLine();
	System.out.println("Enter the Best:");
	String best = scanner.nextLine();
	Player player = new Player();
	player.setPlayerId(playerId);
	
    Bowler bowler = new Bowler(bowlerid,player,wickets,economy,best);
	// Setting department id to employee
	

//	batter.setBatterId(batterid);
//	batter.setTotalRuns(totalRuns);
//	batter.setHundreds(hundreds);
//	batter.setFifties(fifties);
	BowlerServiceImpl bowlerServiceImpl = new BowlerServiceImpl();
	bowlerServiceImpl.update(bowler);
	getAllBowlers();
	

}

private static void deleteBowlers() {
	getAllBowlers();
	Scanner scanner = new Scanner(System.in);
	System.out.println("********Deleting the Batters********");
	System.out.println("Enter the Bowler ID:");
	int bowlerid = scanner.nextInt();
	scanner.nextLine();
	Bowler bowler = new Bowler(bowlerid, null, null, null, null);
//	batter.setBatterId(batterid);
	BowlerServiceImpl bowlerServiceImpl = new BowlerServiceImpl();
	bowlerServiceImpl.delete(bowler);

	getAllBowlers();

}
private static void bowlersfindbyid() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter the id");
	int bowlerrid = scanner.nextInt();
	BowlerServiceImpl bowlerServiceImpl = new BowlerServiceImpl();
	Bowler bowler = bowlerServiceImpl.bowlerinid(bowlerrid);
	if(bowler!=null)
	System.out.println("Player ID:"+bowler.getPlayer().getPlayerId() +"\nWickets :"+bowler.getWickets()+
			"\nEconomy :"+bowler.getEconomy()+"\nBest :"+bowler.getBest()
			);
//	else
//		System.out.println("Id not found");
	
}
public static void menudisplay() {
	Scanner input = new Scanner(System.in);

	char response;
	boolean condition = true;
	int choice;

//	String res;
	do {
		System.out.println("*******************BOWLERS*******************\n");
		System.out.println("Choose an option:\n");
		System.out.println("1. Show Bowlers List");
		System.out.println("2. Add new bowlers");
		System.out.println("3. Edit bowler Details");
		System.out.println("4. Remove from bowlers");
		System.out.println("5. Search bowler by Id");
		System.out.println("0. Exit");
		System.out.print("Enter your choice: ");
		choice = input.nextInt();

		switch (choice) {

		case 1:
			getAllBowlers();

			System.out.println("\n");
			break;
		case 2:

			getAllBowlers();

			do {
				// code to be executed
				System.out.println("Do you want to insert? (y/n)");
				response = input.next().charAt(0);

				if (response == 'n') {
					break;
				} else {

					insertIntoBowler();
					
				}
			} while (response == 'y');

			break;
		case 3:
			getAllBowlers();

			do {
				System.out.println("Do you want to Update? (y/n)");
				response = input.next().charAt(0);
				if (response == 'n') {
					break;
				} else {

					updateBowlers();
					
				}
			} while (response == 'y');

			break;

		case 4:
			getAllBowlers();

			do {
				System.out.println("Do you want to  Delete ? (y/n)");
				response = input.next().charAt(0);
				if (response == 'n') {
					break;
				} else {

					deleteBowlers();
					
				}
			} while (response == 'y');

			break;
		case 5:
			bowlersfindbyid();
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
