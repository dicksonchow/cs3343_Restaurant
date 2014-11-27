package restaurant;

public class CmdEditRTable {

	ReservedTable t;
	
	public String execute(String[] cmdParts) {
		Restaurant r = Restaurant.getInstance();
		ReservedTable rTable = r.findRTable(cmdParts[1]); 
		if(rTable==null){ 
			return "Invalid Table ID!";
		}
		else{
			ReservedTable newRTable = r.findRTable(cmdParts[2]); 
			if(newRTable==null){ 
				r.removeRTable(rTable);
				t=new ReservedTable (cmdParts[2]);
				return "Table reservation is edited.";
			}
			else {
				return cmdParts[2] + " is unavailable.";
			}
		}		

	}
	
	
}
