package restaurant;

public class CmdEditOrder {

	Order o;
	
	public void execute(String[] cmdParts) {
		if(cmdParts.length>=3) {
			if(FoodIDIdentification.foodIDIdentification(cmdParts)==true) {
				Restaurant r = Restaurant.getInstance();
				Order order = r.findOrder(cmdParts[1]); 
				if(order==null){ 
					System.out.println("Invalid table ID!");
				}
				else{
					r.removeOrder(order);
					o=new Order (cmdParts);
					System.out.println("Order is edited.");
				}	
			}
			else {
				System.out.println("Invalid food ID!");
			}	
		}
		else {
			System.out.println("Invalid input!");
		}
	}

}