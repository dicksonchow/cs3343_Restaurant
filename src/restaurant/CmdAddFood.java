package restaurant;

public class CmdAddFood implements ActionCmd{

	Food f;
	
	public void execute(String[] cmdParts) throws NumberFormatException {
		try {
			if(cmdParts.length==4 && Integer.parseInt(cmdParts[3])>=0) {
				Restaurant r = Restaurant.getInstance();
				Food food = r.findFood(cmdParts[1]);
				if(food==null){
					f=new Food (cmdParts[1],cmdParts[2],cmdParts[3]);    
					System.out.println("Food is added.");
				}
				else{
					f=null;
					System.out.println("Food ID has been used.");
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
