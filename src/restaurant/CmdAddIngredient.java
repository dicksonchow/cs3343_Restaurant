package restaurant;

public class CmdAddIngredient implements ActionCmd{

	Ingredient i;
	
	public String execute(String[] cmdParts) throws NumberFormatException {
		try {
			if(cmdParts.length==5 && !cmdParts[2].trim().equals("") && Integer.parseInt(cmdParts[3])>=0 && Integer.parseInt(cmdParts[4])>=0) {
				Restaurant r = Restaurant.getInstance();
				Ingredient ingredient = r.findIngredient(cmdParts[1]);
				if(ingredient==null){
					i=new Ingredient (cmdParts[1],cmdParts[2],cmdParts[3],cmdParts[4]); 
					Restaurant.getInstance().addIngredient(i);
					return "Ingredient is added.";
				}
				else{
					i=null;
					return "Ingredient ID has been used.";
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
