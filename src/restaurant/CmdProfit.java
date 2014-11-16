package restaurant;

public class CmdProfit {

	public void execute() {
		Restaurant restaurant = Restaurant.getInstance();
		restaurant.printProfit();
    }
	
}
