package restaurant;

public class CmdListOrder{

	public void execute() {
		Restaurant restaurant = Restaurant.getInstance();
		restaurant.listOrder();
    }
}
