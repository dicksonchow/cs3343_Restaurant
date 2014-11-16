package restaurant;

public class CmdAddIng {

	Ingredient i;
	
	public void execute(String[] cmdParts) throws NumberFormatException {
		try {
			if(cmdParts.length==5 && Integer.parseInt(cmdParts[3])>=0 && Integer.parseInt(cmdParts[4])>=0) {
				Restaurant r = Restaurant.getInstance();
				Ingredient ingredient = r.findIngredient(cmdParts[1]);
				if(ingredient==null){
					i=new Ingredient (cmdParts[1],cmdParts[2],cmdParts[3],cmdParts[4]);    
					System.out.println("Ingredient is added.");
				}
				else{
					i=null;
					System.out.println("Ingredient ID has been used.");
				}	
			}
			else {
				System.out.println("Invalid input!");
			}
		}
		catch(NumberFormatException e) {
			System.out.println("Invalid input!");
		}
	}

	
}
