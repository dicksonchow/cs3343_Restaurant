package restaurant;

public class Manager extends Staff {

	public Manager(String sid, String sname, String position, String salary,
			String password) {
		super(sid, sname, position, salary, password);
	}

	public void printOptions() {
		System.out.print("\n--------------- Options ----------------\n");
		
 		System.out.print("a. List Order\n"); 
 		System.out.print("b. Add Order\n");
		System.out.print("c. Edit Order\n");
		System.out.print("d. Delete Order\n");
		
		System.out.print("\ne. List Menu\n");
 		System.out.print("f. Add Food\n"); 
 		System.out.print("g. Edit Food\n"); 
 		System.out.print("h. Delete Food\n");
   
 		System.out.print("\ni. List Ingredient\n");		
 		System.out.print("j. Add Ingredient\n"); 
 		System.out.print("k. Edit Ingredient\n");  
 		System.out.print("l. Delete Ingredient\n"); 
		
 		System.out.print("\nm. List Reserved Table\n"); 
 		System.out.print("n. Reserve Table\n");
		System.out.print("o. Edit Reserved Table\n");
		System.out.print("p. Delete Reserved Table\n");
 		
 		System.out.print("\nq. List Staff\n");		
 		System.out.print("r. Add Staff\n"); 
 		System.out.print("s. Edit Staff\n");  
 		System.out.print("t. Delete Staff\n"); 
 		
 		System.out.print("\nu. Revenue\n"); 
 		System.out.print("v. Cost\n"); 
 		System.out.print("w. Profit\n"); 
 		
		System.out.print("\n(You may enter \"options\" to check the options again.)\n");
	}

}
