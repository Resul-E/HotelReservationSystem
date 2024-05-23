package hrs;

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
		
		new Menu();
		
	}
}