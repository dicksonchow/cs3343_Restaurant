package testcase;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import restaurant.CmdAddStaff;
import restaurant.UserIdentification;

public class TestUserIdentification {

	@Before
	public void setUp() throws Exception {
		/*A staff must exist before a user can login.
		 *CmdAddStaff format: "addStaff", Staff_ID, Name, Position, Salary, Password
		 *After the user successfully logins, UserIdentification will be implemented.
		 */
		
		String[] addStaffManager = {"addStaff", "M001", "Jack", "Manager", "15000", "123"};
		CmdAddStaff cmd1 = new CmdAddStaff();
		cmd1.execute(addStaffManager);
		
		String[] addStaffNormal = {"addStaff", "S001", "Rose", "Staff", "9000", "123"};
		CmdAddStaff cmd2 = new CmdAddStaff();
		cmd2.execute(addStaffNormal);
	}
	
	public void tearDown() {}
	
	@Test
	public void testIdentityManager(){
		boolean b = UserIdentification.userIdentification("M001");
		assertEquals(b, true);
	}
	
	@Test
	public void testIdentityNormal(){
		boolean b = UserIdentification.userIdentification("S001");
		assertEquals(b, false);
	}

}