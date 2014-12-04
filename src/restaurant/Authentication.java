package restaurant;

public class Authentication {

	private static Authentication instance = new Authentication();
	private Restaurant restaurant = Restaurant.getInstance();
	private Staff staff;
		
	public static Authentication getInstance() {
		return instance;
	}
	
	//This method is to validate user's staff ID and password.
	public String validation(String inputStaffId, String inputStaffPw) {
			if(restaurant.findStaff(inputStaffId) != null) {
				staff = restaurant.findStaff(inputStaffId);		
				if(staff.getStaffPassword().equals(inputStaffPw)) {
					return "Login successfully!";
				}
				else {
					return "Invalid password!";
				}
			}
			else {
				return "Invalid staff ID!";
			}
	}
	
}
