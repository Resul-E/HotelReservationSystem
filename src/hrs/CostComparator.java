package hrs;

import java.util.Comparator;

public class CostComparator implements Comparator<Services>{

	@Override
	public int compare(Services o1, Services o2) {
		
		double cost1 = o1.getCost();
		double cost2 = o2.getCost();
		
		if(cost1 == cost2) { 
			return 0; 
		}
		else if (cost1 > cost2) { 
			return 1; 
		}
		else {
			return -1; 
		} 
	}

}
