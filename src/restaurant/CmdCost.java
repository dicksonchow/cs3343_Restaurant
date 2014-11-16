package restaurant;

public class CmdCost {

	public void execute() {
		Restaurant restaurant = Restaurant.getInstance();
		restaurant.printCost();
    }
		
}
