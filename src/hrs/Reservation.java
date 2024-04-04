package hrs;

public class Reservation {
	private static Room[] rooms = new Room[5];
	private static int roomCounter = 0;
	
	public Reservation() {
			
	}
	
	public void createNewStandartRoom() {
		if (roomCounter < 5) {			
			rooms[roomCounter++] = new Room();
		}else {
			System.out.println("There is no space for new rooms.");
		}
	}
	
	public void displayAllInfo() {
		for(Room room : rooms) {
			if(room != null) {
				System.out.println("Room #" + room.getId() + " has " + room.getPersonCount() + " people with a price total of $" + (room.getPersonCount() * room.getPrice()));
			}
		}
	}
	
	public void displayRoomCount() {
		System.out.println(roomCounter + " rooms has been created so far.");
	}
}
