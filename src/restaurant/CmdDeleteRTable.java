package restaurant;

public class CmdDeleteRTable {

	public String execute(String[] cmdParts) {
		Restaurant r = Restaurant.getInstance();
		ReservedTable rTable = r.findRTable(cmdParts[1]);
		if(rTable==null){ 
			return "Invalid Table ID!";
		}
		else{
			r.removeRTable(rTable);
			return "Table reservation is cancelled.";
		}    	

    }

}
