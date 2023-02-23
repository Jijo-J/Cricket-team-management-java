package com.canddella.utility;

import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Batter;
import com.canddella.entity.Player;
import com.canddella.service.BatterServiceImpl;
import com.canddella.service.PlayerServiceImpl;

public class BatterUtility {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

//		insertIntoBatter();
//		getAllBatters();
//		updateBatters();
//		deleteBatters();
//		menudisplay();
		battersfindbyid();
	}

	private static void insertIntoBatter() {

		PlayerUtility.getAllTeam();
		getAllBatters();

		Scanner scanner = new Scanner(System.in);
		System.out.println("********Inserting into Batters********");
		System.out.println("Enter the Player ID:");
		int playerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Total Runs:");
		String totalRuns = scanner.nextLine();
		System.out.println("Enter the Hundreds:");
		String hundreds = scanner.nextLine();
		System.out.println("Enter the Fifties:");
		String fifties = scanner.nextLine();

		Batter batter = new Batter();
		// Setting department id to employee
		Player player = new Player();
		player.setPlayerId(playerId);
		batter.setPlayer(player);

		batter.setTotalRuns(totalRuns);
		batter.setHundreds(hundreds);
		batter.setFifties(fifties);

		BatterServiceImpl batterServiceImpl = new BatterServiceImpl();
		batterServiceImpl.save(batter);

		getAllBatters();
	}

	public static void getAllBatters() {

		BatterServiceImpl batterServiceImpl = new BatterServiceImpl();
		List<Batter> batterList = batterServiceImpl.findAll();
		display();
		for (Batter batter : batterList) {
			System.out.println(batter.getBatterId() + "\t\t" + batter.getPlayer().getPlayerId() + "\t\t"
					+ batter.getTotalRuns() + "\t\t" + batter.getHundreds() + "\t\t" + batter.getFifties());
		}
	}

	private static void display() {
		System.out.println("*********************BATTERS---LIST*********************");
		System.out.println("Batter_ID\tPlayer_ID\tTotal_Runs\tHundreds\tFifties");

	}

	private static void updateBatters() {
		PlayerUtility.getAllTeam();
		getAllBatters();
		Scanner scanner = new Scanner(System.in);
		System.out.println("********Updatingting into Batters********");
		System.out.println("Enter the batter ID:");
		int batterid = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Player ID:");
		int playerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Total Runs:");
		String totalRuns = scanner.nextLine();
		System.out.println("Enter the Hundreds:");
		String hundreds = scanner.nextLine();
		System.out.println("Enter the Fifties:");
		String fifties = scanner.nextLine();
		Player player = new Player();
		player.setPlayerId(playerId);
		
		Batter batter = new Batter(batterid,player,totalRuns,hundreds,fifties);
	

		BatterServiceImpl batterServiceImpl = new BatterServiceImpl();
		batterServiceImpl.update(batter);

		getAllBatters();

	}

	private static void deleteBatters() {
		getAllBatters();
		Scanner scanner = new Scanner(System.in);
		System.out.println("********Deleting the Batters********");
		System.out.println("Enter the batter ID:");
		int batterid = scanner.nextInt();
		scanner.nextLine();
		Batter batter = new Batter(batterid, null, null, null, null);

		BatterServiceImpl batterServiceImpl = new BatterServiceImpl();
		batterServiceImpl.delete(batter);

		getAllBatters();

	}

	private static void battersfindbyid() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id");
		int batterid = scanner.nextInt();
		BatterServiceImpl batterServiceImpl = new BatterServiceImpl();
		Batter batter = batterServiceImpl.batterinid(batterid);
		if(batter!=null)
		System.out.println("Player ID:"+batter.getPlayer().getPlayerId() +"\nTotal Runs :"+batter.getTotalRuns()+
				"\nHundreds :"+batter.getHundreds()+"\nFifties :"+batter.getFifties()
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


		do {
			System.out.println("*******************BATTERS*******************\n");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show Batters List");
			System.out.println("2. Add new batters");
			System.out.println("3. Edit batter Details");
			System.out.println("4. Remove from batters");
			System.out.println("5. Search batters by id");
			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");
			choice = input.nextInt();

			switch (choice) {

			case 1:
				getAllBatters();
				System.out.println("\n");
				break;
			case 2:

				getAllBatters();
				do {
				
					System.out.println("Do you want to insert? (y/n)");
					response = input.next().charAt(0);

					if (response == 'n') {
						break;
					} else {

						insertIntoBatter();
						
					}
				} while (response == 'y');

				break;
			case 3:
				getAllBatters();
				do {
					System.out.println("Do you want to Update? (y/n)");
					response = input.next().charAt(0);
					if (response == 'n') {
						break;
					} else {

						updateBatters();
						
					}
				} while (response == 'y');

				break;

			case 4:
				getAllBatters();
				do {
					System.out.println("Do you want to  Delete ? (y/n)");
					response = input.next().charAt(0);
					if (response == 'n') {
						break;
					} else {

						deleteBatters();
						
					}
				} while (response == 'y');

				break;
			case 5:
				battersfindbyid();
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
