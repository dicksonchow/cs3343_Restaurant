package restaurant;

public class CmdAddOrder implements ActionCmd, FoodIdValidation{

	Order o;
	
	public boolean foodIDIdentification(String[] foodId) {
		for(int i=0; i < foodId.length; i++)
		{	
			if(Restaurant.getInstance().findFood(foodId[i]) == null) {
				return false;
			}
		}
		return true;
	}
	
	public String execute(String[] cmdParts) {
		if(cmdParts.length>=3) {

			String tableId;
			String[] foodId = new String[cmdParts.length-2];

			tableId = cmdParts[1];
			for(int i = 2; i < cmdParts.length; i++) foodId[i - 2] = cmdParts[i];

			if(foodIDIdentification(foodId)==true) {				
				Restaurant r = Restaurant.getInstance();
				Order order = r.findOrder(cmdParts[1]);
				
				if(order==null){
					o = new Order (tableId, foodId);
					return "Order is added.";
				}   	
				else{
					o = null;
					return "Order ID has been used.";
				}
			}
			else {
				return "Invalid food ID!";
			}			
		}
		else {
			return "Invalid input!";
		}
		
	}

}
