package hrs;

import java.util.ArrayList;
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

public class Reservation extends Services{
	
	public static int counter = 0;

	private String hotelName;
	private String reservationMonth;
	private int reservationStart;
	private int reservationEnd;
	private RoomType roomType;
	private Room room;
	public static boolean flag = false;
	

	public Reservation(){
		Scanner scanner = new Scanner(System.in);
		
		this.setCustomerID(counter+1);
		
		if(flag) {
			System.out.println("ROOM INFOS:");
			System.out.println("Room Type: Single, Daily Cost: 100, Room Size: 15, Has Bath: false");
			System.out.println("Room Type: Double, Daily Cost: 180, Room Size: 30, Has Bath: false");
			System.out.println("Room Type: Club, Daily Cost: 250, Room Size: 45, Has Bath: true");
			System.out.println("Room Type: Family, Daily Cost: 400, Room Size: 50, Has Bath: false");
			System.out.println("Room Type: Family With View, Daily Cost: 450, Room Size: 50, Has Bath: true");
			System.out.println("Room Type: Suite, Daily Cost: 650, Room Size: 80, Has Bath: true");
			System.out.println();
		}
		
		System.out.println("Hotel Name: ");
		hotelName = scanner.nextLine();
		
		if(flag) {
			System.out.println("Room Type: ");
			String userInp = scanner.nextLine();
			userInp = AdditionalMethods.formatInput(userInp);
			for(RoomType rType : RoomType.values()) {	
				if(rType.getType().equals(userInp)) {
					roomType = rType;
				}
			}
			while(roomType == null) {
				System.out.println("Invalid type!");
				System.out.println("Room Type: ");
				userInp = scanner.nextLine();
				userInp = AdditionalMethods.formatInput(userInp);
				for(RoomType rType : RoomType.values()) {	
					if(rType.getType().equals(userInp)) {
						roomType = rType;
					}
				}
			}
		
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
		}else {
			roomType = RoomType.S;
			room = new Single();
		}
		
		System.out.println("Reservation Month: ");
		reservationMonth = scanner.nextLine();
		reservationMonth = AdditionalMethods.formatInput(reservationMonth);
		
		System.out.println("Check-in Date:(1-29) ");
		reservationStart = scanner.nextInt();
		scanner.nextLine();
		while((reservationStart >= 30) || (reservationStart <= 0)) {
			System.out.println("Invalid date!");
			System.out.println("Check-in Date:(1-29) ");
			reservationStart = scanner.nextInt();
			scanner.nextLine();
		}
		
		System.out.println("Check-out Date:(" + (reservationStart+1) + "-30) ");
		reservationEnd = scanner.nextInt();
		scanner.nextLine();
		while((reservationEnd <= reservationStart) || (reservationEnd > 30) || (reservationEnd <= 0)) {
			System.out.println("Invalid date!");
			System.out.println("Check-out Date:(" + (reservationStart+1) + "-30) ");
			reservationEnd = scanner.nextInt();
			scanner.nextLine();
		}
		
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
	String getServiceType() {
		return "Reservation";
	}
	
	@Override
	double calculateService() {
		return 0;
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

}
