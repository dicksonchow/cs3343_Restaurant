package restaurant;

public class CmdListRTable {

	public String execute() {
		Restaurant restaurant = Restaurant.getInstance();
		return restaurant.listRTable();
    }
	
}
