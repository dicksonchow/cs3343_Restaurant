package restaurant;

public class CmdAddIngredient implements ActionCmd{

	Ingredient i;
	
	public void execute(String[] cmdParts) throws NumberFormatException {
		try {
			if(cmdParts.length==5 && Integer.parseInt(cmdParts[3])>=0 && Integer.parseInt(cmdParts[4])>=0) {
				Restaurant r = Restaurant.getInstance();
				Ingredient ingredient = r.findIngredient(cmdParts[1]);
				if(ingredient==null){
					i=new Ingredient (cmdParts[1],cmdParts[2],cmdParts[3],cmdParts[4]); 
					Restaurant.getInstance().addIngredient(i);
					System.out.print("Ingredient is added.\n");
				}
				else{
					i=null;
					System.out.print("Ingredient ID has been used.\n");
				}	
			}
			else {
				System.out.print("Invalid input!\n");
			}
		}
		catch(NumberFormatException e) {
			System.out.print("Invalid input!\n");
		}
	}

	
}
