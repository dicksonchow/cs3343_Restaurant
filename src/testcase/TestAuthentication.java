package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import restaurant.Authentication;
import restaurant.CmdAddStaff;
import restaurant.Restaurant;
import restaurant.Staff;

public class TestAuthentication {

	@Before
	public void setUp() throws Exception {
		/*A staff must exist before a user can login.
		 *CmdAddStaff format: "addStaff", Staff_ID, Staff_Name, Staff_Position, Staff_Salary, Staff_Password
		 */
		
		String[] addStaffManager = {"addStaff", "M001", "Jack", "Manager", "15000", "123"};
		CmdAddStaff cmd1 = new CmdAddStaff();
		cmd1.execute(addStaffManager);
		
		String[] addStaffNormal = {"addStaff", "S001", "Rose", "Staff", "9000", "123"};
		CmdAddStaff cmd2 = new CmdAddStaff();
		cmd2.execute(addStaffNormal);
	}
	
	@After
	public void tearDown() {
		String staffID1 = "M001";
		String staffID2 = "S001";
		Staff Jack = Restaurant.getInstance().findStaff(staffID1);
		Staff Rose = Restaurant.getInstance().findStaff(staffID2);
		Restaurant.getInstance().removeStaff(Jack);
		Restaurant.getInstance().removeStaff(Rose);
	}
	
	@Test
	public void testManagerNotExists(){
		String b = Authentication.getInstance().validation("M1000000", "4321");
		assertEquals("Invalid staff ID!", b);
	}
	
	@Test
	public void testManagerInvalidPw(){
		String b = Authentication.getInstance().validation("M001", "4321");
		assertEquals("Invalid password!", b);
	}
	
	@Test
	public void testManagerCorrect(){
		String b = Authentication.getInstance().validation("M001", "123");
		assertEquals("Login successfully!", b);
	}
	
	@Test
	public void testStaffNotExists(){
		String b = Authentication.getInstance().validation("S1000000", "4321");
		assertEquals("Invalid staff ID!", b);
	}
	
	@Test
	public void testStaffInvalidPw(){
		String b = Authentication.getInstance().validation("S001", "4321");
		assertEquals("Invalid password!", b);
	}
	
	@Test
	public void testStaffCorrect(){
		String b = Authentication.getInstance().validation("S001", "123");
		assertEquals("Login successfully!", b);
	}
	
}
