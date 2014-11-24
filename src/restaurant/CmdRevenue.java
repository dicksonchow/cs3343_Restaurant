package restaurant;

public class CmdRevenue {
	
	public void execute() {
		/*Restaurant restaurant = Restaurant.getInstance();
		restaurant.printRevenue();*/
		System.out.print(Revenue.getInstance().toString());
    }
	
}
