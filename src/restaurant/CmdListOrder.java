package restaurant;

public class CmdListOrder implements ListingAndCalCmd{

	public String execute() {
		Restaurant restaurant = Restaurant.getInstance();
		return restaurant.listOrder();
    }
}
