package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurant.CmdListStaff;
import restaurant.Manager;
import restaurant.Restaurant;
import restaurant.Staff;

public class TestCmdListStaff {
	
	Manager m = new Manager("M001", "Jack", "Manager", "15000", "123");
	Staff s = new Staff("S001", "Mary", "Staff", "8000", "123");

	@Before
	public void setUp() throws Exception {
		//Staff must exist before listing Staff.
		Restaurant.getInstance().addStaff(m);
		Restaurant.getInstance().addStaff(s);
	}
	
	@After
	public void tearDown() {
		Restaurant.getInstance().removeStaff(s);
		Restaurant.getInstance().removeStaff(m);
	}

	//CmdListStaff format: "listStaff"
	
	@Test
	public void testListStaff() throws Exception 
	{
		String listingHeader = "Staff_ID     Staff_Name   Position     Salary       " + "\n";
		String toString1 = "M001         Jack         Manager      $15000       " + "\n";
		String toString2 = "S001         Mary         Staff        $8000        " + "\n";
		String listStaff = listingHeader + toString1 + toString2;
		CmdListStaff cmd = new CmdListStaff();
		assertEquals(listStaff, cmd.execute());
	}

}
