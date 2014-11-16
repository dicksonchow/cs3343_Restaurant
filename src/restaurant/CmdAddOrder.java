package restaurant;

public class CmdAddOrder {

	Order o;
	
	public void execute(String[] cmdParts) {
		if(cmdParts.length>=3) {
			if(FoodIDIdentification.foodIDIdentification(cmdParts)==true) {				
				Restaurant r = Restaurant.getInstance();
				Order order = r.findOrder(cmdParts[1]);
				if(order==null){
					o=new Order (cmdParts);    
					System.out.println("Order is added.");
				}   	
				else{
					o=null;
					System.out.println("Order ID has been used.");
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
