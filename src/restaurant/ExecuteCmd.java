package restaurant;

public class ExecuteCmd {
		
	public static String executeCmd(String[] cmdParts) {        		
        if (cmdParts[0].equals("addFood"))
        	return (new CmdAddFood()).execute(cmdParts);
        if (cmdParts[0].equals("deleteFood"))
            return (new CmdDeleteFood()).execute(cmdParts); 
        if (cmdParts[0].equals("editFood"))
            return (new CmdEditFood()).execute(cmdParts); 
        if (cmdParts[0].equals("listFood"))
            return (new CmdListFood()).execute(); 
        
        if (cmdParts[0].equals("addStaff"))
        	return (new CmdAddStaff()).execute(cmdParts);      
        if (cmdParts[0].equals("deleteStaff"))       	
        	return (new CmdDeleteStaff()).execute(cmdParts);      
        if (cmdParts[0].equals("editStaff"))        	
        	return (new CmdEditStaff()).execute(cmdParts);      
        if (cmdParts[0].equals("listStaff"))    	
        	return (new CmdListStaff()).execute();
       
        if (cmdParts[0].equals("addOrder"))
            return (new CmdAddOrder()).execute(cmdParts); 
        if (cmdParts[0].equals("listOrder"))
            return (new CmdListOrder()).execute();
        if (cmdParts[0].equals("editOrder"))    	
            return (new CmdEditOrder()).execute(cmdParts);
        if (cmdParts[0].equals("deleteOrder"))
            return (new CmdDeleteOrder()).execute(cmdParts); 
        
        if (cmdParts[0].equals("rTable"))
            return (new CmdRTable()).execute(cmdParts);                
        if (cmdParts[0].equals("listRTable"))
            return (new CmdListRTable()).execute();                
        if (cmdParts[0].equals("editRTable"))
            return (new CmdEditRTable()).execute(cmdParts);               
        if (cmdParts[0].equals("deleteRTable"))
            return (new CmdDeleteRTable()).execute(cmdParts);             
        
        if (cmdParts[0].equals("addIng"))
            return (new CmdAddIngredient()).execute(cmdParts);
        if (cmdParts[0].equals("listIng"))
            return (new CmdListIng()).execute();
        if (cmdParts[0].equals("editIng"))
            return (new CmdEditIngIngredient()).execute(cmdParts);
        if (cmdParts[0].equals("deleteIng"))
            return (new CmdDeleteIngredient()).execute(cmdParts);
           
            
        if (cmdParts[0].equals("revenue"))         	
        	return (new CmdRevenue()).execute();       	
        if (cmdParts[0].equals("cost"))        	
        	return (new CmdCost()).execute();       	
        if (cmdParts[0].equals("profit"))    	
        	return (new CmdProfit()).execute(); 
	
            
        return null;    
	}	
	
}
