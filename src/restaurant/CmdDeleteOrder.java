package restaurant;

public class CmdDeleteOrder {

	public void execute(String[] cmdParts) {
		if(cmdParts.length==2) {
			Restaurant r = Restaurant.getInstance();
			Order order = r.findOrder(cmdParts[1]);
			if(order==null){ 
				System.out.print("Invalid table ID!");
			}
			else{
				r.removeOrder(order);
				System.out.print("Order is deleted.");
			}
		}
		else {
			System.out.print("Invalid input!");
		}
		
	}
	
}
