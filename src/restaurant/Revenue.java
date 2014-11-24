package restaurant;

import java.util.ArrayList;

public class Revenue {

	//private int revenue;
	private static Revenue instance = new Revenue();
	
	public static Revenue getInstance() {
		return instance;
	}

	public int setRevenue() {
		int revenue = 0;
		//Restaurant restaurant = Restaurant.getInstance();
		ArrayList<Order> order = Restaurant.getInstance().getOrderArrayList();
		for(Order o: order) {			
			revenue += o.setTotalAmount(); //before o.getTotalAmount
		}
		return revenue;
	}
	
	public String toString() {
		int revenue = setRevenue();
		return String.format("%-15s", "$" + revenue);
	}
	
}
