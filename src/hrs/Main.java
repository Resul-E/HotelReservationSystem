package hrs;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Reservation reservation = new Reservation();
		
		int userInp = -1;
		
		Scanner scanner = new Scanner(System.in);
		
		while(userInp != 0) {
			System.out.println("1. Create new Standard Room");
			System.out.println("2. Display all room information");
			System.out.println("3. Display the total number rooms");
			System.out.println("0. Exit");
		
			
			userInp = scanner.nextInt();
			switch (userInp) {
				case 0: {
					continue;
				}
				case 1: {
					reservation.createNewStandartRoom();
					break;
				}
				case 2: {
					reservation.displayAllInfo();
					break;
				}
				case 3: {
					reservation.displayRoomCount();
					break;
				}
				default: { 
					System.out.println("Invalid input!");
					break;
				}
			}
		}
		scanner.close();
	}
}






