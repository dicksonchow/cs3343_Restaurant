package restaurant;

public class CmdListStaff{

	public String execute() {
		Restaurant restaurant = Restaurant.getInstance();
		return restaurant.listStaff();
    }
}
