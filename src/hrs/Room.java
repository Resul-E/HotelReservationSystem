package hrs;

public class Room {

	private int dailyCost;
	protected int roomSize;
	protected boolean hasBath;

	public Room(int dc, int rs, boolean hb){
		dailyCost = dc;
		roomSize = rs;
		hasBath = hb;
		
	}
	
	public int getDailyCost() {
		return dailyCost;
	}

	public void setDailyCost(int dc) {
		dailyCost = dc;
	}

	@Override
	public String toString() {
		return "Room [dailyCost=" + dailyCost + ", roomSize=" + roomSize + ", hasBath=" + hasBath + "]";
	}
	
	
}

class Single extends Room{

	public Single() {
		super(100, 15, false);
		
	}
	
}

class Double extends Room{
	
	public Double() {
		super(180, 30, false);

	}
	
}

class Club extends Room{
	
	public Club() {
		super(250, 45, true);

	}
	
}

class Family extends Room{
	
	public Family() {
		super(400, 50, false);

	}
	
}

class FamilyWithView extends Room{
	
	public FamilyWithView() {
		super(450, 50, true);

	}
	
}

class Suite extends Room{
	
	public Suite() {
		super(650, 80, true);

	}
	
}