package restaurant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	private static Scanner inFile;
	
	public static void main(String[] args) throws FileNotFoundException {	
        String filepathname = args[0];              
        inFile = new Scanner(new File(filepathname));
        FileCmd.fileCmd(inFile);           
        inFile.close();        
         
    }

}
