package restaurant;

public class UserIdentification {

	private static Staff staff;
	private static Restaurant restaurant = Restaurant.getInstance();
	
	public static boolean userIdentification(String inputStaffId) {
		staff = restaurant.findStaff(inputStaffId);	
		if(staff instanceof Manager) {
			return true;
		}
		else {
			return false;
		}
	}
	
//	public static Staff getStaff() {
//		return staff;
//	}
}
