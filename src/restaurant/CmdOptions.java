package restaurant;

public class CmdOptions {

	public static void options(String inputStaffId) {
		inputStaffId = Login.getInputStaffId();
		UserIdentification.userIdentification(inputStaffId);
		UserIdentification.getStaff().printOptions(); 
	}
	
}
