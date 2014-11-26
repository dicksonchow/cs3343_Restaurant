package restaurant;

public class CmdDeleteStaff {

	public String execute(String[] cmdParts) {
		Restaurant r = Restaurant.getInstance();
		Staff staff = r.findStaff(cmdParts[1]);
		if(staff==null){ 
			return "Invalid staff ID!\n";
		}
		else{
			r.removeStaff(staff);
			return "Staff is deleted.\n";
		}

    }
	
}
