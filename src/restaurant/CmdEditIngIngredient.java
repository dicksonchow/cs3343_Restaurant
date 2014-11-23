package restaurant;

public class CmdEditIngIngredient {

	Ingredient i;
	
	public void execute(String[] cmdParts) throws NumberFormatException {
		try {
			if(cmdParts.length==5 && Integer.parseInt(cmdParts[3])>=0 && Integer.parseInt(cmdParts[4])>=0) {		
				Restaurant r = Restaurant.getInstance();
				Ingredient ingredient = r.findIngredient(cmdParts[1]); 
				if(ingredient==null){ 
					System.out.print("Invalid ingredient ID!\n");
				}
				else {
					r.removeIngredient(ingredient);
					i=new Ingredient(cmdParts[1], cmdParts[2], cmdParts[3], cmdParts[4]);
					Restaurant.getInstance().addIngredient(i);
					System.out.print("Ingredient is edited.\n");
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
