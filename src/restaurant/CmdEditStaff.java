package restaurant;

public class CmdEditStaff {

	Staff s;
	
	public void execute(String[] cmdParts) throws NumberFormatException {
		try {
			if(cmdParts.length==6 && Integer.parseInt(cmdParts[4])>=0) {
				Restaurant r = Restaurant.getInstance();
				Staff staff = r.findStaff(cmdParts[1]); 
				if(staff==null){ 
					System.out.print("Invalid staff ID!\n");
				}		
				else{				
					if(!cmdParts[3].equals("Manager") && !cmdParts[3].equals("Staff")){
						System.out.print("Invalid position!\n");
					}
					else {			
						r.removeStaff(staff);
						s=new Staff (cmdParts[1], cmdParts[2], cmdParts[3], cmdParts[4], cmdParts[5]);
						System.out.print("Staff is edited.\n");
					}
				}		
			}
			else {
				System.out.print("Invalid input!\n");
			}
		}
		catch(NumberFormatException e) {
			System.out.print("Invalid salary!\n");
		}	
	}
	
}
