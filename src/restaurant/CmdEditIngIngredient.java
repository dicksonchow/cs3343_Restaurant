package restaurant;

public class CmdEditIngIngredient {

	Ingredient i;
	
	public String execute(String[] cmdParts) throws NumberFormatException {
		try {
			if(cmdParts.length==5 && Integer.parseInt(cmdParts[3])>=0 && Integer.parseInt(cmdParts[4])>=0) {		
				Restaurant r = Restaurant.getInstance();
				Ingredient ingredient = r.findIngredient(cmdParts[1]); 
				if(ingredient==null){ 
					return "Invalid ingredient ID!";
				}
				else {
					r.removeIngredient(ingredient);
					i=new Ingredient(cmdParts[1], cmdParts[2], cmdParts[3], cmdParts[4]);
					Restaurant.getInstance().addIngredient(i);
					return "Ingredient is edited.";
				}
			}
			else {
				return "Invalid input!";
			}
		}
		catch(NumberFormatException e) {
			return "Invalid input!";
		}
	}
	
}
