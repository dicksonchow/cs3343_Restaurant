package restaurant;

public class CmdDeleteStaff {

	public void execute(String[] cmdParts) {
		if(cmdParts.length==2) {
			Restaurant r = Restaurant.getInstance();
			Staff staff = r.findStaff(cmdParts[1]);
			if(staff==null){ 
				System.out.println("Invalid staff ID!");
			}
			else{
				r.removeStaff(staff);
				System.out.println("Staff is deleted.");
			}
		}
		else {
			System.out.println("Invalid input!");
		}
    }
	
}
