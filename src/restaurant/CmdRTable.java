package restaurant;

public class CmdRTable {
	
	ReservedTable t;
	
	public String execute(String[] cmdParts) {
			Restaurant r = Restaurant.getInstance();
			ReservedTable rTable = r.findRTable(cmdParts[1]);
			if(rTable==null){
				t=new ReservedTable (cmdParts[1]);    
				r.addRTable(t);
				return "Table is reserved.";
			}
			else{
				t=null;
				return "Table is unavailable.";
			}	

	}

	
}
