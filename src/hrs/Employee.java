package hrs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Employee implements Calculable{

	String name;
	String surname;
	double monthlyPayment;
	int id;
	
	public Employee(){
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Name:");
		name = scanner.nextLine();
		
		System.out.println("Surname: ");
		surname = scanner.nextLine();
		
		System.out.println("ID: ");
		id = scanner.nextInt();
		scanner.nextLine();
		
		boolean contFlag = false;
		do {
			
			System.out.println("Monthly Payment: ");
		
			try {
				
				if(!scanner.hasNext("[0-9]+")) {
					throw new InputMismatchException();
				}
				
				monthlyPayment = scanner.nextDouble();
							
				contFlag = true;
				
			}catch(InputMismatchException e) {
				
				System.err.println("Monthly Payment must be a numeric value!");
				scanner.nextLine();
				
			}
			
		} while (!contFlag);
		
	}

	@Override
	public double getCost() {
		return monthlyPayment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}


}
