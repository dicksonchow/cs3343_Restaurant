package restaurant;

public class CmdListIng {

	public String execute() {
		Restaurant restaurant = Restaurant.getInstance();
		return restaurant.listIngredient();
    }
	
}
