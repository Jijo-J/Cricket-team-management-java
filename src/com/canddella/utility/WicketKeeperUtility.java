package com.canddella.utility;

import java.util.List;
import java.util.Scanner;

import com.canddella.dao.WicketKeeperDAOImpl;
import com.canddella.entity.Batter;
import com.canddella.entity.Player;
import com.canddella.entity.WicketKeeper;
import com.canddella.service.BatterServiceImpl;

public class WicketKeeperUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menudisplay();

	}
	private static void insertIntoWicketkeepers() {

		PlayerUtility.getAllTeam();
		getWicketKeepers();

		Scanner scanner = new Scanner(System.in);
		System.out.println("********Inserting into Wicket Keepers********");
		System.out.println("Enter the Player ID:");
		int playerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Stumps:");
		String stumps = scanner.nextLine();
		System.out.println("Enter the Catches");
		String catches = scanner.nextLine();
		
		WicketKeeper wicketkeeper = new WicketKeeper();
		// Setting department id to employee
		Player player = new Player();
		player.setPlayerId(playerId);
		wicketkeeper.setPlayer(player);

		wicketkeeper.setStumps(stumps);
		wicketkeeper.setCatches(catches);
		WicketKeeperDAOImpl wicketKeeperDAOImpl = new WicketKeeperDAOImpl();
		wicketKeeperDAOImpl.save(wicketkeeper);

		getWicketKeepers();
	}

	public static void getWicketKeepers() {

		WicketKeeperDAOImpl wicketKeeperDAOImpl = new WicketKeeperDAOImpl();
		List<WicketKeeper> wicketkeeperList = wicketKeeperDAOImpl.findAll();
		display();
		for (WicketKeeper wicketkeeper : wicketkeeperList) {
			System.out.println(wicketkeeper.getWicketkeeperId() + "\t\t" + wicketkeeper.getPlayer().getPlayerId() + "\t\t"
					+ wicketkeeper.getStumps()+ "\t\t"  + wicketkeeper.getCatches());
		}
	}

	private static void display() {
		System.out.println("*********************WICKET KEEPERS---LIST*********************");
		System.out.println("Wicket_Keeper_ID\tPlayer_ID\tStumps\tCatches");

	}

	private static void updateWicketkeepers() {
		PlayerUtility.getAllTeam();
		getWicketKeepers();
		Scanner scanner = new Scanner(System.in);
		System.out.println("********Updatingting into Wicket Keepers********");
		System.out.println("Enter the Wicket Keeper ID:");
		int wicketkeeperid = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Player ID:");
		int playerId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the Stumps:");
		String stumps = scanner.nextLine();
		System.out.println("Enter the catches:");
		String catches = scanner.nextLine();
		
		Player player = new Player();
		player.setPlayerId(playerId);
		
		WicketKeeper wicketkeeper = new WicketKeeper(wicketkeeperid,player,stumps,catches);
		// Setting department id to employee
		

//		batter.setBatterId(batterid);
//		batter.setTotalRuns(totalRuns);
//		batter.setHundreds(hundreds);
//		batter.setFifties(fifties);

		WicketKeeperDAOImpl wicketKeeperDAOImpl = new WicketKeeperDAOImpl();
		wicketKeeperDAOImpl.update(wicketkeeper);
		getWicketKeepers();

	}

	private static void deleteWicketkeepers() {
		getWicketKeepers();
		Scanner scanner = new Scanner(System.in);
		System.out.println("********Deleting the Wicket Keepers********");
		System.out.println("Enter the Wicket Keeper ID:");
		int wicketkeeperid = scanner.nextInt();
		scanner.nextLine();
		WicketKeeper wicketkeeper = new WicketKeeper(wicketkeeperid, null, null, null);
//		batter.setBatterId(batterid);
		WicketKeeperDAOImpl wicketKeeperDAOImpl = new WicketKeeperDAOImpl();
		wicketKeeperDAOImpl.delete(wicketkeeper);
		getWicketKeepers();
	}

	public static void menudisplay() {
		Scanner input = new Scanner(System.in);

		char response;
		boolean condition = true;
		int choice;

//		String res;
		do {
			System.out.println("*******************WICKET KEEPER*******************\n");
			System.out.println("Choose an option:\n");
			System.out.println("1. Show Batters List");
			System.out.println("2. Add new batters");
			System.out.println("3. Edit batter Details");
			System.out.println("4. Remove from batters");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			choice = input.nextInt();

			switch (choice) {

			case 1:
				getWicketKeepers();
				System.out.println("\n");
				break;
			case 2:

				getWicketKeepers();
				do {
					// code to be executed
					System.out.println("Do you want to insert? (y/n)");
					response = input.next().charAt(0);

					if (response == 'n') {
						break;
					} else {

						insertIntoWicketkeepers();
						
					}
				} while (response == 'y');

				break;
			case 3:
				getWicketKeepers();
				do {
					System.out.println("Do you want to Update? (y/n)");
					response = input.next().charAt(0);
					if (response == 'n') {
						break;
					} else {

						updateWicketkeepers();						
					}
				} while (response == 'y');

				break;

			case 4:
				getWicketKeepers();
				do {
					System.out.println("Do you want to  Delete ? (y/n)");
					response = input.next().charAt(0);
					if (response == 'n') {
						break;
					} else {

						deleteWicketkeepers();
						
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
