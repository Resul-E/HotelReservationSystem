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
}
