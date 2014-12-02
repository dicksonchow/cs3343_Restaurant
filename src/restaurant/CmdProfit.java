package restaurant;

public class CmdProfit implements ListingAndCalCmd{

	public String execute() {
		return Profit.getInstance().toString();
    }
	
}
