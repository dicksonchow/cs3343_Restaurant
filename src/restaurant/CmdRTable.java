package restaurant;

public class CmdRTable {
	
	ReservedTable t;
	
	public String execute(String[] cmdParts) {
		if(cmdParts.length==2) {
			Restaurant r = Restaurant.getInstance();
			ReservedTable rTable = r.findRTable(cmdParts[1]);
			if(rTable==null){
				t=new ReservedTable (cmdParts[1]);    
				return "Table is reserved.";
			}
			else{
				t=null;
				return "Table has been reserved.";
			}	
		}
		else {
			return "Invalid input!";
		}
	}

	
}
