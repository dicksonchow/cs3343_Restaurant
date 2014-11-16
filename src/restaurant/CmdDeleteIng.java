package restaurant;

public class CmdDeleteIng {

	public void execute(String[] cmdParts) {
		if(cmdParts.length==2) {
			Restaurant r = Restaurant.getInstance();
			Ingredient ingredient = r.findIngredient(cmdParts[1]);
			if(ingredient==null){ 
				System.out.println("Invalid ingredient ID!");
			}
			else{
				r.removeIngredient(ingredient);
				System.out.println("Ingredient is deleted.");
			}
		}
		else {
			System.out.println("Invalid input!");
		}

	}
	
	
}
