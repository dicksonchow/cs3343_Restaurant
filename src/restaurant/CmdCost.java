package restaurant;

public class CmdCost implements ListingAndCalCmd{

	public String execute() {
		return Cost.getInstance().toString();
    }
		
}
