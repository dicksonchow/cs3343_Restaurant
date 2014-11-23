package restaurant;

public class CmdAddStaff  implements ActionCmd{

	Staff s;
	
	public void execute(String[] cmdParts) throws NumberFormatException {
		try {
			if(cmdParts.length==6 && Integer.parseInt(cmdParts[4])>=0) {
				Restaurant r = Restaurant.getInstance();
				Staff staff = r.findStaff(cmdParts[1]);
				if(staff==null){
					//if(!cmdParts[3].equals("Manager")||!cmdParts[3].equals("Staff"))
					//		throw new PositionMissMatchException();
					if(cmdParts[3].equals("Manager")) {
						s=new Manager (cmdParts[1],cmdParts[2],cmdParts[3], cmdParts[4], cmdParts[5]);
						System.out.print("Staff is added.\n");
					}
					else if(cmdParts[3].equals("Staff")) {
						s=new Staff (cmdParts[1],cmdParts[2],cmdParts[3], cmdParts[4], cmdParts[5]);
						System.out.print("Staff is added.\n");
					}
					else {
						System.out.print("Invalid position!\n");
					}
				}
				else{
					s=null;
					System.out.print("Staff ID has been used.\n");
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
