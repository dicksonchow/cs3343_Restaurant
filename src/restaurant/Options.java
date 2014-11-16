package restaurant;

public class Options {

	public static void options(String inputStaffId) {
		inputStaffId = Login.getInputStaffId();
		Identification.identification(inputStaffId);
		Identification.getStaff().printOptions(); 
	}
	
}
