package restaurant;

public class ExecuteCmd {
		
	public static void executeCmd(String[] cmdParts, String inputStaffId) {
		InputFormat.inputFormat(cmdParts);
		
	    if (cmdParts[0].equals("options")) {
	    	inputStaffId = Login.getInputStaffId();
	    	CmdOptions.options(inputStaffId);
	    }
	        
		
        if (cmdParts[0].equals("addFood"))
        	(new CmdAddFood()).execute(cmdParts);
        if (cmdParts[0].equals("deleteFood"))
            (new CmdDeleteFood()).execute(cmdParts); 
        if (cmdParts[0].equals("editFood"))
            (new CmdEditFood()).execute(cmdParts); 
        if (cmdParts[0].equals("listMenu"))
            (new CmdListMenu()).execute(); 
        
        
        if (cmdParts[0].equals("addStaff")) {
        	if(UserIdentification.userIdentification(inputStaffId) == true) {        	
        		(new CmdAddStaff()).execute(cmdParts);
        	}
        	else {
        		System.out.println("Invalid access." + "\nThis function is only available for manager.");
        	}
        }
        
       
        if (cmdParts[0].equals("deleteStaff")) {
        	if(UserIdentification.userIdentification(inputStaffId) == true) {        	
        		(new CmdDeleteStaff()).execute(cmdParts);
        	}
        	else {
        		System.out.println("Invalid access." + "\nThis function is only available for manager.");
        	}
        }
        
        
        if (cmdParts[0].equals("editStaff")) {
        	if(UserIdentification.userIdentification(inputStaffId) == true) {        	
        		(new CmdEditStaff()).execute(cmdParts);
        	}
        	else {
        		System.out.println("Invalid access." + "\nThis function is only available for manager.");
        	}
        }
        
        
        if (cmdParts[0].equals("listStaff")) {
        	if(UserIdentification.userIdentification(inputStaffId) == true) {        	
        		(new CmdListStaff()).execute();
            }
            else {
            	System.out.println("Invalid access." + "\nThis function is only available for manager.");
            }
        }
        
        
        if (cmdParts[0].equals("addOrder"))
            (new CmdAddOrder()).execute(cmdParts);              
        if (cmdParts[0].equals("listOrder"))
            (new CmdListOrder()).execute();            
        if (cmdParts[0].equals("editOrder"))       	
        	(new CmdEditOrder()).execute(cmdParts);               
        if (cmdParts[0].equals("deleteOrder"))
            (new CmdDeleteOrder()).execute(cmdParts);       
        
        if (cmdParts[0].equals("rTable"))
            (new CmdRTable()).execute(cmdParts);                
        if (cmdParts[0].equals("listRTable"))
            (new CmdListRTable()).execute();                
        if (cmdParts[0].equals("editRTable"))
            (new CmdEditRTable()).execute(cmdParts);               
        if (cmdParts[0].equals("deleteRTable"))
            (new CmdDeleteRTable()).execute(cmdParts);             
        
        if (cmdParts[0].equals("addIng"))
            (new CmdAddIngredient()).execute(cmdParts);
        if (cmdParts[0].equals("listIng"))
            (new CmdListIng()).execute();
        if (cmdParts[0].equals("editIng"))
            (new CmdEditIngIngredient()).execute(cmdParts);
        if (cmdParts[0].equals("deleteIng"))
            (new CmdDeleteIngredient()).execute(cmdParts);
           
            
        if (cmdParts[0].equals("revenue")) {
        	if(UserIdentification.userIdentification(inputStaffId) == true) {        	
        		(new CmdRevenue()).execute(); 
            }
            else {
            	System.out.println("Invalid access." + "\nThis function is only available for manager.");
            }
        }
        	
        if (cmdParts[0].equals("cost")) {
        	if(UserIdentification.userIdentification(inputStaffId) == true) {        	
        		(new CmdCost()).execute(); 
            }
            else {
            	System.out.println("Invalid access." + "\nThis function is only available for manager.");
            }
        }	
        	
        if (cmdParts[0].equals("profit")) {
        	if(UserIdentification.userIdentification(inputStaffId) == true) {        	
        		(new CmdProfit()).execute(); 
            }
            else {
            	System.out.println("Invalid access." + "\nThis function is only available for manager.");
            }
        }		
            
        
	}	
	
}
