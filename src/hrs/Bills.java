package hrs;

import java.util.Scanner;

public class Bills implements Calculable{

	String type;
	double amount;
	String month;
	
	public Bills() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type: ");
		type = scanner.nextLine();
		System.out.println("Amount: ");
		amount = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Month: ");
		month = scanner.nextLine();
		
	}

	@Override
	public double getCost() {
		return amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}
