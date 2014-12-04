package restaurant;

public class UserIdentification {

	private static Staff staff;
	private static Restaurant restaurant = Restaurant.getInstance();
	
	/*This method is to check whether the user is a manager or a normal staff
	 * after the user successfully logins.
	*/
	public static boolean userIdentification(String inputStaffId) {
		staff = restaurant.findStaff(inputStaffId);	
		if(staff instanceof Manager) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
