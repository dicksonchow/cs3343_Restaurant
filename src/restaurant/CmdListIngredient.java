package restaurant;

public class CmdListIngredient implements ListingAndCalCmd{

	public String execute() {
		Restaurant restaurant = Restaurant.getInstance();
		return restaurant.listIngredient();
    }
	
}
