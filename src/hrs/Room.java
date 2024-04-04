package hrs;

import java.util.Scanner;

public class Room {
	private static int roomCount = 0;
	
	private int id;
	private int price;
	private int personCount;
	
	public Room() {
		roomCount++;
		id = roomCount;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Person Count: ");
		personCount = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Price: ");
		price = scanner.nextInt();
		
		System.out.println("Room #" + id + " created!");
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setPrice(int price){
		this.price = price;
	}
	
	public int getPrice(){
		return this.price;
	}
	public void setPersonCount(int personCount){
		this.personCount = personCount;
	}
	
	public int getPersonCount(){
		return this.personCount;
	}
	
	public int getRoomCount() {
		return Room.roomCount;
	}
	  
}
