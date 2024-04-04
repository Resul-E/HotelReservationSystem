package hrs;

import java.util.Scanner;

enum MenuOptions{
	CREATE_NEW_RESERVATION(1, "Create New Reservation"),
	CREATE_NEW_RESERVATION_WITH_ROOM_TYPE(2, "Create new Reservation with Room Type"),
	DISPLAY_ALL_RESERVATIONS(3, "Display All Reservations"),
	DISPLAY_TOTAL_RESERVATION_COUNT(4, "Display the total number of reservations"),
	EXIT(5, "Exit");
	
	private final int index;
	private final String detail;
	
	private MenuOptions(int mIndex, String mDetail) {
		index = mIndex;
		detail = mDetail;
	}
	
	public int getIndex() {
		return index;
	}
	
	public String getDetail() {
		return detail;
	}
}

public class Main {
	public static void main(String[] args) {
		
		Reservation[] reservationLs = new Reservation[20];
		
		int userInp = -1;
		Scanner scanner = new Scanner(System.in);
		
		int exitInp = MenuOptions.EXIT.getIndex();
		
		while(userInp != exitInp) {
	
			for(MenuOptions menuOption : MenuOptions.values()) {
				System.out.println(menuOption.getIndex() + ". " + menuOption.getDetail());
			}
			
			userInp = scanner.nextInt();

			MenuOptions selection = null;
			
			for(MenuOptions menuOption : MenuOptions.values()) {
				if(menuOption.getIndex() == userInp) {
					selection = menuOption; 
				}
			}
			
			switch(selection) {
				case CREATE_NEW_RESERVATION:
					reservationLs[Reservation.counter++] = new Reservation();
					break;
				case CREATE_NEW_RESERVATION_WITH_ROOM_TYPE:
					Reservation.flag = true;
					reservationLs[Reservation.counter++] = new Reservation();
					Reservation.flag = false;
					break;
				case DISPLAY_ALL_RESERVATIONS:
					for(Reservation reservation : reservationLs) {
						if(reservation != null) {
							reservation.displayInfo();
						}
					}
					System.out.println();
					break;
				case DISPLAY_TOTAL_RESERVATION_COUNT:
					System.out.println(Reservation.counter + " reservations created so far.");
					System.out.println();
					break;
				case EXIT:
					break;
				default:
					System.out.println("Invalid entry!");
			}
		}
	scanner.close();
	}
}