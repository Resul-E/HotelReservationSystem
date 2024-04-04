package hrs;

import java.util.Scanner;

public class Reservation {
	
	private String hotelName;
	private String reservationMonth;
	private int reservationStart;
	private int reservationEnd;
	private	int dailyCost;
	private RoomType roomType;
	
	enum RoomType{
		S("Single"),
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
	
	public Reservation(){
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Hotel Name: ");
		hotelName = scanner.nextLine();
		
		System.out.println("Reservation Month: ");
		reservationMonth = scanner.nextLine();
		
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
		
		System.out.println("Daily Cost: ");
		dailyCost = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Room Type:(Single, Double, Club, Family, Family With View, Suite)");
		String userInp = scanner.nextLine();
		userInp = userInp.substring(0,1).toUpperCase() + userInp.substring(1).toLowerCase();
		for(RoomType rType : RoomType.values()) {	
			if(rType.getType().equals(userInp)) {
				roomType = rType;
			}
		}
		while(roomType == null) {
			System.out.println("Invalid type");
			System.out.println("Room Type:(Single, Double, Club, Family, Family With View, Suite)");
			userInp = scanner.nextLine();
			userInp = userInp.substring(0,1).toUpperCase() + userInp.substring(1).toLowerCase();
			for(RoomType rType : RoomType.values()) {	
				if(rType.getType().equals(userInp)) {
					roomType = rType;
				}
			}
		}
		System.out.println("Reservation created!");
	}

	
	public void displayInfo() {
		System.out.println(roomType.getType() + " room reservation for " +
				   this.hotelName + " starts on " +
				   this.reservationMonth + " " +
				   this.reservationStart + " and ends on " +
				   this.reservationMonth + " " +
				   this.reservationEnd + ".");
		System.out.println("Reservation has a total cost of $" + this.calculateTotalPrice() );
	}
	
	private int calculateTotalPrice() {
		return (reservationEnd - reservationStart) * dailyCost;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getReservationMonth() {
		return reservationMonth;
	}

	public void setReservationMonth(String reservationMonth) {
		this.reservationMonth = reservationMonth;
	}

	public int getReservationStart() {
		return reservationStart;
	}

	public void setReservationStart(int reservationStart) {
		this.reservationStart = reservationStart;
	}

	public int getReservationEnd() {
		return reservationEnd;
	}

	public void setReservationEnd(int reservationEnd) {
		this.reservationEnd = reservationEnd;
	}

	public int getDailyCost() {
		return dailyCost;
	}

	public void setDailyCost(int dailyCost) {
		this.dailyCost = dailyCost;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
}
