package hrs;

public class Laundry extends Services {

	private int clothingPieces;
	private double laundryCost = 20;
	
	public void setClothingPieces(int cp) {
		clothingPieces = cp;
	}
	
	@Override
	public String getServiceType() {
		return "Laundry";
	}
	
	@Override
	public double calculateService() {
		return clothingPieces * laundryCost;
	}

	@Override
	public double getCost() {
		return calculateService();
	}

	@Override
	public void displayServiceInfo() {
		System.out.println("Customer ID: " + this.getCustomerID() + ", Service Type: " + this.getServiceType() + ", Service Cost: " + this.getCost());
		
	}
}
