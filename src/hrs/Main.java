package hrs;

import java.util.*;

enum MenuOptions{
	CREATE_NEW_RESERVATION_WITH_ROOM_TYPE(1, "Create New Reservation With Room Type"),
	DISPLAY_ALL_RESERVATIONS(2, "Display All Reservations"),
	LIST_RESERVATIONS_SPECIFIC_CITY(3, "List The Reservations For A Specific City"),
	ADD_EXTRA_SERVICE_TO_RESERVATION(4, "Add Extra Services To A Reservation"),
	CALCULATE_TOTAL_COST_FOR_EACH_SERVICE(5, "Calculate Total Cost For Each Service"),
	DISPLAY_TOTAL_COST_OF_EVERY_CUSTOMER(6,"Display The Total Cost Of Every Customer"),
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
		
		ArrayList<Reservation> reservationLs = new ArrayList<Reservation>();
		ArrayList<Services> serviceLs = new ArrayList<Services>();
		
		int userInp = -1;
		int exitInp = MenuOptions.EXIT.getIndex();

		boolean flag = false;
		Services dummySer = null;
		Reservation dummyR = null;
		Laundry dummyL = null;
		Spa dummyS = null;
		String wantedCity = null;

		Scanner scanner = new Scanner(System.in);
		
		while(userInp != exitInp) {
	
			for(MenuOptions menuOption : MenuOptions.values()) {
				System.out.println(menuOption.getIndex() + ". " + menuOption.getDetail());
			}
			
			userInp = scanner.nextInt();
			scanner.nextLine();

			MenuOptions selection = null;
			
			for(MenuOptions menuOption : MenuOptions.values()) {
				if(menuOption.getIndex() == userInp) {
					selection = menuOption; 
				}
			}
			
			switch(selection) {
				
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

				case LIST_RESERVATIONS_SPECIFIC_CITY:
					
					System.out.println("Type a city name for a reservation search: ");
					wantedCity = scanner.nextLine();
					System.out.println();
					
					Iterator<Reservation> iteratorLRSC = reservationLs.iterator();
					
					while(iteratorLRSC.hasNext()) {
						
						dummyR = iteratorLRSC.next();
						
						if(dummyR.getHotelName().toLowerCase().contains(wantedCity.toLowerCase())) {
							System.out.println(dummyR.getHotelName());
							flag = true;
						}
					}
					
					System.out.println();
					
					if(!flag) {
						System.out.println("No reservations found for given city.");
					}
					
					flag = false;
					
					dummyR = null;
					break;
					
				case ADD_EXTRA_SERVICE_TO_RESERVATION:
					
					while(!flag) {
						
						System.out.println("Please select one of the extra services from below:");
						System.out.println("1. Laundy Service");
						System.out.println("2. Spa Service");
						userInp = scanner.nextInt();
						scanner.nextLine();
						
						switch(userInp) {
						case 1:
							flag = true;
							
							dummyL = new Laundry();
							
							System.out.println("Type the reservation ID to credit this service: ");
							userInp = scanner.nextInt();
							scanner.nextLine();
							
							dummyL.setCustomerID(userInp);
							
							System.out.println("How many pieces of clothing? ");
							userInp = scanner.nextInt();
							scanner.nextLine();
							
							dummyL.setClothingPieces(userInp);
							
							serviceLs.add(dummyL);
						
							break;
							
						case 2:
							flag = true;
							
							dummyS = new Spa();
							
							System.out.println("Type the reservation ID to credit this service: ");
							userInp = scanner.nextInt();
							scanner.nextLine();
							
							dummyS.setCustomerID(userInp);
							
							System.out.println("How many days?");
							userInp = scanner.nextInt();
							scanner.nextLine();
							
							dummyS.setDays(userInp);
							
							serviceLs.add(dummyS);
							
							break;
							
						default:
							System.out.println("Invalid entry!");
						}
					}
					
					flag = false;
					userInp = -1;
					break;
					
				case CALCULATE_TOTAL_COST_FOR_EACH_SERVICE:
					
					Iterator<Reservation> iteratorCTCR = reservationLs.iterator();
					Iterator<Services> iteratorCTCS = serviceLs.iterator();
					
					while(iteratorCTCR.hasNext()) {
						
						dummyR = iteratorCTCR.next();
						System.out.println("The cost for the Room booking service of reservation ID " + dummyR.getCustomerID() +": " + dummyR.calculateTotalPrice(2));
						
					}
			
					while(iteratorCTCS.hasNext()) {
				
						dummySer = iteratorCTCS.next();
						System.out.println("The cost for the " + dummySer.getServiceType() + " service of reservation ID " + dummySer.getCustomerID() + ": " + dummySer.calculateService());
					
					}	
					
					break;
		
				case DISPLAY_TOTAL_COST_OF_EVERY_CUSTOMER:
					
					for(int i = 0; i < Reservation.counter; i++) {
						int total = 0;
						 dummyR = reservationLs.get(i);
						 
						 total += dummyR.calculateTotalPrice(2);
						 
						 for(Services s: serviceLs) {
							 if(s.getCustomerID() == i+1) {
								 total += s.calculateService();
							 }
						 }
						 
						 System.out.println("The total cost of all services of the reservation with ID: "+ i +" is " + total);
						
					}
					
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