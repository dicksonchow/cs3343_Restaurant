package restaurant;

public class CmdAddFood {

	Food f;
	
	public void execute(String[] cmdParts) throws NumberFormatException {
		try {
			if(cmdParts.length==4 && Integer.parseInt(cmdParts[3])>=0) {
				Restaurant r = Restaurant.getInstance();
				Food food = r.findFood(cmdParts[1]);
				if(food==null){
					f=new Food (cmdParts[1],cmdParts[2],cmdParts[3]);    
					System.out.print("Food is added.\n");
				}
				else{
					f=null;
					System.out.print("Food ID has been used.\n");
				}	
			}
			else {
				System.out.print("Invalid input!\n");
			}
		}
		catch(NumberFormatException e) {
			System.out.print("Invalid food price!\n");
		}
	}

}
