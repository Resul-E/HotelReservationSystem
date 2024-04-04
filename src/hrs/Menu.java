package hrs;

public class Menu {

	private static Reservation[] reservations = new Reservation[20];
	public static int counter = 0;
	
	public Menu(){}
	
	public void createNewReservation() {
		reservations[counter] = new Reservation();
	}
	
	public void createNewReservationWithRoomType() {
		Reservation.flag = true;
		reservations[counter] = new Reservation();
		Reservation.flag = false;
	}
	
	public void displayAllReservations() {
		for(Reservation reservation : reservations) {
			if(reservation != null) {
				reservation.displayInfo();
			}
		}	
	}
	
	public void displayTotalNumberReservations() {
		System.out.println(counter + " reservations created so far.");
	}
}