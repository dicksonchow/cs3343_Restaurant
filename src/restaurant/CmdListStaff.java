package restaurant;

public class CmdListStaff{

	public void execute() {
		Restaurant restaurant = Restaurant.getInstance();
		restaurant.listStaff();
    }
}
