package testcase;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import restaurant.Manager;
import restaurant.Staff;

public class TestStaff {
	
	private Staff s;
	private Manager m;


	@Before
	public void setUp(){
		Staff s = new Staff("S010", "Michael", "Staff", "2000", "abcd1234");
		Manager m = new Manager("M020", "Jack", "Manager", "200000", "54321");
		this.s = s;
		this.m = m;
	}
	
	@Test
	public void StaffGetName(){
		String name = s.getStaffName();
		assertEquals("Michael", name);
	}
	
	@Test
	public void ManagerGetName(){
		String name = m.getStaffName();
		assertEquals("Jack", name);
	}
	
	@Test
	public void StaffGetId(){
		String id = s.getStaffID();
		assertEquals("S010", id);
	}

	@Test
	public void ManagerGetId(){
		String id = m.getStaffID();
		assertEquals("M020", id);
	}
	
	@Test
	public void StaffGetPos(){
		String pos = s.getPosition();
		assertEquals("Staff", pos);
	}

	@Test
	public void ManagerGetPos(){
		String pos = m.getPosition();
		assertEquals("Manager", pos);
	}
	
	@Test
	public void StaffGetSalary(){
		int sal = s.getStaffSalary();
		assertEquals(2000, sal);
	}

	@Test
	public void ManagerGetSalary(){
		int sal = m.getStaffSalary();
		assertEquals(200000, sal);
	}
	
	@Test
	public void StaffGetPasswd(){
		String pw = s.getStaffPassword();
		assertEquals("abcd1234", pw);
	}

	@Test
	public void ManagerGetPasswd(){
		String pw = m.getStaffPassword();
		assertEquals("54321", pw);
	}
	
	@Test
	public void StaffToString(){
		String str = s.toString();
		String toBeCom = String.format("%-13s%-13s%-13s%-13s", "S010", "Michael", "Staff", "$" + "2000");
		assertEquals(toBeCom, str);
	}

	@Test
	public void ManagerToString(){
		String str = m.toString();
		String toBeCom = String.format("%-13s%-13s%-13s%-13s","M020", "Jack", "Manager", "$" + "200000");
		assertEquals(toBeCom, str);
	}
	
	@Test
	public void StaffGetListingHeader(){
		String str = s.toString();
		String toBeCom = String.format("%-13s%-13s%-13s%-13s", "S010", "Michael", "Staff", "$" + "2000");
		assertEquals(toBeCom, str);
	}

	@Test
	public void ManagerGetListingHeader(){
		String str = m.toString();
		String toBeCom = String.format("%-13s%-13s%-13s%-13s","M020", "Jack", "Manager", "$" + "200000");
		assertEquals(toBeCom, str);
	}

}
