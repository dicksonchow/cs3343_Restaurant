package restaurant;

public class Manager extends Staff {

	public Manager(String sid, String sname, String position, String salary,
			String password) {
		super(sid, sname, position, salary, password);
	}

	public void printOptions() {
		System.out.println("\n--------------- Options ----------------");
		
 		System.out.println("a. List Order"); 
 		System.out.println("b. Add Order");
		System.out.println("c. Edit Order");
		System.out.println("d. Delete Order");
		
		System.out.println("\ne. List Menu");
 		System.out.println("f. Add Food"); 
 		System.out.println("g. Edit Food"); 
 		System.out.println("h. Delete Food");
   
 		System.out.println("\ni. List Ingredient");		
 		System.out.println("j. Add Ingredient"); 
 		System.out.println("k. Edit Ingredient");  
 		System.out.println("l. Delete Ingredient"); 
		
 		System.out.println("\nm. List Reserved Table"); 
 		System.out.println("n. Reserve Table");
		System.out.println("o. Edit Reserved Table");
		System.out.println("p. Delete Reserved Table");
 		
 		System.out.println("\nq. List Staff");		
 		System.out.println("r. Add Staff"); 
 		System.out.println("s. Edit Staff");  
 		System.out.println("t. Delete Staff"); 
 		
 		System.out.println("\nu. Revenue"); 
 		System.out.println("v. Cost"); 
 		System.out.println("w. Profit"); 
 		
		System.out.println("\n(You may enter \"options\" to check the options again.)");
	}

}
