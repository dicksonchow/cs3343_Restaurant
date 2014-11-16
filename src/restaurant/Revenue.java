package restaurant;

public class Revenue {

	private static int revenue;

	public static int setRevenue() {
		revenue = 0;
		Restaurant restaurant = Restaurant.getInstance();
		for(int i=0; i<restaurant.getOrderArrayList().size(); i++) {			
			revenue += restaurant.getOrderArrayList().get(i).getTotalAmount();
		}
		return revenue;
	}
	
	public String toString() {
		setRevenue();
		return String.format("%-15s", "$" + revenue);
	}
	
}
