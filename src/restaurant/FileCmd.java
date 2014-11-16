package restaurant;

import java.util.Scanner;

public class FileCmd {

	private static String[] cmdParts;
	
	public static void fileCmd(Scanner inFile) {
		while(inFile.hasNext()) {
			String cmdLine = inFile.nextLine();         
			if (cmdLine.trim().equals("")) continue;           
			System.out.println("\n> "+cmdLine);            
			cmdParts = cmdLine.split(" ");
			ExecuteFileCmd.executeFileCmd(cmdParts);
		}
		
	}
	
}
