package hrs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bills implements Calculable{

	String type;
	double amount;
	String month;
	
	public Bills() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type: ");
		type = scanner.nextLine();
		
		boolean contFlag = false;
		do {
			
			System.out.println("Amount: ");
		
			try {
				
				if(!scanner.hasNext("[0-9]+")) {
					throw new InputMismatchException();
				}
				
				amount = scanner.nextInt();
							
				contFlag = true;
				
			}catch(InputMismatchException e) {
				
				System.err.println("Bill Amount must be a numeric value!");
				scanner.nextLine();
				
			}
			
		} while (!contFlag);
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
