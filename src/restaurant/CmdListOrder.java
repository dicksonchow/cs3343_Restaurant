package restaurant;

public class CmdListOrder{

	public String execute() {
		Restaurant restaurant = Restaurant.getInstance();
		return restaurant.listOrder();
    }
}
