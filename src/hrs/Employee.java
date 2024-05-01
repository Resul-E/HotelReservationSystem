package hrs;

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
		System.out.println("Monthly Payment: ");
		monthlyPayment = scanner.nextDouble();
		scanner.nextLine();
		
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
