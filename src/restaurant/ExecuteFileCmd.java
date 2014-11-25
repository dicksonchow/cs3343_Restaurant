package restaurant;

public class ExecuteFileCmd {
	
//	private static String inputStaffId;
	
	public static void executeFileCmd(String[] cmdParts) {
		InputFormat.inputFormat(cmdParts);
		
//        if (cmdParts[0].equals("options")) {
//        	inputStaffId = Login.getInputStaffId();
//        	CmdOptions.options(inputStaffId);
//        }
        
        if (cmdParts[0].equals("addFood"))
        	(new CmdAddFood()).execute(cmdParts);
        if (cmdParts[0].equals("deleteFood"))
            (new CmdDeleteFood()).execute(cmdParts); 
        if (cmdParts[0].equals("editFood"))
            (new CmdEditFood()).execute(cmdParts); 
        if (cmdParts[0].equals("listFood"))
            (new CmdListFood()).execute(); 
        
        if (cmdParts[0].equals("addStaff"))  
            (new CmdAddStaff()).execute(cmdParts);
        if (cmdParts[0].equals("deleteStaff"))
            (new CmdDeleteStaff()).execute(cmdParts);
        if (cmdParts[0].equals("editStaff"))
            (new CmdEditStaff()).execute(cmdParts);
        if (cmdParts[0].equals("listStaff"))
            (new CmdListStaff()).execute();
        
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
        
        if (cmdParts[0].equals("revenue"))
            (new CmdRevenue()).execute(); 
        if (cmdParts[0].equals("cost"))
            (new CmdCost()).execute(); 
        if (cmdParts[0].equals("profit"))
            (new CmdProfit()).execute(); 
        
	}
	
	
}
