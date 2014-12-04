package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import restaurant.CmdDeleteStaff;
import restaurant.Manager;

public class TestCmdDeleteStaff {

	@Before
	public void setUp() throws Exception {
		//Staff must exist before deleting staff.

		new Manager("M001", "Jack", "Manager", "15000", "123");
	}
	
	@After
	public void tearDown() {}

	/*CmdDeleteStaff format: "deleteStaff", Staff_ID
	 *Staff_ID is selected by user.
	 */

	@Test
	public void testDeleteStaffCorrect() throws Exception{
		String[] deleteStaff = {"deleteStaff", "M001"};
		CmdDeleteStaff cmd = new CmdDeleteStaff();
		assertEquals("Staff is deleted.", cmd.execute(deleteStaff));
	}
	
	@Test
	public void testDeleteStaffInvalidId() throws Exception{
		String[] deleteStaff = {"deleteStaff", "S520"};
		CmdDeleteStaff cmd = new CmdDeleteStaff();
		assertEquals("Invalid staff ID!", cmd.execute(deleteStaff));
	}
	
}
