package testcase;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import restaurant.CmdAddStaff;

public class TestCmdAddStaff {
	@Before
	public void setUp() throws Exception {}
	
	public void tearDown() {}
	
	/*CmdAddStaff format: "addStaff", Staff_ID, Staff_Name, Staff_Position, Staff_Salary, Staff_Password
	 *Staff_ID is selected by user. Staff_Name, Staff_Position, Staff_Salary, Staff_Password are inputed by user.
	 */

	@Test
	public void testAddStaffMgrCorrect() throws Exception 
	{
		String[] addStaff = {"addStaff", "M001", "Jack", "Manager", "15000", "123"};
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Staff is added.", cmd.execute(addStaff));
	}
	
	@Test
	public void testAddStaffMgrDuplicateId() throws Exception 
	{
		String[] addStaff = {"addStaff", "M001", "Tony", "Manager", "15000", "123"};
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Staff ID has been used.", cmd.execute(addStaff));
	}	
	
	@Test
	public void testAddStaffNmlCorrect() throws Exception 
	{
		String[] addStaff = {"addStaff", "S001", "Rose", "Staff", "9000", "123"};
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Staff is added.", cmd.execute(addStaff));
	}

	@Test
	public void testAddStaffNmlDuplicateId() throws Exception 
	{
		String[] addStaff = {"addStaff", "S001", "Mary", "Staff", "9000", "123"};
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Staff ID has been used.", cmd.execute(addStaff));
	}
	
	@Test
	public void testAddStaffInvalidPosition() throws Exception 
	{
		String[] addStaff = {"addStaff", "M002", "Arron", "asdfasdfasd", "50", "123"};
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Invalid position!", cmd.execute(addStaff));
	}
	
	@Test
	public void testAddStaffInvalidSalary() throws Exception 
	{
		String[] addStaff = {"addStaff", "S002", "Kent", "Staff", "dfas", "123"};
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Invalid salary!", cmd.execute(addStaff));
	}
	
	@Test
	public void testAddStaffNegativeSalary() throws Exception 
	{
		String[] addStaff = {"addStaff", "M003", "Jason", "Manager", "-1000", "123"};
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Invalid input!", cmd.execute(addStaff));
	}
	
	@Test
	public void testAddStaffInvalidPw() throws Exception 
	{
		String[] addStaff = {"addStaff", "S003", "Tim", "Staff", "8000", ""};
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Invalid input!", cmd.execute(addStaff));
	}
	
	@Test
	public void testAddStaffInvalidName() throws Exception 
	{
		String[] addStaff = {"addStaff", "S004", " ", "Staff", "8000", "123"};
		CmdAddStaff cmd = new CmdAddStaff();
		assertEquals("Invalid input!", cmd.execute(addStaff));
	}

}
