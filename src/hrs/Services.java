package hrs;

public abstract class Services implements Calculable{
	
	int customerID;
	
	abstract String getServiceType();
	
	abstract double calculateService();
	
	abstract void displayServiceInfo();

	abstract String getServiceDetail();
	
	
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

}
