package restaurant;

public class CmdAddOrder implements ActionCmd, FoodIdValidate{

	Order o;
	String tableId;
	String[] foodId = null;
	
	public boolean foodIDIdentification(String[] foodId) {
		System.out.println(foodId.length);
		/*for(int i=0; i < (foodId.length - 1) ; i++) 
		{	
			if(Restaurant.getInstance().findFood(foodId[i]) == null) {
				return false;
			}
		}*/		
		return true;
	}
	
	public void execute(String[] cmdParts) {
		if(cmdParts.length>=3) {
			
			tableId = cmdParts[1];
			System.out.println(cmdParts.length);
			System.out.println(cmdParts[cmdParts.length-1]);
			for(int i = 2; i < (cmdParts.length - 1); i++) {
				foodId[i - 2] = cmdParts[i];
			}
			if(foodIDIdentification(foodId)==true) {				
				Restaurant r = Restaurant.getInstance();
				Order order = r.findOrder(cmdParts[1]);
				
				if(order==null){
					o = new Order (tableId, foodId);    
					Restaurant.getInstance().addOrder(o);
					System.out.print("Order is added.\n");
				}   	
				else{
					o = null;
					System.out.print("Order ID has been used.\n");
				}
			}
			else {
				System.out.print("Invalid food ID!\n");
			}			
		}
		else {
			System.out.print("Invalid input!\n");
		}

	}

}
