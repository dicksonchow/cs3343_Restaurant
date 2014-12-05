package testcase;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurant.CmdAddStaff;
import restaurant.CmdDeleteStaff;
import restaurant.Manager;
import restaurant.Restaurant;
import restaurant.Staff;

public class TestCmdAddStaff {
	
	Manager m = new Manager ("M001", "Kate", "Manager", "15000", "123");		
	Staff s = new Staff ("S001", "Rome", "Staff", "8000", "123");
	
	String staffId;
	
	@Before
	public void setUp() throws Exception {
		//Staffs M001 and S001 have been added.
		Restaurant.getInstance().addStaff(m);
		Restaurant.getInstance().addStaff(s);
	}
	
	@After
	public void tearDown() {
		Restaurant.getInstance().removeStaff(m);
		Restaurant.getInstance().removeStaff(s);
		
		Staff sd = Restaurant.getInstance().findStaff(staffId);
		Restaurant.getInstance().removeStaff(sd);
		System.out.println(Restaurant.getInstance().listStaff());
	}
	
	/*CmdAddStaff format: "addStaff", Staff_ID, Staff_Name, Staff_Position, Staff_Salary, Staff_Password
	 *Staff_ID is selected by user. Staff_Name, Staff_Position, Staff_Salary, Staff_Password are inputed by user.
	 */

	@Test
	public void testAddStaffManagerCorrect() throws Exception 
	{
		String[] addStaff = {"addStaff", "M002", "Jack", "Manager", "15000", "123"};
		staffId = addStaff[1];
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Staff is added.", cmd.execute(addStaff));
	}
	
	@Test
	public void testAddStaffManagerDuplicateId() throws Exception 
	{
		String[] addStaff = {"addStaff", "M001", "Tony", "Manager", "15000", "123"};
		staffId = addStaff[1];
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Staff ID has been used.", cmd.execute(addStaff));
	}	
	
	@Test
	public void testAddStaffNormalCorrect() throws Exception 
	{
		String[] addStaff = {"addStaff", "S002", "Rose", "Staff", "9000", "123"};
		staffId = addStaff[1];
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Staff is added.", cmd.execute(addStaff));
	}

	@Test
	public void testAddStaffNormalDuplicateId() throws Exception 
	{
		String[] addStaff = {"addStaff", "S001", "Mary", "Staff", "9000", "123"};
		staffId = addStaff[1];
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Staff ID has been used.", cmd.execute(addStaff));
	}
	
	@Test
	public void testAddStaffInvalidPosition() throws Exception 
	{
		String[] addStaff = {"addStaff", "M003", "Arron", "asdfasdfasd", "50", "123"};
		staffId = addStaff[1];
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Invalid position!", cmd.execute(addStaff));
	}
	
	@Test
	public void testAddStaffInvalidSalary() throws Exception 
	{
		String[] addStaff = {"addStaff", "S003", "Kent", "Staff", "dfas", "123"};
		staffId = addStaff[1];
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Invalid salary!", cmd.execute(addStaff));
	}
	
	@Test
	public void testAddStaffNegativeSalary() throws Exception 
	{
		String[] addStaff = {"addStaff", "M004", "Jason", "Manager", "-1000", "123"};
		staffId = addStaff[1];
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Invalid input!", cmd.execute(addStaff));
	}
	
	@Test
	public void testAddStaffInvalidPw() throws Exception 
	{
		String[] addStaff = {"addStaff", "S004", "Tim", "Staff", "8000", ""};
		staffId = addStaff[1];
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Invalid input!", cmd.execute(addStaff));
	}
	
	@Test
	public void testAddStaffInvalidName() throws Exception 
	{
		String[] addStaff = {"addStaff", "S005", " ", "Staff", "8000", "123"};
		staffId = addStaff[1];
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Invalid input!", cmd.execute(addStaff));
	}

}
