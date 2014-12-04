package restaurant;

public class CmdListFood{

	public String execute() {
		Restaurant restaurant = Restaurant.getInstance();
		return restaurant.listFood();
    }
}
