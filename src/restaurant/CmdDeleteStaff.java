package restaurant;

public class CmdDeleteStaff {

	public void execute(String[] cmdParts) {
		if(cmdParts.length==2) {
			Restaurant r = Restaurant.getInstance();
			Staff staff = r.findStaff(cmdParts[1]);
			if(staff==null){ 
				System.out.print("Invalid staff ID!\n");
			}
			else{
				r.removeStaff(staff);
				System.out.print("Staff is deleted.\n");
			}
		}
		else {
			System.out.print("Invalid input!\n");
		}
    }
	
}
