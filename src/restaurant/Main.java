package restaurant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	private static Scanner inFile;
	
	public static void main(String [] args) throws FileNotFoundException, NullPointerException {	
        Scanner in = new Scanner(System.in);      
        System.out.print("Please input the file pathname: ");
        String filepathname = in.nextLine();
        
        try {        
        	inFile = new Scanner(new File(filepathname));
        }
        catch(FileNotFoundException e) {
        	System.out.println("File cannot be found!");
        }
        
        try {
        	FileCmd.fileCmd(inFile);           
        	Login.login();
        	
            inFile.close();        
            in.close();  
        }
        catch(NullPointerException e) {
        	System.out.println("Please retry.\n");
        	main(args);
        }
          
    }

}
