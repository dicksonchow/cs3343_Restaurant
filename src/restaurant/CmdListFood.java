package restaurant;

public class CmdListFood implements ListingAndCalCmd{

	public String execute() {
		Restaurant restaurant = Restaurant.getInstance();
		return restaurant.listFood();
    }
}
