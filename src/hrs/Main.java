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
	LIST_ALL_SERVICES_ON_COST(10, "List All Services Sorted Based on Cost"),
	LIST_ALL_SERVICES_ON_HOTEL_NAMES(11, "List All Reservations Sorted Based on Hotel Names"),
	EXIT(12, "Exit");
	
	
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
		
		ArrayList<Calculable> expenseLs = new ArrayList<Calculable>();
		ArrayList<Services> incomeLs = new ArrayList<Services>();

		int userInp = -1;
		int exitInp = MenuOptions.EXIT.getIndex();

		Scanner scanner = new Scanner(System.in);
		
		while(userInp != exitInp) {
	
			
			

			
			
			MenuOptions selection = null;
			boolean contFlag = false;
			
			do {
				
				for(MenuOptions menuOption : MenuOptions.values()) {
					System.out.println(menuOption.getIndex() + ". " + menuOption.getDetail());
				}
				
				userInp = scanner.nextInt();
				scanner.nextLine();
				
				try {
					
					for(MenuOptions menuOption : MenuOptions.values()) {
						if(menuOption.getIndex() == userInp) {
							selection = menuOption; 
						}
					}
					
					if(selection == null) {
						throw new NullPointerException();
					}
					
					contFlag = true;
					
				}catch (NullPointerException e){
					
					System.err.println("You entered an invalid menu option. Enter again.");
					
				}
				
			} while (!contFlag);
			
			
			
			switch(selection) {
				
				case CREATE_NEW_RESERVATION_WITH_ROOM_TYPE:
					
					incomeLs.add(new Reservation());
					Reservation.counter++;
					break;
				
				case DISPLAY_ALL_RESERVATIONS:
					
					Iterator<Services> iteratorDAR = incomeLs.iterator();
					Services dummySer_DAR;
					Reservation dummyR_DAR;
					
					while(iteratorDAR.hasNext()) {
					
						dummySer_DAR = iteratorDAR.next();
						
						if(dummySer_DAR instanceof Reservation) {
							
							dummyR_DAR = ((Reservation) dummySer_DAR);
							dummyR_DAR.displayInfo();
							
						}
					}
					
					System.out.println();
					break;

				case LIST_RESERVATIONS_SPECIFIC_CITY:
					
					Services dummySer_LRSC;
					Reservation dummyR_LRSC;
					boolean flag_LRSC = false;
					String wantedCity_LRSC;
					
					System.out.println("Type a city name for a reservation search: ");
					wantedCity_LRSC = scanner.nextLine();
					System.out.println();
					
					Iterator<Services> iteratorLRSC = incomeLs.iterator();
					
					while(iteratorLRSC.hasNext()) {
						
						dummySer_LRSC = iteratorLRSC.next();
						
						if(dummySer_LRSC instanceof Reservation) {
							
							dummyR_LRSC = ((Reservation) dummySer_LRSC);
							
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
					boolean flag2_AESTR = false;
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
							
							while(!flag2_AESTR) {
								
								System.out.println("Type the reservation ID to credit this service: ");
								userInp_AESTR = scanner.nextInt();
								scanner.nextLine();
								
								if(userInp_AESTR <= 0 | userInp_AESTR > Reservation.counter) {
									System.out.println("Invalid ID!");
								}else {
									flag2_AESTR = true;
								}
							}
							
							dummyL_AESTR.setCustomerID(userInp_AESTR);
							
							contFlag = false;
							do {
								
								System.out.println("How many pieces of clothing? ");
							
								try {
									if(!scanner.hasNext("[0-9]+")) {
										throw new InputMismatchException();
									}
									
									userInp_AESTR = scanner.nextInt();
												
									contFlag = true;
									
								}catch(InputMismatchException e) {
									
									System.err.println("Clothing count must be a numeric value!");
									scanner.nextLine();
									
								}
								
							} while (!contFlag);
							
							dummyL_AESTR.setClothingPieces(userInp_AESTR);
							
							incomeLs.add(dummyL_AESTR);
						
							break;
							
						case 2:
							flag_AESTR = true;
							
							dummyS_AESTR = new Spa();
							
							while(!flag2_AESTR) {
								
								System.out.println("Type the reservation ID to credit this service: ");
								userInp_AESTR = scanner.nextInt();
								scanner.nextLine();
								
								if(userInp_AESTR <= 0 | userInp_AESTR > Reservation.counter) {
									System.out.println("Invalid ID!");
								}else {
									flag2_AESTR = true;
								}
							}
							
							dummyS_AESTR.setCustomerID(userInp_AESTR);
							
							contFlag = false;
							do {
								
								System.out.println("How many days?");
							
								try {
									if(!scanner.hasNext("[0-9]+")) {
										throw new InputMismatchException();
									}
									
									userInp_AESTR = scanner.nextInt();
												
									contFlag = true;
									
								}catch(InputMismatchException e) {
									
									System.err.println("Day count must be a numeric value!");
									scanner.nextLine();
									
								}
								
							} while (!contFlag);
							
							dummyS_AESTR.setDays(userInp_AESTR);
							
							incomeLs.add(dummyS_AESTR);
							
							break;
							
						default:
							System.out.println("Invalid entry!");
						}
					}
					
					break;
					
				case CALCULATE_TOTAL_COST_FOR_EACH_SERVICE:
					
					Iterator<Services> iteratorCTCS = incomeLs.iterator();
					Reservation dummyR_CTCS;
					Services dummySer_CTCS;
					
					while(iteratorCTCS.hasNext()) {
						
						dummySer_CTCS = iteratorCTCS.next();

						if(dummySer_CTCS instanceof Reservation) {
							
							dummyR_CTCS = ((Reservation) dummySer_CTCS);
							System.out.println("The cost for the Room booking service of reservation ID " + dummyR_CTCS.getCustomerID() +": " + dummyR_CTCS.calculateService());
							
						}
						
					}
					
					iteratorCTCS = incomeLs.iterator();
			
					while(iteratorCTCS.hasNext()) {
				
						dummySer_CTCS = iteratorCTCS.next();
						
						if(dummySer_CTCS instanceof Spa | dummySer_CTCS instanceof Laundry ) {
							

							System.out.println("The cost for the " + dummySer_CTCS.getServiceType() + " service of reservation ID " + dummySer_CTCS.getCustomerID() + ": " + dummySer_CTCS.calculateService());
							
						}
					
					}	
					System.out.println();
					break;
		
				case DISPLAY_TOTAL_COST_OF_EVERY_CUSTOMER:
					
					Reservation dummyR_DTCC;
					Services dummySer_DTCC;
					int idCounter = Reservation.counter;
					
					while(idCounter > 0) {
						
						for(Services Ser : incomeLs) {
						
							if(Ser instanceof Reservation) {
								
								idCounter--;
								dummyR_DTCC = ((Reservation) Ser);

								int total = 0;
								total += dummyR_DTCC.getCost();
								
								for(Services ser : incomeLs) {
									
									if(ser instanceof Spa | ser instanceof Laundry) {
										dummySer_DTCC = ser;
										
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
					
					expenseLs.add(new Employee());
					
					break;
				
				case ADD_A_BILL:
					
					expenseLs.add(new Bills());
					
					break;
				
				case GET_MONTHLY_BALANCE:
					
					System.out.println("Enter Month: ");
					String wantedMonth = scanner.nextLine();
					Services dummySer_GMB;
					Reservation dummyR_GMB;
					int income = 0;
					int billCost = 0;
					int employeeCost = 0;
					
					
					for(Services Ser : incomeLs) {
						if(Ser instanceof Reservation) {
							
							dummyR_GMB = ((Reservation) Ser);
							
							if(dummyR_GMB.getReservationMonth().equalsIgnoreCase(wantedMonth)) {
								
								income += dummyR_GMB.getCost();
								dummyR_GMB.displayServiceInfo();
								
								for(Services ser : incomeLs) {
									if( (ser instanceof Spa | ser instanceof Laundry) & (ser.getCustomerID() == dummyR_GMB.getCustomerID()) ) {
											
											dummySer_GMB = ser;
											income += dummySer_GMB.getCost();
											dummySer_GMB.displayServiceInfo();
										
									}
								}
							}
						}
					}
							
					for(Calculable C : expenseLs) {
						if( (C instanceof Bills) ) {
							if( ((Bills) C).getMonth().equalsIgnoreCase(wantedMonth) ){
								billCost += C.getCost();
							}
							
						}else if(C instanceof Employee) {
							employeeCost += C.getCost();
						}
					}
					
					System.out.println("Total Monthly Income: " + income);
					System.out.println("Total Monthly Bills Due: " + billCost);
					System.out.println("Total Monthly Employee Cost: " + employeeCost);
					System.out.println("End of Month Balance: " + (income - billCost - employeeCost));
					System.out.println();
					
					break;
				
				case LIST_ALL_SERVICES_ON_COST:
					
					ArrayList<Services> sortedSer = new ArrayList<Services>();
					sortedSer = incomeLs;
					
					CostComparator c = new CostComparator();
					
					Collections.sort(sortedSer, c);
					Collections.reverse(sortedSer);
					
					for(Services s : sortedSer) {
						s.displayServiceInfo();
					}
					
					break;
					
				case LIST_ALL_SERVICES_ON_HOTEL_NAMES:
					
					ArrayList<Reservation> sortedR = new ArrayList<Reservation>();
					
					for(Services s : incomeLs) {
						if(s instanceof Reservation) {
							sortedR.add((Reservation) s);
						}
					}
					
					Collections.sort(sortedR);
					
					for(Reservation r : sortedR) {
						r.displayServiceInfo();
					}
					
					break;
					
				case EXIT:
					System.out.println("Exiting, Goodbye!");
					break;
				
				default:
					
					System.err.println("You entered an invalid menu option. Enter again.");
			}
		}
	scanner.close();
	}
}