package restaurant;

public class CmdRevenue implements ListingAndCalCmd{
	
	public String execute() {
		return Revenue.getInstance().toString();
    }
	
}
