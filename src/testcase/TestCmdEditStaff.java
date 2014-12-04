package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurant.CmdEditStaff;
import restaurant.Manager;
import restaurant.Restaurant;

public class TestCmdEditStaff {

	@Before
	public void setUp() throws Exception {
		//Staff must exist before editing Staff.
		
		Manager m = new Manager("M001", "Jack", "Manager", "15000", "123");
		Restaurant.getInstance().addStaff(m);
	}
	
	@After
	public void tearDown() {}

	/*CmdEditStaff format: "editStaff", Staff_ID, Staff_Name, Staff_Position, Staff_Salary, Staff_Password
	 *Staff_ID is selected by user. Staff_Name, Staff_Position, Staff_Salary, Staff_Password are inputed by user.
	 */
	
	@Test
	public void testEditStaffCorrect() throws Exception{
		String[] editStaff = {"editStaff", "M001", "Mary", "Manager", "12000", "333"};
		CmdEditStaff cmd = new CmdEditStaff();
		assertEquals("Staff is edited.", cmd.execute(editStaff));
	}
	
	@Test
	public void testEditStaffInvalidId() throws Exception{
		String[] editStaff = {"editStaff", "M002", "Mary", "Manager", "12000", "333"};
		CmdEditStaff cmd = new CmdEditStaff();
		assertEquals("Invalid staff ID!", cmd.execute(editStaff));
	}	
	
	@Test
	public void testEditStaffInvalidPosition() throws Exception{
		String[] editStaff = {"editStaff", "M001", "Mary", "ghsfhjd", "12000", "333"};
		CmdEditStaff cmd = new CmdEditStaff();
		assertEquals("Invalid position!", cmd.execute(editStaff));
	}
	
	@Test
	public void testEditStaffInvalidSalary() throws Exception{
		String[] editStaff = {"editStaff", "M001", "Mary", "Manager", "asdfsadfdas", "321"};
		CmdEditStaff cmd = new CmdEditStaff();
		assertEquals("Invalid salary!", cmd.execute(editStaff));
	}	
	
	@Test
	public void testEditStaffNegativeSalary() throws Exception{
		String[] editStaff = {"editStaff", "M001", "Mary", "Manager", "-1000", "321"};
		CmdEditStaff cmd = new CmdEditStaff();
		assertEquals("Invalid input!", cmd.execute(editStaff));
	}	
	
	@Test
	public void testEditStaffInvalidPw() throws Exception 
	{
		String[] editStaff = {"editStaff", "M001", "Mary", "Manager", "12000", ""};
		CmdEditStaff cmd = new CmdEditStaff();
		assertEquals("Invalid input!", cmd.execute(editStaff));
	}
	
	@Test
	public void testEditStaffInvalidName() throws Exception 
	{
		String[] editStaff = {"editStaff", "M001", " ", "Manager", "12000", "321"};
		CmdEditStaff cmd = new CmdEditStaff();
		assertEquals("Invalid input!", cmd.execute(editStaff));
	}
	
}
