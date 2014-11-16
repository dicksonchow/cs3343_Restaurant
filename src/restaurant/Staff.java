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
		
		System.out.println("\n(You may enter \"options\" to check the options again.)");
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
