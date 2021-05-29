package com.qa.main;

import java.sql.SQLException;
import java.util.Scanner;

public class Runner {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {

		DBConnection dbCon = new DBConnection();
		String action = getAction();
		int actionInt = Integer.parseInt(action);

		try {
			do {
				switch (actionInt) {
				case 1:
					System.out.println("Enter de name you wanna add to database");
					String name = scanner.nextLine();
					dbCon.create(name);
					break;
				case 2:
					System.out.println("Reading all entries");
					dbCon.readAll();
					break;
				case 3:
					System.out.println("Enter id of Costumer you'd like lookup");
					int id = scanner.nextInt();
					scanner.nextLine();
					dbCon.readOne(id);
					break;
				case 4:
					System.out.println("Enter id of Costumer you'd like to update");
					int uId = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter new name for this Costumer id");
					String uName = scanner.nextLine();
					dbCon.update(uId,uName);
					break;
                case 5:
					System.out.println("Enter id of Costumer you'd like to delete");
					int dId = scanner.nextInt();
					scanner.nextLine();
					dbCon.delete(dId);
					break;

				}
            action = getAction();
            actionInt = Integer.parseInt(action);
			} while (actionInt != 6);
		System.out.println("\nHave a nice day!");
		} finally {
			scanner.close();
			dbCon.tearDown();

		}

	}

	private static String getAction() {

		String menu = "\n\nWELCOME TO THE INTERNAL COSTUMER DATABASE \n\n" + "1 - Create new Costumer \n"
				+ "2 - Read all Costumers  \n" + "3 - Read One Costumer   \n" + "4 - Update Costumer   \n"
				+ "5 - Delete Costumer   \n" + "6 - Exit \n\n"

				+ "Please select a number ...";

		System.out.println(menu + "");
		return scanner.nextLine().toLowerCase();

	}
  
  
	  
	  
	  
  }






