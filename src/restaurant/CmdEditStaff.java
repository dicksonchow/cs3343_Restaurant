package restaurant;

public class CmdEditStaff {

	Staff s;
	
	public void execute(String[] cmdParts) throws NumberFormatException {
		try {
			if(cmdParts.length==6 && Integer.parseInt(cmdParts[4])>=0) {
				Restaurant r = Restaurant.getInstance();
				Staff staff = r.findStaff(cmdParts[1]); 
				if(staff==null){ 
					System.out.println("Invalid staff ID!");
				}		
				else{				
					if(!cmdParts[3].equals("Manager") && !cmdParts[3].equals("Staff")){
						System.out.println("Invalid position!");
					}
					else {			
						r.removeStaff(staff);
						s=new Staff (cmdParts[1], cmdParts[2], cmdParts[3], cmdParts[4], cmdParts[5]);
						System.out.println("Staff is edited.");
					}
				}		
			}
			else {
				System.out.println("Invalid input!");
			}
		}
		catch(NumberFormatException e) {
			System.out.println("Invalid salary!");
		}	
	}
	
}
