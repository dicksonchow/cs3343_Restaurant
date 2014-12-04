package restaurant;

public class CmdAddFood implements ActionCmd{

	Food f;
	
	public String execute(String[] cmdParts) throws NumberFormatException {
		try {
			if(!cmdParts[2].trim().equals("") && Integer.parseInt(cmdParts[3])>=0) {
				Restaurant r = Restaurant.getInstance();
				Food food = r.findFood(cmdParts[1]);
				if(food==null){
					f=new Food (cmdParts[1],cmdParts[2],cmdParts[3]);    
					return "Food is added.";
				}
				else{
					f=null;
					return "Food ID has been used.";
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
