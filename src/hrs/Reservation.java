package hrs;

import java.util.InputMismatchException;
import java.util.Scanner;

enum RoomType{
	S("Single") ,
	D("Double"),
	C("Club"),
	F("Family"),
	FWV("Family With View"),
	SU("Suite");
	
	private String type;
	
	private RoomType(String rType) {
		this.type = rType;
	}
	
	public String getType(){
		return type;
	}
}

public class Reservation extends Services implements Comparable<Reservation>{
	
	public static int counter = 0;

	private String hotelName;
	private String reservationMonth;
	private String city;
	private int reservationStart;
	private int reservationEnd;
	private RoomType roomType;
	private Room room;
	
	public Reservation(String hName, String month, String city, int start, int end) {
		
		this.hotelName = hName;
		this.reservationMonth = month;
		this.city = city;
		this.reservationStart = start;
		this.reservationEnd = end;
		this.roomType = RoomType.S;
		this.room = new Single();
		
	}

	public Reservation(){
		Scanner scanner = new Scanner(System.in);
		
		this.setCustomerID(counter+1);
		
		System.out.println("ROOM INFOS:");
		System.out.println("Room Type: Single, Daily Cost: 100, Room Size: 15, Has Bath: false");
		System.out.println("Room Type: Double, Daily Cost: 180, Room Size: 30, Has Bath: false");
		System.out.println("Room Type: Club, Daily Cost: 250, Room Size: 45, Has Bath: true");
		System.out.println("Room Type: Family, Daily Cost: 400, Room Size: 50, Has Bath: false");
		System.out.println("Room Type: Family With View, Daily Cost: 450, Room Size: 50, Has Bath: true");
		System.out.println("Room Type: Suite, Daily Cost: 650, Room Size: 80, Has Bath: true");
		System.out.println();

		
		System.out.println("Hotel Name: ");
		hotelName = scanner.nextLine();
		
		System.out.println("Enter City: ");
		city = scanner.nextLine();
		
		String userInp;
		boolean contFlag = false;
		do {
			
			System.out.println("Room Type: ");
			userInp = scanner.nextLine();
			userInp = AdditionalMethods.formatInput(userInp);
			for(RoomType rType : RoomType.values()) {	
				if(rType.getType().equals(userInp)) {
					roomType = rType;
				}
			}
			
			
			try {
				if(roomType == null) {
					throw new RoomTypeException();
				}
				
				contFlag = true;
			
			}catch(RoomTypeException e) {
				System.err.println("Room Type is not valid!");
			}
		} while (!contFlag);
			
			
		
		
		
	
		switch(roomType) {
			case S:
				room = new Single();
				break;
			case D:
				room = new Double();
				break;
			case C:
				room = new Club();
				break;
			case F:
				room = new Family();
				break;
			case FWV:
				room = new FamilyWithView();
				break;
			case SU:
				room = new Suite();
				break;
			default:
				room = new Single();
		}
		
		
		System.out.println("Reservation Month: ");
		reservationMonth = scanner.nextLine();
		reservationMonth = AdditionalMethods.formatInput(reservationMonth);
		
		contFlag = false;
		do {
			
			System.out.println("Check-in Date:(1-29) ");
		
			try {
				if(!scanner.hasNext("[0-9]+")) {
					throw new InputMismatchException();
				}
				
				reservationStart = scanner.nextInt();
							
				contFlag = true;
				
				if((reservationStart >= 30) || (reservationStart <= 0)) {
					System.err.println("Invalid date!");
					contFlag = false;
				}
				
			}catch(InputMismatchException e) {
				
				System.err.println("Reservation Start must be a numeric value!");
				scanner.nextLine();
				
			}
			
		} while (!contFlag);
		
		
		contFlag = false;
		do {
			
			System.out.println("Check-out Date:(" + (reservationStart+1) + "-30) ");
			
			try {
				if(!scanner.hasNext("[0-9]+")) {
					throw new InputMismatchException();
				}
				
				reservationEnd = scanner.nextInt();
							
				contFlag = true;
				
				if((reservationEnd <= reservationStart) || (reservationEnd > 30) || (reservationEnd <= 0)) {
					System.err.println("Invalid date!");
					contFlag = false;
				}
				
			}catch(InputMismatchException e) {
				
				System.err.println("Reservation End must be a numeric value!");
				scanner.nextLine();
				
			}
		} while (!contFlag);
		
		System.out.println("Reservation ID: "+ (counter+1) +" created!");
		System.out.println();
	}

	public void displayInfo() {
		System.out.println("Reservation for a " + roomType.getType() + " room reservation in " +
				   hotelName + " starts on " +
				   reservationMonth + " " +
				   reservationStart + " and ends on " +
				   reservationMonth + " " +
				   reservationEnd + ".");
		System.out.println("Reservation has a total cost of $" + calculateTotalPrice(2));
	}
	
	public void displayInfoSimple() {
		System.out.println("Hotel Name: " + this.getHotelName() + ", Customer ID: " + this.getCustomerID() + ", Service Type: " + this.getServiceType() + ", Cost: " + this.getCost());
	
	}
	
	@Override
	public void displayServiceInfo() {
		System.out.println("Customer ID: " + this.getCustomerID() + ", Service Type: " + this.getServiceType() + ", Service Cost: " + this.getCost());
		
	}
	
	public int calculateTotalPrice() {
		return (reservationEnd - reservationStart) * room.getDailyCost();
	}

	public int calculateTotalPrice(int multiplier) {
		if(reservationMonth.equalsIgnoreCase("June") | reservationMonth.equalsIgnoreCase("July") | reservationMonth.equalsIgnoreCase("August")) {
			return (calculateTotalPrice() * multiplier);
		}else {
			return calculateTotalPrice();
		}
	}

	@Override
	public double calculateService() {
		return calculateTotalPrice(2); 
	}

	@Override
	public double getCost() {
		return calculateService();
	}

	@Override
	public int compareTo(Reservation o) {
		return this.getHotelName().compareTo(o.getHotelName());
	}
	
	@Override
	String getServiceType() {
		return "Room Booking";
	}
	

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hName) {
		hotelName = hName;
	}

	public String getReservationMonth() {
		return reservationMonth;
	}

	public void setReservationMonth(String rMonth) {
		reservationMonth = rMonth;
	}

	public int getReservationStart() {
		return reservationStart;
	}

	public void setReservationStart(int rStart) {
		reservationStart = rStart;
	}

	public int getReservationEnd() {
		return reservationEnd;
	}

	public void setReservationEnd(int rEnd) {
		reservationEnd = rEnd;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType rType) {
		roomType = rType;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String getServiceDetail() {
		String detail = ("Reservation ID#" + this.customerID + "\nReservation at " + this.hotelName + " starts on " + this.reservationMonth + " " + this.reservationStart + " and ends on " + this.reservationMonth + " " + this.reservationEnd);
		return detail;
	}

}
