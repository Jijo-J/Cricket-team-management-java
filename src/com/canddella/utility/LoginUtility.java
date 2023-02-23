package com.canddella.utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.canddella.dao.LoginDAOImpl;
import com.canddella.service.LoginServiceImpl;

public class LoginUtility {

	public static void main(String[] args) {
	
//		        try {
//		            // Connect to database
//		        	String statement = "SELECT * FROM login WHERE user_name = ? AND pass_word = ?";
//		        	Connection connection = null;
//		          	PreparedStatement preparedStatement = null;
//		        	 preparedStatement = connection.prepareStatement(statement);
//		      
//
//					
//					DataSource ds = DBConnectionPool.getDataSource();
//					connection = ds.getConnection();
//					
//					preparedStatement = connection.prepareStatement(statement);
//
//		            // Prompt user for login credentials
//		            String username = "john123"; // replace with user's username
//		            String password = "password123"; // replace with user's password
//
//		            // Check if user exists in database
//		            
//		            prepareStatement.setString(1, username);
//		            prepareStatement.setString(2, password);
//		            ResultSet result = prepareStatement.executeQuery();
//
//		            if (result.next()) {
//		                // User exists in database, login successful
//		                System.out.println("Login successful!");
//		            } else {
//		                // User does not exist in database or password is incorrect
//		                System.out.println("Invalid username or password.");
//		            }
//
//		            // Close database connection
//		            conn.close();
//		        } catch (SQLException e) {
//		            System.err.println("Error: " + e.getMessage());
//		        }
//		    }
//		
//
//			 
		userLogin();
			
				
				
			}

			
		
	public static void userLogin() {
		int value=0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("**User Login Credentials*");
		System.out.println("-------------------------------");
		System.out.println();

		System.out.println("Enter User Name :");
		String userName = scanner.nextLine();
		System.out.println("Enter Password :");
		String password = scanner.nextLine();

		LoginDAOImpl loginDao = new LoginDAOImpl();
		boolean isLoginValid;
		try {
			isLoginValid = loginDao.login(userName, password);
			if (isLoginValid) {
				DisplayFinal.finalDisaply();
			} else {
				
				System.out.println("Incorrect Login credentials. Try again");
				System.out.println();
				userLogin();
		
				
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	
	

}
