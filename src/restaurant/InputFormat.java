package restaurant;

public class InputFormat {

	public static void inputFormat(String[] cmdParts) {
        if (cmdParts[0].equals("a"))
        	System.out.print("Input format: listOrder");
        if (cmdParts[0].equals("b"))
        	System.out.print("Input format: addOrder Table_ID Food_ID Food_ID ...");
        if (cmdParts[0].equals("c"))
        	System.out.print("Input format: editOrder Table_ID New_Food_ID New_Food_ID ...");
        if (cmdParts[0].equals("d"))
        	System.out.print("Input format: deleteOrder Table_ID");
        
        if (cmdParts[0].equals("e"))
        	System.out.print("Input format: listMenu");
        if (cmdParts[0].equals("f"))
        	System.out.print("Input format: addFood Food_ID Food_Name Food_Price");
        if (cmdParts[0].equals("g"))
        	System.out.print("Input format: editFood Food_ID New_Food_Name New_Food_Price");
        if (cmdParts[0].equals("h"))
        	System.out.print("Input format: deleteFood Food_ID");    
               
        if (cmdParts[0].equals("i"))
        	System.out.print("Input format: listIng");
        if (cmdParts[0].equals("j"))
        	System.out.print("Input format: addIng Ingredient_ID Ingredient_Name Ingredient_Price");
        if (cmdParts[0].equals("k"))
        	System.out.print("Input format: editIng Ingredient_ID New_Ingredient_Name New_Ingredient_Price");
        if (cmdParts[0].equals("l"))
        	System.out.print("Input format: deleteIng Ingredient_ID");
        
        if (cmdParts[0].equals("m"))
        	System.out.print("Input format: listRTable");
        if (cmdParts[0].equals("n"))
        	System.out.print("Input format: rTable Table_ID");
        if (cmdParts[0].equals("o"))
        	System.out.print("Input format: editRTable Table_ID New_Table_ID");
        if (cmdParts[0].equals("p"))
        	System.out.print("Input format: deleteRTable Table_ID");   
        
        if (cmdParts[0].equals("q"))
        	System.out.print("Input format: listStaff");
        if (cmdParts[0].equals("r"))
        	System.out.print("Input format: addStaff Staff_ID Staff_Name Staff_Position Staff_Salary Staff_Password");
        if (cmdParts[0].equals("s"))
        	System.out.print("Input format: editStaff Staff_ID New_Staff_Name New_Staff_Position New_Staff_Salary New_Staff_Password");
        if (cmdParts[0].equals("t"))
        	System.out.print("Input format: deleteStaff Staff_ID");

        if (cmdParts[0].equals("u"))
        	System.out.print("Input format: revenue");
        if (cmdParts[0].equals("v"))
        	System.out.print("Input format: cost");
        if (cmdParts[0].equals("w"))
        	System.out.print("Input format: profit");
        
	}
	
}
