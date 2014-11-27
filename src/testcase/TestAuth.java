package testcase;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import restaurant.Authentication;
import restaurant.CmdAddStaff;
import restaurant.Identification;

public class TestAuth {

	@Before
	public void setUp() throws Exception {
		String[] addStaffManager = {"addStaff", "M101", "Hello", "Manager", "20", "123"};
		CmdAddStaff cmd1 = new CmdAddStaff();
		cmd1.execute(addStaffManager);
		String[] addStaffNormal = {"addStaff", "S101", "World", "Staff", "50", "123"};
		CmdAddStaff cmd2 = new CmdAddStaff();
		cmd2.execute(addStaffNormal);
	}
	
	public void tearDown() {}
	
	@Test
	public void testValidManagerNotExists(){
		String b = Authentication.getInstance().validation("M1000000", "4321");
		assertEquals(b, "Invalid staff ID!");
	}
	
	@Test
	public void testValidPasswordNotCorrectManager(){
		String b = Authentication.getInstance().validation("M101", "4321");
		assertEquals(b, "Invalid password!");
	}
	
	@Test
	public void testValidPasswordAllCorrectManager(){
		String b = Authentication.getInstance().validation("M101", "123");
		assertEquals(b, "Login successfully!");
	}
	
	@Test
	public void testValidStaffNotExists(){
		String b = Authentication.getInstance().validation("S1000000", "4321");
		assertEquals(b, "Invalid staff ID!");
	}
	
	@Test
	public void testValidPasswordNotCorrectStaff(){
		String b = Authentication.getInstance().validation("S101", "4321");
		assertEquals(b, "Invalid password!");
	}
	
	@Test
	public void testValidPasswordAllCorrectStaff(){
		String b = Authentication.getInstance().validation("S101", "123");
		assertEquals(b, "Login successfully!");
	}
	
	@Test
	public void testIdentityManager(){
		boolean b = Identification.identification("M101");
		assertEquals(b, true);
	}
	
	@Test
	public void testIdentityNormal(){
		boolean b = Identification.identification("S101");
		assertEquals(b, false);
	}
}
