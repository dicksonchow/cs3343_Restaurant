package restaurant;

public class CmdListIng {

	public void execute() {
		Restaurant restaurant = Restaurant.getInstance();
		restaurant.listIngredient();
    }
	
}
