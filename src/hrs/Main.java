package hrs;

import java.util.*;

enum MenuOptions{
	CREATE_NEW_RESERVATION_WITH_ROOM_TYPE(1, "Create New Reservation With Room Type"),
	DISPLAY_ALL_RESERVATIONS(2, "Display All Reservations"),
	LIST_RESERVATIONS_SPECIFIC_CITY(3, "List The Reservations For A Specific City"),
	ADD_EXTRA_SERVICE_TO_RESERVATION(4, "Add Extra Services To A Reservation"),
	CALCULATE_TOTAL_COST_FOR_EACH_SERVICE(5, "Calculate Total Cost For Each Service"),
	DISPLAY_TOTAL_COST_OF_EVERY_CUSTOMER(6, "Display The Total Cost Of Every Customer"),
	ADD_AN_EMPLOYEE(7, "Add an Employee"),
	ADD_A_BILL(8, "Add a Bill"),
	GET_MONTHLY_BALANCE(9, "Get Monthly Balance"),
	EXIT(10, "Exit");
	
	
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
		
		ArrayList<Calculable> calculableLs = new ArrayList<Calculable>();
//		ArrayList<Reservation> reservationLs = new ArrayList<Reservation>();
//		ArrayList<Services> serviceLs = new ArrayList<Services>();

		int userInp = -1;
		int exitInp = MenuOptions.EXIT.getIndex();

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
					calculableLs.add(new Reservation());
					Reservation.counter++;
					Reservation.flag = false;
					break;
				
				case DISPLAY_ALL_RESERVATIONS:
					
					Iterator<Calculable> iteratorDAR = calculableLs.iterator();
					Calculable dummyC_DAR;
					Reservation dummyR_DAR;
					
					while(iteratorDAR.hasNext()) {
					
						dummyC_DAR = iteratorDAR.next();
						
						if(dummyC_DAR instanceof Reservation) {
							
							dummyR_DAR = ((Reservation) dummyC_DAR);
							dummyR_DAR.displayInfo();
							
						}
					}
					
					System.out.println();
					break;

				case LIST_RESERVATIONS_SPECIFIC_CITY:
					
					Calculable dummyC_LRSC;
					Reservation dummyR_LRSC;
					boolean flag_LRSC = false;
					String wantedCity_LRSC;
					
					System.out.println("Type a city name for a reservation search: ");
					wantedCity_LRSC = scanner.nextLine();
					System.out.println();
					
					Iterator<Calculable> iteratorLRSC = calculableLs.iterator();
					
					while(iteratorLRSC.hasNext()) {
						
						dummyC_LRSC = iteratorLRSC.next();
						
						if(dummyC_LRSC instanceof Reservation) {
							
							dummyR_LRSC = ((Reservation) dummyC_LRSC);
							
							if(dummyR_LRSC.getHotelName().toLowerCase().contains(wantedCity_LRSC.toLowerCase())) {
								System.out.println(dummyR_LRSC.getHotelName());
								flag_LRSC = true;
							}
						}
					}
					
					System.out.println();
					
					if(!flag_LRSC) {
						System.out.println("No reservations found for given city.");
					}
					
					break;
					
				case ADD_EXTRA_SERVICE_TO_RESERVATION:
					
					boolean flag_AESTR = false;
					Laundry dummyL_AESTR;
					Spa dummyS_AESTR;
					int userInp_AESTR;
					
					while(!flag_AESTR) {
						
						System.out.println("Please select one of the extra services from below:");
						System.out.println("1. Laundy Service");
						System.out.println("2. Spa Service");
						userInp_AESTR = scanner.nextInt();
						scanner.nextLine();
						
						switch(userInp_AESTR) {
						case 1:
							flag_AESTR = true;
							
							dummyL_AESTR = new Laundry();
							
							System.out.println("Type the reservation ID to credit this service: ");
							userInp_AESTR = scanner.nextInt();
							scanner.nextLine();
							
							dummyL_AESTR.setCustomerID(userInp_AESTR);
							
							System.out.println("How many pieces of clothing? ");
							userInp_AESTR = scanner.nextInt();
							scanner.nextLine();
							
							dummyL_AESTR.setClothingPieces(userInp_AESTR);
							
							calculableLs.add(dummyL_AESTR);
						
							break;
							
						case 2:
							flag_AESTR = true;
							
							dummyS_AESTR = new Spa();
							
							System.out.println("Type the reservation ID to credit this service: ");
							userInp_AESTR = scanner.nextInt();
							scanner.nextLine();
							
							dummyS_AESTR.setCustomerID(userInp_AESTR);
							
							System.out.println("How many days?");
							userInp_AESTR = scanner.nextInt();
							scanner.nextLine();
							
							dummyS_AESTR.setDays(userInp_AESTR);
							
							calculableLs.add(dummyS_AESTR);
							
							break;
							
						default:
							System.out.println("Invalid entry!");
						}
					}
					
					break;
					
				case CALCULATE_TOTAL_COST_FOR_EACH_SERVICE:
					
					Iterator<Calculable> iteratorCTCS = calculableLs.iterator();
					Calculable dummyC_CTCS;
					Reservation dummyR_CTCS;
					Services dummySer_CTCS;
					
					while(iteratorCTCS.hasNext()) {
						
						dummyC_CTCS = iteratorCTCS.next();

						if(dummyC_CTCS instanceof Reservation) {
							
							dummyR_CTCS = ((Reservation) dummyC_CTCS);
							System.out.println("The cost for the Room booking service of reservation ID " + dummyR_CTCS.getCustomerID() +": " + dummyR_CTCS.calculateService());
							
						}
						
					}
					
					iteratorCTCS = calculableLs.iterator();
			
					while(iteratorCTCS.hasNext()) {
				
						dummyC_CTCS = iteratorCTCS.next();
						
						if(dummyC_CTCS instanceof Spa | dummyC_CTCS instanceof Laundry ) {
							
							dummySer_CTCS = ((Services) dummyC_CTCS);
							System.out.println("The cost for the " + dummySer_CTCS.getServiceType() + " service of reservation ID " + dummySer_CTCS.getCustomerID() + ": " + dummySer_CTCS.calculateService());
							
						}
					
					}	
					
					break;
		
				case DISPLAY_TOTAL_COST_OF_EVERY_CUSTOMER:
					
					Reservation dummyR_DTCC;
					Services dummySer_DTCC;
					int idCounter = Reservation.counter;
					
					while(idCounter > 0) {
						
						for(Calculable C : calculableLs) {
						
							if(C instanceof Reservation) {
								
								idCounter--;
								dummyR_DTCC = ((Reservation) C);

								int total = 0;
								total += dummyR_DTCC.getCost();
								
								for(Calculable c : calculableLs) {
									
									if(c instanceof Spa | c instanceof Laundry) {
										dummySer_DTCC = ((Services) c);
										
										if(dummySer_DTCC.getCustomerID() == dummyR_DTCC.getCustomerID()) {
											total += dummySer_DTCC.getCost();
										}
									}
									
								}
							System.out.println("The total cost of all services of the reservation with ID: "+ dummyR_DTCC.getCustomerID() +" is " + total);
							}
						}
					}
					break;
					
				case ADD_AN_EMPLOYEE:
					
					calculableLs.add(new Employee());
					
					break;
				
				case ADD_A_BILL:
					
					calculableLs.add(new Bills());
					
					break;
				
				case GET_MONTHLY_BALANCE:
					
					System.out.println("Enter Month: ");
					String wantedMonth = scanner.nextLine();
					Services dummySer_GMB;
					Reservation dummyR_GMB;
					Bills dummyB_GMB;
					Employee dummyE_GMB;
					int income = 0;
					int billCost = 0;
					int employeeCost = 0;
					
					
					for(Calculable C : calculableLs) {
						if(C instanceof Reservation) {
							
							dummyR_GMB = ((Reservation) C);
							
							if(dummyR_GMB.getReservationMonth().equalsIgnoreCase(wantedMonth)) {
								
								income += dummyR_GMB.getCost();
								System.out.println("For Reservation ID: " + dummyR_GMB.getCustomerID() + ", Service Type: " + dummyR_GMB.getServiceType() + ", Service Cost: " + dummyR_GMB.getCost());
								
								for(Calculable c : calculableLs) {
									if(c instanceof Spa | c instanceof Laundry) {
										if(((Services) c).getCustomerID() == dummyR_GMB.getCustomerID()) {
											
											dummySer_GMB = ((Services) c);
											income += dummySer_GMB.getCost();
											System.out.println("For Reservation ID: " + dummySer_GMB.getCustomerID() + ", Service Type: " + dummySer_GMB.getServiceType() + ", Service Cost: " + dummySer_GMB.getCost());
										}
									}
								}
							}
							
						}else if(C instanceof Bills){
							dummyB_GMB = ((Bills) C);
							
							if(dummyB_GMB.getMonth().equalsIgnoreCase(wantedMonth)) {
								billCost += dummyB_GMB.getCost();
							}
						}else if(C instanceof Employee){
							dummyE_GMB = ((Employee) C);
							
							employeeCost += dummyE_GMB.getCost();
							
						}
					}
					
					System.out.println("Total Monthly Income: " + income);
					System.out.println("Total Monthly Bills Due: " + billCost);
					System.out.println("Total Monthly Employee Cost: " + employeeCost);
					System.out.println("End of Month Balance: " + (income - billCost - employeeCost));
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