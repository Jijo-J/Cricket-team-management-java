package com.canddella.utility;

import java.util.Scanner;

public class DisplayFinal {
	
	public static void main(String[] args) {
		finalDisaply();
	}
public static void finalDisaply() {
	 Scanner input = new Scanner(System.in);
	 boolean  value = true;
	    int num;
	    do {
	    System.out.println("**************WELCOME**********\n*"
	    		+ "************CRICKET TEAM MANAGEMENT***********");	
	    System.out.println("1.TEAM\n2.PLAYERS\n3.BATTERS\n4.BOWLERS"
	    		+ "\n5.ALL ROUNDDERS\n6.WICKET KEEPERS\n7.FINAL TEAM\n0.Exit");	
	    System.out.print("Enter a Choice: ");
	    num = input.nextInt();
	    
	    switch (num) {
	      case 1:
	    	  TeamUtility.menudisplay();
	        break;
	      case 2:
	    	  PlayerUtility.menudisplay();
	        break;
	      case 3:
	    	  BatterUtility.menudisplay();
	        break;
	      case 4:
	    	  BowlerUtility.menudisplay();
	        break;
	      case 5:
	    	  AllRounderUtility.menudisplay();
	        break;
	     
	      case 6:
	    	  WicketKeeperUtility.menudisplay();
	        break;
	      case 7:
	    	  FinalTeamUtility.menudisplay();
	        break;
  
	      case 0:
	    	 System.out.println("********All THE BEST THANK YOU**********");
	    	 value = false;
	        break;
	      default:
	        System.out.println("*****Wrong choioce Try again**************\n");
	    }
	    
	  }while(value);
}
}
