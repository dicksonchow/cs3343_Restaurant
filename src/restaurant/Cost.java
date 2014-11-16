package restaurant;

public class Cost {

	private static int cost;

	public static int setCost() {
		cost = 0;
		Restaurant restaurant = Restaurant.getInstance();
		for(int i=0; i<restaurant.getIngredientArrayList().size(); i++) {			
			cost += restaurant.getIngredientArrayList().get(i).getIngredientPrice();
		}
		return cost;
	}
	
	public String toString() {
		setCost();
		return String.format("%-15s", "$" + cost);
	}
		
}
