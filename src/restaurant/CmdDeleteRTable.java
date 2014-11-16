package restaurant;

public class CmdDeleteRTable {

	public void execute(String[] cmdParts) {
		if(cmdParts.length==2) {
			Restaurant r = Restaurant.getInstance();
			ReservedTable rTable = r.findRTable(cmdParts[1]);
			if(rTable==null){ 
				System.out.println("Invalid Table ID!");
			}
			else{
				r.removeRTable(rTable);
				System.out.println("Table reservation is cancelled.");
			}    	
		}
		else {
			System.out.println("Invalid input!");
		}
    }
	
	
}
