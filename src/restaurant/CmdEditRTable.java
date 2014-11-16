package restaurant;

public class CmdEditRTable {

	ReservedTable t;
	
	public void execute(String[] cmdParts) {
		if(cmdParts.length==3) {
			Restaurant r = Restaurant.getInstance();
			ReservedTable rTable = r.findRTable(cmdParts[1]); 
			if(rTable==null){ 
				System.out.println("Invalid Table ID!");
			}
			else{
				ReservedTable newRTable = r.findRTable(cmdParts[2]); 
				if(newRTable==null){ 
					r.removeRTable(rTable);
					t=new ReservedTable (cmdParts[2]);
					System.out.println("Table is edited.");
				}
				else {
					System.out.println(cmdParts[2] + " is unavailable.");
				}
			}		
		}
		else {
			System.out.println("Invalid input!");
		}
	}
	
	
}
