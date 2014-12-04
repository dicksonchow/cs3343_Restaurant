package restaurant;

public class CmdListIngredient {

	public String execute() {
		Restaurant restaurant = Restaurant.getInstance();
		return restaurant.listIngredient();
    }
	
}
