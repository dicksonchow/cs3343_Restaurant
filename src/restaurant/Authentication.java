package restaurant;

public class Authentication {

	//private String inputStaffId;
	//private String inputStaffPw;
	private static Authentication instance = new Authentication();
	private Restaurant restaurant = Restaurant.getInstance();
	private Staff staff;
	
	/*public Authentication(String inputStaffId, String inputStaffPw) {
		this.inputStaffId=inputStaffId;
		this.inputStaffPw=inputStaffPw;
	}*/
	
	public static Authentication getInstance() {
		return instance;
	}
	
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
