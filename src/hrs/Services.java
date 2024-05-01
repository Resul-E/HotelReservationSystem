package hrs;

public abstract class Services implements Calculable{
	
	int customerID;
	
	abstract String getServiceType();
	
	abstract double calculateService();

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

}
