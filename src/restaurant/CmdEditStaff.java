package restaurant;

public class CmdEditStaff {

	Staff s;
	
	public String execute(String[] cmdParts) throws NumberFormatException {
		try {
			if(!cmdParts[2].trim().equals("") && Integer.parseInt(cmdParts[4])>=0 && !cmdParts[5].trim().equals("")) {
				Restaurant r = Restaurant.getInstance();
				Staff staff = r.findStaff(cmdParts[1]); 
				if(staff==null){ 
					return "Invalid staff ID!";
				}		
				else{				
					if(!cmdParts[3].equals("Manager") && !cmdParts[3].equals("Staff")){
						return "Invalid position!";
					}
					else {			
						r.removeStaff(staff);
						s=new Staff (cmdParts[1], cmdParts[2], cmdParts[3], cmdParts[4], cmdParts[5]);
						r.addStaff(s);
						return "Staff is edited.";
					}
				}		
			}
			else {
				return "Invalid input!";
			}
		}
		catch(NumberFormatException e) {
			return "Invalid salary!";
		}	
	}
	
}
