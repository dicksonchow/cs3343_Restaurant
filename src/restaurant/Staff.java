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
		
	@Override
	public int compareTo(Staff another) {
		if (this.sid.equals(another.sid)) return 0;
		else if (this.sid.compareTo(another.sid)>0)return 1;
		else return -1;
	}
	
	@Override
	public String toString() {
		return String.format("%-13s%-13s%-13s%-13s", sid, sname, position, "$" + salary);
	}
	
	public static String getListingHeader() {
	return String.format("%-13s%-13s%-13s%-13s", "Staff_ID", "Staff_Name", "Position", "Salary");
	}
	
}
