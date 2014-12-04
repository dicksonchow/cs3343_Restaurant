package restaurant;

public class CmdDeleteIngredient implements ActionCmd{

	public String execute(String[] cmdParts) {
		Restaurant r = Restaurant.getInstance();
		Ingredient ingredient = r.findIngredient(cmdParts[1]);
		if(ingredient==null){ 
			return "Invalid ingredient ID!";
		}
		else{
			r.removeIngredient(ingredient);
			return "Ingredient is deleted.";
		}

	}
		
}
