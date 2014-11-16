package restaurant;

public class CmdDeleteFood {

	public void execute(String[] cmdParts) {
		if(cmdParts.length==2) {
			Restaurant r = Restaurant.getInstance();
			Food food = r.findFood(cmdParts[1]);
			if(food==null){ 
				System.out.println("Invalid food ID!");
			}
			else{
				r.removeFood(food);
				System.out.println("Food is deleted.");
			}
		}
		else {
			System.out.println("Invalid input!");
		}

	}
	
}
