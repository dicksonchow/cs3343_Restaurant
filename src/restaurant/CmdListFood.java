package restaurant;

public class CmdListFood{

	public String execute() implements ListingAndCalCmd{
		Restaurant restaurant = Restaurant.getInstance();
		return restaurant.listFood();
    }
}
