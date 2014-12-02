package restaurant;

public class CmdListStaff implements ListingAndCalCmd{

	public String execute() {
		Restaurant restaurant = Restaurant.getInstance();
		return restaurant.listStaff();
    }
}
