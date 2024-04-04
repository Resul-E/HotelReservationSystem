package hrs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

enum MenuOptions{
	CREATE_NEW_RESERVATION(1, "Create New Reservation"),
	CREATE_NEW_RESERVATION_WITH_ROOM_TYPE(2, "Create new Reservation with Room Type"),
	DISPLAY_ALL_RESERVATIONS(3, "Display All Reservations"),
	DISPLAY_TOTAL_RESERVATION_COUNT(4, "Display the total number of reservations"),
	LIST_RESERVATIONS_SPECIFIC_CITY(5, "List the reservations for a specific city"),
	REMOVE_RESERVATION_SPECIFIC_CITY(6, "Remove reservations in a specific city"),
	EXIT(7, "Exit");
	
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
		
		ArrayList<Reservation> reservationLs = new ArrayList<Reservation>(3);
		
		int userInp = -1;
		int exitInp = MenuOptions.EXIT.getIndex();

		boolean flag = false;
		Reservation dummyR;
		String wantedCity = null;

		Scanner scanner = new Scanner(System.in);
		
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
					
					reservationLs.add(new Reservation());
					Reservation.counter++;
					break;
				
				case CREATE_NEW_RESERVATION_WITH_ROOM_TYPE:
					
					Reservation.flag = true;
					reservationLs.add(new Reservation());
					Reservation.counter++;
					Reservation.flag = false;
					break;
				
				case DISPLAY_ALL_RESERVATIONS:
					
					Iterator<Reservation> iteratorDAR = reservationLs.iterator();
					
					while(iteratorDAR.hasNext()) {
					
						dummyR = iteratorDAR.next();
						dummyR.displayInfo();
					}
					
					dummyR = null;
					System.out.println();
					break;
				
				case DISPLAY_TOTAL_RESERVATION_COUNT:
					
					System.out.println(Reservation.counter + " reservations created so far.");
					System.out.println();
					break;
				
				case LIST_RESERVATIONS_SPECIFIC_CITY:
					
					System.out.println("Type a city name for a reservation search: ");
					scanner.nextLine();
					wantedCity = scanner.nextLine();
					
					Iterator<Reservation> iteratorLRSC = reservationLs.iterator();
					
					while(iteratorLRSC.hasNext()) {
						
						dummyR = iteratorLRSC.next();
						
						if(dummyR.getHotelName().toLowerCase().contains(wantedCity.toLowerCase())) {
							System.out.println(dummyR.getHotelName());
							flag = true;
						}
					}
					
					if(!flag) {
						System.out.println("No reservations found for given city.");
					}
					
					flag = false;
					
					dummyR = null;
					break;
				
				case REMOVE_RESERVATION_SPECIFIC_CITY:
					
					System.out.println("Type a city name for a reservation search: ");
					scanner.nextLine();
					wantedCity = scanner.nextLine();
					
					Iterator<Reservation> iteratorRRSC = reservationLs.iterator();
					
					while(iteratorRRSC.hasNext()) {
						
						dummyR = iteratorRRSC.next();
						
						if(dummyR.getHotelName().toLowerCase().contains(wantedCity.toLowerCase())) {
							iteratorRRSC.remove();
							flag = true;
						}
					
					}
					
					if(!flag) {
						System.out.println("No reservations found for given city.");
					}
					
					flag = false;
					
					dummyR = null;
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