package restaurant;

public class CmdEditOrder implements ActionCmd, FoodIdValidate{

	Order o;
	
	public boolean foodIDIdentification(String[] foodId) {
		for(int i=0; i < foodId.length ; i++) 
		{	
			if(Restaurant.getInstance().findFood(foodId[i]) == null) {
				return false;
			}
		}		
		return true;
	}
	
	public void execute(String[] cmdParts) {
		if(cmdParts.length>=3) {

			String tableId;
			String[] foodId = new String[cmdParts.length-2];

			tableId = cmdParts[1];
			for(int i = 2; i < cmdParts.length; i++) foodId[i - 2] = cmdParts[i];
			
			if(foodIDIdentification(foodId)) {
				Restaurant r = Restaurant.getInstance();
				Order order = r.findOrder(cmdParts[1]);
				
				if(order==null){ 
					System.out.println("Invalid table ID!");
				}
				else{
					r.removeOrder(order);
					o = new Order (tableId, foodId);
					Restaurant.getInstance().addOrder(o);
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