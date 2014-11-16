package restaurant;

public class Authentication {

	private String inputStaffId;
	private String inputStaffPw;
	private Restaurant restaurant = Restaurant.getInstance();
	private Staff staff;
	
	public Authentication(String inputStaffId, String inputStaffPw) {
		this.inputStaffId=inputStaffId;
		this.inputStaffPw=inputStaffPw;
	}
	
	public boolean validation() {
			if(restaurant.findStaff(inputStaffId) != null) {
				staff = restaurant.findStaff(inputStaffId);		
				if(staff.getStaffPassword().equals(inputStaffPw)) {
					System.out.println("\nLogin successfully!" + "\nWelcome, " + staff.getStaffName() + ".");
					return true;
				}
				else {
					System.out.println("\nInvalid password!");
					return false;
				}
			}
			else {
				System.out.println("\nInvalid staff ID!");
				return false;
			}
	}
	
	public String getInputStaffId() {
		return inputStaffId;
	}
	
}
