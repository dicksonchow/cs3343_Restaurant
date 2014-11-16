package restaurant;

public class CmdListRTable {

	public void execute() {
		Restaurant restaurant = Restaurant.getInstance();
		restaurant.listRTable();
    }
	
}
