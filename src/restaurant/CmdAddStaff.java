package restaurant;

public class CmdAddStaff {

	Staff s;
	
	public void execute(String[] cmdParts) throws NumberFormatException {
		try {
			if(cmdParts.length==6 && Integer.parseInt(cmdParts[4])>=0) {
				Restaurant r = Restaurant.getInstance();
				Staff staff = r.findStaff(cmdParts[1]);
				if(staff==null){
					if(cmdParts[3].equals("Manager")) {
						s=new Manager (cmdParts[1],cmdParts[2],cmdParts[3], cmdParts[4], cmdParts[5]);
						System.out.println("Staff is added.");
					}
					else if(cmdParts[3].equals("Staff")) {
						s=new Staff (cmdParts[1],cmdParts[2],cmdParts[3], cmdParts[4], cmdParts[5]);
						System.out.println("Staff is added.");
					}
					else {
						System.out.println("Invalid position!");
					}
				}
				else{
					s=null;
					System.out.println("Staff ID has been used.");
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
