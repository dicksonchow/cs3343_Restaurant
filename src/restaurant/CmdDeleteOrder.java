package restaurant;

public class CmdDeleteOrder {

	public void execute(String[] cmdParts) {
		if(cmdParts.length==2) {
			Restaurant r = Restaurant.getInstance();
			Order order = r.findOrder(cmdParts[1]);
			if(order==null){ 
				System.out.println("Invalid table ID!");
			}
			else{
				r.removeOrder(order);
				System.out.println("Order is deleted.");
			}
		}
		else {
			System.out.println("Invalid input!");
		}
		
	}
	
}
