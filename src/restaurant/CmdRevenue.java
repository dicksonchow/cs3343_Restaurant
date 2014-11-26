package restaurant;

public class CmdRevenue {
	
	public String execute() {
		return Revenue.getInstance().toString();
    }
	
}
