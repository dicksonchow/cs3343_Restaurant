package restaurant;

public class CmdEditFood implements ActionCmd{

	Food f;
	
	public String execute(String[] cmdParts) throws NumberFormatException {
		try {
			if(cmdParts.length==4 && !cmdParts[2].trim().equals("") && Integer.parseInt(cmdParts[3])>=0) {		
				Restaurant r = Restaurant.getInstance();
				Food food = r.findFood(cmdParts[1]); 
				if(food==null){ 
					return "Invalid food ID!";
				}
				else {
					r.removeFood(food);
					f=new Food (cmdParts[1], cmdParts[2], cmdParts[3]);
					return "Food is edited.";
				}
			}
			else {
				return "Invalid input!";
			}
		}
		catch(NumberFormatException e) {
			return "Invalid food price!";
		}
	}
}
