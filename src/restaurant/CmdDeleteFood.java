package restaurant;

public class CmdDeleteFood {

	public String execute(String[] cmdParts) {
		Restaurant r = Restaurant.getInstance();
		Food food = r.findFood(cmdParts[1]);
		if(food==null){ 
			return "Invalid food ID!";
		}
		else{
			r.removeFood(food);
			return "Food is deleted.";
		}

	}
	
}
