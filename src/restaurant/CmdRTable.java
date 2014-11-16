package restaurant;

public class CmdRTable {
	
	ReservedTable t;
	
	public void execute(String[] cmdParts) {
		if(cmdParts.length==2) {
			Restaurant r = Restaurant.getInstance();
			ReservedTable rTable = r.findRTable(cmdParts[1]);
			if(rTable==null){
				t=new ReservedTable (cmdParts[1]);    
				System.out.println("Table is reserved.");
			}
			else{
				t=null;
				System.out.println("Table has been reserved.");
			}	
		}
		else {
			System.out.println("Invalid input!");
		}
	}

	
}
