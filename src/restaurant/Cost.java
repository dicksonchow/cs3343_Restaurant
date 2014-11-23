package restaurant;

import java.util.ArrayList;

public class Cost {

	//private int cost;
	private static Cost instance = new Cost();
	
	public static Cost getInstance() {
		return instance;
	}

	public int setCost() {
		int cost = 0;
		//Restaurant restaurant = Restaurant.getInstance();
		ArrayList<Ingredient> ing = Restaurant.getInstance().getIngredientArrayList();
		/*for(int i=0; i<restaurant.getIngredientArrayList().size(); i++) {			
			cost += restaurant.getIngredientArrayList().get(i).getIngredientPrice();
		}*/
		for(Ingredient i: ing){
			cost += i.getIngredientPrice();
		}
		return cost;
	}
	
	public String toString() {
		int cost = setCost();
		return String.format("%-15s\n", "$" + cost);
	}
		
}
