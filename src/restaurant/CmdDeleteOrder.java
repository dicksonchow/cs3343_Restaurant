package restaurant;

public class CmdDeleteOrder {

	public String execute(String[] cmdParts) {
		Restaurant r = Restaurant.getInstance();
		Order order = r.findOrder(cmdParts[1]);
		if(order==null){ 
			return "Invalid table ID!";
		}
		else{
			r.removeOrder(order);
			return "Order is deleted.";
		}
	}
	
}
