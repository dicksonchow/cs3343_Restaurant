package restaurant;

public class CmdDeleteIngredient {

	public void execute(String[] cmdParts) {
		if(cmdParts.length==2) {
			Restaurant r = Restaurant.getInstance();
			Ingredient ingredient = r.findIngredient(cmdParts[1]);
			if(ingredient==null){ 
				System.out.print("Invalid ingredient ID!");
			}
			else{
				r.removeIngredient(ingredient);
				System.out.print("Ingredient is deleted.");
			}
		}
		else {
			System.out.print("Invalid input!");
		}

	}
	
	
}
