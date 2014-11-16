package restaurant;

public class CmdRevenue {
	
	public void execute() {
		Restaurant restaurant = Restaurant.getInstance();
		restaurant.printRevenue();
    }
	
}
