package restaurant;

public class FoodIDIdentification {

	private static boolean result;
	
	public static boolean foodIDIdentification(String[] cmdParts) {
		Restaurant r = Restaurant.getInstance();
		for(int i=2; i<cmdParts.length; i++) {	
			if(r.findFood(cmdParts[i]) == null) {
				result = false;
				break;
			}
			else {
				result = true;
			}
		}		
		return result;
		
	}
	
	
}
