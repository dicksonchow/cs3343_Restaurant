package restaurant;

public class CmdListIng implements ListingAndCalCmd{

	public String execute() {
		Restaurant restaurant = Restaurant.getInstance();
		return restaurant.listIngredient();
    }
	
}
