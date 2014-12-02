package restaurant;

public class CmdDeleteStaff implements ActionCmd{

	public String execute(String[] cmdParts) {
		Restaurant r = Restaurant.getInstance();
		Staff staff = r.findStaff(cmdParts[1]);
		if(staff==null){ 
			return "Invalid staff ID!";
		}
		else{
			r.removeStaff(staff);
			return "Staff is deleted.";
		}

    }
	
}
