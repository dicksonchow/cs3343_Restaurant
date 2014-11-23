package restaurant;

public class Staff implements Comparable<Staff> {

	private String sid;
	private String sname;
	private String position;
	private int salary;
	private String password;
	
	public Staff(String sid, String sname, String position, String salary, String password) {
		this.sid=sid;
		this.sname=sname;
		this.position=position;
		this.salary=Integer.parseInt(salary);
		this.password=password;
		Restaurant.getInstance().addStaff(this);
	}

	public String getStaffName() {
		return sname;
	}
	
	public String getStaffID() {
		return sid;
	}
	
	public String getPosition() {
		return position;
	}
	
	public int getStaffSalary() {
		return salary;
	}
	
	public String getStaffPassword() {
		return password;
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
		
		System.out.print("\n(You may enter \"options\" to check the options again.)\n");
	}
	
	@Override
	public int compareTo(Staff another) {
		if (this.sid.equals(another.sid)) return 0;
		else if (this.sid.compareTo(another.sid)>0)return 1;
		else return -1;
	}
	
	@Override
	public String toString() {
		return String.format("%-15s%-15s%-15s%-15s", sid, sname, position, "$" + salary);
	}
	
	public static String getListingHeader() {
	return String.format("%-15s%-15s%-15s%-15s", "Staff_ID", "Staff_Name", "Position", "Salary");
	}
	
}
