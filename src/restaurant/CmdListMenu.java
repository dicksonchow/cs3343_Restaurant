package restaurant;

public class CmdListMenu{

	public void execute() {
		Restaurant restaurant = Restaurant.getInstance();
		restaurant.listFood();
    }
}
