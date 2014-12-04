package restaurant;

public class CmdListRTable implements ListingAndCalCmd{

	public String execute() {
		Restaurant restaurant = Restaurant.getInstance();
		return restaurant.listRTable();
    }
	
}
