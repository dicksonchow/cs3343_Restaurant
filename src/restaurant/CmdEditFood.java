package restaurant;

public class CmdEditFood {

	Food f;
	
	public void execute(String[] cmdParts) throws NumberFormatException {
		try {
			if(cmdParts.length==4 && Integer.parseInt(cmdParts[3])>=0) {		
				Restaurant r = Restaurant.getInstance();
				Food food = r.findFood(cmdParts[1]); 
				if(food==null){ 
					System.out.println("Invalid food ID!");
				}
				else {
					r.removeFood(food);
					f=new Food (cmdParts[1], cmdParts[2], cmdParts[3]);
					System.out.println("Food is edited.");
				}
			}
			else {
				System.out.println("Invalid input!");
			}
		}
		catch(NumberFormatException e) {
			System.out.println("Invalid food price!");
		}
	}
}
