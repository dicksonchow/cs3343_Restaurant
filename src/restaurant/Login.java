package restaurant;

import java.util.Scanner;


public class Login {

	private static String[] cmdParts;
	private static String inputStaffId;
	
	public static void login(){
        Scanner in = new Scanner(System.in);
    	System.out.print("\n-------------- User Login --------------" + "\nStaff ID: ");
    	inputStaffId = in.nextLine();
    	System.out.print("Password: ");
    	String inputStaffPw = in.nextLine();
    	//v = new Authentication(inputStaffId, inputStaffPw);
    
    	if(Authentication.getInstance().validation(inputStaffId, inputStaffPw) == true) {   		
    		CmdOptions.options(inputStaffId);
    		System.out.print("\n> ");    		
    		do {
    			String cmdLine = in.nextLine();         
    			cmdParts = cmdLine.split(" ");
    			ExecuteCmd.executeCmd(cmdParts, inputStaffId); 
    			System.out.print("\n> "); 
    		} while(in.hasNext());        
    	}
    	else {
    		System.out.println("Please retry."); 
    		login();
    	}
 
        in.close();   
	}
	
	public static String getInputStaffId() {
		return inputStaffId;
	}
}
