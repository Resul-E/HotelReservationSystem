package hrs;

public class Menu {

	private static Reservation[] reservations = new Reservation[20];
	private static int counter = 0;
	
	public Menu(){}
	
	public void createNewReservation() {
		reservations[counter++] = new Reservation();
	}
	
	public void displayAllReservations() {
		for(Reservation reservation : reservations) {
			if(reservation != null) {
				reservation.displayInfo();
			}
		}	
	}
}