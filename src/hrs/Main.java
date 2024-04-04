package hrs;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Menu menu = new Menu();
		
		int userInp = -1;
		Scanner scanner = new Scanner(System.in);
		
		while(userInp != 0) {
	
			System.out.println("1. Create New Reservation");
			System.out.println("2. Display All Reservations");
			System.out.println("0. Exit");
			
			userInp = scanner.nextInt();
			
			
			switch(userInp) {
				case 1:
					menu.createNewReservation();
					break;
				case 2:
					menu.displayAllReservations();
					break;
				case 0:
					continue;
				default:
					System.out.println("Invalid entry!");
			}
		}
	scanner.close();
	}
}