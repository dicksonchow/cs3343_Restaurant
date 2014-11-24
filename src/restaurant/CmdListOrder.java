package restaurant;

public class CmdListOrder{

	public String execute(String[] cmdParts) {
		Restaurant restaurant = Restaurant.getInstance();
		return restaurant.listOrder();
    }
}
