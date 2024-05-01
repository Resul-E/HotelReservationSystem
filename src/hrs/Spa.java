package hrs;

public class Spa extends Services{

	private int days;
	private double spaCost = 100;
	
	public void setDays(int d) {
		days = d;
	}
	
	@Override
	public String getServiceType() {
		return "Spa";
	}
	
	@Override
	public double calculateService() {
		return days * spaCost;
	}

	@Override
	public double getCost() {
		return calculateService();
	}
}
